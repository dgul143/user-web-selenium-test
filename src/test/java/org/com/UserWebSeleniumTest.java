package org.com;

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
public class UserWebSeleniumTest {
	
     static  WebDriver driver = null;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Sama-Java-Training\\Selenium\\Browser-Drivers\\chromedriver_win32\\chromedriver.exe");  
		
		 driver = new ChromeDriver();  
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //maximize window
		  driver.manage().window().maximize();
		  driver.get("http://localhost:8080/MyWeb/user.html");
	}
	
	@Before
	public void init() {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless", "--window-size=1920,1200");
       System.out.println("User_web_Selenium_test.init()"); 
	}
	@After
	public void closeTest(){
		  
	}
	
	@AfterClass
	public static void close() {
		  driver.quit();	  
	}
	
	 @Test
	  public void testUserPageTitle() {
		  String actual = driver.getTitle();
		  String expected = "My Page";
		  Assert.assertEquals(expected, actual);	  
	  }
	
	@Test
	public void verifyParaText() {
	WebElement paraElement = 	driver.findElement(By.id("para1"));
	String text = paraElement.getText();
	String expected = "This is first line of paragrpah";
	Assert.assertEquals(expected, text);	  
	}
	
	@Test
	public void verifyParaTextByClass() {
	WebElement paraElement = 	driver.findElement(By.className("myclass"));
	String text = paraElement.getText();
	String expected = "This is first line of paragrpah";
	Assert.assertEquals(expected, text);	  
	}
	
	@Test
	public void verifyParaTextByTag() {
	WebElement paraElement = 	driver.findElement(By.tagName("p"));
	String text = paraElement.getText();
	String expected = "This is first line of paragrpah";
	Assert.assertEquals(expected, text);	  
	}
	
	@Test
	public void verifyParaTextColor() {
	WebElement paraElement = 	driver.findElement(By.xpath("//*[@id=\"para1\"]"));
	String color = paraElement.getCssValue("color");
	String expected = "rgba(255, 0, 0, 1)";
	Assert.assertEquals(expected, color);	  
	}
	
	
	@Test
	public void verifyH3TextByTag() {
	WebElement paraElement = 	driver.findElement(By.tagName("h3"));
	String text = paraElement.getText();
	String expected = "Welcome to my page";
	Assert.assertEquals(expected, text);	  
	}
	
	@Test
	public void verifyMarqueeTag() {
	WebElement paraElement = 	driver.findElement(By.tagName("marquee"));
	String text = paraElement.getText();
	String expected = "This is a protected page!";
	Assert.assertEquals(expected, text);	  
	}
	
	@Test
	public void verifyMarqueeAttributes() {
	WebElement marqueeElement = 	driver.findElement(By.tagName("marquee"));
	String text = marqueeElement.getAttribute("direction");
	System.out.println("The attribute is "+text);
	String expected = "";
	Assert.assertEquals(expected, text);	  
	}
	
	@Test
	public void verifySecondParaGraphByCssSelector() {
	WebElement para = 	driver.findElement(By.cssSelector("body > p:nth-child(4)"));
	String text = para.getText();	 
	String expected = "This is my image";			 
	Assert.assertEquals(expected, text);	  
	}
	
	
	@Test
	public void verifySecondParaGraphByXPath() {
	WebElement para = 	driver.findElement(By.xpath("/html/body/p[2]"));
	String text = para.getText();	 
	String expected = "This is my image";			 
	Assert.assertEquals(expected, text);	  
	}
	
	
	@Test
	public void verifySecondParaGraphImage() {
	WebElement image = 	driver
			.findElement(By.cssSelector("body > p:nth-child(4) > img"));
	String src = image.getAttribute("src");
	String expected = "http://localhost:8080/MyWeb/game.jfif";
	Assert.assertEquals(expected, src);	  
	}
	
	
	@Test
	public void verifyImageWidth() {
	WebElement image = 	driver
			.findElement(By.xpath("/html/body/p[2]/img"));
	String width = image.getAttribute("width");
	String expected = "250";
	Assert.assertEquals(expected, width);	
	 
	}
	
	
	@Test
	public void verifyImageHeight() {
	WebElement image = 	driver
			.findElement(By.xpath("/html/body/p[2]/img"));	 
	String height = image.getAttribute("height");
	String value = "180";
	Assert.assertEquals(value, height);	
	}
	@Test
	@Ignore
	public void verifySecondParaGraphTextByXPath() {
		By select = By.xpath("/html/body/p[2]/text()"); 
		 
   // WebElement para= 	driver.findElement(ByXPath.xpath("/html/body/p[2]/text()"));
			  
    //	String text = para.getText();	 
	String expected = "This is my image";			 
	//Assert.assertEquals(expected, text);	  
	}
	
	
	@Test
	public void verifyParagraphAlignment() {
	WebElement para = 	driver
			.findElement(By.xpath("/html/body/p[2]"));
	String value = para.getCssValue("text-align");
	String expected = "right";
	Assert.assertEquals(expected, value);	
	 
	}
	
	
	
	

}
