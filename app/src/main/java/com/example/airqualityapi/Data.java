package com.example.airqualityapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {
    @SerializedName("deviceId") // Name of JSON attribute. Used for GSON de-serialization
    public int deviceId;
    @SerializedName("pm25")
    public double pm25;
    @SerializedName("pm10")
    public double pm10;
    @SerializedName("o3")
    public double co2;
    @SerializedName("co2")
    public double o3;
    @SerializedName("pressure")
    public double pressure;
    @SerializedName("temperature")
    public double temperature;
    @SerializedName("humidity")
    public double humidity;
    @SerializedName("utc")
    public double utc;
    @SerializedName("latitude")
    public double latitude;
    @SerializedName("longitude")
    public double longitude;
    @SerializedName("noise")
    public double noise;
    @SerializedName("userId")
    public String userId;

    public Data(int deviceId, double pm25, double pm10, double co2, double o3, double pressure,
                double temperature, double humidity, double utc, double latitude, double longitude, double noise, String userId) {
        this.deviceId = deviceId;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.co2 = co2;
        this.o3 = o3;
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;
        this.utc = utc;
        this.latitude = latitude;
        this.longitude = longitude;
        this.noise = noise;
        this.userId = userId;
    }

    public Data() {

    }
    public void setId(int deviceId) {
        this.deviceId = deviceId;
    }

    /*public void setId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setPm25(double pm25) {this.pm25=pm25; }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public void setO3(double o3) {this.o3=o3; }

    public void setPressure(double pressure) {this.pressure=pressure;}

    public void setTemp(double temperature) {this.temperature=temperature; }

    public void setHumidity(double humidity) {this.humidity=humidity; }

    public void setUtc(double utc) {this.utc=utc; }

    public void setLatitude(double latitude) {this.latitude=latitude; }

    public void setLongtitude(double longtitude) {this.longtitude=longtitude; }

    public void setNoise(double noise) {this.noise=noise; }

    public void setUserId(String userId) {this.userId=userId; }*/


    @Override
    public String toString() {
        return userId;
    }

    public String getUserId() {return userId;}

    public double getPressure() { return pressure; }

    public double getTemp() {return temperature; }

    public double getCo2() { return co2; }

    public double getDeviceId() { return deviceId; }

    public double getHumidity() {return humidity; }

    public double getLatitude() { return latitude; }

    public double getLongtitude() { return longitude; }

    public double getO3() {return o3; }

    public double getNoise() { return noise; }

    public double getPm10() { return pm10; }

    public double getPm25() { return pm25; }

    public double getUtc() { return utc; }

    public int getDeviceID(){return deviceId;}

}
