package com.mwx.b4f.citool.crawling.webtour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 12.03.15
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class WebTourFactory {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebTourFactory.class);

    public static List<WebTour> buildTourList(){

        List<WebTour> tourList = new ArrayList<WebTour>();

        String tourDataFolderPath = "tourData";
        String prefixTourDataFile = "tourData_";
        String fileEndingTourDataFile = ".properties";

        File tourDataFolder = null;

        try{
            ClassLoader classLoader = WebTourFactory.class.getClassLoader();
            tourDataFolder = new File(classLoader.getResource(tourDataFolderPath).getFile());
        }catch (Exception e){
            LOGGER.debug("failed to load tourData from path ["+tourDataFolderPath+"]");
        }

        if(tourDataFolder != null){

            File tourFile[] = tourDataFolder.listFiles();

            for(File file: tourFile){
                if(file.getName().startsWith(prefixTourDataFile) && file.getName().endsWith(fileEndingTourDataFile)){

                    Properties props = new Properties();
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        props.load(fis);
                    } catch (Exception e) {
                        LOGGER.debug("failed to load tourData from file ["+file.getName()+"]");
                    }

                    if(props != null){

                        String tourName = file.getName();
                        tourName = tourName.replace(prefixTourDataFile, "");
                        tourName = tourName.replace(fileEndingTourDataFile, "");

                        TourData tourData = new TourData(props);

                        WebTour webTour = buildWebTour(tourName, tourData);
                        if(webTour==null){
                            LOGGER.debug("failed to get WebTour class for name ["+tourName+"]");
                        }else{
                            tourList.add(webTour);
                        }
                    }
                }
            }
        }
        return tourList;
    }

    private static WebTour buildWebTour(String tourName, TourData tourData){

        WebTour webTour = null;

        if("amazon".equals(tourName)){
            webTour = new AmazonWebTour(tourName, tourData);
        }

        return webTour;
    }
}