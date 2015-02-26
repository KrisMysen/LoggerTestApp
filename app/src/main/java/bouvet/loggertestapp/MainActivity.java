package bouvet.loggertestapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

  private static final int[] NR_OF_CALLS_LIST = new int[] {1,10,100,1000,10000};
  private List<LoggerTest> loggerTests;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TextView resultView = (TextView) findViewById(R.id.result_textview);
    resultView.setMovementMethod(new ScrollingMovementMethod());
    setupTests();
  }

  private void setupTests() {
    loggerTests = new ArrayList<>();
    loggerTests.add(new NativeTest());
    loggerTests.add(new LogBackNativeTest());
    loggerTests.add(new LogBackExtractMethodTest());
  }

  public void runTests(View view) {
    StringBuilder builder = new StringBuilder();

    for (int nrOfCalls : NR_OF_CALLS_LIST) {
      builder.append(runTests(nrOfCalls).concat("\n"));
    }

    TextView textView = (TextView) findViewById(R.id.result_textview);
    textView.setText(builder.toString());
  }

  private String runTests(int nrOfCalls) {
    StringBuilder builder = new StringBuilder();
    for (LoggerTest loggerTest : loggerTests) {
      long duration = loggerTest.runTest(nrOfCalls);
      builder.append(createReturnMessage(loggerTest, duration, nrOfCalls));
    }
    return builder.toString();
  }

  private String createReturnMessage(LoggerTest loggerTest, long duration, int nrOfCalls) {
    double durationInMillis = duration / 1000000.0;
    return loggerTest.getClass().getSimpleName() + "::It took an average of " + durationInMillis + " ms to call debug. Averaged " + nrOfCalls + " debug messages.\n";
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


}