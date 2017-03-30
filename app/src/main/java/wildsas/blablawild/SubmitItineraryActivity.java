package wildsas.blablawild;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SubmitItineraryActivity extends AppCompatActivity {

    EditText mEditTextDeparture;
    EditText mEditTextDestination;
    EditText mPrice;
    EditText mDate;
    Button buttonValider;

    FirebaseDatabase itineraryDatabase;
    DatabaseReference refItinerary;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);

        mEditTextDeparture = (EditText)findViewById(R.id.editTextDeparture);
        mEditTextDestination = (EditText)findViewById(R.id.editTextDestination);
        mPrice = (EditText)findViewById(R.id.editTextPrice);
        mDate = (EditText)findViewById(R.id.editTextDate);
        buttonValider = (Button)findViewById(R.id.buttonValider);

        firebaseAuth = FirebaseAuth.getInstance();




        // DATEPICKER //

        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {

                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                mDate.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        mDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SubmitItineraryActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // DATEPICKER //




        buttonValider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (mEditTextDeparture.length() == 0 || mEditTextDestination.length() == 0 || mPrice.length() == 0)
                {
                    Toast.makeText(SubmitItineraryActivity.this, getString(R.string.renseignerPrix),
                            Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(SubmitItineraryActivity.this, getString(R.string.itineraireOK),
                            Toast.LENGTH_LONG).show();

                    user = FirebaseAuth.getInstance().getCurrentUser();

                    String mId = user.getUid();

                    String departure = mEditTextDeparture.getText().toString();
                    String destination = mEditTextDestination.getText().toString();
                    int price = Integer.parseInt(mPrice.getText().toString());
                    String strDate = mDate.getText().toString();

                    itineraryDatabase = FirebaseDatabase.getInstance(); //APPELLE LA BASE DE DONNEES
                    refItinerary = itineraryDatabase.getReference("Itineraries");

                    ItineraryModel newPurpose = new ItineraryModel(strDate, price, departure, destination, mId); //INSTANCIE UN OBJET DE LA CLASSE

                    refItinerary.push().setValue(newPurpose);

                    finish();
                }//PUSH LES DONNEES
            }
        });




    }
}
