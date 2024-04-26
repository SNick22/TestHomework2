package tests;

import data.LoginData;
import helpers.LoginHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        manager.getNavigationHelper().openStartPage();
        LoginHelper loginHelper = manager.getLoginHelper();
        LoginData loginData = new LoginData("noxem40711@abnovel.com", "Azat3310977!");
        loginHelper.login(loginData);
        loginHelper.showProfile();
        String username = loginHelper.getUsername();
        loginHelper.showProfile();
        assertEquals("testuser112233", username);
        loginHelper.logout();
    }
}
