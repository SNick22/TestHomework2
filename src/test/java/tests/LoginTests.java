package tests;

import helpers.LoginHelper;
import model.LoginData;
import org.junit.Test;
import util.Settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void loginFail() throws InterruptedException {
        manager.getNavigationHelper().openStartPage();
        LoginData invalidLoginData = new LoginData();
        invalidLoginData.username = "qwerty";
        invalidLoginData.email = "qwerty";
        invalidLoginData.password = "qwerty";

        LoginHelper helper = manager.getLoginHelper();

        if (helper.isLoggedIn()) {
            helper.logout();
        }

        Thread.sleep(1000);
        helper.login(invalidLoginData);
        Thread.sleep(1000);
        assertTrue(helper.isErrorPassword());
    }

    @Test
    public void login() {
        manager.getNavigationHelper().openStartPage();
        LoginHelper helper = manager.getLoginHelper();

        if (helper.isLoggedIn()) {
            helper.logout();
        }

        helper.login(Settings.validLogin);
        helper.showProfile();
        String username = helper.getUsername();
        helper.showProfile();
        assertEquals(Settings.validLogin.username, username);
    }
}
