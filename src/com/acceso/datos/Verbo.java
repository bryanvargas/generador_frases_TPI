package com.acceso.datos;


public class Verbo {

    private String singular;
    private String plural;
    private String past;
    

    public Verbo(String x, String y) {
        singular = x;
        plural = y;
    }

    public Verbo(String x, String y, String z) {
        singular = x;
        plural = y;
        past = z;
    }

    public String getSingular() {
        return singular;
    }
    public String getPlural() {
        return plural;
    }
    public String getPast() {
        return past;
    }

    public String toString() {
        return "[" + singular + "]";
    }

}