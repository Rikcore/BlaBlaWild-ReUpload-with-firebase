package wildsas.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    TextView departureTime;
    TextView firstName;
    TextView price;
    ListView itemsListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intentGoResults = getIntent();
        SearchRequestModel trajet = getIntent().getExtras().getParcelable(SearchItineraryActivity.EXTRA_TRAJET);
        this.setTitle(trajet.getmDepart() + " " + trajet.getmDestination());

        Toast.makeText(ViewSearchItineraryResultsListActivity.this, getString(R.string.felicitations) + " " + trajet.getmDepart() + " " + getString(R.string.le) + " " + trajet.getmDate(),
                Toast.LENGTH_LONG).show();



        // LISTVIEW //


        mDatabase = FirebaseDatabase.getInstance().getReference();

        TripResultAdapter mTripResultAdapter = new TripResultAdapter(mDatabase, this, R.layout.trip_item );

        itemsListView = (ListView) findViewById(R.id.listViewResult);
        itemsListView.setAdapter(mTripResultAdapter);
    }

}
