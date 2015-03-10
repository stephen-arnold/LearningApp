/**********************************************************************************************
 Main Activity
 **********************************************************************************************/
package edu.unh.cs.cs791;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Background
    public void sendMessage()
    {
         Intent intent = new Intent(this, SubmissionFormActivity_.class);
         startActivity(intent);
    }


    @Click(R.id.btnLogIn)
    public void logInClicked(){ sendMessage(); }


    @Override
    protected void onResume() {  super.onResume();  }

    @Override
    protected void onPause() {  super.onPause();    }
}