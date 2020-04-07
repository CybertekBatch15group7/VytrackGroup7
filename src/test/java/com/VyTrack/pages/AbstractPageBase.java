package com.VyTrack.pages;


import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.Driver;
import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * THis class will be extended by page classes
 * And common weblements/locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicated page class to store elements from that menu
 */
public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

   @FindBy (css = "#user-menu > a")
    protected WebElement currentUser;

    public AbstractPageBase(){
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     *
     * Method for vytrack navigation. Provide tabname and module name to navigate
     * @param tabName like Dashboards, Fleet or Customers
     * @param moduleName like Vehicles,
     */
    public void navigateTo(String tabName, String moduleName){
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName+"')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='"+moduleName+"']" ;

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);
        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        //increase wait time if still failing
        BrowserUtils.wait(10);
    }
}
