package edu.unh.cs.cs791;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity
public class PlacesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
       // requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_places);
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
    public void submissionForm()
    {
        Intent intent = new Intent(this, SubmissionFormActivity_.class);
        startActivity(intent);
    }


    @Click(R.id.btnNewObservation)
    public void newObservationClicked(){ submissionForm(); }


    @Background
    public void thankYou()
    {
        Intent intent = new Intent(this, ThankYouActivity_.class);
        startActivity(intent);
    }


    @Click(R.id.btnFinalizeAndSubmit)
    public void finalizeAndSubmitClicked(){ thankYou(); }




}
