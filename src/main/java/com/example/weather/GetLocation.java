package com.example.weather;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetLocation {
    public Location currentLocation;
    private LocationManager locationManager;
    private Context context;
    public GetLocation(Context context){
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setCostAllowed(false);
        String provider = locationManager.getBestProvider(criteria, true);
        currentLocation = locationManager.getLastKnownLocation(provider);
        if(currentLocation == null){
            getGeo(provider, 0, 0);
        }
        if(currentLocation == null){
            getGeo(LocationManager.GPS_PROVIDER, 6000, 1000);
        } 

    }
    private void getGeo(String provider, int minTime, int minM){
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location loc) {
                if(loc!=null){
                    currentLocation = loc;
                    Log.e("Coord", "" + loc.getLatitude() + "/" + loc.getLongitude());
                    locationManager.removeUpdates(this);
                }
                else
                {
                    Log.e("Coord","looser");
                }
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };
        locationManager.requestLocationUpdates(provider, minTime, minM, locationListener);
    }

    public Location getCurrentLocation(){
        return currentLocation;
    }
}
