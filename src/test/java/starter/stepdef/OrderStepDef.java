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

public class OrderStepDef {
    @Steps
    RedstoreAPI redstoreAPI;
    //Scenario 1 & 2
    @Given("Create order with valid data {string}")
    public void createOrderWithValidData(String json) {
        File jsonCreateOrder = new File(Constants.REQ_BODY + json);
        redstoreAPI.createOrder(jsonCreateOrder);
    }
    @When("Send request create order")
    public void sendRequestCreateOrder() {
        SerenityRest.when().post(RedstoreAPI.CREATE_ORDER);
    }

    @And("Validate order json schema {string}")
    public void validateOrderJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    //Scenario 3
    @Given("Create order with blank address {string}")
    public void createOrderWithBlankAddress(String json) {
        File jsonCreateOrderBlankAddress = new File(Constants.REQ_BODY + json);
        redstoreAPI.createOrder(jsonCreateOrderBlankAddress);
    }

    //Scenario 4
    @Given("Create order with blank bank {string}")
    public void createOrderWithBlankBank(String json) {
        File jsonCreateOrderBlankBank = new File(Constants.REQ_BODY + json);
        redstoreAPI.createOrder(jsonCreateOrderBlankBank);
    }

    //Scenario 5
    @Given("Create order with invalid {string}")
    public void createOrderWithInvalid(String json) {
        File jsonCreateOrderInvalidData = new File(Constants.REQ_BODY + json);
        redstoreAPI.createOrder(jsonCreateOrderInvalidData);
    }

    //Scenario 6 & 7
    @Given("Get my order")
    public void getMyOrder() {
        redstoreAPI.getOrder();
    }
    @When("Send request get order")
    public void sendRequestGetOrder() {
        SerenityRest.when().get(RedstoreAPI.GET_ORDER);
    }

    //Scenario 8
    @Given("Cancel my order with valid {string}")
    public void cancelMyOrderWithValid(String order_id) {
        redstoreAPI.cancelOrder(order_id);
    }
    @When("Send request cancel order")
    public void sendRequestCancelOrder() {
        SerenityRest.when().put(RedstoreAPI.CANCEL_ORDER);
    }

    //Scenario 9
    @Given("Cancel my order with invalid {string}")
    public void cancelMyOrderWithInvalid(String order_id) {
        redstoreAPI.cancelOrder(order_id);
    }

    //Scenario 10
    @Given("Cancel my order with valid {string} without login")
    public void cancelMyOrderWithValidWithoutLogin(String order_id) {
        redstoreAPI.cancelOrder(order_id);
    }

    //Scenario 11
    @Given("Cancel my order without {string}")
    public void cancelMyOrderWithout(String order_id) {
        redstoreAPI.cancelOrder(order_id);
    }
}
