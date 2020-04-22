import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiClient {
    public Response createBillingOrder(BillingOrder order) {
        return given()
                .contentType("application/json")
                .body(order)
                .when()
                .post(BASE_URL + BILLING_ORDER_ENDPOINT);
    }

    public Response getBillingOrders() {
        return get(BASE_URL + BILLING_ORDER_ENDPOINT);
    }

    public Response getBillingOrder(int id) {
        return get(BASE_URL + BILLING_ORDER_ENDPOINT + "/" + id);
    }

    public Response deleteBillingOrder(int id) {
        return delete(BASE_URL + BILLING_ORDER_ENDPOINT + "/" + id);
    }

    static final String BASE_URL = "http://localhost:8080";
    static final String BILLING_ORDER_ENDPOINT = "/BillingOrder";
}
