package com.acceso.datos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import repositorio.persistente.Repositorio;

/**
 * 
 * @author Bryan Vargas
 *	Clase encargada de interctuar con el repositorio
 */
public class Frases implements Serializable{	

	private static final long serialVersionUID = 4252805343917149380L;
	private FrasesList lista;
	private File archivoActual;
	private boolean modificado;
	Repositorio repositorio = new Repositorio();
	
	public Frases() {
		lista = new FrasesList();
	}
	public FrasesList obtenerFrases(){
		return lista;
	}
	
	public void setFrasesList(FrasesList lista){
		this.lista = lista;
	}
	
	
	 public void generadorFrases(String tema,int cantidad, String agresibidad, int complejidad, FrasesList frasesSeleccionadas) {	
		 	lista.clear();
		 	
		 	if (complejidad==0) {
		 		for (int i = 0; i < cantidad; i++) {
		 			int rand = (int)(Math.random()*5);	        
			        if (rand == 0)
			        	lista.add(fraseMolde1(repositorio, tema, agresibidad));
			        if (rand == 1)
			        	lista.add(fraseMolde2(repositorio,tema, agresibidad));  
			        if (rand == 2)
			        	lista.add(fraseMolde3(repositorio, tema, agresibidad));
			        if (rand == 3)
			        	lista.add(fraseMolde4(repositorio,tema, agresibidad));
			        if (rand == 4)
			        	lista.add(fraseMolde5(repositorio,tema, agresibidad));
				}
			}else if (complejidad==1) {
		 		for (int i = 0; i < cantidad; i++) {
		 			int rand = (int)(Math.random()*7);	        
			        if (rand == 0)
			        	lista.add(fraseMolde6(repositorio, tema, agresibidad));
			        if (rand == 1)
			        	lista.add(fraseMolde7(repositorio,tema, agresibidad)); 
			        if (rand == 2)
			        	lista.add(fraseMolde8(repositorio,tema, agresibidad)); 
			        if (rand == 3)
			        	lista.add(fraseMolde9(repositorio,tema, agresibidad)); 
			        if (rand == 4)
			        	lista.add(fraseMolde10(repositorio,tema, agresibidad));
			        if (rand == 5)
			        	lista.add(fraseMolde11(repositorio,tema, agresibidad));
			        if (rand == 6)
			        	lista.add(fraseMolde12(repositorio,tema, agresibidad));
			       
				}
			}else if (complejidad==2) {
		 		for (int i = 0; i < cantidad; i++) {		
		 			int rand = (int)(Math.random()*4);	        
			        if (rand == 0)
			        	lista.add(fraseMolde13(repositorio, tema, agresibidad));
			        if (rand == 1)
			        	lista.add(fraseMolde14(repositorio, tema, agresibidad));
			        if (rand == 2)
			        	lista.add(fraseMolde15(repositorio, tema, agresibidad));
			        if (rand == 3)
			        	lista.add(fraseMolde16(repositorio, tema, agresibidad));
			       
				}
			}  
		 	guardarFrasesSeleccionadas(frasesSeleccionadas);
	    }
	 
	 
	 public File getArchivoActual() {
			return archivoActual;
		}

	public void setArchivoActual(File archivoActual) {
		this.archivoActual = archivoActual;
	}

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}


	public Frase fraseMolde1(Repositorio r, String tema, String agresibidad) {	 	
				String s = "";
				String noun = r.getSustantivo(tema);
				String det  = r.getDeterminante(r.isSingular(), r.isMasculino());
				String adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);	        
				String verb = r.getVerbo(r.isSingular());	       
				s = det + " " + adj + " " + noun + " " + verb;   					          
	        return  new Frase(primeraLetraMayuscula(s));
	    }
	
	public Frase fraseMolde2(Repositorio r, String tema, String agresibidad) {	
			String s = "";
			String noun = r.getSustantivo(tema);
			String det  = r.getDeterminante(r.isSingular(), r.isMasculino());
			String adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);	        
			String verb = r.getVerbo(r.isSingular());	
			String susDos = r.getSustantivo(tema);
			s = det + " " + adj + " " + noun + " " + verb + " " + susDos; 
		         
        return new Frase(primeraLetraMayuscula(s));
    }
	

	
	
	 public Frase fraseMolde3(Repositorio r,String tema, String agresibidad) {	
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $verbUno = r.getVerbo(r.isSingular());

	        String $susDos = r.getSustantivo(tema);     
	        s =$detUno + " " + $susUno + " " + $advUno + " " + $verbUno + " " + $susDos ;        
        return new Frase(primeraLetraMayuscula(s));
    }
	 
