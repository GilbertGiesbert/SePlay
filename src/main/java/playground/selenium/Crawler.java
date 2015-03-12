package playground.selenium;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import playground.selenium.webtour.WebTour;
import playground.selenium.webtour.WebTourFactory;
import playground.selenium.webtour.WebTourType;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 11.03.15
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class Crawler extends Thread{

    private final static Logger LOGGER = LoggerFactory.getLogger(Crawler.class);

    private int id;
    private WebTourType tourType;

    public Crawler(int id, WebTourType tourType){
        super(Crawler.class.getSimpleName()+"_"+id);
        this.id = id;
        this.tourType = tourType;
    }

    public void run(){
        LOGGER.info("-----------------------------------");
        LOGGER.debug("["+getName()+"] on ["+tourType+"] started");

        WebDriver driver = WebDriverFactory.buildWebDriver();
        if(driver==null){
            LOGGER.debug("["+getName()+"] failed to build driver, will skip "+tourType);
            return;
        }

        WebTour tour = null;
        boolean run = true;
        int remainingRestarts = 3;

        while(run && remainingRestarts > 0){

            try{
                tour = WebTourFactory.buildWebTour(getName(), driver, tourType);
                if(tour!=null)
                    tour.start();

                run = false;

            }catch(Exception e){
                LOGGER.debug("["+getName()+"] on ["+tourType+"] crashed");

                if(isSeleniumGridConnectionProblems(e)){

                    remainingRestarts--;
                    LOGGER.debug("["+getName()+"] on ["+tourType+"]: restarting due to seleniumGridConnectionProblems");
                    LOGGER.debug("["+getName()+"] on ["+tourType+"]: remaining restarts: "+remainingRestarts);

                }else{
                    run = false;
                }
            }
        }

        if(driver != null)
            driver.quit();

        LOGGER.debug("["+getName()+"] on ["+tourType+"] finished");
    }

    private boolean isSeleniumGridConnectionProblems(Exception e) {

        // TODO: e.g. check if e was some how caused by UnreachableBrowserException
        return false;
    }
}
