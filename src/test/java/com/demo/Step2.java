package com.demo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step2  {
	static WebDriver driver;
	@Given("People Launchs the Application")
	public void people_Launchs_the_Application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abdul\\OneDrive\\Desktop\\Samples\\driv\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://demo.guru99.com/telecom/index.html");
	    driver.manage().window().maximize();
	    
	}
	
	@When("people click the Add Tariff")
	public void people_click_the_Add_Tariff() {
		
		Step1.handleFrame();
		
	    driver.findElement(By.xpath("(//a[text()='Add Tariff Plan'])[1]")).click();
	}

	@When("fills the field with two dim List")
	public void fills_the_field_with_two_dim_List(io.cucumber.datatable.DataTable data) {
		Step1.handleFrame();
		List<List<String>> asLists = data.asLists(String.class);
		
		driver.findElement(By.id("rental1")).sendKeys(asLists.get(0).get(2));
		driver.findElement(By.id("local_minutes")).sendKeys(asLists.get(1).get(3));
		driver.findElement(By.id("inter_minutes")).sendKeys(asLists.get(3).get(1));
		driver.findElement(By.id("sms_pack")).sendKeys(asLists.get(2).get(1));
		driver.findElement(By.id("minutes_charges")).sendKeys(asLists.get(3).get(1));
		driver.findElement(By.id("inter_charges")).sendKeys(asLists.get(0).get(3));
		driver.findElement(By.id("sms_charges")).sendKeys(asLists.get(2).get(0));
	}
	
	@When("fills the field with two dim Map")
	public void fills_the_field_with_two_dim_map(io.cucumber.datatable.DataTable data) {
		Step1.handleFrame();
		List<Map<String, String>> asMaps = data.asMaps(String.class, String.class);
		
		driver.findElement(By.id("rental1")).sendKeys(asMaps.get(0).get("MR"));
		driver.findElement(By.id("local_minutes")).sendKeys(asMaps.get(1).get("LMC"));
		driver.findElement(By.id("inter_minutes")).sendKeys(asMaps.get(3).get("SMS"));
		driver.findElement(By.id("sms_pack")).sendKeys(asMaps.get(2).get("FSP"));
		driver.findElement(By.id("minutes_charges")).sendKeys(asMaps.get(3).get("FLM"));
		driver.findElement(By.id("inter_charges")).sendKeys(asMaps.get(0).get("SMS"));
		driver.findElement(By.id("sms_charges")).sendKeys(asMaps.get(2).get("MR"));
	}

	@Then("click the submit")
	public void click_the_submit() throws Exception {
		Step1.handleFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
Assert.assertTrue(driver.findElement(By.xpath("//header[@class='align-center']")).isDisplayed());
System.out.println("Valid");
	}



}
