package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;

import hooks.Hooks;

public class ExampleSteps {

    private Response response;
    private ExtentTest test = Hooks.getTest();


    @Given("I set GET service endpoint")
    public void i_set_get_service_endpoint() {
        baseURI = "https://reqres.in/api";
        test.info("Setting Base URL:" + baseURI);
    }

    @When("I send GET HTTP request")
    public void i_send_get_http_request() {
        response = given().when().get("/users?page=2");
        test.info(MarkupHelper.createJsonCodeBlock(response.asString()));
    }

    @Then("I receive valid HTTP response")
    public void i_receive_valid_http_response() {
        response.then().statusCode(200);
        test.pass("Validated the response code");
    }
}
