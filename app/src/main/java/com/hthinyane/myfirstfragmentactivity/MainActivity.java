package com.hthinyane.myfirstfragmentactivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentOne.OnButtonPressedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration config = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentOne ls_fragment = new FragmentOne();
            fragmentTransaction.replace(android.R.id.content, ls_fragment);
        } else {
            FragmentTwo pm_fragment = new FragmentTwo();
            fragmentTransaction.replace(android.R.id.content, pm_fragment);
        }

        fragmentTransaction.commit();
    }

    public void onButtonPressed(String s) {
        FragmentOne fragment = (FragmentOne) getFragmentManager().findFragmentById(R.id.text_one);

        // do whatever you need to do...

    }
}
