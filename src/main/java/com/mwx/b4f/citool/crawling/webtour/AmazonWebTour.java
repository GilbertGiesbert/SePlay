package com.mwx.b4f.citool.crawling.webtour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 11.03.15
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class AmazonWebTour extends WebTour {

    private final static Logger LOGGER = LoggerFactory.getLogger(AmazonWebTour.class);

    public AmazonWebTour(String tourName, TourData tourData) {
        super(tourName, tourData);
    }

    @Override
    protected void doLogin(){
        LOGGER.debug("doLogin()");

        // login on login page doesn't work
        // not even for humans
        doLoginOnRegisterPage();
    }

    private void doLoginOnLoginPage(){
        LOGGER.debug("doLoginOnLoginPage()");

        WebElement element = driver.findElement(By.id("ap_email"));
        String loginName = tourData.get("loginName");
        element.sendKeys(loginName);

        element = driver.findElement(By.id("ap_password"));
        String loginPswd = tourData.get("loginPswd");
        element.sendKeys(loginPswd);

        element = driver.findElement(By.id("signInSubmit"));
        element.submit();
    }

    private void doLoginOnRegisterPage(){
        LOGGER.debug("doLoginOnRegisterPage()");

        WebElement el = driver.findElement(By.id("registrationLink"));
        el.click();

        el = driver.findElement(By.id("ap_customer_name"));
        String fullName = tourData.get("fullName");
        el.sendKeys(fullName);

        el = driver.findElement(By.id("ap_email"));
        String email = tourData.get("email");
        el.sendKeys(email);

        el = driver.findElement(By.id("ap_email_check"));
        el.sendKeys(email);

        el = driver.findElement(By.id("ap_password"));
        String loginPswd = tourData.get("loginPswd");
        el.sendKeys(loginPswd);

        el = driver.findElement(By.id("ap_password_check"));
        el.sendKeys(loginPswd);

        el = driver.findElement(By.id("continue"));
        el.click();
    }
}