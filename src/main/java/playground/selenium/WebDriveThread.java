package playground.selenium;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 11.03.15
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class WebDriveThread extends Thread{

    public WebDriveThread(String name){
        super(name);
    }

    public void run(){

        System.out.println("starting wdThread "+getName());

        WebDriver driver = null;

        boolean run = true;
        int repeatCount = 0;

        while(run && repeatCount < 3){

            try{
                driver = WebDriverFactory.buildWebDriver();
                if(driver != null){
                    WebDrive webDrive = new WebDrive();
                    webDrive.start(getName(), driver);
                }
                run = false;

            }catch(Exception e){
                System.out.println("problems on wdThread "+getName());

                if(isSeleniumGridConnectionProblems(e)){

                    repeatCount++;
                    System.out.println("repeating wdThread "+getName()+" because of UnreachableBrowserException, repeatCount="+repeatCount);
                }
            }
        }

        if(driver != null)
            driver.quit();

        System.out.println("closing wdThread "+getName());
    }

    private boolean isSeleniumGridConnectionProblems(Exception e) {

        // TODO: e.g. check if e was some how caused by UnreachableBrowserException
        return false;
    }
}
