package stepdefs;

import Driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void befor(){
        Driver.getDriver();

    }

    @After(order = 0)
    public void after() {
        Driver.quitDriver();

    }
    @After(order = 1)
    public void after1(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshoot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshoot, "image/png", scenario.getName());
        }
    }
}
