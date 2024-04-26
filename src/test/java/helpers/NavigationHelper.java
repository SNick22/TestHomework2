package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.AppManager;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(AppManager appManager, String baseUrl) {
        super(appManager);
        this.baseUrl = baseUrl;
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/header/div/div/div[3]/div[4]/a")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div[2]/section/div/div/a[3]")
    private WebElement discussions;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/header/div/div/div[3]/div[3]/button")
    private WebElement showProfileButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/section/div/div/div[2]/a[7]")
    private WebElement settingsButton;

    private void showProfile() {
        showProfileButton.click();
    }

    private void clickSettingsButton() {
        settingsButton.click();
    }

    public void goToDiscussions() {
        addButton.click();
        discussions.click();
    }

    public void goToSettings() {
        showProfile();
        clickSettingsButton();
    }

    public void openStartPage() {
        driver.get(baseUrl);
    }
}
