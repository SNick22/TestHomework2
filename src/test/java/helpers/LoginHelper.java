package helpers;

import model.LoginData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.AppManager;

import java.util.Objects;

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

    public boolean isLoggedIn() {
        return !driver.findElements(By.xpath("//*[@id=\"main\"]/div[3]/header/div/div/div[3]/div[3]/button")).isEmpty();
    }

    public boolean isLoggedIn(String username) {
        showProfile();
        String actualUsername = getUsername();
        showProfile();
        return Objects.equals(actualUsername, username);
    }

    public boolean isErrorPassword() {
        return passwordField.getDomAttribute("class").contains("input--mode-error");
    }

    public void login(LoginData loginData) {
        if (isLoggedIn()) {
            if (isLoggedIn(loginData.username)) {
                return;
            } else {
                logout();
            }
        }

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
