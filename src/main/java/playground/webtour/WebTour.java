package playground.webtour;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 11.03.15
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public abstract class WebTour {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebTour.class);

    protected WebDriver driver;
    protected WebTourData tourData;
    protected String tourName;

    public WebTour(String tourName, WebTourData tourData){
        this.tourName = tourName;
        this.tourData = tourData;
    }

    public void start(WebDriver driver){

        this.driver = driver;

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
