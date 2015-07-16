package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import entidades.Cliente;
import entidades.ClienteRegistrado;
import entidades.Reserva;
import entidades.TipoCliente;

public class Prueba {
	public static void main(String[] args) {
		ReservasDao rdao = new ReservasDao();
		ClienteDao cdao = new ClienteDao();	
		CanchaDao cancha = new CanchaDao();
		//cdao.create(new ClienteRegistrado(null, TipoCliente.$registrado, "bryan", "vargas", "3232323", 100332, "shingo", "shingo", 33, 0, "bryanprsvar@gmail.com"));
		//cdao.create(new ClienteRegistrado(null, "indentificado", "Boris", "Vargas", "777979", 100022, "boras", "boras", 23, 2, "boras@gmail.com"));
		//rdao.upDateControlReserva(false,4, 2);
		//cdao.upDate(new ClienteRegistrado(3, TipoCliente.registrado, "shingo", "shingo", "23232", 200001,"shingo", "shingo", 32, 2, "bryanprsvar@gmail.com"));
//		try {
//			rdao.create(new Reserva(4, 2, new Date(), 10, 12, 240, false, 120));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//CanchaDao c= new CanchaDao();
		//Reserva r =rdao.read(1);
		
		//System.out.println(r.isEstado_reservacion());
	//	System.out.println(cdao.readAllMenosCumplidores());
		//System.out.println(cdao.readAllMenosCumplidoresDos());
		//System.out.println(cdao.readAllMenosCumplidoresTres().size());
//		for (Map<Integer, Cliente> map : cdao.readAllMenosCumplidoresTres())
//		     for (Entry<Integer, Cliente> entry : map.entrySet())
//		    	 System.out.println(entry.getKey() + " => " + entry.getValue().getClass());
//		         //view.append(entry.getKey() + " => " + entry.getValue());
//		
//		try {
//			Object[] arreglo = cdao.getNombreColumnas();
//			for (int i = 0; i < arreglo.length; i++) 
//				System.out.println(arreglo[i].getClass());
			
			Object[][] tabla = rdao.readAllDos();
			for (int i = 0; i < tabla.length; i++) {
				for (int j = 0; j < tabla[i].length; j++) {
					System.out.print(tabla[i][j] + " ");
				}
				System.out.println();
			}
			
			
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}
}
