package bouvet.loggertestapp;

/**
 * Created by kristoffer.mysen on 26.02.2015.
 */
public abstract class LoggerTest {

  protected static final String MESSAGE = "Debug this!";

  /**
   * Run the test and return the time it took in nanos
   * @return
   */
  public long runTest(int nrOfCalls) {
    long nanos = System.nanoTime();
    for (int i = 0; i < nrOfCalls; i++) {
      logDebugMessage();
    }
    return (System.nanoTime() - nanos) / nrOfCalls;
  }

  public abstract void logDebugMessage();
}
