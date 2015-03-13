package playground.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 13.03.15
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverWrapper implements WebDriver {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebDriverWrapper.class);

    private int timeoutSeconds = 5;

    private WebDriver driver;

    public WebDriverWrapper(WebDriver driver){
        this.driver = driver;
    }


    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {

        WebElement el = null;

        try{
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            el = wait.until(
            ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            LOGGER.debug("failed to wait for element by ["+by+"]", e);
        }

        if(el==null)
            LOGGER.debug("failed to get element by ["+by+"]");

        return el;
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }
}
