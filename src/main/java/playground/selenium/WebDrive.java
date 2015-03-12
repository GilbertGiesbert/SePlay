package playground.selenium;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 11.03.15
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class WebDrive {



    public void start(String threadName, WebDriver driver){

        System.out.println("started webDrive with "+threadName);

        driver.get("http://www.google.com");
        driver.get("http://www.hrs.com");
        driver.get("http://www.amazon.com");

        System.out.println("finished webDrive with "+threadName);
    }
}
