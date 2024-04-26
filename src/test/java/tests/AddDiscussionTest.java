package tests;

import data.AddDiscussionData;
import data.LoginData;
import helpers.AddDiscussionHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddDiscussionTest extends BaseTest {

    @Test
    public void testAddDiscussion() {
        LoginHelper loginHelper = manager.getLoginHelper();
        AddDiscussionHelper addDiscussionHelper = manager.getAddDiscussionHelper();
        NavigationHelper navigationHelper = manager.getNavigationHelper();
        AddDiscussionData addDiscussionData = new AddDiscussionData("test title", "test description");
        LoginData loginData = new LoginData("noxem40711@abnovel.com", "Azat3310977!");
        navigationHelper.openStartPage();
        loginHelper.login(loginData);
        navigationHelper.goToDiscussions();
        addDiscussionHelper.addDiscussion(addDiscussionData);
        String discussionTitle = addDiscussionHelper.getDiscussionTitle();
        addDiscussionHelper.deleteDiscussion();
        loginHelper.logout();
        assertEquals(addDiscussionData.title, discussionTitle);
    }
}
