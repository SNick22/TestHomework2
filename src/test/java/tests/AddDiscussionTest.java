package tests;

import model.AddDiscussionData;
import model.LoginData;
import helpers.AddDiscussionHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AddDiscussionTest extends BaseTest {

    private final LoginData loginData;
    private final AddDiscussionData addDiscussionData;

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws IOException {
        FileInputStream fis1 = new FileInputStream("src/test/java/data/login_data.xml");
        String xml1 = new String(fis1.readAllBytes(), StandardCharsets.UTF_8);
        fis1.close();
        LoginData[] loginDatas = mapper.readValue(xml1, LoginData[].class);
        FileInputStream fis2 = new FileInputStream("src/test/java/data/discussion_data.xml");
        String xml2 = new String(fis2.readAllBytes(), StandardCharsets.UTF_8);
        fis2.close();
        AddDiscussionData[] discussionDatas = mapper.readValue(xml2, AddDiscussionData[].class);
        List<Object[]> objects = new ArrayList<>();
        for (LoginData data : loginDatas) {
            for (AddDiscussionData discussionData : discussionDatas) {
                objects.add(new Object[]{data, discussionData});
            }
        }
        return objects;
    }

    public AddDiscussionTest(LoginData loginData, AddDiscussionData addDiscussionData) {
        super();
        this.loginData = loginData;
        this.addDiscussionData = addDiscussionData;
    }

    @Test
    public void testAddDiscussion() {
        LoginHelper loginHelper = manager.getLoginHelper();
        AddDiscussionHelper addDiscussionHelper = manager.getAddDiscussionHelper();
        NavigationHelper navigationHelper = manager.getNavigationHelper();
        navigationHelper.openStartPage();
        loginHelper.login(loginData);
        navigationHelper.goToDiscussions();
        addDiscussionHelper.addDiscussion(addDiscussionData);
        String discussionTitle = addDiscussionHelper.getDiscussionTitle();
        addDiscussionHelper.deleteDiscussion();
        manager.getWebDriver().manage().deleteAllCookies();
        assertEquals(addDiscussionData.title, discussionTitle);
    }
}
