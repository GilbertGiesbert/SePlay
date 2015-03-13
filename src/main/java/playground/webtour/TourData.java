package playground.webtour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Copyright mediaworx berlin AG, Berlin, Germany
 * User: joern
 * Date: 12.03.15
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class TourData {

    private final static Logger LOGGER = LoggerFactory.getLogger(TourData.class);

    private Properties properties;

    public TourData(Properties properties){
        this.properties = properties;
    }

    public String get(String key){

        String data = properties.getProperty(key);
        if(data == null)
            LOGGER.debug("missing tour data for key ["+key+"]");

        return data;
    }
}