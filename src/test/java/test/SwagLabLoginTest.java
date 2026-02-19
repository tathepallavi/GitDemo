package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import pojo.Browser;
import pom.LoginPage;
import utility.BaseClass;
import utility.Parameterization;

@Listeners(utility.Listeners.class)


public class SwagLabLoginTest extends BaseClass {
	
	@BeforeMethod
	public void openBrowser() {
		driver = Browser.launchChrome();
	}
	
	@Test
	public void swagLabLoginTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		LoginPage loginPage = new LoginPage(driver);
		String user = Parameterization.getExcelData("Data", 0, 0);
		String pass = Parameterization.getExcelData("Data", 1, 0);
		loginPage.enterUserName(user);
		loginPage.enterPassword(pass);
		loginPage.clickOnLogin();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		
		
		
	}
	

}
