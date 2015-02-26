package bouvet.loggertestapp;

import android.util.Log;

/**
 * Created by kristoffer.mysen on 26.02.2015.
 */
public class NativeTest extends LoggerTest {

  private static final String TAG = NativeTest.class.getName();

  @Override
  public void logDebugMessage() {
    Log.d(TAG, MESSAGE);
  }
}
