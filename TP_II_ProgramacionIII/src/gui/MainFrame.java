package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import entidades.Reserva;
import negocio.Controlador;

public class MainFrame extends JFrame {	
	private static final long serialVersionUID = -8026416994513756565L;
	private TablaPanel $tablaPanel;	
	private Toolbar $toolbar;
	private Controlador $controlador;
	private FormPanel $form_nuevo_cliente_panel;
	private ReservaPanel $form_nueva_reserva;
	private Graficos $graficos;
	private JSplitPane splitPane;
	
	
	public MainFrame() {
		super("TP II");
		$controlador = new Controlador();
		$toolbar = new Toolbar();		
		$tablaPanel = new TablaPanel();
		$graficos =  new Graficos();
		$form_nuevo_cliente_panel =  new FormPanel();
		$form_nueva_reserva =  new ReservaPanel();
		setJMenuBar(mostrarMenuBar());
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,$form_nuevo_cliente_panel,$tablaPanel);	
			splitPane.setRightComponent($form_nueva_reserva);
			splitPane.	
	
		splitPane.setOneTouchExpandable(true);
		
		
		
		
		/** ***************** Eventos Formulario ********** **/
		/** *********************************************** **/	
		$form_nuevo_cliente_panel.setFormListener(new FormListener() {			
			@Override
			public void formEventOccurred(FormEvent e) {
				splitPane.setDividerLocation((int)$form_nuevo_cliente_panel.getMinimumSize().getWidth());
			
				$form_nuevo_cliente_panel.setVisible(false);
			}
		});
		
		
		
		/** ***************** Eventos Toolbar ************* **/
		/** *********************************************** **/	
		$toolbar.setToolbarListener(new ToolbarListener() {			
			
			@Override
			public void mostrasReservasEventOcurred() {
				$tablaPanel.setNombreColumnasTabla($controlador.getNombresColTablaReservas());
				
				//$tablaPanel = new TablaPanel($controlador.getNombresColTablaReservas());
				$tablaPanel.setDataTabla($controlador.getDatosTablaReservas());
				$tablaPanel.refresh();
				
			}
			
			@Override
			public void mostrarClientesEventOccured() {
				$tablaPanel.setNombreColumnasTabla($controlador.getNombresColTablaClientes());
				//$tablaPanel = new TablaPanel($controlador.getNombresColTablaClientes());
				$tablaPanel.setDataTabla($controlador.getDatosTablaClientes());
				$tablaPanel.refresh();
			}
			
			@Override
			public void mostrarCanchasEventOccured() {
				$tablaPanel.setNombreColumnasTabla($controlador.getnombresColTabCanchas());
				//$tablaPanel = new TablaPanel($controlador.getnombresColTabCanchas());
				$tablaPanel.setDataTabla($controlador.getDatosTablaCanchas());
				$tablaPanel.refresh();
			}

			@Override
			public void mostrasEstadisticasEventOcurred() {
				//$torta_estadistica =  new TableChartPopup();
				//$torta_estadistica.setVisible(true);
				$graficos.setVisible(true);
			}

			@Override
			public void mostrarFomularioEventOcurred() {				
				splitPane.setDividerLocation((int)$form_nuevo_cliente_panel.getMinimumSize().getWidth());				
				$form_nuevo_cliente_panel.setVisible(true);			
			}

			@Override
			public void mostrarFomularioReservaEventOcurred() {
				splitPane.setDividerLocation((int)$form_nueva_reserva.getMinimumSize().getWidth());				
				$form_nueva_reserva.setVisible(true);		
				
			}
		});
		
		
		
		/** ***************** SetUp MainFrame ************* **/
		/** *********************************************** **/		
		setLayout(new BorderLayout());
//		add($tablaPanel,BorderLayout.CENTER);
		add(splitPane, BorderLayout.CENTER);
		add($toolbar,BorderLayout.PAGE_START);		
		
		setMinimumSize(new Dimension(500, 400));
		setSize(600,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	private JMenuBar mostrarMenuBar(){
		JMenuBar $menu_bar = new JMenuBar();
		JMenu $file_menu = new JMenu("Menu");
		JMenuItem $expor_data_item = new JMenuItem("Exportar Archivo...");
		JMenuItem $import_data_item = new JMenuItem("Importar Archivo...");
		JMenuItem $exit_item = new JMenuItem("Exit");
	    $file_menu.add($expor_data_item);
	    $file_menu.add($import_data_item);
	    $file_menu.add($exit_item);
	    
	    JMenu $window_menu = new JMenu("Window");
	    JMenu $mostrar_menu = new JMenu("Mostrar");
	    JMenuItem $pref_item = new JMenuItem("Preferencias...");	    
	    JCheckBoxMenuItem $show_form_item = new JCheckBoxMenuItem("Person Form");
	    $mostrar_menu.add($show_form_item);
	    $window_menu.add($mostrar_menu);
	    $window_menu.add($pref_item);	    
	    
	    $menu_bar.add($file_menu);
	    $menu_bar.add($window_menu);
		
		return $menu_bar;
	}
	
}
