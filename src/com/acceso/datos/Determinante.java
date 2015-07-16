package com.acceso.datos;

public class Determinante{


    private String detMasculinoSingular;
    private String detFemeninoSingular;
    private String detMasculinoPlural;
    private String detFemeninoPlural;

    public Determinante(String ms,String fs, String mp, String fp) {
    	detMasculinoSingular = ms;
    	detFemeninoSingular = fs;
    	detMasculinoPlural = mp;
    	detFemeninoPlural = fp;
    	
    }

	public String getDetMasculinoSingular() {
		return detMasculinoSingular;
	}

	public String getDetFemeninoSingular() {
		return detFemeninoSingular;
	}

	public String getDetMasculinoPlural() {
		return detMasculinoPlural;
	}

	public String getDetFemeninoPlural() {
		return detFemeninoPlural;
	}
    
    
    
    


  



	



	

}