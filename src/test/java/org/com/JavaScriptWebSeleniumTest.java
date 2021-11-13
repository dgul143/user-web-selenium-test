package org.com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Node;

import junit.framework.Assert;

//This test class is designed to test he user web page UI
public class JavaScriptWebSeleniumTest {
	
     static  WebDriver driver = null;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Sama-Java-Training\\Selenium\\Browser-Drivers\\chromedriver_win32\\chromedriver.exe");  
		
		 driver = new ChromeDriver();  
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //maximize window
		  driver.manage().window().maximize();
		  driver.get("http://localhost:8080/WebJavaScript/");
	}
	
	@Before
	public void init() {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless", "--window-size=1920,1200");
      // System.out.println("User_web_Selenium_test.init()"); 
	}
	@After
	public void closeTest(){
		  
	}
	
	@AfterClass
	public static void close() {
		  driver.quit();	  
	}
	
	  
	@Test
	public void verifySecondButttonClickActions() {
	WebElement btnElement = 	driver.
			findElement(By.xpath("/html/body/button"));
	String text = btnElement.getAttribute("value");	
	btnElement.click();
	driver.switchTo().alert().accept();
	//WebElement para = driver.findElement(By.cssSelector("#para"));
	WebElement div = driver.findElement(By.id("div1"));
	 div.click();	
	String alertText = driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	String expected = "This was DIV Block you clicked!";	
	Assert.assertEquals(expected, alertText);   
  
	/*
	 * String value = div.getAttribute("OnClick"); String expected = "testDivBlock";
	 * Assert.assertEquals(expected, text);
	 */
	}
	
	@Test(expected = org.openqa.selenium.NoAlertPresentException.class)
	public void verifyFirstButttonClickActions() {
	WebElement btnElement = 	driver.
			findElement(By.id("btn1"));
	String text = btnElement.getAttribute("value");	
	btnElement.click();
	driver.switchTo().alert().accept();	 
	WebElement div = driver.findElement(By.id("div1"));
	 div.click();		
	driver.switchTo().alert().accept();	 
	Assert.assertTrue(true);
  
	 
	}
	
	
	

}
