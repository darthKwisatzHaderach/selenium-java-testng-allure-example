import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BillingOrder {
    @JsonProperty("id")
    public int id;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("email")
    public String email;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("city")
    public String city;

    @JsonProperty("zipCode")
    public String zipCode;

    @JsonProperty("state")
    public State state;

    @JsonProperty("addressLine1")
    public String addressLine1;

    @JsonProperty("addressLine2")
    public String addressLine2;

    @JsonProperty("itemNumber")
    public int itemNumber;

    @JsonProperty("comment")
    public String comment;

    @JsonCreator
    public BillingOrder(
            @JsonProperty("id")
            int id,
            @JsonProperty("firstName")
            String firstName,
            @JsonProperty("lastName")
            String lastName,
            @JsonProperty("email")
            String email,
            @JsonProperty("phone")
            String phone,
            @JsonProperty("city")
            String city,
            @JsonProperty("zipCode")
            String zipCode,
            @JsonProperty("state")
            State state,
            @JsonProperty("addressLine1")
            String addressLine1,
            @JsonProperty("addressLine2")
            String addressLine2,
            @JsonProperty("itemNumber")
            int itemNumber,
            @JsonProperty("comment")
            String comment)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.itemNumber = itemNumber;
        this.comment = comment;
    }
}