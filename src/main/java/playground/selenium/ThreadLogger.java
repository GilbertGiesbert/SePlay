package playground.selenium;

import org.slf4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: joern
 * Date: 12.03.15
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public class ThreadLogger {

    public static void log(String msg, Logger logger){

        String thread = Thread.currentThread().getName();

        logger.debug("["+thread+"]: "+msg);
    }
}
