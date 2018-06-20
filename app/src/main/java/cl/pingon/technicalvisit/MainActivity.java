package cl.pingon.technicalvisit;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.pingon.technicalvisit.R;
import cl.pingon.technicalvisit.models.Visit;

public class MainActivity extends AppCompatActivity {

    private VisitsFragment visitsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_visit_details);

                ImageButton button = dialog.findViewById(R.id.saveBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditText clientEt = dialog.findViewById(R.id.clientEt);
                        String client = clientEt.getText().toString();

                        if (client.trim().length() > 0) {
                            Visit visit = new Visit();
                            visit.setClient(client);
                        }

                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateList(Visit visit) {
        Log.d("visit", visit.getClient());
    }
}
