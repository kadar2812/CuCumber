package com.demo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step1 {
	
	static WebDriver driver;
	
	@Given("People Launch the Application")
	public void people_Launch_the_Application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abdul\\OneDrive\\Desktop\\Samples\\driv\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://demo.guru99.com/telecom/index.html");
	    driver.manage().window().maximize();
	}
	
	public static void handleFrame() {
	try
	{
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.id("flow_close_btn_iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("closeBtn")).click();
		driver.switchTo().defaultContent();
	}
	
	catch (Exception e)
	{
		e.printStackTrace();
	}
	}

	@When("people clicks the Add Customer")
	public void people_clicks_the_Add_Customer() {
		
		handleFrame();
		
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	   
	}

	@When("fills the fields")
	public void fills_the_fields() {
		handleFrame();
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys("Abdul");
		driver.findElement(By.id("lname")).sendKeys("kadar");
		driver.findElement(By.id("email")).sendKeys("abdulkadar2812@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Pudukkottai");
		driver.findElement(By.id("telephoneno")).sendKeys("8124329094");
	    
	}
	@When("fills the fields with one Dim List")
	public void fills_the_fields_with_one_Dim_List(io.cucumber.datatable.DataTable dataTable) {
	    List<String> asList = dataTable.asList(String.class);
	    handleFrame();
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(asList.get(0));
		driver.findElement(By.id("lname")).sendKeys(asList.get(1));
		driver.findElement(By.id("email")).sendKeys(asList.get(2));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(asList.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(asList.get(4));
	}
	
	@When("fills the fields with one Dim Map")
	public void fills_the_fields_with_one_Dim_Map(io.cucumber.datatable.DataTable data) {
		Map<String, String> asMap = data.asMap(String.class, String.class);
		handleFrame();
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(asMap.get("fname"));
		driver.findElement(By.id("lname")).sendKeys(asMap.get("lname"));
		driver.findElement(By.id("email")).sendKeys(asMap.get("mail"));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(asMap.get("ad"));
		driver.findElement(By.id("telephoneno")).sendKeys(asMap.get("phn"));
	}
		
	
	@Then("clicks the submit")
	public void clicks_the_submit() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		handleFrame();
Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
WebElement text = driver.findElement(By.xpath("(//td[@align='center'])[3]"));
String s = text.getText();
System.out.println(s);
	}


	
	
	

}
