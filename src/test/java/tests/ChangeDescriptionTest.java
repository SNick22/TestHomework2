package tests;

import model.LoginData;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.SettingsHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ChangeDescriptionTest extends BaseTest {

    private final LoginData loginData;

    @Parameterized.Parameters
    public static Collection<Object> data() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/data/login_data.xml");
        String xml = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
        fis.close();
        LoginData[] loginDatas = mapper.readValue(xml, LoginData[].class);
        return Arrays.stream(loginDatas).map((x) -> (Object) x).toList();
    }

    public ChangeDescriptionTest(LoginData loginData) {
        super();
        this.loginData = loginData;
    }

    @Test
    public void testChangeDescription() throws InterruptedException {
        LoginHelper loginHelper = manager.getLoginHelper();
        NavigationHelper navigationHelper = manager.getNavigationHelper();
        SettingsHelper settingsHelper = manager.getSettingsHelper();
        String description = "test description";
        navigationHelper.openStartPage();
        loginHelper.login(loginData);
        navigationHelper.goToSettings();
        settingsHelper.changeDescription(description);
        Thread.sleep(1000);
        String actualDescription = settingsHelper.getDescription();
        manager.getWebDriver().manage().deleteAllCookies();
        assertEquals(description, actualDescription);
    }
}
