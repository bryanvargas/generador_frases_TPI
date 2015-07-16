package com.gui;

import java.util.EventObject;

public class FormularioEvent extends EventObject {

	private static final long serialVersionUID = -5362085156809999022L;
	private String tema;
	private int cantidad;
	private String agresibidad;
	private int complejidad; 
	
	public FormularioEvent(Object source) {
		super(source);		
	}

	
	public FormularioEvent(Object source, String tema, int cantidad, String agresibidad, int complejidad ) {
		super(source);
		this.tema = tema;
		this.cantidad= cantidad; 
		this.agresibidad = agresibidad;	
		this.complejidad = complejidad;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getAgresibidad() {
		return agresibidad;
	}

	public void setAgresibidad(String agresibidad) {
		this.agresibidad = agresibidad;
	}


	public int getComplejidad() {
		return complejidad;
	}


	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	}
	
	
	
}
