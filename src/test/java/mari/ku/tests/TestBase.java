package mari.ku.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mari.ku.config.CredentialsConfig;
import mari.ku.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1600x900";
        Configuration.remote = format("https://%s:%s@%s", credentials.login(), credentials.password(),
                System.getProperty("url","selenoid.autotests.cloud/wd/hub/"));

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
