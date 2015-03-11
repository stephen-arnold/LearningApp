package edu.unh.cs.cs791;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity
public class SubmissionFormActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @ViewById
    TextView txtClassroom;

    @ViewById
    TextView txtBuilding;


    @ViewById
    Button btnSubmit;


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

    public void updateDB() {

        String classroom = txtClassroom.getText().toString();
        String building = txtBuilding.getText().toString();

        Log.v(TAG, classroom);
        Log.v(TAG, building);


        ObserveDB entry = new ObserveDB(this);
        entry.open();
        entry.createEntry(classroom, building);
        entry.close();
    }

    @Background
    public void places()
    {
        Intent intent = new Intent(this, PlacesActivity_.class);
        startActivity(intent);
    }


    @Click(R.id.btnSubmit)
    public void submitClicked(){
        updateDB();
        places();
      }
}
