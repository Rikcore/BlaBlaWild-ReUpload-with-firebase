package wildsas.blablawild;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.Query;


public class TripResultAdapter extends FirebaseListAdapter<ItineraryModel> {

    TextView ID;
    TextView firstName;
    TextView Lastname;
    TextView departureDate;
    TextView departure;
    TextView destination;
    TextView price;



    public TripResultAdapter(Query ref, Activity activity, int layout) {
        super(ref, ItineraryModel.class, layout, activity);

    }


    @Override
    protected void populateView(View view, ItineraryModel newPurpose) {
        // Map a Chat object to an entry in our listview


        departureDate = (TextView)view.findViewById(R.id.textViewDepartureTime);
        firstName = (TextView)view.findViewById(R.id.textViewFirstName);
        price = (TextView)view.findViewById(R.id.textViewPrice);

        departureDate.setText(String.valueOf(newPurpose.getDepartureDate()));
        firstName.setText(String.valueOf(newPurpose.getDriverFirstName()));
        price.setText(Integer.toString(newPurpose.getPrice()));


    }
}
