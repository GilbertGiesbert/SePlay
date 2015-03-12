package playground.selenium.webtour;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 11.03.15
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public abstract class WebTour {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebTour.class);

    protected WebTourData tourData;
    protected String tourName;
    protected String crawlerName;
    protected WebDriver driver;

    public WebTour(String crawlerName, WebDriver driver, WebTourData tourData){
        this.crawlerName = crawlerName;
        this.driver = driver;
        this.tourData = tourData;
        this.tourName = tourData.get("tourName");
    }

    public void start(){

        LOGGER.debug(crawlerName +" on "+ tourName +": started");

        driver.get(tourData.get("loginPage"));

        doLogin();

        LOGGER.debug(crawlerName +" on "+ tourName +": finished");
    }

    protected abstract void doLogin();

    public WebDriver getDriver() {
        return driver;
    }
}
