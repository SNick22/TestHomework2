package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tests.AppManager;

public class HelperBase {

    protected WebDriver driver;
    protected AppManager manager;

    protected HelperBase(AppManager appManager) {
        this.manager = appManager;
        this.driver = appManager.getWebDriver();
        PageFactory.initElements(driver, this);
    }
}
