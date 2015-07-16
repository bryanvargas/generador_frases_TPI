package com.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;
import javax.swing.undo.UndoableEditSupport;

import com.acceso.datos.FrasesList;
import com.modelo.negocio.Controlador;

public class MainFrame extends JFrame{	
	private static final long serialVersionUID = -4400693783804967080L;
	private FormularioPanel $formPanel;
	private JFileChooser $fileChooser;
	private ToolbarCabecera $toolbar;
	private Preferencias $prefsDialog;
	private TextPanel $textPanel;
	private JSplitPane $splitPane;
	private JTabbedPane $tabPane;
//	private TablePanel tablePanel;
	private FrasesPanel $frasesPanel;
	private Controlador $controlador;
	private UndoManager $undoManager;
	private UndoableEditSupport $undoSupport;
	
	private ToolbarPie $toolbarFinal;
	
	public MainFrame() {
		
		/** *********************** Set Cabecera ********************* **/
		
		//set Cabecera
		setTitle("Generador de Frases V.000000000000000000001 BETA");	
		setIconImage(Utils.createImageIcon("/images/icon.png").getImage());
		
		/** ********************************************************** **/
		
		$controlador = new Controlador();
		
		/** ********************************************************** **/
		/** *********************** Set Panels   ********************* **/
		/** ********************************************************** **/
		setJMenuBar(createMenuBar());
		setLayout(new BorderLayout());
		$formPanel = new FormularioPanel();
		$formPanel.setVisible(true);
		$textPanel = new TextPanel();
		$tabPane = new JTabbedPane();
		$frasesPanel = new FrasesPanel();	
		$prefsDialog = new Preferencias(this,new Font("Thaoma", Font.PLAIN, 12));

		
		
		$toolbarFinal = new ToolbarPie();
		
		
		$splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,$formPanel,$tabPane);		
		$splitPane.setOneTouchExpandable(true);
	
		
		
//		$tabPane.addTab("Frases",Utils.createIcon("/images/favicon.png"), $frasesPanel,"frases");
		$tabPane.addTab("Frases", $frasesPanel);
		$tabPane.addTab("Notas", $textPanel);
		$tabPane.setFont(new Font("Thaoma", Font.PLAIN, 12));
//		$tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//		$tabPane.setMnemonicAt(0, KeyEvent.VK_BACK_SPACE);
		$tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		$undoManager= new UndoManager();
	    $undoSupport = new UndoableEditSupport();
	    $undoSupport.addUndoableEditListener(new UndoAdapter());
	    
	    
	    
	    /**
	     * 
	     */
	    Action addAction  = new AbstractAction() {	    	
			private static final long serialVersionUID = 6482668072106674177L;

			@Override
			public void actionPerformed(ActionEvent e) {
				 $undoSupport.postEdit(new AbstractUndoableEdit());				
			}
		};	    		
		
		$formPanel.addListener(addAction);		
		
		
		/** ********************************************************** **/
		/** ******************* Eventos del Formumario *************** **/
		/** ********************************************************** **/
		$formPanel.setFormListener(new FormularioListener() {			
			public void formEventOccurred(FormularioEvent e) {	
				FrasesList fg = $frasesPanel.guardarFrasesSeleccionadas();
				$frasesPanel.clearList();
				$controlador.generarFrases(e,fg );				
				$frasesPanel.setData($controlador.mostrarFrases(), e.getTema());				
				$controlador.guardarEstado($frasesPanel.saveToEstado());
				
			}
		});
		
		
		$tabPane.addChangeListener(new ChangeListener() {	
			public void stateChanged(ChangeEvent e) {
				int tablaIndex = $tabPane.getSelectedIndex();
				if (tablaIndex==1) {
					$textPanel.refresh();
				}
						
			}
		});

		
		
		
		
		$prefsDialog.setPrefsListener(new PrefsListener(){
			@Override
			public void preferencesSet(PrefEvent ev) {
				accionesAplicar(ev.getTema());	
				$frasesPanel.setApariencia(ev);
				$textPanel.setApariencia(ev);				
			}			
		});

		
		
		$fileChooser = new JFileChooser();
		$fileChooser.addChoosableFileFilter(new FrasesFileFilter());
		$fileChooser.setAcceptAllFileFilterUsed(true);
		$fileChooser.setFileView(new ImagenFileVista());
		$fileChooser.setAccessory(new ImagenPreview($fileChooser));

		
		
		
		
