package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import javax.swing.JToolBar;


public class ToolbarPie extends JToolBar {

	private static final long serialVersionUID = -283159480129814452L;
	@SuppressWarnings("unused")
	private Toolkit toolkit;
	private  JLabel pathLabel;
	
	private Timer tiempo;
	
	public ToolbarPie() {
	setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
	setFloatable(false);
    toolkit = Toolkit.getDefaultToolkit();
    tiempo = new Timer();
    pathLabel = new JLabel("Ready");  
    
    pathLabel.setHorizontalTextPosition(JLabel.LEFT);
    pathLabel.setVerticalTextPosition(JLabel.BOTTOM);
    pathLabel.setFont(new Font("Thaoma", Font.PLAIN, 12));

    
    setLayout(new BorderLayout());		
	add(pathLabel, BorderLayout.WEST);
	
	}


	public void setRutaGuardada(String $rutaGuardada) {
		pathLabel.setText($rutaGuardada);
	}
	public void start(){
		tiempo.schedule(new RemindTask(), 5 * 1000);
	}
	
	class RemindTask extends TimerTask {
	    public void run() {
    	pathLabel.setText("Ready");
	    }
  }

}
