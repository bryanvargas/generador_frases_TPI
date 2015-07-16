package com.gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.undo.UndoManager;

public class ToolbarCabecera extends JToolBar implements ActionListener{
	private static final long serialVersionUID = 2382495618935885749L;
	private JButton guardarButton;
	private JButton imprimirButton;
	private JButton preferenciasButton;
	private JButton undoButton;
	private JButton rendoButton;
	private JButton abrirButton;
	private JButton limpiarButton;
	private ToolbarListener toolbarListener;	
	private boolean modificado;
	
	public ToolbarCabecera() {		
//		setBorder(BorderFactory.createEtchedBorder());
		setFloatable(true);
		
		guardarButton = new JButton();
		guardarButton.setIcon(Utils.createImageIcon("/images/save.png"));
		guardarButton.setToolTipText("Save");
		guardarButton.addActionListener(this);
		
		imprimirButton = new JButton();		
		imprimirButton.addActionListener(this);
		imprimirButton.setIcon(Utils.createImageIcon("/images/print.png"));
		imprimirButton.setToolTipText("Imprimir");
		
		preferenciasButton = new JButton();
		preferenciasButton.setIcon(Utils.createImageIcon("/images/pref.png"));
		preferenciasButton.setToolTipText("Preferencias");
		preferenciasButton.addActionListener(this);
		
		limpiarButton = new JButton();
		limpiarButton.setIcon(Utils.createImageIcon("/images/refresh.png"));
		limpiarButton.setToolTipText("Refrescar");
		limpiarButton.setEnabled(false);
		limpiarButton.addActionListener(this);
		
		undoButton = new JButton();
		undoButton.setIcon(Utils.createImageIcon("/images/undo.png"));
		undoButton.setToolTipText("Deshacer");
		undoButton.setEnabled(false);
		undoButton.addActionListener(this);
		
		rendoButton = new JButton();
		rendoButton.setIcon(Utils.createImageIcon("/images/redo.png"));
		rendoButton.setEnabled(false);
		rendoButton.setToolTipText("Rehacer");
		rendoButton.addActionListener(this);
		
		abrirButton = new JButton();
		abrirButton.setIcon(Utils.createImageIcon("/images/open.png"));
		abrirButton.setToolTipText("abrir");
		abrirButton.addActionListener(this);

		
				
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addSeparator();
		add(abrirButton);
		add(guardarButton);
		addSeparator();
		add(imprimirButton);
		addSeparator();
		add(undoButton);
		add(rendoButton);
		add(limpiarButton);
		addSeparator();		
//		addSeparator(new Dimension(50,0));
		
		add(preferenciasButton);
	}
	
	
	
	public void desabilitarUndo(){
		undoButton.setEnabled(isModificado());
	}
	
	public void abilitarUndo(){
		undoButton.setEnabled(isModificado());
	}
	
	
	public boolean isModificado() {
		return modificado;
	}






	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}








	
	public void setToolbarListener(ToolbarListener listener){
		this.toolbarListener = listener;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		if(clicked == abrirButton){
			if (toolbarListener != null) {
				toolbarListener.abrirEventOccured();
			}	
		}else if(clicked == guardarButton){			
			if (toolbarListener != null) {
				toolbarListener.saveEventOccured();
				
			}
		}else if (clicked == imprimirButton){
			if (toolbarListener != null) {
				toolbarListener.printEventOccured();
			}
		}else if (clicked == preferenciasButton){
			if (toolbarListener != null) {
				toolbarListener.prefEventOcurred();
			}
		}else if (clicked == rendoButton){			
			if (toolbarListener != null) {
				toolbarListener.rendoEventOcurred();
			}
		}else if (clicked == undoButton){	
	
			if (toolbarListener != null) {
				toolbarListener.undoEventOcurred();
			}
		}else if (clicked == limpiarButton){	
			
			if (toolbarListener != null) {
				toolbarListener.refreshEventOcurred();
			}
		}
	}
	
	
	 public void refreshUndoRedo(UndoManager undoManager) {		 
	     undoButton.setEnabled(undoManager.canUndo());	   
	     rendoButton.setEnabled( undoManager.canRedo());
	     limpiarButton.setEnabled(undoManager.canUndo());
	  }



	




	 
	
}
