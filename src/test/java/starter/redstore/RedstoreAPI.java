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

}
