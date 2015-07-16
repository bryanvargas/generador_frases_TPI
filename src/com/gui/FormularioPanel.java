package com.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.Border;




public class FormularioPanel extends JPanel{

	private static final long serialVersionUID = 1671891217834203461L;
	private JLabel $temaFrase_jl, $cantidadFrase_jl, $nivelAgresiv_jl,
				  $agresiv_jl;
	
	@SuppressWarnings("rawtypes")
	private JComboBox $listaTema_jcb, $cantFrases_jcb;
	private JSlider $nivelAgresibidad_s;
	@SuppressWarnings("rawtypes")
	private JList ageList;
	private JButton generar_btn;
	private JRadioButton bajoRadio;	
	private JRadioButton altoRadio;
	private ButtonGroup agresibidadGroup;
	private FormularioListener formListener;
	static final int FPS_INIT = 5;
	int delay;
	    
	    
	
	public FormularioPanel() {
		setLayout(null);
		Dimension dim = getPreferredSize();
		dim.width = 257;	
		setPreferredSize(dim);
		setMinimumSize(dim);
		inicializarComponentes();		
		
		/** ******************************************************************************* **/
		/** **************************** Eventos del Boton Generar ************************ **/
		/** ******************************************************************************* **/
		generar_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				GramCategoria categoriaGram = (GramCategoria)ageList.getSelectedValue();
				String tema = (String)$listaTema_jcb.getSelectedItem();	
				String nivel = (String) $cantFrases_jcb.getSelectedItem();
				int nivelInteger = Integer.parseInt(nivel);				
				String agresibidad = agresibidadGroup.getSelection().getActionCommand();
				//crea un evento donde le pasa como argumentos los datos del formPanel
				FormularioEvent ev = new FormularioEvent(this, tema, nivelInteger, agresibidad, categoriaGram.id);				
				if (formListener != null) {
					formListener.formEventOccurred(ev);					
				}				
			}
		});
	}
	
	
	/** ******************************************************************************* **/
	/** **************************** Inicializar Componentes   ************************ **/
	/** ******************************************************************************* **/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void inicializarComponentes() {
		//Set Up $temaFrase_jl
		$temaFrase_jl = new JLabel("Seleccione Tema");
		$temaFrase_jl.setBounds(20,40, 120, 25);
		
		//Set Up $listaTema_jcb
		$listaTema_jcb = new JComboBox();
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		modelo.addElement("Amor");
		modelo.addElement("Deporte");
		modelo.addElement("Tristeza");
		modelo.addElement("Alegria");
		modelo.addElement("Dolor");
		modelo.addElement("Odio");
		$listaTema_jcb.setModel(modelo);
		$listaTema_jcb.setSelectedItem(0);
		$listaTema_jcb.setEditable(false);
		$listaTema_jcb.setBounds(120, 40, 85, 25);
		
		//$cantidadFrase_jl
		$cantidadFrase_jl = new JLabel("Cantidad: ");
		$cantidadFrase_jl.setBounds(20, 80, 120, 25);
		add($cantidadFrase_jl);
		$cantFrases_jcb = new JComboBox();
		for(int f=1;f<=50;f++) {
			$cantFrases_jcb.addItem(String.valueOf(f));
        }
		$cantFrases_jcb.setMaximumRowCount(5);
		$cantFrases_jcb.setBounds(120, 80, 85, 25);
		
		
		//Set Up $nivelAgresibidad_s		
		$nivelAgresibidad_s = new JSlider(JSlider.VERTICAL, 0, 10, FPS_INIT);
		$nivelAgresibidad_s.setMajorTickSpacing(1);
		$nivelAgresibidad_s.setMinorTickSpacing(1);
		$nivelAgresibidad_s.setPaintTicks(true);
		
		//Set Up $$nivelAgresibidad_s
		$nivelAgresibidad_s.setPaintLabels(true);
		$nivelAgresibidad_s.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		$nivelAgresibidad_s.setMinimum(1);
		

		//ageList
		ageList = new JList();
		DefaultListModel ageModel = new DefaultListModel();
		
		ageModel.addElement(new GramCategoria(0,"Baja"));
		ageModel.addElement(new GramCategoria(1,"Medio"));
		ageModel.addElement(new GramCategoria(2,"Alta"));
		
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize(new Dimension(110,66));
		ageList.setBorder(BorderFactory.createEtchedBorder());		
		ageList.setSelectedIndex(1);
		ageList.setBounds(120, 200, 88, 65);
		
		
		$nivelAgresiv_jl = new JLabel("Complejidad");
		$nivelAgresiv_jl.setBounds(20, 200, 80, 30);
		
		
		
		
		$agresiv_jl = new JLabel("Agresibidad");
		
		$agresiv_jl.setBounds(20, 110, 100, 50);
		add($agresiv_jl);
		
		bajoRadio = new JRadioButton("bajo");	
		bajoRadio.setActionCommand("bajo");
		bajoRadio.setSelected(true);
		bajoRadio.setBounds(120, 110, 100, 50);
		
		
		altoRadio = new JRadioButton("alto");
		altoRadio.setActionCommand("alto");	
		altoRadio.setBounds(120, 150, 100, 50);
		
		
		agresibidadGroup = new ButtonGroup();		
		agresibidadGroup.add(bajoRadio);
		agresibidadGroup.add(altoRadio);		
   

		generar_btn = new JButton("Generar frase");
		generar_btn.setBounds(70, 580, 120, 30);
		generar_btn.setMnemonic(KeyEvent.VK_O);
		
		
		
		add($temaFrase_jl);
		add($listaTema_jcb);
		add($cantFrases_jcb);
		add(ageList);
		add($nivelAgresiv_jl);
		add(bajoRadio);
		add(altoRadio);
		add(generar_btn);
		
		Border innerBorder = BorderFactory.createTitledBorder(null, "Generador de Frases", delay, delay, 
				new Font("Thaoma", Font.BOLD, 17), Color.GRAY);
		Border outerBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);		
		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
//	    setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generador de Frases",
		//javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, 
//		new Font("Tahoma", Font.BOLD, 16)));
	}

  

    
    class GramCategoria{
    	private String texto;
    	private int id;
    	public GramCategoria(int id, String texto){
    		this.id = id;
    		this.texto = texto;
    	}
    	
    	@Override
    	public String toString() {	
    		return this.texto;
    	}

    	public int getId() {
    		return id;
    	}
    	
    	
    }
    
	public void setFormListener(FormularioListener formListener) {
		this.formListener = formListener;
		
	} 
//	
	
	//este  metodo borrar
	public void addListener(Action addAction) {		
		generar_btn.addActionListener(addAction);
	}



	
	
	
}
