package edu.unh.cs.cs791;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity
public class PlacesActivity extends Activity {


    @ViewById
    TextView txtClassroomUpdate;


    @ViewById
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
       // requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_places);

        ObserveDB info = new ObserveDB(this);

        info.open();
        String data = info.getData();
        info.close();
        txtClassroomUpdate.setText(data);

        info.open();
        ArrayList<String>  dataArray = new ArrayList<String>();
        dataArray = info.getDataArray();
        info.close();

        gridView.setAdapter(new GridAdapter(this,
                dataArray));
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

    @Background
    public void submitInfo()
    {
        ObserveDB entry = new ObserveDB(this);
        entry.open();
        entry.deleteEntry(ObserveDB.DATABASE_TABLE, null, null);
        entry.close();
    }


    @Click(R.id.btnFinalizeAndSubmit)
    public void finalizeAndSubmitClicked(){
        submitInfo();
        thankYou(); }

}
