package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import starter.redstore.*;
import starter.utils.Constants;



import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProductStepDef {

    @Steps
    RedstoreGetUserProductsAPI redstoreGetUserProductsAPI;
    @Steps
    RedstoreDeleteProductAPI redstoreDeleteProductAPI;
    @Steps
    RedstoreCreateProductAPI redstoreCreateProductAPI;
    @Steps
    RedstoreUpdateProductAPI redstoreUpdateProductAPI;

    @Given("Get my product")
    public void getMyProduct(){
        redstoreGetUserProductsAPI.setGetMyProducts();
    }

    @When ("Send request get my product")
    public void sendRequestGetMyProduct(){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_KEI)
                .get(redstoreGetUserProductsAPI.GET_MY_PRODUCTS);
    }

    @Then ("Validate product json schema {string}")
    public void validateProductJsonSchema(String json){
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    @When("Send request get my product without login")
    public void sendRequestGetMyProductWithoutLogin() {
        SerenityRest.given().get(redstoreGetUserProductsAPI.GET_MY_PRODUCTS);
    }

    @Given("Get all product with param {int} and {int}")
    public void getAllProductWithParamAnd(int page, int limit) {
        redstoreGetUserProductsAPI.setGetAllProducts(page, limit);
        sendRequestGetAllProduct();
    }

    @When("Send request get all products with all param")
    public void sendRequestGetAllProduct() {
        SerenityRest.when().get(redstoreGetUserProductsAPI.GET_All_PRODUCTS);
    }


    @Given("Get all product with param page {int}")
    public void getAllProductWithParamPage(int page) {
        redstoreGetUserProductsAPI.setGetAllProductsPage(page);
        sendRequestGetAllProductsWithPage();
    }

    @When("Send request get all products with page")
    public void sendRequestGetAllProductsWithPage() {
        SerenityRest.when().get(redstoreGetUserProductsAPI.GET_ALL_PRODUCTS_PAGE);
    }

    @Given("Get all product with param limit {int}")
    public void getAllProductWithParamLimit(int limit) {
        redstoreGetUserProductsAPI.setGetAllProductsLimit(limit);
        sendRequestGetAllProductsWithLimit();
    }

    @When("Send request get all products with limit")
    public void sendRequestGetAllProductsWithLimit() {
        SerenityRest.when().get(redstoreGetUserProductsAPI.GET_ALL_PRODUCTS_LIMIT);
    }

    @Given("Get single product with {int}")
    public void getSingleProductWith(int product_id) {
        redstoreGetUserProductsAPI.setGetSingleProducts(product_id);

    }

    @When("Send request get single product")
    public void sendRequestGetSingleProduct() {
        SerenityRest.when().get(redstoreGetUserProductsAPI.GET_SINGLE_PRODUCTS);
    }

    @Given("Get product search with {string}")
    public void getProductSearchWith(String type) {
        redstoreGetUserProductsAPI.setGetSearchProduct(type);
    }

    @When("Send request get search product")
    public void sendRequestGetSearchProduct() {
        SerenityRest.when().get(redstoreGetUserProductsAPI.GET_SEARCH_PRODUCTS);
    }

    @And("Response body was same with {string}")
    public void responseBodyWasSameWith(String type) {
        Response searchProductResponse = SerenityRest.then().extract().response();
        String responseBody = searchProductResponse.getBody().asString();
        Assertions.assertThat(responseBody).contains(type);
    }

    //    [DELETE PRODUCT]

    @Given("Delete product with {string}")
    public void deleteProductWith(String product_id) {
        redstoreDeleteProductAPI.setDeleteProduct(product_id);
    }

    @When("Send request delete product")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(RedstoreDeleteProductAPI.DELETE_PRODUCT);
    }

    @Given("Delete product with {string} without login")
    public void deleteProductWithWithoutLogin(String product_id) {
        redstoreDeleteProductAPI.setDeleteProductNoLogin(product_id);
    }


//    [PUT UPDATE PRODUCT]

    @Given("Update product with {string} and {string}")
    public void updateProductWithProduct_idAnd(String product_id, String json) {
        // Assuming Constants.REQ_BODY is the base path for your JSON files
        String jsonFilePath = Constants.REQ_BODY + json;

        // Create a File object from the JSON file path
        File jsonUpdateProduct = new File(jsonFilePath);

        // Update the product using the redstoreUpdateProductAPI
        redstoreUpdateProductAPI.updateProductLogin(product_id, jsonUpdateProduct);
    }

    @Given("Update product with {string} and {string} without login")
    public void updateProductWithNoLogin(String product_id, String json) {
        // Assuming Constants.REQ_BODY is the base path for your JSON files
        String jsonFilePath = Constants.REQ_BODY + json;

        // Create a File object from the JSON file path
        File jsonUpdateProduct = new File(jsonFilePath);

        // Update the product using the redstoreUpdateProductAPI
        redstoreUpdateProductAPI.updateProductNoLogin(product_id, jsonUpdateProduct);
    }

    @When("Send request update product")
    public void sendRequestUpdateProduct() {
        SerenityRest.when().put(RedstoreUpdateProductAPI.UPDATE_PRODUCT);
    }


//    [POST CREATE PRODUCT]
    Response response;

    @Given("Create product with all param")
    public void createProductWithParam() {
        response = redstoreCreateProductAPI.sendCreateProductRequest();
    }

    @When("Send request create product")
    public void sendRequestCreateProduct() {
        // No additional logic needed here, as the product creation is done in the Given step
    }

    @Then("Verify status code is {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("Verify response message is {string}")
    public void verifyResponseMessage(String expectedMessage) {
        response.then().body(RedstoreResponses.MESSAGE, equalTo(expectedMessage));
    }


    @Given("Create product with all param without login")
    public void createProductWithParamNoLogin() {
        response = redstoreCreateProductAPI.sendCreateProductRequestNoLogin();
    }

    @Given("Create product with all param except name")
    public void createProductWithParamNoName() {
        response = redstoreCreateProductAPI.sendCreateProductRequestNoName();
    }







}
