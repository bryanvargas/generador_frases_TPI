package com.acceso.datos;
public class Pronombre{

   
    private String pronMasculinoSingular;
    private String pronMasculinoPlural;   
    private String pronFemeninoSingular;
    private String pronFemeninoPlural;

    public Pronombre(String ms, String fs, String mp, String fp) {
    	pronMasculinoSingular = ms;
    	pronFemeninoSingular = fs;
    	pronMasculinoPlural = mp;
    	pronFemeninoPlural = fp;
    }

	public String getPronMasculinoSingular() {
		return pronMasculinoSingular;
	}

	public String getPronMasculinoPlural() {
		return pronMasculinoPlural;
	}

	public String getPronFemeninoSingular() {
		return pronFemeninoSingular;
	}

	public String getPronFemeninoPlural() {
		return pronFemeninoPlural;
	}

	




}