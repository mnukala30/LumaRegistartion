package util;

import org.openqa.selenium.By;

public class GenericObjects {
	
	
	public By pText(String firstName,String lastName) {
		return By.xpath("//p[contains(text(),'"+firstName+" "+ lastName+"')]");
	}
	public By returnUsingTxt(String email) {
		return By.xpath("//*[text()='"+email+"']");
	}
	
}
