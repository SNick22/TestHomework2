package tests;

import helpers.AddDiscussionHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.SettingsHelper;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.Destructor;
import util.Settings;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class AppManager {

    private final AddDiscussionHelper addDiscussionHelper;
    private final LoginHelper loginHelper;
    private final NavigationHelper navigationHelper;
    private final SettingsHelper settingsHelper;
    private final WebDriver driver;

    private AppManager() {
        new Settings();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        addDiscussionHelper = new AddDiscussionHelper(this);
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, Settings.baseUrl);
        settingsHelper = new SettingsHelper(this);
        Destructor.addManagerDestructor(this);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public AddDiscussionHelper getAddDiscussionHelper() {
        return addDiscussionHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SettingsHelper getSettingsHelper() {
        return settingsHelper;
    }

    public void stop() {
        driver.quit();
    }

    private static final AppManager instance = new AppManager();

    public static AppManager getInstance() {
        return instance;
    }
}
