package com.gail.wenzhi.bean;

import androidx.annotation.NonNull;

import java.util.List;

public class WeatherInfo {

    private String reason;
    private Result result;
    private int error_code;


    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getReason() {
        return reason;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    public int getError_code() {
        return error_code;
    }


    public class Realtime {

        private String temperature;
        private String humidity;
        private String info;
        private String wid;
        private String direct;
        private String power;
        private String aqi;
        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
        public String getTemperature() {
            return temperature;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }
        public String getHumidity() {
            return humidity;
        }

        public void setInfo(String info) {
            this.info = info;
        }
        public String getInfo() {
            return info;
        }

        public void setWid(String wid) {
            this.wid = wid;
        }
        public String getWid() {
            return wid;
        }

        public void setDirect(String direct) {
            this.direct = direct;
        }
        public String getDirect() {
            return direct;
        }

        public void setPower(String power) {
            this.power = power;
        }
        public String getPower() {
            return power;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }
        public String getAqi() {
            return aqi;
        }

    }

    public class Wid {

        private String day;
        private String night;
        public void setDay(String day) {
            this.day = day;
        }
        public String getDay() {
            return day;
        }

        public void setNight(String night) {
            this.night = night;
        }
        public String getNight() {
            return night;
        }

        @NonNull
        @Override
        public String toString() {
            return day + night;
        }
    }


    public class Future {

        private String date;
        private String temperature;
        private String weather;
        private Wid wid;
        private String direct;
        public void setDate(String date) {
            this.date = date;
        }
        public String getDate() {
            return date;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
        public String getTemperature() {
            return temperature;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }
        public String getWeather() {
            return weather;
        }

        public void setWid(Wid wid) {
            this.wid = wid;
        }
        public Wid getWid() {
            return wid;
        }

        public void setDirect(String direct) {
            this.direct = direct;
        }
        public String getDirect() {
            return direct;
        }


        @NonNull
        @Override
        public String toString() {
            return date + temperature + weather + wid + direct;
        }
    }

    public class Result {

        private String city;
        private Realtime realtime;
        private List<Future> future;
        public void setCity(String city) {
            this.city = city;
        }
        public String getCity() {
            return city;
        }

        public void setRealtime(Realtime realtime) {
            this.realtime = realtime;
        }
        public Realtime getRealtime() {
            return realtime;
        }

        public void setFuture(List<Future> future) {
            this.future = future;
        }
        public List<Future> getFuture() {
            return future;
        }


        @NonNull
        @Override
        public String toString() {
            return city + realtime + future.toString();
        }
    }


    @NonNull
    @Override
    public String toString() {
        return reason + result.toString() + error_code;
    }
}
