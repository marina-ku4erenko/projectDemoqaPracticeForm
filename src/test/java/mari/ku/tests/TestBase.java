package mari.ku.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mari.ku.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {


    @BeforeAll
    static void beforeAll() {


        /*
                String browser = System.getProperty("browser");
        String version = System.getProperty("version");
        String size = System.getProperty("size");
        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub");
        String login = System.getProperty("login");
        String pass = System.getProperty("pass");
        * */


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1600x900";
        // Configuration.browserSize = System.getProperty("browserSize", "1600x900");
        //Configuration.browser = System.getProperty("browser", "chrome");
        // Configuration.browserVersion = System.getProperty("browserVersion", "91");

        String remoteUrl = System.getProperty("remoteUrl");
        String user = System.getProperty("user");
        String password = System.getProperty("password");

        // Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.remote = "https://" + user + ":" + password + "@" + remoteUrl;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
