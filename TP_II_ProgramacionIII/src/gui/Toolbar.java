package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;


public class Toolbar extends JToolBar implements ActionListener{

	private static final long serialVersionUID = -4471978633890412807L;
	private JButton $mostrar_clientes;
	private JButton $mostrar_canchas;
	private JButton $mostrar_reservas;
	private JButton $mostrar_estadisticas;
	private JButton $cliente;
	private JButton $reserva;
	private ToolbarListener toolbarListener;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setFloatable(false);
		setUpBotones();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		if(clicked == $mostrar_clientes){
			if (toolbarListener != null) {
				toolbarListener.mostrarClientesEventOccured();
			}
		}else if(clicked == $mostrar_canchas){
			if (toolbarListener != null) {
				toolbarListener.mostrarCanchasEventOccured();
			}
		}else if(clicked == $mostrar_reservas){
			if (toolbarListener != null) {
				toolbarListener.mostrasReservasEventOcurred();
			}
		}else if(clicked == $mostrar_estadisticas){
			if (toolbarListener != null) {
				toolbarListener.mostrasEstadisticasEventOcurred();
			}
		}else if(clicked == $cliente){
			if (toolbarListener != null) {
				toolbarListener.mostrarFomularioEventOcurred();
			}
		}else if(clicked == $reserva){
			if (toolbarListener != null) {
				toolbarListener.mostrarFomularioReservaEventOcurred();
			}
		}
		
		
	}
	
	public void setToolbarListener(ToolbarListener listener){
		this.toolbarListener = listener;
	}
	
	private void setUpBotones(){		
		$mostrar_clientes = new JButton();
		$mostrar_clientes.setText("Mostrar registro Clientes");
		$mostrar_clientes.addActionListener(this);
		
		$mostrar_canchas = new JButton();
		$mostrar_canchas.setText("Mostrar registro Canchas");
		$mostrar_canchas.addActionListener(this);
		
		$mostrar_reservas = new JButton();
		$mostrar_reservas.setText("Mostrar registro Registro");
		$mostrar_reservas.addActionListener(this);
		
		$mostrar_estadisticas = new JButton();
		$mostrar_estadisticas.setText("Estadsticas Clientes");
		$mostrar_estadisticas.addActionListener(this);
		
		$cliente =  new JButton();
		$cliente.setText("Ingresar Nuevo cliente");
		$cliente.addActionListener(this);
		
		$reserva =  new JButton();
		$reserva.setText("Ingresar Nueva Reserva");
		$cliente.addActionListener(this);
		
		add($mostrar_clientes);
		add($mostrar_canchas);
		add($mostrar_reservas);
		add($cliente);
		add($mostrar_estadisticas);
	}
}
