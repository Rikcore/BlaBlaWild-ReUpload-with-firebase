package wildsas.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAccueil;
    Button buttonTrajet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buttonAccueil = (Button)findViewById(R.id.buttonAccueil);
        buttonTrajet = (Button)findViewById(R.id.buttontrajet);

        buttonAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goSearch = new Intent(MainActivity.this, SearchItineraryActivity.class);
                startActivity(goSearch);

            }
        });

        buttonTrajet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goPurpose = new Intent(MainActivity.this, SubmitItineraryActivity.class);
                startActivity(goPurpose);
            }
        });
    }



}