//	 art + adj + noun + verb + "and" + art + adj + noun + verb 
	 public Frase fraseMolde4(Repositorio r,String tema, String agresibidad) {
			 
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $adjUno = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $conj = r.getConjuncion();     
	        
	        String $pron = r.getPronombre(r.isSingular(), r.isMasculino());
	        String $susDos = r.getSustantivo(tema);
	        String $adjDos = r.getAdjetivo(r.isSingular(), r.isMasculino(),agresibidad);
	        String $verbDos = r.getVerbo(r.isSingular());	 
	        s =$detUno + " " + $adjUno + " " + $susUno + " " + $verbUno + " " + $conj + " " + 
	        		$pron + " " + $verbDos + " " + $susDos + " " + $adjDos;       
        return new Frase(primeraLetraMayuscula(s));
    }
	 
	 

//	 det/sus/adj/verb /conj/verv/conj/pron/verb
	 public Frase fraseMolde5(Repositorio r,String tema, String agresibidad) {
		 
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $adjUno = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $conj = r.getConjuncion();
	        String $verbDos = r.getVerbo(r.isSingular());
	        String $pron = r.getPronombre(r.isSingular(), r.isMasculino());
	        String $verbTres = r.getVerbo(r.isSingular());    
	        
	        s =$detUno + " " + $susUno + " " + $adjUno + " " + $verbUno + " " + $conj + " " + 
	        		$verbDos + " " + $conj + " " + $pron + " " + $verbTres;       
	        return new Frase(primeraLetraMayuscula(s));
    }
	 

	 
	 
	 public Frase fraseMolde6(Repositorio r, String tema, String agresibidad) {	
			String s = "";
			String sus = r.getSustantivo(tema);
			String det  = r.getDeterminante(r.isSingular(), r.isMasculino());
			String adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);	        
			String adv = r.getAdverbio();	
			String verbPas = r.getVerboPas(r.isSingular());
			String susDos = r.getSustantivo(tema);
			
			String art = r.getDeterminante(r.isSingular(), r.isMasculino());
	
			s = det + " " + adj + " " + sus + ", " + verbPas + " " + adv + " "+ art + " "+susDos; 
		         
     return new Frase(primeraLetraMayuscula(s));
 }
	

	
	
	 public Frase fraseMolde7(Repositorio r,String tema, String agresibidad) {	
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $verbUno = r.getVerbo(r.isSingular());
	     
	        String $prep = r.getPreposicion();
	       String $susTres = r.getSustantivo(tema);
	       String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	        s =$detUno + " " + $susUno + " " + $advUno + ", " + $verbUno + " " + $prep +" "+ $detDos +" "+ $adj + " "+ $susTres ;        
     return new Frase(primeraLetraMayuscula(s));
 }
	 
	 public Frase fraseMolde8(Repositorio r,String tema, String agresibidad) {	
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	    
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $prep = r.getPreposicion();
	        String $susTres = r.getSustantivo(tema);
	       	String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	        s =$detUno + " " + $susUno + " " + $advUno +" "+ $adj+ ", " + $verbUno + " " + $prep +" "+ $detDos +" "+ $susTres;
	        
	        
	        return new Frase(primeraLetraMayuscula(s));
 	}
	 
	 
	 public Frase fraseMolde9(Repositorio r,String tema, String agresibidad) {	
	        String salida = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $verbUno = r.getVerbo(r.isSingular());
	       
	        String $prep = r.getPreposicion();
	       String $susDos = r.getSustantivo(tema);
	       String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	        salida =$detUno + " " + $susUno + " " + $advUno + ", " + $verbUno + " " + $detDos +" "+ $susDos +" "+ $prep+" "+$adj ;        
	        return new Frase(primeraLetraMayuscula(salida));
	 	}
	 
	 
	 public Frase fraseMolde10(Repositorio r,String tema, String agresibidad) {	
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $verbUno = r.getVerbo(r.isSingular());
	       
	        String $prep = r.getPreposicion();
	       String $susTres = r.getSustantivo(tema);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	        s =$detUno + " " + $susUno + " " + $advUno +" "+ $adj+ ", " + $verbUno + " " + $prep +" "+ $detDos +" "+ $susTres + " su " + tema ;        
	        return new Frase(primeraLetraMayuscula(s));
}
	 public Frase fraseMolde11(Repositorio r,String tema, String agresibidad) {	
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $prep = r.getPreposicion();
	       String $susTres = r.getSustantivo(tema);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	        s =$detUno + " " + $susUno + " " + $advUno + " "+ $adj+", " + $verbUno + " " + $prep +" "+ $detDos +" "+ $susTres ;        
  return new Frase(primeraLetraMayuscula(s));
	 }
	 
	 
	 public Frase fraseMolde12(Repositorio r,String tema, String agresibidad) {	
	        String s = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	    
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $prep = r.getPreposicion();
	        String $prepDos = r.getPreposicion();
	       String $susTres = r.getSustantivo(tema);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	        s =$detUno + " " + $susUno + " " + $advUno +" "+ $adj+ ", " + $verbUno + " " + $prep +" "+ $detDos +" "+ $susTres +" "+$prepDos+ " su " + tema ;        
	        return new Frase(primeraLetraMayuscula(s));
}
	 
	 
	 
