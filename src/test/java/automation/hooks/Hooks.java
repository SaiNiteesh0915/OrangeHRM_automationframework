package automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    public static WebDriver webDriver;
    public static Properties properties;

    @Before
    public void setup () {
        loadProperties(); //Load Config file

        //Setup ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_drivers/chromedriver");
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = properties.getProperty("url");
        webDriver.get(url);
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    private void loadProperties () {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Unable to load config.properties: " + e.getMessage());
        }
    }
}
