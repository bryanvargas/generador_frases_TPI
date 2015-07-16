package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.Conexion;
import entidades.Cancha;
import entidades.Reserva;
import entidades.TipoCesped;


/**
 * 
 * @author Bryan Vargas	
 * @version 0.2
 */
public class CanchaDao implements Daoable<Cancha> {
	private static final String SQL_INSERT =
			"INSERT INTO cancha VALUES (?,?,?,?,?,?)";
	private static final String SQL_DELETE = 
			"DELETE FROM cancha WHERE id_cancha=?";
	private static final String SQL_UPDATE = 
			"UPDATE cancha SET nombre = ?,precio=?,cantidad_max_jugadores=?, descripcion=?,tipo=? WHERE id_cancha = ?";
	private static final String SQL_READ = 
			"SELECT * FROM cancha WHERE id_cancha=?";
	private static final String SQL_READALL = 
			"SELECT * FROM cancha ";
	private static final String SQL_READCANCHASDISPONIBLES = 
			"SELECT * FROM cancha WHERE id_cancha NOT IN(SELECT id_cancha FROM reserva )";
	
	public static final String[] $CABECERA_TABLA =
			{"Id Cancha","Nombre","Precio","Cantidad Maxima Jugadores",
			 "Descripcion"};
	
	private static final Conexion conn = Conexion.saberEstado();
	
	/**
	 * @param cancha de tipo Cancha.<br>
	 * 			Ejemplo: Cancha(null, "Las Palmas I", 120.00, 16,
	 * 			 "alguna descripcion",TipoCesped.sintetico )
	 * @return TRUE si la creacion a sido exitosa,<br>
	 * 		   FALSE si la ocurrio algun problema. 
	 */
	@Override
	public boolean create(Cancha cancha) {
		Object[] values = {
			cancha.getId_cancha(),
			cancha.getNombre(),
			cancha.getPrecio(),
			cancha.getMax_jugadores(),
			cancha.getDescripcion(),
			cancha.getTipoCancha()
		};		
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;        
        try {
        	 connection = conn.getConn();
             preparedStatement = UtilSQL.prepareStatement(connection, SQL_INSERT, true, values);
             int $filasAfectadas = preparedStatement.executeUpdate();
             if ($filasAfectadas == 0) {
            	 System.err.println("Creacion de Cancha fallada, No hay filas afectadas.");
//                 throw new DAOException("Creacion de Cancha fallada, No hay filas afectadas.");
             }
             generatedKeys = preparedStatement.getGeneratedKeys();
             if (generatedKeys.next()) {
            	 cancha.setId_cancha(generatedKeys.getInt(1));
//                 cancha.setId(generatedKeys.getLong(1));
             } else {
            	 System.err.println("No se pudo obtener el ID.");
//                 throw new DAOException("No se pudo obtener el ID.");
             }
             return true;
        } catch (SQLException e) {
        	System.err.println("problema:" + e.getMessage());
//        	throw new DAOException(e);
        } finally {
        	UtilSQL.close(connection,preparedStatement,generatedKeys);
        }
        return false;
	}
	/**
	 * @param id de tipo Object de la fila a borrar 			
	 * @return retorna TRUE si la eliminacion  a sido exitosa,<br>
	 * 		   FALSE si la ocurrio algun problema. 
	 */
	@Override
	public boolean delete(Object id) {
		Object[] values = {id};
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {	
            connection = conn.getConn();            
            preparedStatement = UtilSQL.prepareStatement(connection, SQL_DELETE, false, values);            
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {            
                System.err.println(("Borrado de Cancha fallada, No hay filas afectadas." ));
            } else {
            	JOptionPane.showMessageDialog(null, "DELETE TRUE");
				return true;
            }
        } catch (SQLException e) {
//            throw new Exception(e);
        } finally {
        	UtilSQL.close(connection, preparedStatement);
        }
		return false;
	}

