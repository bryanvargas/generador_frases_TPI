package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import entidades.Reserva;

public class ReservasDao implements Daoable<Reserva> {
	
	private static final String SQL_INSERT =
			"INSERT INTO reserva VALUES (?,?, ?,?, ?,?,?,?)";	
	private static final String SQL_UPDATE = 
			"UPDATE reserva SET estado_reservacion = ? WHERE n_inventario = ?";
	private static final String SQL_READ =
			"SELECT * FROM reserva WHERE n_inventario = ? ";			
	private static final String SQL_READALL = 
			"SELECT * FROM Reserva ";
	private static final String SQL_ACTUALIZAR_ESTADO_RESERVA =
			"UPDATE reserva SET estado_reservacion = ? WHERE id_cancha = ? AND n_inventario = ?";
	private static final Conexion conn = Conexion.saberEstado();
	
	public static final String[] $CABECERA_TABLA = 
			{"Id Inventario", "Nro Inventario","Fecha","Hora Inicio","Hora Fin","Monto a Pagar",
			 "Estado Reservacion","Duracion"};

	@Override
	public boolean create(Reserva reserva) throws SQLException {
		Object[] values = {
				reserva.get$id_cancha(),
				reserva.get$id_inventario(),
				reserva.get$fecha(),
				reserva.get$hora_inicio(),
				reserva.get$hora_fin(),
				reserva.get$monto_pagar(),
				reserva.isEstado_reservacion(),
				reserva.get$duracion()
			};
			
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet generatedKeys = null;        
	        try {
	        	 connection = conn.getConn();
	             preparedStatement = UtilSQL.prepareStatement(connection, SQL_INSERT, true, values);
	             int $filasAfectadas = preparedStatement.executeUpdate();
	             if ($filasAfectadas == 0) {
	            	 System.err.println("Creacion de resrva fallada, No hay filas afectadas.");
//	                 throw new DAOException("Creacion de Cancha fallada, No hay filas afectadas.");
	             }
	             generatedKeys = preparedStatement.getGeneratedKeys();
	             if (generatedKeys.next()) {
//	            	 reserva.setId_cancha(generatedKeys.getInt(1));
//	                 cancha.setId(generatedKeys.getLong(1));
	             } else {
	            	 System.err.println("No se pudo obtener el ID.");
//	                 throw new DAOException("No se pudo obtener el ID.");
	             }
	             return true;
	        } catch (SQLException e) {
	        	System.err.println("problema:" + e.getMessage());
//	        	throw new DAOException(e);
	        } finally {
	        	UtilSQL.close(connection,preparedStatement,generatedKeys);
	        }
	        return false;
	}

	@Override
	public boolean delete(Object id) {		
		try {
			throw new Exception("Viola Integridad por referecia. No hay filas afectadas.");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean upDate(Reserva reserva) {
		Object[] values = {
				reserva.isEstado_reservacion(),
				reserva.get$id_inventario()				
			};			
			Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        
	        try {
	            connection = conn.getConn();
	            preparedStatement = UtilSQL.prepareStatement(connection, SQL_UPDATE, false, values);
	            int affectedRows = preparedStatement.executeUpdate();
	            if (affectedRows == 0) {
//	                throw new DAOException("Updating user failed, no rows affected.");
	            	System.err.println("La actualizacion de la Reserva ha fallado, no hay filas afectadas");
	            }
	            return true;
	        } catch (SQLException e) {
//	            throw new DAOException(e);
	        	System.err.println("error: " + e.getMessage());
	        } finally {
	        	UtilSQL.close(connection, preparedStatement);
	        }
	        return false;
	}

	@Override
	public Reserva read(Object id) {
		Object[] values = { id };		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Reserva reserva = null;
        try {            
            preparedStatement = UtilSQL.prepareStatement(conn.getConn(), SQL_READ, false, values);          
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { 
            	reserva = mapeoCancha(resultSet);          	 
            }
           
        } catch (SQLException e) {
            
        } finally {
        	UtilSQL.close(conn.getConn(), preparedStatement, resultSet);
        }

        return reserva;
	}

	@Override
	public List<Reserva> readAll() {
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<Reserva> reserva = new ArrayList<>();
        try {            
            //preparedStatement = conn.getConn().prepareStatement(SQL_READALL);
            preparedStatement = UtilSQL.prepareStatement(conn.getConn(), SQL_READALL, false);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            	reserva.add(mapeoCancha(resultSet));
            }
            return reserva;
        } catch (SQLException e) {
//            throw new DAOException(e);
        } finally {
        	UtilSQL.close(connection, preparedStatement, resultSet);
        }
        return reserva;
	}
	
	
	public boolean upDateControlReserva(boolean reserva, int id_cancha, int n_inventario) {
		Object[] values = {reserva, id_cancha, n_inventario};
			
			Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        
	        try {
	            connection = conn.getConn();
	            preparedStatement = UtilSQL.prepareStatement(connection, SQL_ACTUALIZAR_ESTADO_RESERVA, false, values);
	            int affectedRows = preparedStatement.executeUpdate();
	            if (affectedRows == 0) {
//	                throw new DAOException("Updating user failed, no rows affected.");
	            	System.err.println("La actualizacion de la Reserva ha fallado, no hay filas afectadas");
	            }
	            return true;
	        } catch (SQLException e) {
//	            throw new DAOException(e);
	        	System.err.println("error: " + e.getMessage());
	        } finally {
	        	UtilSQL.close(connection, preparedStatement);
	        }
	        return false;
	}
	
	 /**
	 * @return un arreglo de tipo String con los nombres de las columnas de la tabla 
	 * reserva
	 * @throws SQLException
	 */
    public static String[] getNombreColumnas() throws SQLException{
		return UtilSQL.getNombreColumnas(conn.getConn(),SQL_READALL);        
    }
    public Object[][] tabla() throws SQLException{
   	 	return UtilSQL.GetStructTable(conn.getConn(),SQL_READALL);
    }
    
	private Reserva mapeoCancha(ResultSet resultSet) throws SQLException {		
		return new Reserva(
	            resultSet.getObject("id_cancha"),
	            resultSet.getObject("n_inventario"),
	            resultSet.getDate("fecha"),
	            resultSet.getInt("hora_inicio"),
	            resultSet.getInt("hora_fin"),
	            resultSet.getDouble("monto_pagar"),
	            resultSet.getBoolean("estado_reservacion"),
	            resultSet.getInt("duracion"));
	}
	
	public Object[] arregloReserva(Reserva reservas){
		Object[] o = {reservas.get$id_cancha(),
					reservas.get$id_inventario(),					
					reservas.get$fecha(),
					reservas.get$hora_inicio(),
					reservas.get$hora_fin(),
					reservas.get$monto_pagar(),				
					reservas.isEstado_reservacion(),
					reservas.get$duracion()};		
		return o;
	}
	public Object[][] readAllArray(List<Reserva> reservas){
		Object[][] reservasArray = new Object[reservas.size()][];
		for (int i = 0; i < reservas.size(); i++) {
			reservasArray[i] = arregloReserva(reservas.get(i));
		}
		return reservasArray;
	}
}
