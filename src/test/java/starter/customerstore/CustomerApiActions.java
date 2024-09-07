package starter.customerstore;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.Matchers;

public class CustomerApiActions extends UIInteractions {

  @Given("I set mandatory information of customer")
  public void givenSetMandatoryInformationCustomer() {
    Customer customer = new Customer();
    customer.setDateOfBirth("1988-06-25");
    customer.setDocumentType("PASSPORT");
    customer.setFullName("Danilo");
    customer.setIdentityDocument((int)(Math.random()*10*7+1));

    given()
      .baseUri("http://localhost:3000")
      .basePath("/customers")
      .body(customer, ObjectMapperType.GSON)
      .accept(ContentType.JSON)
      .contentType(ContentType.JSON);
  }

  @When("I sent post request")
  public void whenISentPostRequest() {
    when().post();
  }

  @When("I sent get request by id")
  public void whenISentGetRequest(String id) {
    when().get(id);
  }

  @Then("I created customer and return status 201 Created and exists id")
  public void thenICreatedCustomer() {
    then().body("fullName", Matchers.equalTo("Danilo"));
    then().body("id",Matchers.notNullValue());
    then().statusCode(201);
    then().statusLine("HTTP/1.1 201 Created");
  }
  @Then("I geted customer and return status 200 OK and exists id")
  public void thenIGetCustomer() {
    then().body("fullName", Matchers.equalTo("Amelia Doe"));
    then().body("identityDocument", Matchers.equalTo(123456789));
    then().body("documentType", Matchers.equalTo("PASSPORT"));
    then().body("dateOfBirth", Matchers.equalTo("1988-06-25"));
    then().body("id",Matchers.notNullValue());
    then().statusCode(200);
    then().statusLine("HTTP/1.1 200 OK");
  }

  @Then("I not get customer and return status 404 Not Found and exists id")
  public void thenINotGetCustomer() {
    then().statusCode(404);
    then().statusLine("HTTP/1.1 404 Not Found");
  }

  @Given("I set incomplete information of customer")
  public void givenSetIncompleteInformationCustomer() {
    Customer customer = new Customer();
    customer.setDateOfBirth("1988-06-25");
    customer.setFullName("Danilo");
    given()
      .baseUri("http://localhost:3000")
      .basePath("/customers")
      .body(customer, ObjectMapperType.GSON)
      .accept(ContentType.JSON)
      .contentType(ContentType.JSON);
  }

  @Then("I not created customer and return status 400 Bad Request Created and show error message")
  public void thenINotCreatedCustomer() {
    then().statusCode(400);
    then().statusLine("HTTP/1.1 400 Bad Request");
    then().body("error", Matchers.equalTo("Datos de entrada inválidos o incompletos"));
  }

  @Given("I set invalid information of customer")
  public void givenSetInvalidInformationCustomer() {
    Customer customer = new Customer();
    customer.setDateOfBirth("1988-06-25");
    customer.setDocumentType("PASSPORT");
    customer.setFullName("Danilo");
    customer.setIdentityDocument(0);

    given()
      .baseUri("http://localhost:3000")
      .basePath("/customers")
      .body(customer, ObjectMapperType.GSON)
      .accept(ContentType.JSON)
      .contentType(ContentType.JSON);
  }
  @Given("I set invalid information of customer")
  public void givenSetEndpointCustomer() {
    given()
      .baseUri("http://localhost:3000")
      .basePath("/customers")
      .accept(ContentType.JSON)
      .contentType(ContentType.JSON);
  }
}
