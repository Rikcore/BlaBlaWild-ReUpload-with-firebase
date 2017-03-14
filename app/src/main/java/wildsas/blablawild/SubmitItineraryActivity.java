package wildsas.blablawild;

import android.annotation.TargetApi;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SubmitItineraryActivity extends AppCompatActivity {

    EditText mEditTextDeparture;
    EditText mEditTextDestination;
    EditText mPrice;
    EditText mDate;
    Button buttonValider;

    FirebaseDatabase itineraryDatabase;
    DatabaseReference refItinerary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);

        mEditTextDeparture = (EditText)findViewById(R.id.editTextDeparture);
        mEditTextDestination = (EditText)findViewById(R.id.editTextDestination);
        mPrice = (EditText)findViewById(R.id.editTextPrice);
        mDate = (EditText)findViewById(R.id.editTextDate);
        buttonValider = (Button)findViewById(R.id.buttonValider);


        itineraryDatabase = FirebaseDatabase.getInstance();




        buttonValider.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String departure = mEditTextDeparture.getText().toString();
                String destination = mEditTextDestination.getText().toString();
                int price = Integer.parseInt(mPrice.getText().toString());
                String strDate = mDate.getText().toString();

                refItinerary = itineraryDatabase.getReference(departure+"-"+destination);

                ItineraryModel newItinerary = new ItineraryModel(strDate, price, departure, destination);

                Map<String, ItineraryModel> ItineraryModelResult = new HashMap<>();
                ItineraryModelResult.put("Données", newItinerary);


                refItinerary.setValue(ItineraryModelResult);
            }
        });




    }
}
