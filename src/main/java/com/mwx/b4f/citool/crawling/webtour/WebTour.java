package com.mwx.b4f.citool.crawling.webtour;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 11.03.15
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public abstract class WebTour {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebTour.class);

    protected WebDriver driver;
    protected TourData tourData;
    protected String tourName;

    public WebTour(String tourName, TourData tourData){
        this.tourName = tourName;
        this.tourData = tourData;
    }

    public void start(WebDriver driver){

        this.driver = driver;

        LOGGER.debug("started tour");

        driver.get(tourData.get("loginPage"));

        doLogin();

        String pageSource = driver.getPageSource();

        LOGGER.debug("finished tour");
    }

    protected abstract void doLogin();

    public String getTourName(){
        return tourName;
    }
}