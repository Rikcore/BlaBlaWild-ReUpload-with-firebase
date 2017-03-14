package wildsas.blablawild;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import java.util.Locale;

import static wildsas.blablawild.R.string.date;

public class SearchItineraryActivity extends AppCompatActivity {

    EditText mEditText1;
    EditText mEditText2;
    EditText mEditText3;
    Button button;
    public final static String EXTRA_TRAJET = "trajet";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        mEditText1 = (EditText) findViewById(R.id.editTextSearchDeparture);
        mEditText2 = (EditText) findViewById(R.id.editTextSearchDestination);
        mEditText3 = (EditText) findViewById(R.id.editTextSearchDate);
        button = (Button)findViewById(R.id.button);



        //CALENDAR //


        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {

                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                mEditText3.setText(sdf.format(myCalendar.getTime()));
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

        mEditText3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SearchItineraryActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //CALENDAR//



        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                if (mEditText1.length() == 0 || mEditText2.length() == 0)
                {
                    Toast.makeText(SearchItineraryActivity.this, getString(R.string.renseigner),
                            Toast.LENGTH_LONG).show();
                }
                    else
                    {
                        String depart = mEditText1.getText().toString();
                        String destination = mEditText2.getText().toString();
                        String date = mEditText3.getText().toString();
                        SearchRequestModel trajet= new SearchRequestModel(depart, destination, date);
                        Intent intentgoresults = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                        intentgoresults.putExtra(SearchItineraryActivity.EXTRA_TRAJET, trajet);

                        startActivity(intentgoresults);
                    }

            }
        });
    }

}
