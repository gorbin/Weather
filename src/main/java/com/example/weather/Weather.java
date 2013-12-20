package com.example.weather;

import android.content.Context;
import java.io.Serializable;

public class Weather implements Serializable {

    private String date;
    private String timeOfDay;
    private String weekday;
    private String cloudiness;
    private String precipitation;
    private int pressure;
    private int temperatureMin, temperatureMax;
    private int windMin, windMax;
    private String windDirection;
    private int wetMin, wetMax;
    private int heatMin, heatMax;
    private String[] weekdayArray = new String[7];
    private String[] timedayArray = new String[4];
    private String[] cloudinessArray = new String[11];
    private String[] windDirectionArray = new String[8];

    public Weather(Context context)
    {
        weekdayArray = context.getResources().getStringArray(R.array.week_day);
        timedayArray = context.getResources().getStringArray(R.array.time_day);
        cloudinessArray = context.getResources().getStringArray(R.array.сloudiness);
        windDirectionArray = context.getResources().getStringArray(R.array.wind_direction);
    }
    public void setDate(String day, String month, String year)
    {
        this.date = day+"."+month+"."+year;
    }
    public void setTimeOfDay(String timeOfDay)
    {
        int tod = Integer.parseInt(timeOfDay);
        this.timeOfDay = timedayArray[tod];
    }
    public void setWeekDay(String weekDay)
    {
        int wd = Integer.parseInt(weekDay);
        this.weekday = weekdayArray[wd];
    }
    public void setCloudiness(String cloudiness)
    {
        int cloud = Integer.parseInt(cloudiness);
        this.cloudiness = cloudinessArray[cloud];
    }
    public void setPrecipitation(String precipitation)
    {
        int precip = Integer.parseInt(precipitation);
        this.precipitation = cloudinessArray[precip];
    }
    public void setPressure(String pressureMin,String pressureMax)
    {
        int min = Integer.parseInt(pressureMin);
        int max = Integer.parseInt(pressureMax);
        this.pressure = Math.round((min + max) / 2);
    }
    public void setTemperatureMin(String temperatureMin)
    {
        this.temperatureMin = Integer.parseInt(temperatureMin);
    }
    public void setTemperatureMax(String temperatureMax)
    {
        this.temperatureMax = Integer.parseInt(temperatureMax);
    }
    public void setWindMin(String windMin)
    {
        this.windMin = Integer.parseInt(windMin);
    }
    public void setWindMax(String windMax)
    {
        this.windMax = Integer.parseInt(windMax);
    }
    public void setWindDirection(String windDirection)
    {
        int wd = Integer.parseInt(windDirection);
        this.windDirection = windDirectionArray[wd];
    }
    public void setWetMin(String wetMin)
    {
        this.wetMin = Integer.parseInt(wetMin);
    }
    public void setWetMax(String wetMax)
    {
        this.wetMax = Integer.parseInt(wetMax);
    }
    public void setHeatMin(String heatMin)
    {
        this.heatMin = Integer.parseInt(heatMin);;
    }
    public void setHeatMax(String heatMax)
    {
        this.heatMax = Integer.parseInt(heatMax);
    }

    public String getDate()
    {
        return date;
    }
    public String getTimeOfDay()
    {
        return timeOfDay;
    }
    public String getweekDay()
    {
        return weekday;
    }
    public String getCloudiness()
    {
        return cloudiness;
    }
    public String getPrecipitation()
    {
        return precipitation;
    }
    public int getPressure()
    {
        return pressure;
    }
    public int getTemperatureMin()
    {
        return temperatureMin;
    }
    public int getTemperatureMax()
    {
        return temperatureMax;
    }
    public int getWindMin()
    {
        return windMin;
    }
    public int getWindMax()
    {
        return windMax;
    }
    public String getWindDirection()
    {
        return windDirection;
    }
    public int getWetMin()
    {
        return wetMin;
    }
    public int getWetMax()
    {
        return wetMax;
    }
    public int getHeatMin()
    {
        return heatMin;
    }
    public int getHeatMax()
    {
        return heatMax;
    }
    public String weatherString()
    {
        return ""+temperatureMin+"..."+temperatureMax+", "+cloudiness+", "+precipitation;
    }
    public String dateString()
    {
        return weekday+", "+date;
    }
    public String windString()
    {
        return ""+windDirection+", "+windMax+"-"+windMin;
    }
}


