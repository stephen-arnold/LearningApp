package edu.unh.cs.cs791;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity
public class SubmissionFormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_submission_form);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    @Background
    public void places()
    {
        Intent intent = new Intent(this, PlacesActivity_.class);
        startActivity(intent);
    }


    @Click(R.id.btnSubmit)
    public void submitClicked(){ places(); }




}
