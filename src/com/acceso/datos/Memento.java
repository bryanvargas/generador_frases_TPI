package com.acceso.datos;



public class Memento {	
	private FrasesList estado;
	
	 public Memento(FrasesList fraseBackup) {
		 this.estado = fraseBackup;
	}
	
	public FrasesList getSavedState(){
		 return this.estado;
	 }
	

}