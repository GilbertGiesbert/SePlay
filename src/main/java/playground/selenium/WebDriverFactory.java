package playground.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final static Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);

    public static WebDriver buildWebDriver(){

        DesiredCapabilities capability = DesiredCapabilities.firefox();

        WebDriver driver = null;
//        try {
//            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//        } catch (MalformedURLException e) {
//            LOGGER.debug("problems building WebDriver");
//            e.printStackTrace();
//        }

        driver = new FirefoxDriver();

        LOGGER.debug("started ["+driver.getClass().getSimpleName()+"]");


        return driver;
    }
}