package playground.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import playground.selenium.Crawler;
import playground.selenium.webtour.WebTourType;

public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
        new App().start();
    }

    private void start(){

        for(int i = 0; i < 1; i++){

            Crawler thread = new Crawler(i, WebTourType.AMAZON);
            thread.start();
        }
    }
}