package playground.selenium.webtour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 12.03.15
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class WebTourData {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebTourData.class);

    private ResourceBundle data;

    public WebTourData(WebTourType tourType){

        try{
            data = ResourceBundle.getBundle(""+tourType);
        }catch (Exception e){
            LOGGER.debug("failed to get data for tour ["+tourType+"]");
        }
    }

    public String get(String key){

        try{
            return data.getString(key);
        }catch (Exception e){
            LOGGER.debug("failed to get data["+key+"] for tour ["+data.getBaseBundleName()+"]");
            return null;
        }
    }
}