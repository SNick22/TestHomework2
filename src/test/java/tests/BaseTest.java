package tests;

import org.junit.BeforeClass;

public class BaseTest {

    protected static AppManager manager;

    @BeforeClass
    public static void setup() {
        manager = AppManager.getInstance();
    }
}
