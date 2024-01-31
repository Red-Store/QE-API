package starter.redstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class RedstoreDeleteProductAPI {

    public static String DELETE_PRODUCT = Constants.BASE_URL + "/products/{product_id}";

    @Step("Delete product")
    public void setDeleteProduct(String product_id) {
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("product_id", product_id);

    }

    @Step("Delete product without login")
    public void setDeleteProductNoLogin(String product_id) {
        SerenityRest.given().pathParam("product_id", product_id);

    }
}