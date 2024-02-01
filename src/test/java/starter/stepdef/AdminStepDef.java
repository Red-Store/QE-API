package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.redstore.RedstoreAPI;
import starter.redstore.RedstoreAdminAPI;

public class AdminStepDef {
    private final RedstoreAdminAPI redstoreAdminAPI = new RedstoreAdminAPI();
    @Given("Get list user")
    public void getListUser() {
        redstoreAdminAPI.getListUsers();
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_USER);
    }

    @Given("Get list order")
    public void getListOrder() {
        redstoreAdminAPI.getListOrders();
    }

    @When("Send request get list order")
    public void sendRequestGetListOrder() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_ORDER);
    }

    @Given("Get list user with {int}")
    public void getListUserWithPage(int page) {
        redstoreAdminAPI.getListUserPage(page);
    }

    @When("Send request get list user with page")
    public void sendRequestGetListUserWithPage() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_USERPAGE);
    }

    @Given("Get list order with {int}")
    public void getListOrderWith(int page) {
        redstoreAdminAPI.getListOrderPage(page);
    }

    @When("Send request get list order with page")
    public void sendRequestGetListOrderWithPage() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_ORDERPAGE);
    }

    @Given("Get list user with limit {int}")
    public void getListUserWithLimit(int limit) {
        redstoreAdminAPI.getListUserLimit(limit);
    }

    @When("Send request get list user with limit")
    public void sendRequestGetListUserWithLimit() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_USERLIMIT);
    }

    @Given("Get list order with limit {int}")
    public void getListOrderWithLimit(int limit) {
        redstoreAdminAPI.getListOrderLimit(limit);
    }

    @When("Send request get list order with limit")
    public void sendRequestGetListOrderWithLimit() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_ORDERLIMIT);
    }

    @Given("Get list user with page {int} and limit {int}")
    public void getListUserWithPageAndLimit(int page, int limit) {
        redstoreAdminAPI.getListUserPageLimit(page, limit);
    }

    @When("Send request get list user with page and limit")
    public void sendRequestGetListUserWithPageAndLimit() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_USERPAGELIMIT);
    }

    @Given("Get list order with page {int} and limit {int}")
    public void getListOrderWithPageAndLimit(int page, int limit) {
        redstoreAdminAPI.getListOrderPageLimit(page, limit);
    }

    @When("Send request get list order with page and limit")
    public void sendRequestGetListOrderWithPageAndLimit() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_ORDERPAGELIMIT);
    }

    @Given("Get list user with invalid path")
    public void getListUserWithInvalidPath() {
        redstoreAdminAPI.getListUsersInv();
    }

    @When("Send request get list user invalid path")
    public void sendRequestGetListUserInvalidPath() {
        SerenityRest.when()
                .get(RedstoreAdminAPI.GET_LIST_INVALIDURL);
    }

    @Given("Get list order with invalid path")
    public void getListOrderWithInvalidPath() {
        redstoreAdminAPI.getListOrdersInv();
    }

    @When("Send request get list order invalid path")
    public void sendRequestGetListOrderInvalidPath() {
        SerenityRest.when().get(RedstoreAdminAPI.GET_LIST_INVALIDURL);
    }
}
