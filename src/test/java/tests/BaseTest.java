package tests;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.BeforeClass;

public class BaseTest {

    protected static AppManager manager;
    protected static XmlMapper mapper = new XmlMapper();

    @BeforeClass
    public static void setup() {
        manager = AppManager.getInstance();
    }
}
