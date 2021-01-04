import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
        record TravelDetail(
        @JsonProperty("firstName")
        String firstName,
        @JsonProperty("lastName")
        String lastName,
        @JsonProperty("email")
        String email,
        @JsonProperty("mobileNumber")
        String mobileNumber,
        @JsonProperty("specialRequests")
        String specialRequests,
        @JsonProperty("donation")
        Integer donation,
        @JsonProperty("paymentButton")
        String paymentButton) {
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class TravelDetailLombok {
    @JsonProperty("firstName")
    String firstName;
    @JsonProperty("lastName")
    String lastName;
    @JsonProperty("email")
    String email;
    @JsonProperty("mobileNumber")
    String mobileNumber;
    @JsonProperty("specialRequests")
    String specialRequests;
    @JsonProperty("donation")
    Integer donation;
    @JsonProperty("paymentButton")
    String paymentButton;
}

public class RecordExample {
    public static void main(String[] args) {
        String stringBlock = """
                firstName: "Avi"
                lastName: "Cohen"
                email: "avi.cohen@bbc.co.uk"
                mobileNumber: "90091929222"
                specialRequests: "Not applicable"
                donation: 65
                paymentButton: "Not applicable"
                """;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            TravelDetail travelDetail1 = objectMapper.readValue(stringBlock, TravelDetail.class);
            System.out.println(travelDetail1);
            new TravelDetailLombok().setEmail("abc");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
