package starter.redstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class RedstoreGetUserProductsAPI {

    public static String GET_MY_PRODUCTS = Constants.BASE_URL+"/users/products";
    public static String GET_SINGLE_PRODUCTS = Constants.BASE_URL+"/products/{product_id}";
    public static String GET_All_PRODUCTS = Constants.BASE_URL+"/products?page={page}&limit={limit}";
    public static String GET_ALL_PRODUCTS_PAGE= Constants.BASE_URL+"/products?page={page}";
    public static String GET_ALL_PRODUCTS_LIMIT= Constants.BASE_URL+"/products?limit={limit}";
    public static String GET_SEARCH_PRODUCTS= Constants.BASE_URL+"/products/search?search={type}";
    @Step("Get my products")
    public void setGetMyProducts(){
        SerenityRest.given();
    }

    @Step("Get all products with page and limit")
    public void setGetAllProducts(int page, int limit){
        SerenityRest.given().
        pathParam("page",page)
        .pathParam("limit", limit);

    }
    @Step("Get all products with only page")
    public void setGetAllProductsPage(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Get all products with only limit")
    public void setGetAllProductsLimit(int limit){
        SerenityRest.given().pathParam("limit",limit);
    }
    @Step("Get single product")
    public void setGetSingleProducts(int product_id){
        SerenityRest.given().pathParam("product_id", product_id);
    }
    @Step("Get search product")
    public void setGetSearchProduct(String type){
        SerenityRest.given().pathParam("type",type);
    }

}