		$frasesPanel.setFraseListListener(new FrasesPanelListener() {			
			@Override
			public void rowDelete(int row) {
				$controlador.eliminarFrase(row);				
			}
		
		});
		
		
		
		/** ********************************************************** **/
		/** *********************** eventos del Toolbar ************** **/
		/** ********************************************************** **/
		
		$toolbar.setToolbarListener(new ToolbarListener() {			
			public void abrirEventOccured() {				
				if ($fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {						
						$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "   ...abierto");
						$toolbarFinal.start();
						$frasesPanel.clearList();
						$frasesPanel.setData($controlador.loadFromFile($fileChooser.getSelectedFile()));					
					
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"No se pudo abrir el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}					
				}				
			}
			
			public void printEventOccured() {
				$controlador.imprimir($frasesPanel, MainFrame.this);
			}
			
			public void saveEventOccured() {				
				
				if ($fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					int $action =-1;
					try {
						if ($fileChooser.getSelectedFile().exists()) {
							$action = JOptionPane.showConfirmDialog(MainFrame.this,
									$fileChooser.getSelectedFile().getName()+" ya existe"+"\r\n Desea reemplazarlo?",
									"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
							if ($action == JOptionPane.YES_OPTION) {						
								$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "...guardado");
								$toolbarFinal.start();
								$controlador.saveToFile($fileChooser.getSelectedFile());
							}
						}else{
							$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "...guardado");
							$toolbarFinal.start();
							$controlador.saveToFile($fileChooser.getSelectedFile());
						}
						
						
						
					} catch (IOException e1) {						
						JOptionPane.showMessageDialog(null,e1.getMessage());
					}
					
				}
			}
			
			//JDialog Preferencias
			public void prefEventOcurred() {
				$prefsDialog.setVisible(true);				
			}
	
			@Override
			public void undoEventOcurred() {					
				$frasesPanel.clearList();
				$frasesPanel.setData($controlador.undoMemento().getSavedState());	
				$undoManager.undo();
				$toolbar.refreshUndoRedo($undoManager);
			}
			
			@Override
			public void rendoEventOcurred() {
				
				$frasesPanel.clearList();
				$frasesPanel.setData($controlador.redoMemento().getSavedState());
				$undoManager.redo();
		    	$toolbar.refreshUndoRedo($undoManager);
			}

			@Override
			public void refreshEventOcurred() {
				$frasesPanel.clearList();
				$toolbar.refreshUndoRedo($undoManager);
			}
		});		
		
		/** ********************************************************** **/
		/** *********************************************************** **/
		/** ********************************************************** **/
	
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                close();
            }
        });
   
 
              
	
		
		
		add($toolbarFinal, BorderLayout.SOUTH);
		
		add($toolbar, BorderLayout.PAGE_START);
		add($splitPane, BorderLayout.CENTER);

		setMinimumSize(new Dimension(675, 580));
		//accionesAplicar("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
		
		setSize(600, 500);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//aplica las preferencias elegidas (Font, apariencia, Color)
	protected void accionesAplicar(String i) {
		try {
			 
			UIManager.setLookAndFeel(i);
			SwingUtilities.updateComponentTreeUI(MainFrame.this);

		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	
  

	private JMenuBar createMenuBar() {
		$toolbar = new ToolbarCabecera();		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(new Font("Thaoma", Font.PLAIN, 12));
//		fileMenu.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.BLACK));
//		UIManager.put("MenuItem.background", Color.CYAN);
//		UIManager.put("MenuItem.opaque", true);
		JMenuItem $abrirtDataItem = new JMenuItem("Abrir...");
		$abrirtDataItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem $guardarDataItem = new JMenuItem("Guardar...");
		$guardarDataItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem exportDataItem = new JMenuItem("Exportar a txt...");
		exportDataItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem exportPdfDataItem = new JMenuItem("Exportar a pdf...");
		exportPdfDataItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem importDataItem = new JMenuItem("Importar a notas...");
		importDataItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setFont(new Font("Thaoma", Font.PLAIN, 12));

		fileMenu.add($abrirtDataItem);
		fileMenu.add($guardarDataItem);
		fileMenu.add(exportDataItem);
		fileMenu.add(exportPdfDataItem);
		fileMenu.add(importDataItem);
		fileMenu.add(exitItem);

		JMenu edit = new JMenu("Editar");		
		edit.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem $deshacerItem = new JMenuItem("Deshacer");
		$deshacerItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem $rehacerItem = new JMenuItem("Rehacer");
		$rehacerItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		
		
		edit.add($deshacerItem);
		edit.add($rehacerItem);
		
		
		JMenu windowMenu = new JMenu("Window");
		windowMenu.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenu showMenu = new JMenu("Show");
		showMenu.setFont(new Font("Thaoma", Font.PLAIN, 12));
		JMenuItem prefsItem = new JMenuItem("Preferences...");
		prefsItem.setFont(new Font("Thaoma", Font.PLAIN, 12));
		

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Frases Form");
		showFormItem.setFont(new Font("Thaoma", Font.PLAIN, 12));

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		windowMenu.add(prefsItem);
		
		menuBar.add(fileMenu);
		menuBar.add(edit);
		menuBar.add(windowMenu);
	
		
			 
		
				

		showFormItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();
				if (menuItem.isSelected()) {
					$splitPane.setDividerLocation((int)$formPanel.getMinimumSize().getWidth());
				}
				$formPanel.setVisible(menuItem.isSelected());
			}
		});

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		
		importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I ,
				ActionEvent.CTRL_MASK));
		
		exportDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U ,
				ActionEvent.CTRL_MASK));
		
		$abrirtDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		
		$guardarDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		
		$deshacerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				ActionEvent.CTRL_MASK));
		
		$rehacerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		
		prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,
				ActionEvent.ALT_MASK));
		
		
		
		$deshacerItem.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e){
				try {
					$frasesPanel.clearList();
					$frasesPanel.setData($controlador.undoMemento().getSavedState());			
					$undoManager.undo();
					$toolbar.refreshUndoRedo($undoManager);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No hay frases para Deshacer");
				}
						
			}
			
		});

		$rehacerItem.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e){
				try {
					$frasesPanel.clearList();
					$frasesPanel.setData($controlador.redoMemento().getSavedState());
					$undoManager.redo();			
			     	$toolbar.refreshUndoRedo($undoManager);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No hay frases para Reahacer");
				}
			
		     	
		     	
			}			
		});
		
		$abrirtDataItem.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e){
				if ($fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {						
						$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "...abierto");
						$frasesPanel.clearList();
						$frasesPanel.setData($controlador.loadFromFile($fileChooser.getSelectedFile()));						
					
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"No pudo guardarse el archivo "+$fileChooser.getSelectedFile().getName(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			
		});
		
		$guardarDataItem.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e){
				if ($fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "...guardado");
						$controlador.saveToFile($fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"No pudo guardarse el archivo "+$fileChooser.getSelectedFile().getName(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			
		});
		
		
		prefsItem.addActionListener(new ActionListener(){					
					public void actionPerformed(ActionEvent e){
						$prefsDialog.setVisible(true);
					}					
		});

		
		
		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ($fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "   ...abierto");
						$toolbarFinal.start();
						$controlador.loadFromFile($fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"No pudo pudo ser importado el archivo "+$fileChooser.getSelectedFile().getName(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ($fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					if (!$fileChooser.getSelectedFile().exists()) {
						$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "   ...abierto");
						$toolbarFinal.start();
						$controlador.saveAs($fileChooser.getSelectedFile());						}
					else{
						$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "   ...abierto");
						$toolbarFinal.start();
						File s = $fileChooser.getSelectedFile();
						$controlador.exportar(s);
					}
					$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "...exportado");
				}
				
				

			}
		});
		
		exportPdfDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ($fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "   ...abierto");
					$toolbarFinal.start();
					$controlador.exportarPdf($fileChooser.getSelectedFile());
				}					
				$toolbarFinal.setRutaGuardada($fileChooser.getSelectedFile().toString() + "...exportado");
			}
		});

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int $action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Do you really want to exit the appication?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

				if ($action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}

			}
		});
		return menuBar;

	}
	
	
	  private void close(){
	        if (JOptionPane.showConfirmDialog(rootPane,
	        		"¿Desea realmente salir de la Aplicacion?", "Salir de la Aplicacion", 
	        		JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
	        		Utils.createIcon("/images/icon.png")) == JOptionPane.YES_OPTION)
	            System.exit(0);
	       
	    }  
  
	  private class UndoAdapter implements UndoableEditListener {
		     public void undoableEditHappened (UndoableEditEvent evt) {
		     	UndoableEdit edit = evt.getEdit();
		     	$undoManager.addEdit( edit );		     	
		     	$toolbar.refreshUndoRedo($undoManager);
		     }
		  }
  }
