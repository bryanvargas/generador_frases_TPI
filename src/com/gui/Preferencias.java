package com.gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Position;



public class Preferencias extends JDialog {
	

	private static final long serialVersionUID = -7085424523670479526L;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField userField;	
	@SuppressWarnings("rawtypes")
	private JComboBox comboLAF;
	private JLabel prefer;

	private Font initialFont;    //fuente inicial
    private Color color;

    private JLabel label1;
	private JLabel label2;
	private JLabel label3;
    private JTextField textFieldNames;     //campo de texto para el nombre del fuente
    private JTextField textFieldStyles;    //campo de texto para el estilo del fuente
    private JTextField textFieldSizes;     //campo de texto para el tamaño del fuente
    private JList<String> listFontNames;     //lista para nombres de fuente
    private JList<String> listFontStyles;    //lista para estilos de fuente
    private JList<String> listFontSizes;     //lista para tamaños de fuente
    private JLabel textExample;    //etiqueta que muestra un ejemplo del fuente seleccionado



    private JScrollPane jScrollPane;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;   
    private JButton editColorButon;    
	private PrefsListener prefsListener;
	public	Preferencias(JFrame parent, Font font_Initial){
		super(parent, "Preferences", false);		
		
		okButton= new JButton("OK");
		cancelButton = new JButton("CANCEL");
		comboLAF = new JComboBox<Object>(cargarLAFsDisponibles());
		prefer = new JLabel("Apariencia");
		this.initialFont = font_Initial;
		


		
		
		/* **********************JFontChoose *************** */
	    /* ************************************************* */
	    /* ************************************************* */
		final EventHandler eventHandler = new EventHandler();    //construye una instancia de EventHandler
		label1 = new JLabel("Name:");
		label2 = new JLabel("Style:");
		label3 = new JLabel("Size:");
		textFieldNames = new JTextField("");
		textFieldStyles = new JTextField("");
		textFieldSizes = new JTextField(""); 
		
		
		
		editColorButon = new JButton();
		editColorButon.setText("Edit");	
		
		
		listFontNames = new JList<String>(Utils.FONT_NAMES);
	   
		listFontNames = new JList<String>(Utils.FONT_NAMES);    //construye la lista para nombres de fuente
        
        String fontName = getInitialFont().getName();
        listFontNames.setSelectedValue(fontName, true);    //selecciona el nombre de fuente inicial
        textFieldNames.setText(fontName);
        jScrollPane2 = new JScrollPane(listFontNames);
        listFontNames.addListSelectionListener(eventHandler);
        
        listFontStyles = new JList<String>(Utils.FONT_STYLES);    //construye la lista para estilos de fuente
        jScrollPane = new JScrollPane(listFontStyles);
        int fontSyle = getInitialFont().getStyle();
        listFontStyles.setSelectedIndex(fontSyle);    //selecciona el estilo de fuente inicial
        textFieldStyles.setText(listFontStyles.getSelectedValue().toString());
        listFontStyles.addListSelectionListener(eventHandler);
        
        
        listFontSizes = new JList<String>(Utils.FONT_SIZES);    //construye la lista para tamaños de fuente
        jScrollPane3 = new JScrollPane(listFontSizes);
        String fontSize = String.valueOf(getInitialFont().getSize());
        listFontSizes.setSelectedValue(fontSize, true);    //selecciona el tamaño de fuente inicial
        textFieldSizes.setText(fontSize);
        listFontSizes.addListSelectionListener(eventHandler);
        
        
        textExample = new JLabel("AaBaCcDdEeFfGgHhJj");        //construye la etiqueta para mostrar un ejemplo del fuente seleccionado
        textExample.setHorizontalAlignment(JLabel.CENTER);
        textExample.setFont(getInitialFont());    //establece el fuente inicial
        textExample.setOpaque(true);
        
        textExample.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Texto de ejemplo"),
                                                                 BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		
		
		layoutControls();

		
		editColorButon.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){		            
		    	 final JColorChooser chooser = new JColorChooser();
		    	 Component[] panelss =chooser.getComponents();
		         
		          for (Component component : panelss) {
		        	  String dsds = component.getName();
		        	  if (dsds.equals("ColorChooser.previewPanelHolder")) {
						chooser.remove(component);
					}
		        	
		        	 
				
				}
		          AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
		         
		          
		          for (AbstractColorChooserPanel accp : panels) {
		        	 
		        	  accp.setPreferredSize(new Dimension(420,200));
		        	  String displayName=accp.getDisplayName();
//		              System.out.println(displayName);
		              if (!displayName.equals("HSV")) {
						chooser.removeChooserPanel(accp);
						
					}
		            
		          }
		    	 /**************************
		    	  * 
		    	  ****************************/	    	 
		    	 
		          JDialog dialog = JColorChooser.createDialog(null,
		                  "Setting Color CARP", true, chooser, new ActionListener() {
		                    public void actionPerformed(ActionEvent e) {
		                      color = chooser.getColor();
		                    }
		                  }, null);
		              dialog.setVisible(true);
		              setColor(color);
		              textExample.setForeground(getColor());
		      }
		});
		
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				accionesAplicar();
				Font d = getSelectedFont();	
				PrefEvent ev = new PrefEvent(this, d, getColor(),accionesAplicar());
				if(prefsListener !=null){
					prefsListener.preferencesSet(ev);					
				}
				setVisible(false);				
			}
		});		

		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}			
		});
		
		
		
		
		
		setSize(308,460);
		
		setMaximumSize(new Dimension(308,450));
		setLocationRelativeTo(parent);
	}
	
	
	
	
	
	

    
    public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}







    public Font getInitialFont() {
        return initialFont;
    }
 
