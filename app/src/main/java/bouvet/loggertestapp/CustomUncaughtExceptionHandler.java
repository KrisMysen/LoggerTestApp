package bouvet.loggertestapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kristoffer.mysen on 02.03.2015.
 */
public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

  private Logger log = LoggerFactory.getLogger(CustomUncaughtExceptionHandler.class);

  private final Thread.UncaughtExceptionHandler defaultUEH;

  public CustomUncaughtExceptionHandler(final Thread.UncaughtExceptionHandler defaultUEH) {
    this.defaultUEH = defaultUEH;
  }

  @Override
  public void uncaughtException(Thread thread, Throwable ex) {
    log.error("Test", ex);

    defaultUEH.uncaughtException(thread, ex);
  }
}
