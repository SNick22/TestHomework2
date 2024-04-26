package tests;

import data.LoginData;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.SettingsHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeDescriptionTest extends BaseTest {

    @Test
    public void testChangeDescription() {
        LoginHelper loginHelper = manager.getLoginHelper();
        NavigationHelper navigationHelper = manager.getNavigationHelper();
        SettingsHelper settingsHelper = manager.getSettingsHelper();
        LoginData loginData = new LoginData("noxem40711@abnovel.com", "Azat3310977!");
        String description = "test description";
        navigationHelper.openStartPage();
        loginHelper.login(loginData);
        navigationHelper.goToSettings();
        settingsHelper.changeDescription(description);
        String actualDescription = settingsHelper.getDescription();
        loginHelper.logout();
        assertEquals(description, actualDescription);
    }
}
