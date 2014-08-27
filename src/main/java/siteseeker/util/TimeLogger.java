package siteseeker.util;

import org.apache.commons.logging.Log;

public class TimeLogger {

  private long beginTime;
  private long lastLogTime;
  private Log log;
  private String NL = System.getProperty("line.separator");
    
  public TimeLogger(Log log) {
    this.log = log; 
    lastLogTime = beginTime = System.currentTimeMillis();
  }
    
  public void logCurrentTime(String message) {
    long currentTime = System.currentTimeMillis();
    log.debug(message + NL 
              + "Elapsed: " + (currentTime - lastLogTime) + " ms" + NL
              + "Total: " + (currentTime - beginTime) + " ms");
    lastLogTime = currentTime;
  }
}

