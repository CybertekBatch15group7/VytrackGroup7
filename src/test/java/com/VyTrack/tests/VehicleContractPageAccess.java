package com.VyTrack.tests;

import com.VyTrack.pages.LoginPage;
import com.VyTrack.pages.fleet.VehicleContractPage;
import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class VehicleContractPageAccess extends AbstractTestBase{

    @Test(dataProvider = "credentials")
    public void verifyAccess(String userName, String password){
        test=report.createTest("Verify access to Contract Page");
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as " + userName);
        BrowserUtils.wait(2);
        VehicleContractPage vehicleContractPage = new VehicleContractPage();
        vehicleContractPage.navigateTo("Fleet", "Vehicle Contracts");
        Assert.assertEquals(Driver.getDriver().getTitle(), "All - Vehicle Contract - Entities - System - Car - Entities - System");
        test.pass("Access to Contract Page verified");


    }


    @DataProvider
    public Object [][] credentials(){
        return new Object [][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"}
        };
    }
}
