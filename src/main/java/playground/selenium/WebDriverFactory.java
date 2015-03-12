package playground.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 11.03.15
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverFactory {

    public static WebDriver buildWebDriver(){

        DesiredCapabilities capability = DesiredCapabilities.firefox();

        WebDriver driver = null;

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
        return driver;
    }
}
