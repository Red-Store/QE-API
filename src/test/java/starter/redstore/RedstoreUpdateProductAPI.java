package starter.redstore;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class RedstoreUpdateProductAPI {

    public static String UPDATE_PRODUCT = Constants.BASE_URL+"/products/{product_id}";

    @Step("update product login")
    public void updateProductLogin(String product_id, File json) {
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_KEI)
                .pathParam("product_id", product_id)
                .contentType("multipart/form-data")
                .multiPart("jsonFile", json, "application/json")
                .when()
                .put(UPDATE_PRODUCT);
    }

    @Step("update product not yet login")
    public void updateProductNoLogin(String product_id, File json) {
        SerenityRest.given()
                .pathParam("product_id", product_id)
                .contentType("multipart/form-data")
                .multiPart("jsonFile", json, "application/json")
                .when()
                .put(UPDATE_PRODUCT);
    }




}
