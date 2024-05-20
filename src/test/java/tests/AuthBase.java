package tests;

import helpers.LoginHelper;
import org.junit.Before;
import util.Settings;

public class AuthBase extends BaseTest {

    @Before
    public void login() {
        LoginHelper helper = manager.getLoginHelper();
        helper.login(Settings.validLogin);
    }
}
