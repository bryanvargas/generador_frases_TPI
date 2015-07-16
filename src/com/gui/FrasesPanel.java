package com.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import com.acceso.datos.Frase;
import com.acceso.datos.FrasesList;
import com.acceso.datos.Memento;



public class FrasesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JList<Frase> lista;
	private DefaultListModel<Frase> messageListModel;
	private FrasesList fraseBackup; //frases que son almacenadas para su posterior restauracion
	private FrasesPanelListener fraseListListener;
	private JPopupMenu popup;


	
	public FrasesPanel() {		
		messageListModel = new DefaultListModel<Frase>();

		lista = new JList<Frase>(messageListModel);	
		
		popup =  new JPopupMenu();
		JMenuItem removeItem  = new JMenuItem("Eliminar Fila");
		popup.add(removeItem);
	
		
		 lista.addMouseListener(new MouseAdapter()
		 {
		      public void mousePressed(MouseEvent event)
		      {
		    	  if (lista.getModel().getSize()>0) {		    		 
						if(event.getButton()!=MouseEvent.BUTTON3){     					
			       		  @SuppressWarnings("rawtypes")
						JList list = (JList)event.getSource();                       
			                 int index = list.locationToIndex(event.getPoint());
			                Frase item = (Frase)			                		
			                list.getModel().getElementAt(index);			                
			                 item.setSelected(! item.isSelected());
			                 list.repaint(list.getCellBounds(index, index));                         
			                 int rowe = lista.getSelectedIndex(); 
							lista.getSelectionModel().setSelectionInterval(rowe, index);        				
							
						}else{
							popup.show(lista, event.getX(), event.getY());
					}
				}
		     	
		        
		      }
		 }); 
		
		removeItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				int row  = lista.getSelectedIndex();
				if (fraseListListener != null) {
					fraseListListener.rowDelete(row);
					messageListModel.remove(row);		
			
				}			
			}
		});
		

		
		
		setLayout(new BorderLayout());		
		
		add(new JScrollPane(lista), BorderLayout.CENTER);
	}	


	

	public int getListaSize(){		
		return messageListModel.getSize();
	}
	
	public void setData(FrasesList frases) {
		fraseBackup = new FrasesList();
		this.fraseBackup.addAll(frases);
		Iterator<Frase> it = frases.listIterator();
		while (it.hasNext()) {
			messageListModel.addElement(it.next());			
		}		
	}



	public void setApariencia(PrefEvent ev) {
		this.lista.setFont(ev.getFont());
		this.lista.setForeground(ev.getColor());	
		
	}
	

	public FrasesList guardarFrasesSeleccionadas(){	
		FrasesList frases = new FrasesList();
		for (int i = 0; i < messageListModel.getSize(); i++) {
			if (messageListModel.getElementAt(i).isSelected()) 
				frases.add(messageListModel.get(i));
		}
		return frases;
		
	}
			
		


	public void clearList(){	
		messageListModel.removeAllElements();
	}
		

	
	
	public void setFraseListListener(FrasesPanelListener listener){
		this.fraseListListener  = listener;
	}
	


	
	@SuppressWarnings("unchecked")
	public void setData(FrasesList frases, String string) {	
		fraseBackup = new FrasesList();	
		this.fraseBackup.addAll(frases);	
		Iterator<Frase> it = frases.listIterator();
		while (it.hasNext()) {
			messageListModel.addElement(it.next());			
		}
		lista.setCellRenderer(new FrasesCellRenderer(string));
		
	}
	
	/* ************************************************ */
	/* ************************************************ */
	/* ************************************************ */
	public Memento saveToEstado(){
		return new Memento(fraseBackup);
	}
	
	public void restoreFromMemento(Memento m){
		this.fraseBackup =m.getSavedState();
	}
	public FrasesList getNombre(){
		
		return fraseBackup;
	}

	
	
}
