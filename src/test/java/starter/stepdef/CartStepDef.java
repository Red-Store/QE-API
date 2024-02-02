package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.redstore.RedstoreAPI;
import starter.utils.Constants;

import java.io.File;

public class CartStepDef {
    @Steps
    RedstoreAPI redstoreAPI;

    //Scenario 1
    @Given("Get my cart")
    public void getMyCart() {
        redstoreAPI.getCart();
    }

    @When("Send request get my cart")
    public void sendRequestGetMyCart() {
        SerenityRest.when().get(RedstoreAPI.GET_CART);
    }
    @And("Validate cart json schema {string}")
    public void validateCartJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2
    @Given("Get my cart without login")
    public void getMyCartWithoutLogin() {
        redstoreAPI.getCartWithoutLogin();
    }
    @When("Send request get my cart without login")
    public void sendRequestGetMyCartWithoutLogin() {
        SerenityRest.when().get(RedstoreAPI.GET_CART);
    }

    //Scenario 3
    @Given("Add all product with param {string}")
    public void addAllProductWithParam(String product_id) {
        redstoreAPI.addProductToCart(product_id);
    }

    @When("Send request add all products with all param")
    public void sendRequestAddAllProductsWithAllParam() {
        SerenityRest.when().post(RedstoreAPI.ADD_CART);
    }

    //Scenario 4
    @Given("Add all product with invalid {string}")
    public void addAllProductWithInvalid(String product_id) {
        redstoreAPI.addProductToCartInvalidId(product_id);
    }

    //Scenario 5
    @Given("Add all product without {string}")
    public void addAllProductWithout(String product_id) {
        redstoreAPI.addProductToCartWithoutId(product_id);
    }

    //Scenario 6
    @Given("Add all product with valid {string} without login")
    public void addAllProductWithValidWithoutLogin(String product_id) {
        redstoreAPI.addProductToCartWithoutLogin(product_id);
    }
    @When("Send request add all products without login")
    public void sendRequestAddAllProductsWithoutLogin() {
        SerenityRest.when().post(RedstoreAPI.ADD_CART);
    }

    //Scenario 7
    @Given("Update product to cart with valid {string}")
    public void updateProductToCartWithValid(String cart_id) {
        redstoreAPI.updateProductToCart(cart_id);
    }

    @When("Send request update product to cart with param")
    public void sendRequestUpdateProductToCartWithParam() {
        SerenityRest.when().put(RedstoreAPI.UPDATE_CART);
    }

    //Scenario 8
    @Given("Update product to cart with invalid {string}")
    public void updateProductToCartWithInvalid(String cart_id) {
        redstoreAPI.updateCartInvalid(cart_id);
    }

    //Scenario 9
    @Given("Update product to cart without login with {string}")
    public void updateProductToCartWithoutLogin(String cart_id) {
        redstoreAPI.updateCartWithoutLogin(cart_id);
    }
    @When("Send request update product to cart without login")
    public void sendRequestUpdateProductToCartWithoutLogin() {
        SerenityRest.when().put(redstoreAPI.UPDATE_CART);
    }

    //Scenario 10
    @Given("Delete product to cart with {string}")
    public void deleteProductToCartWith(String cart_id) {
        redstoreAPI.deleteCart(cart_id);
    }
    @When("Send request delete product to cart")
    public void sendRequestDeleteProductToCart() {
        SerenityRest.when().delete(RedstoreAPI.DELETE_CART);
    }

    //Scenario 11
    @Given("Delete product to cart with invalid {string}")
    public void deleteProductToCartWithInvalid(String cart_id) {
        redstoreAPI.deleteCart(cart_id);
    }

    //Scenario 12
    @Given("Delete product to cart without {string}")
    public void deleteProductToCartWithout(String cart_id) {
        redstoreAPI.deleteCart(cart_id);
    }



}