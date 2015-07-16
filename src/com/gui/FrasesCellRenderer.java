package com.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.acceso.datos.Frase;





@SuppressWarnings("rawtypes")
public class FrasesCellRenderer implements ListCellRenderer{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7190588313494988812L;
	private JCheckBox check;
	private JPanel panel;
	private JLabel label;
	private Color selectorColor;
	private String tema;
	
	
	public FrasesCellRenderer(String tema) {
		check = new  JCheckBox();
		panel = new JPanel();
		label = new JLabel();
		this.tema = tema;
		selectorColor = new Color(73,96,92);
		label.setLayout(new FlowLayout());		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(check);
		panel.add(label);
		panel.setOpaque(true);	
	}



	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Frase frases = (Frase) value;

		if (tema.equals("Amor")) {
			label.setIcon(Utils.createImageIcon("/images/love.png"));
		}else if(tema.equals("Odio")){
			label.setIcon(Utils.createImageIcon("/images/hate2.png"));
		}
		else if(tema.equals("Alegria")){
			label.setIcon(Utils.createImageIcon("/images/happy.png"));
		}
		else if(tema.equals("Deporte")){
			label.setIcon(Utils.createImageIcon("/images/sport.png"));
		}
		else if(tema.equals("Dolor")){
			label.setIcon(Utils.createImageIcon("/images/dolor.png"));
		}
		else if(tema.equals("Tristeza")){
			label.setIcon(Utils.createImageIcon("/images/trsiteza.png"));
		}
		
		check.setText(frases.toString());
		
		check.setComponentOrientation(list.getComponentOrientation());
		check.setFont(list.getFont());
		check.setBackground(list.getBackground());
		check.setForeground(list.getForeground());
		check.setSelected(isSelected);
		check.setSelected(((Frase)value).isSelected());
		
		
		check.setBackground(cellHasFocus ? selectorColor:new Color(0,0,0,0));
		panel.setBackground(cellHasFocus ? selectorColor:new Color(0,0,0,0));
//		check.setOpaque(true);
//		check.setText(frases.getFrase().toString());

		return panel;
	}
	





}
