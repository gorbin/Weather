package com.example.weather;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

	TextView log;
	GetLocation gl;
	Location location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		log = (TextView) findViewById(R.id.log);
		gl = new GetLocation(this);
		location = gl.getCurrentLocation();
        if(location==null){
            log.setText("WAT");
        } else {
		log.setText(""+location.getLatitude()+"/"+location.getLongitude());
        }
//        log.setText("WAT");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	public void onParse(View view){
        LoadTask lt = new LoadTask();
        lt.execute();
	}
	///////////////////////////////////
//////-----------Async---------------////////////////////////////////////////////////////////
	///////////////////////////////////
	class LoadTask extends AsyncTask<Void, String, ArrayList<Weather>> {
        
        
		public LoadTask() {
            
        }
		
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
		
        @Override
        protected ArrayList<Weather> doInBackground(Void... params) {
			publishProgress("wat!");
            return null;
        }
		
		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			log.setText(values[0]);
		}
		
        @Override
        protected void onPostExecute(ArrayList<Weather> result) {
            super.onPostExecute(result);
            log.setText("AsyncIt!");
        }
    }
    
}
