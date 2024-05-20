package tests;

import helpers.NavigationHelper;
import helpers.SettingsHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

public class ChangeDescriptionTest extends AuthBase {

    @Test
    public void testChangeDescription() throws InterruptedException {
        NavigationHelper navigationHelper = manager.getNavigationHelper();
        SettingsHelper settingsHelper = manager.getSettingsHelper();
        String description = "test description";
        navigationHelper.goToSettings();
        settingsHelper.changeDescription(description);
        Thread.sleep(1000);
        String actualDescription = settingsHelper.getDescription();
        assertEquals(description, actualDescription);
    }
}
