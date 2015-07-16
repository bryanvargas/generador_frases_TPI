package com.acceso.datos;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class FrasesList extends AbstractSequentialList<Frase> implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3683838012452042871L;
	private List<Frase> frases;	
	public FrasesList() {
		frases  = new ArrayList<>();	
	}
	
	@Override
	public ListIterator<Frase> listIterator(int index) {
		ListIterator<Frase> list = frases.listIterator();
		return list;
	}

	@Override
	public int size() {
		return frases.size();
	}
}
