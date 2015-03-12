package playground.selenium.webtour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 11.03.15
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class AmazonWebTour extends WebTour{

    private final static Logger LOGGER = LoggerFactory.getLogger(AmazonWebTour.class);

    public AmazonWebTour(String webBot, WebDriver driver, WebTourData tourData) {
        super(webBot, driver, tourData);
    }

    @Override
    protected void doLogin(){
        LOGGER.debug(crawlerName +" on "+ tourName +": login()");

        WebElement element = driver.findElement(By.id("ap_email"));
        String loginName = tourData.get("loginName");
        element.sendKeys(loginName);

        element = driver.findElement(By.id("ap_password"));
        String loginPswd = tourData.get("loginPswd");
        element.sendKeys(loginPswd);


        element = driver.findElement(By.id("signInSubmit"));
        element.submit();
    }
}