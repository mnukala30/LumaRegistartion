package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dataHelpers.CreateAccountData;
import util.CommonUtils;
import util.ElementUtil;
import util.GenericObjects;




public class CreateAccountPage {
	
	private WebDriver driver;
	GenericObjects GO= new GenericObjects();
	ElementUtil EU = new ElementUtil();
	CreateAccountData CAD = new CreateAccountData();
	public CreateAccountPage(WebDriver driver)

	 {
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(xpath="//span[text()='Create New Customer Account']")
	private WebElement createAccountHeaderInfo;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameInput;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameInput;
	
	@FindBy(xpath="//input[@id='email_address']")
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	private WebElement confirmPasswordInput;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	private WebElement createAnAccountBtn;
	
	@FindBy(xpath="(//a[text()='Create an Account'])[1]")
	private WebElement createAccountLink;
	
	@FindBy(xpath="(//a[contains(text(),'Sign In')])[1]")
	private WebElement signInLink;
	
	@FindBy(xpath="//span[text()='Customer Login']")
	private WebElement customerLoginHeader;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@title='Password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@name='send'])[1]")
	private WebElement signInBtn;
	
	@FindBy(xpath="//*[text()='Thank you for registering with Fake Online Clothing Store.']")
	private WebElement accountCreationSuccess;
	
	@FindBy(xpath="//div[text()='This is a required field.']")
	private WebElement requiredFieldError;
	
	@FindBy(xpath="//*[text()='This is a required field.']")
	private List<WebElement> fieldError;
	
	@FindBy(xpath="(//span[@class='customer-name'])[1]/button")
	private WebElement dropdownBtn;
	
	@FindBy(xpath="(//a[contains(text(),'Sign Out')])[1]")
	private WebElement signOutLnk;
	
	@FindBy(xpath="(//span[text()='Default welcome msg!'])[1]")
	private WebElement welcomeMsg;
	
	public void createNewAccount() {
		
		EU.elementToBeVisibleWait(createAccountHeaderInfo);
		Assert.assertEquals(createAccountHeaderInfo.getText(), "Create New Customer Account", "Header Text is verified");
		
		CAD.setFirstName(CommonUtils.randomName(10));
		firstNameInput.sendKeys(CAD.getFirstName());
		CAD.setLastName(CommonUtils.randomName(10));
		lastNameInput.sendKeys(CAD.getLastName());
		CAD.setEmailInfo(CommonUtils.randomEmail());
		emailInput.sendKeys(CAD.getEmailInfo());
		CAD.setPassword(CommonUtils.randomString(15));
		passwordInput.sendKeys(CAD.getPassword());
		confirmPasswordInput.sendKeys(CAD.getPassword());
	}
	
	public void createNewAccountWithMissingInfo(String missingInfo) {
		
		EU.elementToBeVisibleWait(createAccountHeaderInfo);
		Assert.assertEquals(createAccountHeaderInfo.getText(), "Create New Customer Account", "Header Text is verified");
		switch(missingInfo) {
		case "firstName": 
			lastNameInput.sendKeys(CommonUtils.randomName(10));
			CAD.setEmailInfo(CommonUtils.randomEmail());
			emailInput.sendKeys(CAD.getEmailInfo());
			CAD.setPassword(CommonUtils.randomString(10));
			passwordInput.sendKeys(CAD.getPassword());
			confirmPasswordInput.sendKeys(CAD.getPassword());
			break;
		case "lastName":
			firstNameInput.sendKeys(CommonUtils.randomName(10));
			CAD.setEmailInfo(CommonUtils.randomEmail());
			emailInput.sendKeys(CAD.getEmailInfo());
			CAD.setPassword(CommonUtils.randomString(10));
			passwordInput.sendKeys(CAD.getPassword());
			confirmPasswordInput.sendKeys(CAD.getPassword());
			break;
		
		case "Email":
			firstNameInput.sendKeys(CommonUtils.randomName(10));
			lastNameInput.sendKeys(CommonUtils.randomName(10));
			CAD.setPassword(CommonUtils.randomString(10));
			passwordInput.sendKeys(CAD.getPassword());
			confirmPasswordInput.sendKeys(CAD.getPassword());
			break;
		case "Password":
			firstNameInput.sendKeys(CommonUtils.randomName(10));
			lastNameInput.sendKeys(CommonUtils.randomName(10));
			CAD.setEmailInfo(CommonUtils.randomEmail());
			emailInput.sendKeys(CAD.getEmailInfo());
			CAD.setPassword(CommonUtils.randomString(10));
			confirmPasswordInput.sendKeys(CAD.getPassword());
			break;
			
		case "ConfirmPassword":
			firstNameInput.sendKeys(CommonUtils.randomName(10));
			lastNameInput.sendKeys(CommonUtils.randomName(10));
			CAD.setEmailInfo(CommonUtils.randomEmail());
			emailInput.sendKeys(CAD.getEmailInfo());
			CAD.setPassword(CommonUtils.randomString(10));
			passwordInput.sendKeys(CAD.getPassword());
		break;
		}
	}
	
	public void clickOnCreateAccount() {
		createAccountLink.click();
	}
	public void LoginToApplication() {
		
		signInLink.click();
		EU.elementToBeVisibleWait(customerLoginHeader);
		email.sendKeys(CAD.getEmailInfo());
		password.sendKeys(CAD.getPassword());
		signInBtn.click();
		
	}
	public void clickOnCreateAccountAfterFillingInfo() {
		createAnAccountBtn.click();
	}
	public void verifyAccountSuccessMessage() {
		EU.elementToBeVisibleWait(accountCreationSuccess);
	}
	public String verifyFieldMissingErrorMessage() {
		EU.elementToBeVisibleWait(requiredFieldError);
		return requiredFieldError.getText();
	}
	public int getErrorMessagesCount() {
		EU.elementsToBeVisibleWait(fieldError);
		return fieldError.size();
	}
	public void verifyUserNameDetails() {
		EU.elementToBeVisibleWait(GO.pText(CAD.getFirstName(), CAD.getLastName()));
		EU.elementToBePresentWait(GO.returnUsingTxt(CAD.getEmailInfo()));
		
	}
	public void signInOutOfApplication() {
		dropdownBtn.click();
		signOutLnk.click();
		EU.elementToBeVisibleWait(welcomeMsg);
		
	}
}
