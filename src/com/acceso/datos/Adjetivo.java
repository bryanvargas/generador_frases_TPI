package com.acceso.datos;

public class Adjetivo {

    private String adjmasculino;
    private String adjfemenino;
    private String adjMaculinoPlural;
    private String adjFemeninoPlural;
    private String adjUnisexSingular;
    private String adjUnisexPlural;

    public Adjetivo(String m,String f, String mp ,String fp) {
    	adjmasculino =m;
    	adjfemenino = f;
    	adjMaculinoPlural = mp;
    	adjFemeninoPlural = fp;
    }
    
	  public Adjetivo(String us,String up) {
		  adjUnisexSingular = us;
		  adjUnisexPlural = up;
	  }


	public String getAdjmasculino() {
		return adjmasculino;
	}

	public String getAdjfemenino() {
		return adjfemenino;
	}

	public String getAdjMaculinoPlural() {
		return adjMaculinoPlural;
	}

	public String getAdjFemeninoPlural() {
		return adjFemeninoPlural;
	}

	public String getAdjUnisexSingular() {
		return adjUnisexSingular;
	}

	public String getAdjUnisexPlural() {
		return adjUnisexPlural;
	}

	

	


}