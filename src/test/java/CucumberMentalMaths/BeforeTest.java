package CucumberMentalMaths;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BeforeTest {

    public static WebDriver chromeDriver;
    public static Properties prop;

    @Before
    public void BeforeSteps() throws IOException {
        final String propFile = "/home/abbas/LocalRepo/CucumberMentalMaths/src/test/java/CucumberMentalMaths/Locators.properties";
        File file = new File(propFile);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        prop.load(fileInput);
        System.out.println(prop.getProperty("Username_field"));
        System.setProperty("webdriver.chrome.driver", "/home/abbas/webdrivers/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.get("http://localhost:5000/login");
    }

    @After
    public void AfterSteps() {
        System.out.println("bye - kill webdriver manually for now");
    }

}

