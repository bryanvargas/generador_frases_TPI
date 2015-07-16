package com.modelo.negocio;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.acceso.datos.*;
import com.gui.FormularioEvent;
import com.gui.MainFrame;
import com.gui.FrasesPanel;
import com.gui.PrintAction;


public class Controlador {	
	Frases frases = new Frases();
	static int puntero=-1;
	private  ArrayList<Memento> estados = new ArrayList<>();
	
	public void generarFrases(FormularioEvent ev, FrasesList frasesList) {		
		frases.generadorFrases(ev.getTema(), ev.getCantidad(), ev.getAgresibidad(), ev.getComplejidad(), frasesList);	
		puntero++;
	}
	
	public FrasesList mostrarFrases(){	
		return frases.obtenerFrases();
	}
	
	public void eliminarFrase(int index) {
			frases.removeFrase(index);		
	}
	
	
	public void saveToFile(File file) throws IOException{			
		frases.saveToFile(file);
	}
	
	public FrasesList loadFromFile(File file) throws IOException{
		return frases.loadFromFile(file);
	}
	


	public void saveAs(File file) {	

			frases.saveAs(file);
	}
	public void exportar(File file) {	

			frases.exportar(file);	
	}	

	public void imprimir(FrasesPanel messagePanel, MainFrame mainFrame) {
		 @SuppressWarnings("unused")
		boolean result = false;
		 result = PrintAction.print(messagePanel, mainFrame);		
	}

	
	public void guardarEstado(Memento m) {	
		estados.add(m);		
	}
	
	
	public Memento undoMemento(){	
		--puntero;	
		if (puntero>=0) {
			return estados.get(puntero);
		}
		return new Memento(new FrasesList());
	}

	public Memento redoMemento(){
		return estados.get(++puntero);
	}
	
	public ArrayList<Memento> getEstados() {
		return estados;
	}

	public int getSize(){
		return estados.size();
	}

	public void exportarPdf(File selectedFile) {
		frases.savePdf(selectedFile);
	}

	public void saveFile(File selectedFile) throws IOException {
		frases.saveFile(selectedFile);
		
	}

	

}
