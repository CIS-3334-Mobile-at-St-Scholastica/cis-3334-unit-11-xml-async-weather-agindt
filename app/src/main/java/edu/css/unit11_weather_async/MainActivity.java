package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * MainActivity sets up actions for the program
 * @author      Adam Gindt
 * @author      Tom Gibbons
 * @version     1.0
 */
public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();

    @Override
    /**
     * onCreate sets up actions when the main activity is created
     * @param       Bundle
     * @return      void
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }

    /**
     * btnClick sets up actions upon clicking the button
     * @param   View
     * @return  void
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
    }

    /**
     * Sets temperature value
     * @param       temperature value in String format
     * @return      void
     */
    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }

    /**
     * Sets wind value
     * @param       wind value in String format
     * @return      void
     */
    public void setWind(String newWind) {
        etWind.setText(newWind);
    }

    /**
     * Gets location value
     * @return      String of location
     */
    public String getLocation() {
        return etLoc.getText().toString();
    }


    /**
     * Sets the current status
     * @param       status value in String format
     * @return      void
     */
    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}
