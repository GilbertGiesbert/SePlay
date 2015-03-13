package playground.app;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import playground.selenium.WebDriverFactory;
import playground.webtour.WebTour;

/**
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 11.03.15
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class Crawler extends Thread{

    private final static Logger LOGGER = LoggerFactory.getLogger(Crawler.class);

    private WebTour webTour;

    public Crawler(String name, WebTour webTour){
        super(name);
        this.webTour = webTour;
    }

    public void run(){
        LOGGER.debug("started crawler");

        WebDriver driver = WebDriverFactory.buildWebDriver();
        if(driver==null){
            LOGGER.debug("failed to build driver");
            return;
        }

        boolean run = true;
        int remainingRestarts = 3;

        while(run && remainingRestarts > 0){

            try{
                webTour.start(driver);
                run = false;

            }catch(Exception e){
                LOGGER.debug("crashed on web tour", e);

                if(isSeleniumGridConnectionProblems(e)){

                    remainingRestarts--;
                    LOGGER.debug("restarting wen tour due to seleniumGridConnectionProblems");
                    LOGGER.debug("remaining restarts: "+remainingRestarts);

                }else{
                    run = false;
                }
            }
        }

        if(driver != null)
            driver.quit();

        LOGGER.debug("finished crawler");
    }

    private boolean isSeleniumGridConnectionProblems(Exception e) {

        // TODO: e.g. check if e was some how caused by UnreachableBrowserException
        return false;
    }
}