package com.github.browep.dsdihorserace;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class InjectedActivity extends AppCompatActivity {

    private static final String TAG = InjectedActivity.class.getCanonicalName();
    @Inject
    DSDIApplication.DataFacade dataFacade;

    @Inject
    DSDIApplication.NetworkFacade networkFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);
        ((DSDIApplication) getApplicationContext()).inject(this);

        // make sure they are not-null
        Log.d(TAG, dataFacade.toString());
        Log.d(TAG, networkFacade.toString());


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                finish();;
            }
        });
    }
}
