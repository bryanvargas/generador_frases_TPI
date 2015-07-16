package com.gui;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class App {
	public static void main(String[] args) {
		try {
		System.out.println();
			JFrame.setDefaultLookAndFeelDecorated(true);
			  JDialog.setDefaultLookAndFeelDecorated(true);
			  UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
			SwingUtilities.invokeLater(new Runnable() {				
			public void run() {
				new MainFrame();					
			}
		});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lo sentimos, se cayo el sistema. "+"ERROR; "+e.getMessage());
		}
	}
}

