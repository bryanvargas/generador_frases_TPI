package negocio;

import java.sql.SQLException;
import java.util.List;

import entidades.Reserva;
import modelo.CanchaDao;
import modelo.ClienteDao;
import modelo.ReservasDao;

public class Controlador {
	CanchaDao $canchas = new CanchaDao();
	ClienteDao $clientes = new ClienteDao();
	ReservasDao $reservas = new ReservasDao();
	
	public String[] getnombresColTabCanchas() {		
		return CanchaDao.$CABECERA_TABLA;
	}

	public String[] getNombresColTablaReservas() {
		return ReservasDao.$CABECERA_TABLA;
	}

	public String[] getNombresColTablaClientes() {		
		return ClienteDao.$CABECERA_TABLA;
	}

	public Object[][] getDatosTablaReservas() {	
		return $reservas.readAllArray($reservas.readAll());
	}

	public Object[][] getDatosTablaClientes() {
		return $clientes.readAllArray($clientes.readAll());
	}

	public Object[][] getDatosTablaCanchas() {
		return $canchas.readAllArray($canchas.readAll());
	}
	
	
}
