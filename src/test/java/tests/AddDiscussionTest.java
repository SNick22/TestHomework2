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
public class AddDiscussionTest extends AuthBase {

    private final AddDiscussionData addDiscussionData;

    @Parameterized.Parameters
    public static Collection<Object> data() throws IOException {
        FileInputStream fis2 = new FileInputStream("src/test/java/data/discussion_data.xml");
        String xml2 = new String(fis2.readAllBytes(), StandardCharsets.UTF_8);
        fis2.close();
        AddDiscussionData[] discussionDatas = mapper.readValue(xml2, AddDiscussionData[].class);
        return Arrays.stream(discussionDatas).map((x) -> (Object) x).toList();
    }

    public AddDiscussionTest(AddDiscussionData addDiscussionData) {
        super();
        this.addDiscussionData = addDiscussionData;
    }

    @Test
    public void testAddDiscussion() {
        AddDiscussionHelper addDiscussionHelper = manager.getAddDiscussionHelper();
        NavigationHelper navigationHelper = manager.getNavigationHelper();
        navigationHelper.goToDiscussions();
        addDiscussionHelper.addDiscussion(addDiscussionData);
        String discussionTitle = addDiscussionHelper.getDiscussionTitle();
        addDiscussionHelper.deleteDiscussion();
        assertEquals(addDiscussionData.title, discussionTitle);
    }
}
