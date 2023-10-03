package org.saucedemo.Bases;

import EnumPage.Browsers;
import io.cucumber.java.AfterAll;
import io.cucumber.messages.types.Product;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
public class BasePage {
    public static WebDriver driver;
    public WebDriverWait wait;
    public Properties prop;
    private String config="src/test/resources/Properties/User.properties";
    public BasePage() {
        try{
            prop =new Properties();
            InputStream fis = new FileInputStream(config);
            prop.load(fis);
        }  catch (IOException e) {
            e.getMessage();
        }
    }
    public void initialization() {
        String browser=prop.getProperty("Browser");
        if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
            driver = new ChromeDriver(chromeOptions);
            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
//                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            if (browser.equalsIgnoreCase(Browsers.IE.name())) {
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        driver.manage().timeouts().pageLoadTimeout(Browsers.pageLoadTime);
        driver.manage().timeouts().implicitlyWait(Browsers.implicitlyWait);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(30)).
                pollingEvery(Duration.ofMillis(500)).
                withTimeout(Duration.ofSeconds(30)).
                ignoring(NoSuchElementException.class);
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get(prop.getProperty("Login_URL"));
    }

}
