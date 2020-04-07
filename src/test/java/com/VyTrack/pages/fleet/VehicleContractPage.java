package com.VyTrack.pages.fleet;

import com.VyTrack.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleContractPage extends AbstractPageBase {

    @FindBy(xpath = "//title")
    private WebElement title;

    private WebElement createVehicleContract;

}
