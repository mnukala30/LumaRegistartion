package stepDefinations;

import java.util.Properties;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CreateAccountPage;
import util.Browser;
import util.ConfigurationReader;

public class AccountCreationSteps {

	ConfigurationReader CR = new ConfigurationReader();
	Properties Prop = CR.init_prop();
	CreateAccountPage createAccountPage;

	@Given("Open the browser and Launch the application")
	public void open_the_browser() {
		Browser.getLogger().log(Status.INFO, "Browser is launched successfully");
		Browser.getDriver().get(Prop.getProperty("url"));
		Browser.getLogger().log(Status.INFO, "Loaded with url " + Prop.getProperty("url"));
	}

	@Given("User clicks on Create An Account link")
	public void user_clicks_on_create_an_account_link() {
		createAccountPage = new CreateAccountPage(Browser.getDriver());
		createAccountPage.clickOnCreateAccount();
	}

	@Given("User provides all personal information")
	public void user_provides_all_personal_information() {
		createAccountPage.createNewAccount();
	}

	@When("User clicks on Create An Account button")
	public void user_clicks_on_create_an_account_button() {
		createAccountPage.clickOnCreateAccountAfterFillingInfo();
	}

	@Then("Account is successfully created")
	public void account_is_successfully_created() {
		createAccountPage.verifyAccountSuccessMessage();
	}

	@Given("User provides personal information by missing {string}")
	public void user_provides_all_personal_information_by_missing(String missingInfo) {
		createAccountPage.createNewAccountWithMissingInfo(missingInfo);
	}

	@Then("User verifies the error message for missing field")
	public void user_verifies_the_error_message_for_missing_field() {
		String errorMessage = createAccountPage.verifyFieldMissingErrorMessage();
		Assert.assertEquals(errorMessage, "This is a required field.", "Error Message while missing field is verified");
	}

	@Then("User verifies the error message for missing all fields")
	public void user_verifies_the_error_message_for_missing_all_fields() {

		Assert.assertEquals(createAccountPage.getErrorMessagesCount(), 5, "Getting error message for all fields");
	}

	@Then("Verify the account details in the home page")
	public void verify_the_account_details_in_the_home_page() {
		createAccountPage.verifyUserNameDetails();
	}
	@When("User logs out and signIn")
	public void user_logs_out_and_signIn() {
		createAccountPage.signInOutOfApplication();
		createAccountPage.LoginToApplication();
	}
}
