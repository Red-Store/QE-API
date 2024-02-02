package starter.redstore;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class RedstoreCreateProductAPI {

    public static String CREATE_PRODUCT = Constants.BASE_URL+"/products";


    @Step("create product request")
    public RequestSpecification createProductRequest() {
        return RestAssured.given()
                .contentType("multipart/form-data")
                .header("Authorization", Constants.TOKEN_KEI)
                .multiPart("name", "sumsang j7 prem")
                .multiPart("photo_product", new File("/Users/keian/Downloads/619S7EI24dL.jpg"))
                .multiPart("category", "Laptop")
                .multiPart("stock", "2")
                .multiPart("price", "1400000")
                .multiPart("description", "ikuu ikuu ikuu ikuu");
    }

    @Step("send create product request")
    public Response sendCreateProductRequest() {
        return createProductRequest().post(CREATE_PRODUCT);
    }

    @Step("create product request without login")
    public RequestSpecification createProductRequestNoLogin() {
        return RestAssured.given()
                .contentType("multipart/form-data")
                .multiPart("name", "sumsang j7 prem")
                .multiPart("photo_product", new File("/Users/keian/Downloads/619S7EI24dL.jpg"))
                .multiPart("category", "Laptop")
                .multiPart("stock", "2")
                .multiPart("price", "1400000")
                .multiPart("description", "ikuu ikuu ikuu ikuu");
    }

    @Step("send create product request no login")
    public Response sendCreateProductRequestNoLogin() {
        return createProductRequestNoLogin().post(CREATE_PRODUCT);
    }

    @Step("create product request without name")
    public RequestSpecification createProductRequestNoName() {
        return RestAssured.given()
                .contentType("multipart/form-data")
                .header("Authorization", Constants.TOKEN_KEI)
                .multiPart("photo_product", new File("/Users/keian/Downloads/619S7EI24dL.jpg"))
                .multiPart("category", "Laptop")
                .multiPart("stock", "2")
                .multiPart("price", "1400000")
                .multiPart("description", "ikuu ikuu ikuu ikuu");
    }

    @Step("send create product request no name")
    public Response sendCreateProductRequestNoName() {
        return createProductRequestNoName().post(CREATE_PRODUCT);
    }

}


