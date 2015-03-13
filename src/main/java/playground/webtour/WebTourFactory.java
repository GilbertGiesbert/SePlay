package playground.webtour;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 12.03.15
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class WebTourFactory {

    public static WebTour[] buildWebTour(){

//        ListResourceBundle.
//
//        WebTourData tourData = new WebTourData(tourType);
//        if(tourData==null)
//            return null;
//
//        WebTour webTour = null;
//        switch (tourType){
//            case AMAZON:
//                webTour = new AmazonWebTour(crawlerName, driver, tourData);
//                break;
//        }
//        return webTour;

        getTourTypes();

        return null;
    }

    private static String[] getTourTypes(){

        ClassLoader classLoader = WebTourFactory.class.getClassLoader();
        File folder = new File(classLoader.getResource("tourData").getFile());

        return folder.list();

    }
}