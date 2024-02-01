package starter.redstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class RedstoreAdminAPI {
    public static String GET_LIST_USER = Constants.BASE_URL + "/admin/users";
    public static String GET_LIST_USERPAGE = Constants.BASE_URL + "/admin/users?page={page}";
    public static String GET_LIST_USERLIMIT = Constants.BASE_URL + "/admin/users?limit={limit}";
    public static String GET_LIST_USERPAGELIMIT = Constants.BASE_URL + "/admin/users?page={page}&limit={limit}";

    public static String GET_LIST_ORDER = Constants.BASE_URL + "/admin/orders";
    public static String GET_LIST_ORDERPAGE = Constants.BASE_URL + "/admin/orders?page={page}";
    public static String GET_LIST_ORDERLIMIT = Constants.BASE_URL + "/admin/orders?limit={limit}";
    public static String GET_LIST_ORDERPAGELIMIT = Constants.BASE_URL + "/admin/orders?page={page}&limit={limit}";

    public static String GET_LIST_INVALIDURL = Constants.BASE_URL + "/admin/usersss";

    @Step("Get list users")
    public void getListUsers(){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN);
    }
    @Step("Get list user page")
    public void getListUserPage(int page){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN)
                .pathParam("page", page);
    }
    @Step("Get list user limit")
    public void getListUserLimit(int limit){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN)
                .pathParam("limit", limit);
    }
    @Step("Get list user page and limit")
    public void getListUserPageLimit(int page, int limit){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN)
                .pathParam("page", page)
                .pathParam("limit", limit);
    }

    @Step("Get list order")
    public void getListOrders(){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN);
    }
    @Step("Get list order page")
    public void getListOrderPage(int page){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN)
                .pathParam("page", page);
    }
    @Step("Get list order limit")
    public void getListOrderLimit(int limit){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN)
                .pathParam("limit", limit);
    }


    @Step("Get list user page and limit")
    public void getListOrderPageLimit(int page, int limit){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN)
                .pathParam("page", page)
                .pathParam("limit", limit);
    }

    @Step("Get list users")
    public void getListUsersInv(){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN);
    }

    @Step("Get list users")
    public void getListOrdersInv(){
        SerenityRest.given()
                .header("Authorization", Constants.ADMIN_TOKEN);
    }
}
