import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillingOrderTests {
    @Test
    public void GetBillingOrders() {
        ApiClient client = new ApiClient();
        Response r = client.getBillingOrders();

        Assert.assertEquals(r.statusCode(), 200);
    }

    @Test
    public void GetBillingOrder() {
        ApiClient client = new ApiClient();
        BillingOrder createdOrder = client.createBillingOrder(order).as(BillingOrder.class);
        Response r = client.getBillingOrder(createdOrder.id);

        Assert.assertEquals(r.statusCode(), 200);
    }

    @Test
    public void PostBillingOrder() {
        ApiClient client = new ApiClient();
        Response r = client.createBillingOrder(order);

        Assert.assertEquals(r.statusCode(), 200);
    }

    @Test
    public void DeleteBillingOrder() {
        ApiClient client = new ApiClient();
        BillingOrder createdOrder = client.createBillingOrder(order).as(BillingOrder.class);
        Response r = client.deleteBillingOrder(createdOrder.id);

        Assert.assertEquals(r.statusCode(), 200);
    }

    BillingOrder order = new BillingOrder(0, "John","Doe","john-doe@gmail.com",
            "1234567890","New-York","123456", State.AK,"line1",
            "line2",1,"comment");
}
