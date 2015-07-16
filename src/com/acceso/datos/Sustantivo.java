package com.acceso.datos;


public class Sustantivo{
    private boolean singular;
    private boolean masculino;
    private String sustantivo;
    
    
    public Sustantivo(String input, boolean x, boolean m) {
        sustantivo = input;
        singular = x;    
        masculino = m;
    }

    public String getSustantivo() { return sustantivo; }
    public boolean isSingular() { return singular; }
    public boolean isMasculino() { return masculino; }


    public String toString() {       
        return "[" + sustantivo + "]";
    }

}