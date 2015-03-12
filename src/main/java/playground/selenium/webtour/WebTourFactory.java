package playground.selenium.webtour;

import org.openqa.selenium.WebDriver;
import playground.selenium.WebDriverFactory;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 12.03.15
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class WebTourFactory {

    public static WebTour buildWebTour(String crawlerName, WebDriver driver, WebTourType tourType){

        WebTourData tourData = new WebTourData(tourType);
        if(tourData==null)
            return null;

        WebTour webTour = null;
        switch (tourType){
            case AMAZON:
                webTour = new AmazonWebTour(crawlerName, driver, tourData);
                break;
        }
        return webTour;
    }
}