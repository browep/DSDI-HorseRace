package com.github.browep.dsdihorserace;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1000;

    /**
     * total number of starts to do
     */
    public static final int NUMBER_OF_STARTS = 200;
    private static final String TAG = MainActivity.class.getCanonicalName();

    /**
     * number of starts left to do
     */
    private int startLeft;
    private long startTime;
    private Class<? extends Activity> activityClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginRaceVanilla(View view) {
        activityClass = VanillaActivity.class;
        beginRace();
    }

    private void beginRace() {
        startLeft = NUMBER_OF_STARTS;
        startTime = System.currentTimeMillis();
        startActivity();
    }

    private void startActivity() {
        Log.i(TAG, "starting activity " + activityClass.getName() + " #" + (NUMBER_OF_STARTS - startLeft));
        startActivityForResult(new Intent(this, activityClass), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && startLeft > 0) {
            startLeft--;
            startActivity();
        } else if (requestCode == REQUEST_CODE && startLeft == 0) {

            long totalTime = System.currentTimeMillis() - startTime;
            long avgTime = totalTime/NUMBER_OF_STARTS;
            Log.i(TAG, activityClass + ": total time: " + totalTime + "ms ms per start: " + avgTime );
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void beginRaceInjected(View view) {
        activityClass = InjectedActivity.class;
        beginRace();
    }
}
