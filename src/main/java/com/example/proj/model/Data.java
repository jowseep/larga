package com.example.proj.model;

public class Data {
    Weather weather;
    private String city_name;
    private String timezone;
    private String country_code;
    private String temp;
    private int rh;
    private String pod;
    private double lon;
    private float pres;
    private String ob_time;
    private int clouds;
    private int ts;
    private String solar_rad, state_code;
    private float wind_spd;
    private String wind_cdir_full, wind_cdir;
    private int slp, vis, h_angle;
    private String sunset;
    private int dni, dewpt, snow, uv, precip, wind_dir;
    private String sunrise;
    private int ghi, dhi, aqi;
    private double lat;
    private String datetime;
    private String station;
    private int elev_angle, app_temp;
    
    public class Weather {
        private String icon;
        private String description;
        private String code;

        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public int getRh() {
        return rh;
    }

    public void setRh(int rh) {
        this.rh = rh;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public float getPres() {
        return pres;
    }

    public void setPres(float pres) {
        this.pres = pres;
    }

    public String getOb_time() {
        return ob_time;
    }

    public void setOb_time(String ob_time) {
        this.ob_time = ob_time;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getSolar_rad() {
        return solar_rad;
    }

    public void setSolar_rad(String solar_rad) {
        this.solar_rad = solar_rad;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public float getWind_spd() {
        return wind_spd;
    }

    public void setWind_spd(float wind_spd) {
        this.wind_spd = wind_spd;
    }

    public String getWind_cdir_full() {
        return wind_cdir_full;
    }

    public void setWind_cdir_full(String wind_cdir_full) {
        this.wind_cdir_full = wind_cdir_full;
    }

    public String getWind_cdir() {
        return wind_cdir;
    }

    public void setWind_cdir(String wind_cdir) {
        this.wind_cdir = wind_cdir;
    }

    public int getSlp() {
        return slp;
    }

    public void setSlp(int slp) {
        this.slp = slp;
    }

    public int getVis() {
        return vis;
    }

    public void setVis(int vis) {
        this.vis = vis;
    }

    public int getH_angle() {
        return h_angle;
    }

    public void setH_angle(int h_angle) {
        this.h_angle = h_angle;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getDewpt() {
        return dewpt;
    }

    public void setDewpt(int dewpt) {
        this.dewpt = dewpt;
    }

    public int getSnow() {
        return snow;
    }

    public void setSnow(int snow) {
        this.snow = snow;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public int getPrecip() {
        return precip;
    }

    public void setPrecip(int precip) {
        this.precip = precip;
    }

    public int getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(int wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public int getGhi() {
        return ghi;
    }

    public void setGhi(int ghi) {
        this.ghi = ghi;
    }

    public int getDhi() {
        return dhi;
    }

    public void setDhi(int dhi) {
        this.dhi = dhi;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getElev_angle() {
        return elev_angle;
    }

    public void setElev_angle(int elev_angle) {
        this.elev_angle = elev_angle;
    }

    public int getApp_temp() {
        return app_temp;
    }

    public void setApp_temp(int app_temp) {
        this.app_temp = app_temp;
    }

    

}
