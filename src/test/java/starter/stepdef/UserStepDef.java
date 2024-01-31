package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.redstore.RedstoreResponses;
import starter.redstore.RedstoreAPI;
import starter.utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class UserStepDef {

    @Steps
    RedstoreAPI redstoreAPI;
    //case 1
    @Given("Login users with valid {string}")
    public void loginUsersWithValid(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        redstoreAPI.postLoginUser(jsonLoginUser);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when()
                .post(RedstoreAPI.LOGIN_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @And("Response body message was {string} and role was {string}")
    public void responseBodyMessageWas(String message, String role) {
        SerenityRest.and()
                .body(RedstoreResponses.MESSAGE, equalTo(message))
                .body(RedstoreResponses.ROLE, equalTo(role));
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //case 2
    @Given("Login admin with valid {string}")
    public void loginAdminWithValid(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        redstoreAPI.postLoginUser(jsonLoginUser);
    }

    @When("Send request login admin")
    public void sendRequestLoginAdmin() {
        SerenityRest.when()
                .post(RedstoreAPI.LOGIN_USER);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and()
                .body(RedstoreResponses.MESSAGE, equalTo(message));
    }

    @Given("Login users with empty email {string}")
    public void loginUsersWithEmptyEmail(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        redstoreAPI.postLoginUser(jsonLoginUser);
    }
    @And("Validate login user json schema with {string}")
    public void validateLoginUserJsonSchemaWith(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Login users with empty password {string}")
    public void loginUsersWithEmptyPassword(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        redstoreAPI.postLoginUser(jsonLoginUser);
    }

    @Given("Create new users with valid data {string}")
    public void createNewUsersWithValidData(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        redstoreAPI.createNewUser(jsonCreateUser);
    }

    @When("Send request create new user")
    public void sendRequestCreateNewUser() {
        SerenityRest.when()
                .post(RedstoreAPI.CREATE_USER);
    }


    @And("Validate create new user json schema with {string}")
    public void validateCreateNewUserJsonSchemaWith(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Create new users with duplicate user_name in {string}")
    public void createNewUsersWithDuplicateUsernameIn(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        redstoreAPI.createNewUser(jsonCreateUser);
    }

    @Given("Create new users with duplicate email in {string}")
    public void createNewUsersWithDuplicateEmailIn(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        redstoreAPI.createNewUser(jsonCreateUser);
    }

    @Given("Get user when logged in")
    public void getUserWhenLoggedIn() {
        redstoreAPI.getUser();
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when()
                .get(RedstoreAPI.GET_USER);
    }

    @And("Validate get user json schema with {string}")
    public void validateGetUserJsonSchemaWith(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get user without logged in")
    public void getUserWithoutLoggedIn() {
    }

//    @Given("Update user with all data {string}")
//    public void updateUserWithValidData(String json) {
//        File jsonUpdateUser = new File(Constants.REQ_BODY + json);
//        redstoreAPI.updateUser(jsonUpdateUser);
//    }

    @Given("Update user with all data {string}")
    public void updateUserWithValidData(String json) {
        Map<String, Object> formData = AllData(json);

        // Call the updateUser2 method from RedstoreAPI
        redstoreAPI.updateUser2(formData);
    }


    private Map<String, Object> AllData(String json) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("name", "dummyy");
        formData.put("user_name", "dummy777");
        formData.put("email", "dumdum777@gmail.com");
        formData.put("password", "dum123");
        formData.put("photo_profil", "https://res.cloudinary.com/dlxvvuhph/image/upload/v1706551564/BE20_MyEcommerce/qqe7g0buqjtotr1jpd0g.jpg");

        return formData;
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when()
                .put(RedstoreAPI.UPDATE_USER);
    }

    @Given("Update user with only field name {string}")
    public void updateUserWithOnlyFieldName(String json) {
        Map<String, Object> formData = OnlyName(json);

        // Call the updateUser2 method from RedstoreAPI
        redstoreAPI.updateUser2(formData);
    }
    private Map<String, Object> OnlyName(String json) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("name", "dummyy");

        return formData;
    }


    @Given("Update user with only field user_name {string}")
    public void updateUserWithOnlyFieldUser_name(String json) {
        Map<String, Object> formData = OnlyUserName(json);

        // Call the updateUser2 method from RedstoreAPI
        redstoreAPI.updateUser2(formData);
    }

    private Map<String, Object> OnlyUserName(String json) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("user_name", "dummy777");

        return formData;
    }

    @Given("Update user with duplicate username {string}")
    public void updateUserWithDuplicate(String json) {
        // Load the JSON file content
        Map<String, Object> formData = DuplicateUsername(json);

        // Call the updateUser2 method from RedstoreAPI
        redstoreAPI.updateUser2(formData);
    }
    private Map<String, Object> DuplicateUsername(String username) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("user_name", username);

        return formData;
    }

    @Given("Update user with duplicate email {string}")
    public void updateUserWithDuplicateEmail(String json) {
        // Load the JSON file content
        Map<String, Object> formData = DuplicateEmail(json);

        // Call the updateUser2 method from RedstoreAPI
        redstoreAPI.updateUser2(formData);
    }
    private Map<String, Object> DuplicateEmail(String email) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("email", email);

        return formData;
    }

    @Given("Delete post when logged in")
    public void deletePostWhenLoggedIn() {
        redstoreAPI.deleteUser();
    }

    @When("Send request delete posts")
    public void sendRequestDeletePosts() {
        SerenityRest.when().delete(RedstoreAPI.DELETE_POST);
    }

    @Given("Delete post without logged in")
    public void deletePostWithoutLoggedIn() {
    }
}
