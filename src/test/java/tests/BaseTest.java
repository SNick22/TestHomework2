package tests;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.After;
import org.junit.BeforeClass;

public class BaseTest {

    protected static AppManager manager;
    protected static XmlMapper mapper = new XmlMapper();

    @BeforeClass
    public static void setup() {
        manager = AppManager.getInstance();
        manager.getNavigationHelper().openStartPage();
    }

    @After
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}
