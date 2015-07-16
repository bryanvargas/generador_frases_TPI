package com.acceso.datos;

import java.io.Serializable;

public class Frase implements Serializable{

	private static final long serialVersionUID = 7942665322496388548L;
	private String mifrase;
	 private boolean isSelected = false;
	
	public Frase(String s) {
		this.mifrase = s;
	}

	public String getMifrase() {
		return mifrase;
	}

	public void setMifrase(String mifrase) {
		this.mifrase = mifrase;
	}
	
	@Override
	public String toString() {		
		return mifrase.toString();
	}

	 public boolean isSelected()
     {
         return isSelected;
     } 
     public void setSelected(boolean isSelected)
     {
         this.isSelected = isSelected;
     }

	
}
