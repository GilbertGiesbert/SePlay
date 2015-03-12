package SeleniumPlayground.selenium;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
        new App().start();
    }

    private void start(){

//        for(int i = 0; i < 10; i++){
//
//            WebDriveThread thread = new WebDriveThread("thread"+i);
//            thread.start();
//        }

        System.out.println("logger enabled="+logger.isDebugEnabled());
logger.

        logger.warn("This is warn : ");
        logger.error("This is error : ");
        logger.warn("This is warn : ");
        logger.error("This is error : ");

    }
}
