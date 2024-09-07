package starter.customerstore;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCreatingCustomer {
  Long id = null;
  CustomerApiActions customerApiActions;

  @Test
  public void createCustomerSuccessfully() {
    customerApiActions.givenSetMandatoryInformationCustomer();
    customerApiActions.whenISentPostRequest();
    customerApiActions.thenICreatedCustomer();
  }

  @Test
  public void createCustomerWithIncompleteInformation() {
    customerApiActions.givenSetIncompleteInformationCustomer();
    customerApiActions.whenISentPostRequest();
    customerApiActions.thenINotCreatedCustomer();
  }

  @Test
  public void createCustomerWithInvalidInformation() {
    customerApiActions.givenSetInvalidInformationCustomer();
    customerApiActions.whenISentPostRequest();
    customerApiActions.thenINotCreatedCustomer();
  }

  @Test
  public void getCustomerExistsById() {
    customerApiActions.givenSetEndpointCustomer();
    customerApiActions.whenISentGetRequest("5");
    customerApiActions.thenIGetCustomer();
  }

  @Test
  public void getCustomerNotExistsById() {
    customerApiActions.givenSetEndpointCustomer();
    customerApiActions.whenISentGetRequest("50");
    customerApiActions.thenINotGetCustomer();
  }
}
