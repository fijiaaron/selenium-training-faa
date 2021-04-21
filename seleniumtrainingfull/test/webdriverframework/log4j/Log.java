/*
 * We have created one common class which is used to print log on various types of outputs. 
 */
package webdriverframework.log4j;
 
import org.apache.log4j.Logger;
 
public class Log {
 
/*
 *  Initialize Log4j logs
 */
 
private static Logger Log = Logger.getLogger(Log.class.getName());//
 
/*
 *  This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
 */
 
public static void startTestCase(String testCase){
 
Log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
 
Log.info("                                   "+testCase+ "                                      ");
 
Log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
 
}
 
/*
 * This is to print log for the ending of the test case
 */
 
public static void endTestCase(String testCase){
 
Log.info("@@@@@@@@@@@@@@@             "+"Test Case "+ testCase + "Completed    @@@@@@@@@@@@@@@@@@@@");
 
}
 
/*
 *  Need to create these methods, so that they can be called  
 */
 
public static void info(String message) {
 
Log.info(message);
 
}
 
public static void warn(String message) {
 
    Log.warn(message);
 
}
 
public static void error(String message) {
 
    Log.error(message);
 
}
 
public static void fatal(String message) {
 
    Log.fatal(message);
 
}
 
public static void debug(String message) {
 
    Log.debug(message);
 
}
 
}