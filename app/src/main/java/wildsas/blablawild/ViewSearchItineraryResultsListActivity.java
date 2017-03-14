package wildsas.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intentGoResults = getIntent();
        SearchRequestModel trajet = getIntent().getExtras().getParcelable(SearchItineraryActivity.EXTRA_TRAJET);
        this.setTitle(trajet.getmDepart() + " " + trajet.getmDestination());

        Toast.makeText(ViewSearchItineraryResultsListActivity.this, getString(R.string.felicitations) + " " + trajet.getmDepart() + " " + getString(R.string.le) + " " + trajet.getmDate(),
                Toast.LENGTH_LONG).show();



        //// LIST ////

        final ArrayList<TripResultModel> TripResultList = new ArrayList<>(); // calls function to get items list


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        try {
            TripResultList.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            TripResultList.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            TripResultList.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            TripResultList.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {


        }
        // instantiate the custom list adapter
        final TripResultAdapter resultAdapter = new TripResultAdapter(this, TripResultList);

        // get the ListView and attach the adapter
        ListView itemsListView = (ListView) findViewById(R.id.listViewResult);
        itemsListView.setAdapter(resultAdapter);
    }

}
