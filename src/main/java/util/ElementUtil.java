package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	GenericObjects GO= new GenericObjects();
	WebDriverWait wait;
	
	public void elementToBeVisibleWait(By ele) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(Browser.getDriver().findElement(ele)));
	}
	
	public void elementToBePresentWait(By ele) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}
	public void elementsToBeVisibleWait(List<WebElement> vehiclesList) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(vehiclesList));
		
	}
	public void elementToBeVisibleWait(WebElement ele) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
}
