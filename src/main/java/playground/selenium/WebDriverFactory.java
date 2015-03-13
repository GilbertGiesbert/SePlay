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
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 11.03.15
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverFactory {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);

    public static WebDriver buildWebDriver(){

        WebDriver driver;

        boolean useLocal = true;
        if(useLocal)
            driver = new FirefoxDriver();
        else
            driver = buildRemoteDriver();

        LOGGER.debug("started ["+driver.getClass().getSimpleName()+"]");

        driver = new WebDriverWrapper(driver);

        return driver;
    }

    private static WebDriver buildRemoteDriver(){

        WebDriver driver = null;
        DesiredCapabilities capability = DesiredCapabilities.firefox();

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        } catch (MalformedURLException e) {
            LOGGER.debug("problems building WebDriver");
            e.printStackTrace();
        }
        return driver;
    }
}