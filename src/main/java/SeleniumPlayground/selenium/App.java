package SeleniumPlayground.selenium;

import java.util.logging.Logger;


public class App {

    private final static Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main( String[] args ){
        new App().start();
    }

    private void start(){

        for(int i = 0; i < 10; i++){

            WebDriveThread thread = new WebDriveThread("thread"+i);
            thread.start();
        }
    }
}
