package mari.ku.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mari.ku.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {


    @BeforeAll
    static void beforeAll() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        System.getProperty("browser", "chrome");
        System.getProperty("browserVersion", "91");
        System.getProperty("browserSize", "1600x900");

        String remoteUrl = System.getProperty("remoteUrl");
        String user = System.getProperty("user");
        String password = System.getProperty("password");
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
        closeWebDriver();

    }

}