	/**
	 * Metodo utilizado para actualizar un campo seleccionado.
	 * @param cancha de tipo Cancha.<br>
	 * 			Ejemplo: Cancha(null, "Las Palmas I", 120.00, 16,
	 * 			 "alguna descripcion",TipoCesped.sintetico )
	 * @return TRUE si la actualizacion a sido exitosa,<br>
	 * 		   FALSE si la ocurrio algun problema. 
	 */
	@Override
	public boolean upDate(Cancha cancha) {
		Object[] values = {
			cancha.getNombre(),
			cancha.getPrecio(),
			cancha.getMax_jugadores(),
			cancha.getDescripcion(),
			cancha.getTipoCancha(),
			cancha.getId_cancha()
		};
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = conn.getConn();
            preparedStatement = UtilSQL.prepareStatement(connection, SQL_UPDATE, false, values);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
//                throw new DAOException("Updating user failed, no rows affected.");
            	System.err.println("La actualizacion de Cancha ha fallado, no hay filas afectadas");
            }
            return true;
        } catch (SQLException e) {
//            throw new DAOException(e);
        	System.err.println("error: " + e.getMessage());
        } finally {
        	UtilSQL.close(connection, preparedStatement);
        }
        return false;
	}
	/**
	 * Metodo utilizado para obtener un registro de la tabla Cancha.
	 * @param  id de tipo Objeto.<br>  
	 * @return Cancha con el ID pasado como paramentro, <br>
	 * 		   NULL e el caso de que el ID no exista.
	 */
	@Override
	public Cancha read(Object id) {
		Object[] values = { id };		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cancha cancha = null;
        try {            
            preparedStatement = UtilSQL.prepareStatement(conn.getConn(), SQL_READ, false, values);          
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { 
            	cancha = mapeoCancha(resultSet);          	 
            }
           
        } catch (SQLException e) {
            
        } finally {
        	UtilSQL.close(conn.getConn(), preparedStatement, resultSet);
        }

        return cancha;		
	}

	/**
	 * Metodo utilizado para obtener todos las filas de la tabla Cancha.	 *  
	 * @return Una lista con todas las filas de la tabla Cancha, <br>
	 * 		   NULL e el caso de que el ID no exista.
	 */
	@Override
	public List<Cancha> readAll() {
		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<Cancha> canchas = new ArrayList<>();

        try {
      
//            preparedStatement = UtilSQL.prepareStatement(conn.getConn(), SQL_READALL, false, new Object());
            preparedStatement = conn.getConn().prepareStatement(SQL_READALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {  
                canchas.add(mapeoCancha(resultSet));
            }
            return canchas;
        } catch (SQLException e) {
//            throw new DAOException(e);
        } finally {
        	UtilSQL.close(connection, preparedStatement, resultSet);
        }
        return canchas;
	}
	
	/**
	 * Metodo utilizado para obtener todas las filas de la tabla Cancha 
	 * en el cual la cancha este disponible. 
	 * @return Una lista con todas las filas de la tabla Cancha, <br>
	 * 		   NULL e el caso de que el ID no exista.
	 */
	public List<Cancha> readCanchasDisponibles() {
		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<Cancha> canchas = new ArrayList<>();

        try {
            connection = conn.getConn();
//            preparedStatement = UtilSQL.prepareStatement(conn.getConn(), SQL_READALL, false, new Object());
            preparedStatement = conn.getConn().prepareStatement(SQL_READCANCHASDISPONIBLES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {  
                canchas.add(mapeoCancha(resultSet));
            }
            return canchas;
        } catch (SQLException e) {
//            throw new DAOException(e);
        } finally {
        	UtilSQL.close(connection, preparedStatement, resultSet);
        }
        return canchas;
	}
	

	private Cancha mapeoCancha(ResultSet resultSet) throws SQLException {		
		TipoCesped t = null;
		if (resultSet.getString("tipo").equals("cesped")) {			
			t = TipoCesped.pasto;
		}else if (resultSet.getString("tipo").equals("sintetico")) {
			t = TipoCesped.sintetico;
		}else if (resultSet.getString("tipo").equals("tierra")) {
			t = TipoCesped.tierra;			
		}	
		return new Cancha(
	            resultSet.getInt("id_cancha"),
	            resultSet.getString("nombre"),
	            resultSet.getDouble("precio"),
	            resultSet.getInt("cantidad_max_jugadores"),
	            resultSet.getString("descripcion"), 
	            t);
	}
	
	 /**
	 * @return un arreglo de tipo String con los nombres de las columnas de la tabla 
	 * cancha
	 * @throws SQLException
	 */
     public String
     [] getNombreColumnas() throws SQLException{
		return UtilSQL.getNombreColumnas(conn.getConn(),SQL_READALL);        
     }
     
     public Object[][] tabla() throws SQLException{
    	 System.out.println("paso por aca: " + UtilSQL.GetStructTable(conn.getConn(),SQL_READALL));
    	 return UtilSQL.GetStructTable(conn.getConn(),SQL_READALL);
     }
	
	  public void writeMetaData(ResultSet resultSet) throws SQLException {		    
		    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
		      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		    }
		  }
//	  "Id Cancha","Nombre","Precio","Cantidad Maxima Jugadores",
//		 "Descripcion","Tipo Cesped"
	  public Object[] arregloCanchas(Cancha canchas){
			Object[] o = {canchas.getId_cancha(),
					canchas.getNombre(),					
					canchas.getPrecio(),
					canchas.getMax_jugadores(),
					canchas.getDescripcion()};	
			System.out.println(canchas.getDescripcion());
			return o;
		}
		public Object[][] readAllArray(List<Cancha> canchas){
			System.out.println("cuantas veces entras");
			Object[][] reservasArray = new Object[canchas.size()][];
			for (int i = 0; i < canchas.size(); i++) {
				reservasArray[i] = arregloCanchas(canchas.get(i));
			}
			return reservasArray;
		}
}
