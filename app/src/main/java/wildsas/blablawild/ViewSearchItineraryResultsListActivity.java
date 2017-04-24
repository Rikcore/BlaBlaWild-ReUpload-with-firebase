package wildsas.blablawild;

import android.content.Intent;
import android.database.DataSetObserver;
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
    ListView itemsListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SearchRequestModel trajet = getIntent().getExtras().getParcelable(SearchItineraryActivity.EXTRA_TRAJET);
        this.setTitle(trajet.getmDepart() + " " + trajet.getmDestination());

        Toast.makeText(ViewSearchItineraryResultsListActivity.this, getString(R.string.felicitations) + " " + trajet.getmDepart() + " " + getString(R.string.le) + " " + trajet.getmDate(),
                Toast.LENGTH_LONG).show();



        // LISTVIEW //


        mDatabase = FirebaseDatabase.getInstance().getReference("Itineraries"); // APPELLE LA BASE DE DONNEES

        final TripResultAdapter mTripResultAdapter = new TripResultAdapter(mDatabase, this, R.layout.trip_item ); // APPELLE L'ADAPTER

        itemsListView = (ListView) findViewById(R.id.listViewResult); //APPELLE LA LISTE .XML
        itemsListView.setAdapter(mTripResultAdapter); //FUSION LIST ET ADAPTER


        mTripResultAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                itemsListView.setSelection(mTripResultAdapter.getCount() - 1);
            }
        });
    }

}