// 
    public void setSelectedFont(Font font) {
    }
    
    
    
  
    public Font getSelectedFont() {
        try {
            //retorna el fuente seleccionado en el dialogo
            return new Font(String.valueOf(listFontNames.getSelectedValue()), listFontStyles.getSelectedIndex(),
                            Integer.parseInt(String.valueOf(listFontSizes.getSelectedValue())));
        } catch (NumberFormatException nfe) {    //en caso de que ocurra una excepción
            System.err.println(nfe);
        }
        return null;    //retorna null
    }

	 

	private String accionesAplicar(){
		String seleccion = (String) comboLAF.getSelectedItem(); 	  
 	  try {
 		 
	   UIManager.setLookAndFeel(Utils.Temas().get(seleccion));
	   SwingUtilities.updateComponentTreeUI(Preferencias.this);
 	  }
 	  catch (Exception e) {
 	   e.printStackTrace();
 	  }
 	  return Utils.Temas().get(seleccion);
 	 }
	
	private Object[] cargarLAFsDisponibles() {
		Object[] nombresLAF;
		nombresLAF = new Object[Utils.Temas().size()];	
		int cont =0;
		Iterator<String> it  = Utils.Temas().keySet().iterator();
		while(it.hasNext()){
		 String key =it.next();
		  nombresLAF[cont++] = key;
		  }

		return nombresLAF;

	}

	private void layoutControls(){
		setLayout(null);
		JPanel controlsPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel fontPanel = new JPanel();
		
		controlsPanel.setLayout(null);
		fontPanel.setLayout(null);
		buttonsPanel.setLayout(null);
		
		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space,space,0,space);
		Border titleBorder = BorderFactory.createTitledBorder("Apariencias");
		
		Border spaceBorderDos = BorderFactory.createEmptyBorder(space,space,0,space);
		Border titleBorderDos = BorderFactory.createTitledBorder("Setting Font");

		controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder,titleBorder));
		fontPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorderDos,titleBorderDos));


		comboLAF.setBounds(140, 35, 105, 27);
		controlsPanel.add(comboLAF);
		prefer.setBounds(50, 35, 70, 20);
		controlsPanel.add(prefer);

		
		
		label1.setBounds(30, 30, 100, 20);
		textFieldNames.setBounds(30, 47, 120, 24);
		jScrollPane2.setBounds(30, 71, 120, 120);
		fontPanel.add(label1);
		fontPanel.add(textFieldNames);
		fontPanel.add(jScrollPane2);
		
		
		label2.setBounds(160, 30,100 , 24);
		textFieldStyles.setBounds(160,51, 60, 20);
		jScrollPane.setBounds(160, 71, 60, 120);
		fontPanel.add(label2);
		fontPanel.add(textFieldStyles);
		fontPanel.add(jScrollPane);
		
		
		label3.setBounds(230, 30, 42, 20);
		textFieldSizes.setBounds(230, 52, 42, 24);
		jScrollPane3.setBounds(230, 76, 42,116);
		fontPanel.add(label3);
		fontPanel.add(textFieldSizes);
		fontPanel.add(jScrollPane3);
		
		
		textExample.setBounds(30, 198, 240, 70);
		fontPanel.add(textExample);
		
		
		JLabel colorLabel = new JLabel("Color");
		colorLabel.setBounds(150, 273, 65, 28);
		
		
		
		editColorButon.setBounds(200,273, 70, 30);
		fontPanel.add(colorLabel);
		fontPanel.add(editColorButon);
		
		
		
		okButton.setBounds(80, 0, 100, 30);
		buttonsPanel.add(okButton);
		
		cancelButton.setBounds(115+70, 0, 100, 30);
		buttonsPanel.add(cancelButton);

		controlsPanel.setBounds(0, 0, 300, 75);
		fontPanel.setBounds(0, 65, 300, 310);
		buttonsPanel.setBounds(0, 380, 300, 30);
		add(controlsPanel);
		add(fontPanel);
		add(buttonsPanel);

		
	}

	public void setDefaults(String user){
		userField.setText(user);
	
	}
	public void setPrefsListener(PrefsListener prefsListener) {
		this.prefsListener = prefsListener;
		
	}

	
    /**
     * Clase interna que extiende e implementa las clases e interfaces necesarias para
     * atender y manejar los eventos sobre la ventana de selección de fuente.
     */
    class EventHandler extends KeyAdapter implements Comparator<String>,
                                                     ListSelectionListener { 
        @Override
        public void keyReleased(KeyEvent ke) {          
            final JTextField eventTField = (JTextField) ke.getSource();
            final String text = eventTField.getText();
            
            if (eventTField == textFieldNames) { 
                int index = listFontNames.getNextMatch(text, 0, Position.Bias.Forward);
 
                if (index > -1) {
                    if (Arrays.binarySearch(Utils.FONT_NAMES, text, this) > -1) //si el resultado es mayor que -1
                    {
                        listFontNames.setSelectedIndex(index);    //selecciona el índice
                    }
 
                    listFontNames.ensureIndexIsVisible(index);    //hace el índice visible en la lista
                }
            } else if (eventTField == textFieldStyles) {    //si el campo de texto es textFieldStyles
                //obtiene el índice del proximo elemento en la lista que coincida con el contenido del campo de texto
                int index = listFontStyles.getNextMatch(text, 0, Position.Bias.Forward);
 
                if (index > -1) {    //si el índice es mayor que -1
                    //itera sobre los elementos en el arreglo de estilos de fuente
                    for (int i = 0 ; i < Utils.FONT_STYLES.length ; i++) {
                        //si el contenido del campo de texto es igual al elemento actual
                        if (text.equalsIgnoreCase(Utils.FONT_STYLES[i]) == true) {
                            listFontStyles.setSelectedIndex(index);    //selecciona el índice
                        }
                    }
 
                    listFontStyles.ensureIndexIsVisible(index);    //hace el índice visible en la lista
                }
            } else if (eventTField == textFieldSizes) {    //si el campo de texto es textFieldSizes
                //obtiene el índice del proximo elemento en la lista que coincida con el contenido del campo de texto
                int index = listFontSizes.getNextMatch(text, 0, Position.Bias.Forward);
 
                if (index > -1) {    //si el índice es mayor que -1
                    //itera sobre los elementos en el arreglo de tamaños de fuente
                    for (int i = 0 ; i < Utils.FONT_SIZES.length ; i++) {
                        //si el contenido del campo de texto es igual al elemento actual
                        if (text.equalsIgnoreCase(Utils.FONT_SIZES[i]) == true) {
                            listFontSizes.setSelectedIndex(index);    //selecciona el índice
                        }
                    }
 
                    listFontSizes.ensureIndexIsVisible(index);    //hace el índice visible en la lista
                }
            }
 
            //establece el fuente seleccionado en la etiqueta de muestra
            textExample.setFont(getSelectedFont());
        } 
       
        @Override
        public int compare(String string1, String string2) {
            //compara dos cadenas de texto ignorando mayúsculas
            return string1.compareToIgnoreCase(string2);
        }
 
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            //averigua en que lista se ah ejecutado el evento
            if (lse.getSource() == listFontNames) {    //si la lista es listFontNames
                //establece el contenido del campo de texto textFieldNames
                textFieldNames.setText(String.valueOf(listFontNames.getSelectedValue()));
            } else if (lse.getSource() == listFontStyles) {    //si la lista es listFontStyles
                //establece el contenido del campo de texto textFieldStyles
                textFieldStyles.setText(String.valueOf(listFontStyles.getSelectedValue()));
            } else if (lse.getSource() == listFontSizes) {    //si la lista es listFontSizes
                //establece el contenido del campo de texto textFieldSizes
                textFieldSizes.setText(String.valueOf(listFontSizes.getSelectedValue()));
            }
 
            //establece el fuente seleccionado en la etiqueta de muestra
            textExample.setFont(getSelectedFont());
        }
    }

}