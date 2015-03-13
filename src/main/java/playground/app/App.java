package playground.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import playground.webtour.WebTour;
import playground.webtour.WebTourFactory;

import java.util.List;

/**
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 11.03.15
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
        new App().start();
    }

    private void start(){

        List<WebTour> tourList = WebTourFactory.buildTourList();

        int index = 0;
        for(WebTour tour: tourList){

            String crawlerName = "Crawler_"+(index++)+"_"+tour.getTourName();

            Crawler thread = new Crawler(crawlerName, tour);
            thread.start();
        }
    }
}