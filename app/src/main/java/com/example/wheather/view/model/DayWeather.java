package com.example.wheather.view.model;

import com.example.wheather.view.AppConst;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Aleksandr on 21.07.2016 in Weather.
 */
public class DayWeather {
    @SerializedName("dt")
    @Expose
    private long date; //in seconds

    @SerializedName("desc")
    @Expose
    private String conditionDesc;

    @SerializedName("con_id")
    @Expose
    private int conditionId;

    @SerializedName("temp")
    @Expose
    private double temp;

    @SerializedName("temp_min")
    @Expose
    private double tempMin;

    @SerializedName("temp_max")
    @Expose
    private double tempMax;

    @SerializedName("pressure")
    @Expose
    private double pressure;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("speed")
    @Expose
    private double windSpeed;


    public DayWeather() {
    }

    public DayWeather(long date, String conditionDesc, int conditionId, double temp, double tempMin, double tempMax,
                      double windSpeed, double pressure, int humidity, String icon) {
        this.date = date;
        this.conditionDesc = conditionDesc;
        this.conditionId = conditionId;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.humidity = humidity;
        this.icon = icon;
    }

    public long getDate() {
        return date;
    }

    public String getDateStr(){
        long millis = date * 1000L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMMM", Locale.getDefault());
        return simpleDateFormat.format(new Date(millis));
    }

    public String getDateString(){
        long millis = date * 1000L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault());
        return simpleDateFormat.format(new Date(millis));
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getConditionDesc() {
        return conditionDesc;
    }

    public void setConditionDesc(String conditionDesc) {
        this.conditionDesc = conditionDesc;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public int getTemp() {
        return (int)temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getTempMin() {
        return (int)tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return (int)tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getPressure() {
        return ConvertUnits.hPa_to_mm(pressure);
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getIcon() {
        return AppConst.WEATHER_ICON_PART+icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayWeather that = (DayWeather) o;

        if (date != that.date) return false;
        return conditionDesc.equals(that.conditionDesc);

    }

    @Override
    public int hashCode() {
        int result = (int) (date ^ (date >>> 32));
        result = 31 * result + conditionDesc.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DayWeather{");
        sb.append("date=").append(date);
        sb.append(", desc='").append(conditionDesc).append('\'');
        sb.append(", temp=").append(temp);
        sb.append(", tempMin=").append(tempMin);
        sb.append(", tempMax=").append(tempMax);
        sb.append(", pressure=").append(pressure);
        sb.append(", humidity=").append(humidity);
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", windSpeed=").append(windSpeed);
        sb.append('}');
        return sb.toString();
    }
}
