package StepDefinitions;

import Common.Charger;
import Common.Parameters;
import Common.UserRegisterDto;
import Common.UserOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class LinkUserCharger {
    private ValidatableResponse apiResponse;
    private UserRegisterDto user = UserRegisterDto.newUser();
    private String token;


    @Given("App is up and running")
    public void appServiceIsUpAndRunning() {
        String verifyMessage;

        this.apiResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all()
                .get(Parameters.getUrl())
                .then()
                .log().ifError()
                .statusCode(200);
        verifyMessage = apiResponse.extract().jsonPath().getString("message");
        Assert.assertEquals(verifyMessage, "Wallbox Challenge API REST is up and running!");
        System.out.println("Message = " + verifyMessage  );

    }


    @Given("admin token has generated")
    public void adminTokenHasGenerated() {
        Map<String, String> formBody = new HashMap<String, String>() {{
            put("email", user.getEmail());
            put("password", user.getPassword());
        }};
        Response response = RestAssured.given()
                .baseUri(Parameters.getUrl())
                .contentType(ContentType.JSON)
                .body(formBody)
                .post("/signin")
                .then()
                .log().all()
                .extract()
                .response();
        this.token = "Bearer " + response.jsonPath()
                .getString("jwt");
        System.out.println("token = " + token );

    }

    @When("admin create Charger with model {string}")
    public void adminCreateChargerWithModel(String arg0) {

        RestAssured.given()
                .baseUri(Parameters.getUrl())
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(Charger.newCharger(arg0))
                .log().all()
                .post("/chargers")
                .then()
                .log().all()
                .statusCode(200);
    }


    @Then("charger is created correctly")
    public void chargerIsCreatedCorrectly() {
    }

    @When("admin create user with {string}")
    public void adminCreateUserWith(String arg0) {
    }

    @Then("user has created correctly")
    public void userHasCreatedCorrectly() {
    }

    @When("admin links user and charger")
    public void adminLinksUserAndCharger() {
    }

    @Then("user and charger linked correctly")
    public void userAndChargerLinkedCorrectly() {
    }


}
