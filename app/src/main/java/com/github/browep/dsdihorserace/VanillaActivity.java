package com.github.browep.dsdihorserace;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class VanillaActivity extends AppCompatActivity {

    private static final String TAG = VanillaActivity.class.getCanonicalName();

    DSDIApplication.DataFacade dataFacade;
    DSDIApplication.NetworkFacade networkFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);

        dataFacade = ((DSDIApplication) (getApplicationContext())).dependencySupplier.dataFacade;
        networkFacade = ((DSDIApplication) (getApplicationContext())).dependencySupplier.networkFacade;

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
