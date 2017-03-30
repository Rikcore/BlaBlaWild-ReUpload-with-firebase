package wildsas.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button buttonAccueil;
    Button buttonTrajet;
    TextView textViewLogin;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();






        buttonAccueil = (Button)findViewById(R.id.buttonAccueil);
        buttonTrajet = (Button)findViewById(R.id.buttontrajet);
        textViewLogin = (TextView)findViewById(R.id.textViewLogin);



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
                if (firebaseAuth.getCurrentUser() == null) {
                    Toast.makeText(MainActivity.this, "Vous devez être connecté pour proposer un trajet.", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    Intent goPurpose = new Intent(MainActivity.this, SubmitItineraryActivity.class);
                    startActivity(goPurpose);
                }

            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(goLogin);
            }
        });
    }



}
