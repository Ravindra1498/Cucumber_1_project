package com.amazon.automation.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class StepDefs {

    WebDriver driver;
    String base_url = "https://amazon.in";
    int implicit_wait_timeout_in_sec = 20;

 
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
    
    @Given("User navigated to the home application url")
    public void User_navigated_to_the_home_application_url()
    {
    	driver.get(base_url);
    	String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    	String acutalTitle = driver.getTitle();
    	Assert.assertEquals("Home paage Title validation", expectedTitle,acutalTitle);
    	
    }
    
    @When("User Search for product {string}")
    public void User_search_for_product(String productName)
    {
    	WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
    	WebElement searchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
    	searchBox.sendKeys(productName);
    	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
    }
    @Then("Search Result page is displayed")
    public void Search_result_page_is_display()
    {
    	WebDriverWait webDriverWait2 = new WebDriverWait(driver,20);
    	webDriverWait2.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));
    	Assert.assertEquals("page title validation","Amazon.in : Laptop",driver.getTitle());
    	
    }
    
    @When("click on fashion category on home page")
    public void click_on_fashion_category()
    {
    	WebElement FashionLinkBtn = driver.findElement(By.xpath("//div[@id='nav-xshop']//a[text()='Fashion']"));
    	FashionLinkBtn.click();
    }
    @Then("Fashion page is displayed")
    public void Fashion_page_is_displayed()
    {
    	WebDriverWait webDriverWait = new WebDriverWait(driver,20);
    	webDriverWait.until(ExpectedConditions.titleIs("Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids"));
    	Assert.assertEquals("Page Title not match","Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids",driver.getTitle());	
    }
    

    
    
    
    
   
}
