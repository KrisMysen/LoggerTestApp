package bouvet.loggertestapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kristoffer.mysen on 26.02.2015.
 */
public class LogBackNativeTest extends LoggerTest {

  private static final Logger log = LoggerFactory.getLogger(LogBackNativeTest.class);

  @Override
  public void logDebugMessage() {
    log.debug(MESSAGE);
  }
}
