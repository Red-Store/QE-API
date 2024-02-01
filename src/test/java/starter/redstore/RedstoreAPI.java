package starter.redstore;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;
import java.util.Map;

public class RedstoreAPI {
    public static String LOGIN_USER = Constants.BASE_URL + "/login";
    public static String CREATE_USER = Constants.BASE_URL + "/users";
    public static String GET_USER = Constants.BASE_URL + "/users";
    public static String UPDATE_USER = Constants.BASE_URL + "/users";
    public static String DELETE_POST = Constants.BASE_URL + "/users";
    public static String CREATE_PRODUCT = Constants.BASE_URL + "/products";
    public static String GET_CART = Constants.BASE_URL + "/carts";
    public static String ADD_CART = Constants.BASE_URL + "/carts/{product_id}";
    public static String UPDATE_CART = Constants.BASE_URL + "/carts/{cart_id}";
    public static String DELETE_CART = Constants.BASE_URL + "/carts/{cart_id}";
    public static String CREATE_ORDER = Constants.BASE_URL + "/orders";
    public static String GET_ORDER = Constants.BASE_URL + "/users/orders";
    public static String CANCEL_ORDER = Constants.BASE_URL + "/orders/{id}";

    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create New User")
    public void createNewUser(File json){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get User")
    public void getUser(){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN);
    }

//    @Step("Update User")
//    public void updateUser(File json){
//        SerenityRest.given()
//                .header("Authorization", Constants.DUMMY_TOKEN)
//                .multiPart("jsonFile", json, "application/json");
//    }
//    @Step("Create Product")
//    public void updateUser1(Map<String, ?> formData){
//        SerenityRest.given()
//                .header("Authorization", Constants.DUMMY_TOKEN)
//                .contentType("multipart/form-data")
//                .multiPart("name", formData.get("name"))
//                .multiPart("user_name", formData.get("user_name"))
//                .multiPart("email", formData.get("email"))
//                .multiPart("password", formData.get("password"))
//                .multiPart("photo_profil", formData.get("photo_profil"));
//    }

    @Step("Create Product")
    public void updateUser2(Map<String, ?> formData){
        SerenityRest.given()
                .header("Authorization", Constants.DUMMY_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("name", formData.get("name"))
                .multiPart("user_name", formData.get("user_name"))
                .multiPart("email", formData.get("email"))
                .multiPart("password", formData.get("password"))
                .multiPart("photo_profil", formData.get("photo_profil"));
    }

    @Step("Delete user")
    public void deleteUser (){
        SerenityRest.given()
                .header("Authorization", Constants.DELETE_TOKEN);
    }
    @Step("Get my cart")
    public void getCart (){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI);
    }
    @Step("Add product to cart")
    public void addProductToCart (String product_id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("product_id", product_id);
    }
    @Step("Add product to cart invalid product_id")
    public void addProductToCartInvalidId (String product_id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("product_id", product_id);
    }
    @Step("Add product to cart without product_id")
    public void addProductToCartWithoutId (String product_id) {
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("product_id", product_id);
    }
    @Step("Add product to cart without login")
    public void addProductToCartWithoutLogin (String product_id) {
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("product_id", product_id);
    }
    @Step("Update product to cart")
    public void updateProductToCart (String cart_id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("cart_id", cart_id);
    }
    @Step("Update product to cart invalid param")
    public void updateCartInvalid (String cart_id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("cart_id", cart_id);
    }
    @Step("Update cart without login")
    public void updateCartWithoutLogin (){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI);
    }
    @Step("Delete cart")
    public void deleteCart(String cart_id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("cart_id", cart_id);
    }
    @Step("Create Order")
    public void createOrder(File json){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_KEI)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get my order")
    public void getOrder (){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI);
    }
    @Step("Cancel order")
    public void cancelOrder (String order_id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_KEI)
                .pathParam("order_id", order_id);
    }

}
