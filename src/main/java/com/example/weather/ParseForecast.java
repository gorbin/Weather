package com.example.weather;


public class ParseForecast {
    public Location location;
    private Context context;
    public ParseForecast(Context context, Location location){
        this.context = context;
		this.location = location;
    }
}