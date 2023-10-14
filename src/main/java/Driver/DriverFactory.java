package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import property.PropertyReaders;

public class DriverFactory {

    public static WebDriver createFireFox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        PropertyReaders pr = PropertyReaders.read();
        for (String str : pr.get("firefox.options").split(",")) {
            options.addArguments(str.trim());
        }
        return new FirefoxDriver(options);
    }

    public static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        PropertyReaders pr = PropertyReaders.read();
        for (String str : pr.get("chrome.options").split(",")) {
            options.addArguments(str.trim());
        }
        return new ChromeDriver(options);
    }



}
