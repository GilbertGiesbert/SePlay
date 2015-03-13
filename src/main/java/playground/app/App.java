package playground.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import playground.webtour.WebTourData;
import playground.webtour.WebTourFactory;
import playground.webtour.WebTourType;

public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
        new App().start();
    }

    private void start(){

//        for(int i = 0; i < 1; i++){
//
//            Crawler thread = new Crawler(i, WebTourType.AMAZON);
//            thread.start();
//        }

        WebTourFactory.buildWebTour();
    }
}