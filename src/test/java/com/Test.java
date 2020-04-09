package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserUtils;
import utilities.DriverFactory;

public class Test {
    private WebDriver driver;
    private Actions actions;
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
     @org.testng.annotations.Test
    public void test1(){
        wait = new WebDriverWait(driver, 10);
        WebElement vehicle = driver.findElement(By.linkText("Fleet"));
        WebElement vehicleContact = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span"));
         actions.moveToElement(vehicle).pause(5).moveToElement(vehicleContact).click().perform();
         wait.until(ExpectedConditions.titleIs("All - Vehicle Contract - Entities - System - Car - Entities - System"));

         WebElement actualResult= driver.findElement(By.cssSelector("h1[class=oro-subtitle]"));
         String actualR=actualResult.getText();
         Assert.assertEquals(actualR,"All Vehicle Contract");



    }
}