//	 La felicidad es incompetente,porque  guarda a una pasion
	 public Frase fraseMolde13(Repositorio r,String tema, String agresibidad) {	
	        String $frasegenerada = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $conj = r.getConjuncion();
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $verbDos = r.getVerbo(r.isSingular());
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $prepDos = r.getPreposicion();
	       String $susTres = r.getSustantivo(tema);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	       
	        $frasegenerada =$detUno + " " + $susUno + " " + $advUno +" "+$verbUno+ ", " + $conj + " " + $verbDos +" "+ $detDos +" "+$adj+" "+ $susTres +" "+$prepDos+ " su " + tema ;        
	        return new Frase(primeraLetraMayuscula($frasegenerada));
}
	 
	 
//	 Una alma demacioado peresosa disfruta , porque escribio aquella verdad alrededor su Amor
	 public Frase fraseMolde14(Repositorio r,String tema, String agresibidad) {	
	        String $frasegenerada = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $adjUno = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $conj = r.getConjuncion();
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $verbDos = r.getVerboPas(r.isSingular());
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $prepDos = r.getPreposicion();
	       String $susTres = r.getSustantivo(tema);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	       
	        $frasegenerada =$detUno + " " + $susUno +  " " +  $advUno+" "+$adjUno+" " + $verbUno +" "+ $adj+ ", " + $conj + " " + $verbDos +" "+ $detDos +" "+ $susTres +" "+$prepDos+ " de su " + tema ;        
	        return new Frase(primeraLetraMayuscula($frasegenerada));
}
	 
	 
	 public Frase fraseMolde15(Repositorio r,String tema, String agresibidad) {	
	        String $frasegenerada = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $adjUno = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $conj = r.getConjuncion();
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $verbDos = r.getVerboPas(r.isSingular());
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $prep = r.getPreposicion();
	        String $susCuatro = r.getSustantivo(tema);
	       String $susTres = r.getSustantivo(tema);
	       String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	       String $susCinco = r.getSustantivo(tema);
	       
	        $frasegenerada =$detUno + " " + $susUno +  " " +  $advUno+" "+$adjUno+" " + $verbUno +" "+ $adj+" "+$susCuatro+ ", " + $conj + " " + $verbDos +" "+ $detDos +" "+ $susTres +" "+$prep+ " su " + $susCinco ;        
	        return new Frase(primeraLetraMayuscula($frasegenerada));
}
	 
	 
	 public Frase fraseMolde16(Repositorio r,String tema, String agresibidad) {	
	        String $frasegenerada = "";
	        String $susUno = r.getSustantivo(tema);
	        String $detUno = r.getDeterminante(r.isSingular(), r.isMasculino());
	        String $advUno = r.getAdverbio();
	        String $adjUno = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $conj = r.getConjuncion();
	        String $verbUno = r.getVerbo(r.isSingular());
	        String $verbDos = r.getVerboPas(r.isSingular());
	        String $adj = r.getAdjetivo(r.isSingular(), r.isMasculino(), agresibidad);
	        String $prep = r.getPreposicion();
	        String $susCuatro = r.getSustantivo(tema);
	        String $detDos = r.getDeterminante(r.isSingular(), r.isMasculino());
	        
	       String $susTres = r.getSustantivo(tema);
	       String $detTres = r.getDeterminante(r.isSingular(), r.isMasculino());
	       String $susCinco = r.getSustantivo(tema);
	       
	        $frasegenerada =$detUno + " " + $susUno +  " " +  $advUno+" "+$adjUno+" " + $verbUno +" "+ $adj+" "+$detDos+" "+$susCuatro+ ", " + $conj + " " + $verbDos +" "+ $detTres +" "+ $susTres +" "+$prep+ " su " + $susCinco ;        
	        return new Frase(primeraLetraMayuscula($frasegenerada));
}
	 
	private static String primeraLetraMayuscula(String palabra){		
		String primeraLetra = palabra.substring(0,1);
        String elResto = palabra.substring(1);
        palabra = primeraLetra.toUpperCase() + elResto;
		return palabra;
	}
	
	
	
	
	
	public void saveToFile(File file) throws IOException{
		FileOutputStream fos;
		if (!file.getName().equals(file.getName()+".carp")) {
			fos = new FileOutputStream(file+".carp");
		}else{
			fos = new FileOutputStream(file);
			 
		}
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Frase[] frases = lista.toArray(new Frase[lista.size()]);
		
		oos.writeObject(frases);
		oos.close();
	}
	
	
	
	
	

	public FrasesList loadFromFile(File file) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		FrasesList load = new FrasesList();	
		try {
			Frase[] frases = (Frase[])ois.readObject();
			for (int i = 0; i < frases.length; i++) {
				System.out.println(frases[i].getMifrase());
			}
			lista.clear();
			load.addAll(Arrays.asList(frases));
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		ois.close();
		return load;
	}
	
	public void exportar(File file) {
		  
		  BufferedWriter out;
		try {
			out = new BufferedWriter
					(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8")); 
//			
			  for (Frase frase:lista) {
				  out.write(frase.toString());
				  out.write("\r\n");   			
	     		}	
			  out.close(); 
		} catch (IOException e) {
			 JOptionPane.showMessageDialog(null,
                     JOptionPane.ERROR_MESSAGE +"esto es un probela");
			e.printStackTrace();
		}
        setModificado(false);     
    }
	
	public void saveAs(File file) {
		 BufferedWriter bw;
		 try {		
			 bw = new BufferedWriter(new FileWriter(file));
            for (Frase frase:lista) {
           	 bw.write(frase.toString());
           	 bw.write("\r\n"); 			
    		}	           
            bw.close();    //cierra el flujo    
            //establece el archivo guardado como el archivo actual
            setArchivoActual(file);
            //marca el estado del documento como no modificado
            setModificado(true);
        } catch (IOException ex) {    
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		
	}
	
	
	public void removeFrase(int index){		
		lista.remove(index);	
	}
	
	public void savePdf(File selectedFile) {
		OutputStream file;
	  try {
		  if (!selectedFile.getName().equals(selectedFile.getName()+".pdf")) {
		  file = new FileOutputStream(selectedFile);
	}else{
		 file = new FileOutputStream(selectedFile+".pdf");
		}
	  Document document = new Document();
	        PdfWriter.getInstance(document, file);
	        document.open();
	        for (Frase frase:lista) {
	        	document.add(new Paragraph(frase.toString()));              	
	        	document.add(new Paragraph("\r\n"));
		
        	}	
	        document.close();
		    file.close();
		
		} catch (Exception e) {		
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		
	}

	public void saveFile(File selectedFile) throws IOException{		
		FileOutputStream fis;
		String path = selectedFile.getName().substring(0, selectedFile.getName().length()-5);		
		fis = new FileOutputStream(path, true);
		
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		Frase[] frases = lista.toArray(new Frase[lista.size()]);
		
		oos.writeObject(frases);
		oos.close();
		
		
	}
	public void guardarFrasesSeleccionadas(FrasesList frasesSeleccionadas) {
		lista.addAll(frasesSeleccionadas);
		
	}
	


}
