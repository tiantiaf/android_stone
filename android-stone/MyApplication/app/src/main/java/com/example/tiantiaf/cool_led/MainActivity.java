package com.example.tiantiaf.cool_led;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView    Led_status_txt;
    private Button      Led_btn;
    private boolean    LED_Status;
    private String      LED_Status_Txt;
    private String      LED_Btn_Txt;

    private boolean LED_On      = true;
    private boolean LED_Off     = false;

    private String LED_On_Txt    = "LED ON";
    private String LED_Off_Txt   = "LED OFF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Led_btn            = (Button) findViewById(R.id.Btn);
        Led_status_txt    = (TextView) findViewById(R.id.status_txt);

        Led_btn.setOnClickListener(ledOnClickListener);

        LED_Status = LED_Off;

        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private View.OnClickListener ledOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            LED_Status      = (LED_Status == LED_On) ? LED_Off : LED_On;
            LED_Status_Txt = (LED_Status == LED_On) ? LED_On_Txt : LED_Off_Txt;
            LED_Btn_Txt     = (LED_Status == LED_Off) ? LED_On_Txt : LED_Off_Txt;

            Led_status_txt.setText("LED status:  " + LED_Status_Txt);
            Led_btn.setText("SET " + LED_Btn_Txt);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
