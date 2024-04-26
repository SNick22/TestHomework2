package helpers;

import data.LoginData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.AppManager;

public class LoginHelper extends HelperBase {

    public LoginHelper (AppManager appManager) {
        super(appManager);
    }

    @FindBy(xpath = "//*[@id=\"loginModalForm-identity\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"loginModalForm-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/header/div/div/div[3]/button[2]")
    private WebElement showLoginButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/header/div/div/div[3]/div[3]/button")
    private WebElement showProfileButton;

    @FindBy(xpath = "//span[contains(@class, 'flex--1')]")
    private WebElement username;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/section/div/div/div[3]/button")
    private WebElement logoutButton;

    private void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    private void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    private void showLoginBlock() {
        showLoginButton.click();
    }

    public void showProfile() {
        showProfileButton.click();
    }

    public String getUsername() {
        return username.getText();
    }

    public void login(LoginData loginData) {
        showLoginBlock();
        inputEmail(loginData.email);
        inputPassword(loginData.password);
        clickLoginButton();
    }

    public void logout() {
        showProfile();
        logoutButton.click();
    }
}
