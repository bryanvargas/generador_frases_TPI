package com.acceso.datos;

public class Preposicion {

    private String prep;

    public Preposicion(String input) {
    	prep = input;
    }

    public String getPrep() {
        return prep;
    }

    public String toString() {
        return  "[" + prep + "]";
    }

}