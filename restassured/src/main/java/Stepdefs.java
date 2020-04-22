import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class Stepdefs {
    @Given("I have correct billing order")
    public void i_have_correct_billing_order() {
        order = new BillingOrder(0, "John", "Smith", "john-smith@gmail.com", "1234567890", "New York", "111111", State.AK, "Line1", "Lin2", 1, "Comment");
    }

    @Given("I have correct billing order with params: {int}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {int}, {string}")
    public void i_have_correct_billing_order_with_params(
            int id, String firstName, String lastName, String email, String phone, String city, String zipCode,
            String state, String addressLine1, String addressLine2, int itemNumber, String comment) {
        order = new BillingOrder(id, firstName, lastName, email, phone, city, zipCode, State.valueOf(state), addressLine1, addressLine2, itemNumber, comment);
    }

    @When("I send this order to API via POST request")
    public void i_send_this_order_to_API_via_POST_request() {
        ApiClient client = new ApiClient();
        response = client.createBillingOrder(order);
    }

    @Then("I receive response with correct HTTP code")
    public void i_receive_response_with_correct_HTTP_code() {
        Assert.assertEquals(200, response.statusCode());
    }

    private BillingOrder order;
    private Response response;
}
