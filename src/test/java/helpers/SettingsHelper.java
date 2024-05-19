package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import tests.AppManager;

public class SettingsHelper extends HelperBase {
    public SettingsHelper(AppManager appManager) {
        super(appManager);
    }

    @FindBy(xpath = "//*[@id=\"profileTab\"]/ul[1]/li[3]/div/form/p/button")
    private WebElement changeDescriptionButton;

    @FindBy(xpath = "//*[@id=\"profile-description-description\"]")
    private WebElement descriptionInput;

    @FindBy(xpath = "//*[@id=\"profileTab\"]/ul[1]/li[3]/div/form/div/p/button[1]")
    private WebElement updateDescriptionButton;

    @FindBy(xpath = "//*[@id=\"profileTab\"]/ul[1]/li[3]/div/form/p/span")
    private WebElement description;

    private void clickChangeDescriptionButton() {
        changeDescriptionButton.click();
    }

    private void enterDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    private void clickUpdateDescription() {
        updateDescriptionButton.click();
    }

    public String getDescription() {
        return description.getText();
    }

    public void changeDescription(String description) {
        clickChangeDescriptionButton();
        enterDescription(description);
        clickUpdateDescription();
    }
}
