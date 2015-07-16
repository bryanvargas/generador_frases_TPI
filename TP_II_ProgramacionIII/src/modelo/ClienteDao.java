package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import conexion.Conexion;
import entidades.Cliente;
import entidades.ClienteRegistrado;
import entidades.TipoCliente;


public class ClienteDao implements Daoable<Cliente> {
	private static final String SQL_INSERTCLIENTE =
			"INSERT INTO cliente VALUES (?,?, ?,?, ?)";
	private static final String SQL_INSERTClLIENTEREGISTRADO =
			"INSERT INTO cliente_registrado VALUES (?,?,?,?,?,?,?)";	
	private static final String SQL_DELETE = 
			"DELETE FROM cliente WHERE n_inventario = ?";
	private static final String SQL_UPDATE = 
			"UPDATE cliente_registrado SET nombre_usuario = ?,password=?,edad=?, email=? WHERE n_inventario = ?";
	private static final String SQL_READ =
			"SELECT * FROM cliente c JOIN cliente_registrado cr USING(n_inventario) WHERE cr.n_inventario = ?";			
	private static final String SQL_READALL = 
			"SELECT * FROM cliente JOIN cliente_registrado USING(n_inventario)";
	private static final String SQL_READALL_MENOS_CUMPLIDORES = 
			"SELECT * FROM cliente JOIN cliente_registrado USING(n_inventario) JOIN reserva USING(n_inventario) where estado_reservacion=0";
	private static final String SQL_READALL_MENOS_CUMPLIDORESDOS = 
			"SELECT *, COUNT(*) AS MENOSCUMPLIDORES FROM cliente JOIN cliente_registrado USING(n_inventario)"
			+ " JOIN reserva USING(n_inventario)"
			+ "where estado_reservacion=0 GROUP BY n_inventario ";
	public static final String[] $CABECERA_TABLA= 
			{"Inventario","Nro Cliente","Nombres","Apellidos","Usuario","Password","Edad","Telefono","Email","Permisos"};
	private static final Conexion conn = Conexion.saberEstado();
	
	/**
	 * @param Recibe un parametro de tipo ClienteRegistrado,
	 * 			Ej: ClienteRegistrado(null,  ) 
	 */
	@Override
	public boolean upDate(Cliente c) {
		PreparedStatement pst;
		ClienteRegistrado cr = (ClienteRegistrado) c;
		try{
			pst = conn.getConn().prepareStatement(SQL_UPDATE);
			pst.setString(1, cr.get$nombre_usuario());
			pst.setString(2, cr.get$password());
			pst.setInt(3, cr.get$edad());
			pst.setString(4, cr.get$email());
			pst.setObject(5, cr.get$n_inventario());
			if(pst.executeUpdate()>0){
				JOptionPane.showMessageDialog(null, "UPDATE TRUE");
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean delete(Object t) {
		PreparedStatement pst;
		try{
			pst =  conn.getConn().prepareStatement(SQL_DELETE);
			pst.setString(1, t.toString());
			if(pst.executeUpdate()>0){
				JOptionPane.showMessageDialog(null, "DELETE TRUE");
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.cerrarConexion();
		}
		
		return false;
	}

	@Override
	public boolean create(Cliente c)   {
		PreparedStatement cliente = null;
		PreparedStatement clienteRegistrado = null;
		
		ClienteRegistrado cr= (ClienteRegistrado) c; 
		try{			
			
			conn.getConn().setAutoCommit(false);
		
			cliente = conn.getConn().prepareStatement(SQL_INSERTCLIENTE,Statement.RETURN_GENERATED_KEYS);
			clienteRegistrado =  conn.getConn().prepareStatement(SQL_INSERTClLIENTEREGISTRADO);
			
			cliente.setObject(1, c.get$n_inventario());			
			cliente.setString(2, c.getTipo().toString());
			cliente.setString(3, c.getNombres());
			cliente.setString(4, c.getApellidos());
			cliente.setString(5, c.getTelefono());
			cliente.executeUpdate();
			int key = 0;
			ResultSet rs = cliente.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    key = (int) rs.getLong(1);
			}
			clienteRegistrado.setObject(1,key);
			clienteRegistrado.setInt(2, cr.get$n_cliente());
			clienteRegistrado.setString(3, cr.get$nombre_usuario());
			clienteRegistrado.setString(4, cr.get$password());
			clienteRegistrado.setInt(5, cr.get$edad());
			clienteRegistrado.setInt(6, cr.get$permisos());
			clienteRegistrado.setString(7, cr.get$email());
			clienteRegistrado.executeUpdate();
			
//			if(cliente.executeUpdate()>0 && clienteRegistrado.executeUpdate()>0){
//				JOptionPane.showMessageDialog(null, "Se ha ingresado exitosamente");
//				
//			}
			conn.getConn().commit();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			if (conn.getConn() != null) {
				try {
					System.err.print("La trasaccion se deshace ");
					conn.getConn().rollback();
				} catch (SQLException ex) {
					e.getMessage();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			if (cliente !=null) {
				try {
					cliente.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}if (clienteRegistrado !=null) {
				try {
					clienteRegistrado.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				conn.getConn().setAutoCommit(true);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			conn.cerrarConexion();
		}
		return false;
	}

	@Override
	public Cliente read(Object t) {
		PreparedStatement pst;
		Cliente cliente = null;
		ResultSet res;
		try{
			pst =conn.getConn().prepareStatement(SQL_READ);
			pst.setString(1,t.toString());
			
			res = pst.executeQuery();
			if (res.next()) { 
            	cliente = mapeoCLiente(res);          	 
            }
			return cliente;
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.cerrarConexion();
		}
		return cliente;
	}

	@Override
	public List<Cliente> readAll() {
		PreparedStatement pst;
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet res;
		try{
			pst = conn.getConn().prepareStatement(SQL_READALL);			
			res = pst.executeQuery();
			while(res.next()){
				clientes.add(mapeoCLiente(res));
			}			
			return clientes;
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.cerrarConexion();
	
		}
		return clientes;
	
	}
	

	public List<Cliente> readAllMenosCumplidores() {		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            connection = conn.getConn();           
            preparedStatement = conn.getConn().prepareStatement(SQL_READALL_MENOS_CUMPLIDORESDOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {  
            	System.out.println(resultSet.getString("MENOSCUMPLIDORES") + " " + resultSet.getString("nombre"));
                clientes.add(mapeoCLiente(resultSet));
            }
            return clientes;
        } catch (SQLException e) {
//            throw new DAOException(e);
        	System.err.println("error: " +e.getMessage());
        } finally {
        	UtilSQL.close(connection, preparedStatement, resultSet);
        }
        return clientes;
	}
	

	public List<Map<Integer,Cliente>> readAllMenosCumplidoresTres() {		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<Map<Integer, Cliente>> clientes = new ArrayList<Map<Integer, Cliente>>();

        try {
            connection = conn.getConn();           
            preparedStatement = conn.getConn().prepareStatement(SQL_READALL_MENOS_CUMPLIDORESDOS);
            resultSet = preparedStatement.executeQuery();
            
            ResultSetMetaData meta = resultSet.getMetaData();		
            while (resultSet.next()) {  
            	Map map = new TreeMap();
            	
                    Integer key =resultSet.getInt("MENOSCUMPLIDORES");
                    Cliente value = mapeoCLiente(resultSet);
                    map.put(key, value);
                
            	clientes.add(map);
            }
            return clientes;
        } catch (SQLException e) {
//            throw new DAOException(e);
        	System.err.println("error: " +e.getMessage());
        } finally {
        	UtilSQL.close(connection, preparedStatement, resultSet);
        }
        return clientes;
	}
	public Object[][] readAllMenosCumplidoresDos() {		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        Object[][] clientes  = null;

        try {
            connection = conn.getConn();           
            preparedStatement = conn.getConn().prepareStatement(SQL_READALL_MENOS_CUMPLIDORESDOS);
            resultSet = preparedStatement.executeQuery();
           clientes  = ResultSetToArray(resultSet);
          // System.out.println(resultSet.getString("MENOSCUMPLIDORES") + " " + resultSet.getString("nombre"));
            
        } catch (SQLException e) {
//            throw new DAOException(e);
        	System.err.println("error: " +e.getMessage());
        } finally {
        	UtilSQL.close(connection, preparedStatement, resultSet);
        }
        return clientes;
	}
	
	
	private Object[][] ResultSetToArray(ResultSet rs)
    {
        Object obj[][]=null;
        //System.out.println(rs.getString("nombre"));
        try
        {
 
        //rs.last();
 
        ResultSetMetaData rsmd = rs.getMetaData();
 
        int numCols = rsmd.getColumnCount();
 System.out.println(numCols);
        int numFils =rs.getRow();
        System.out.println(numFils);
        obj=new Object[numFils][numCols];
        int j = 0;
 
        rs.beforeFirst();
 
        while (rs.next())
        {
        	System.out.println("frfrfrfrfrf");
            for (int i=0;i<numCols;i++)
            {
            	System.out.println("frfrfrfrfrf");
                obj[j][i]=rs.getObject(i+1);
            }
            j++;
 
        }
 
        }
        catch(Exception e)
        {
 
        }
 
        return obj;
    }
	
	 /**
	 * @return un arreglo de tipo String con los nombres de las columnas de la tabla 
	 * ClienteRegistrado
	 * @throws SQLException
	 */
    public String[] getNombreColumnas() throws SQLException{
		return UtilSQL.getNombreColumnas(conn.getConn(),SQL_READALL);        
    }
	
	
	private Cliente mapeoCLiente(ResultSet resultSet) throws SQLException {	
		TipoCliente t = null;
		if (resultSet.getString("tipo").equals("registrado")) {			
			t = TipoCliente.registrado;
		}else if (resultSet.getString("tipo").equals("no registrado")) {
			t = TipoCliente.no_registrado;
		}
		return new ClienteRegistrado(
	            resultSet.getObject("n_inventario"),
	            t,
	            resultSet.getString("nombre"),
	            resultSet.getString("apellido"),
	            resultSet.getString("telefono"),
	            resultSet.getInt("n_cliente"),
	            resultSet.getString("nombre_usuario"),
	            resultSet.getString("password"),
	            resultSet.getInt("edad"),
	            resultSet.getInt("permisos"),
	            resultSet.getString("email"));
	}
	
    public Object[][] tabla() throws SQLException{
      	 return UtilSQL.GetStructTable(conn.getConn(),SQL_READALL);
    }
    
    public Object[][] menosCumplidores() throws SQLException{
     	 return UtilSQL.GetStructTable(conn.getConn(),SQL_READALL_MENOS_CUMPLIDORESDOS);
   }
    
//    "Inventario","Nro Cliente","Nombres","Apellidos","Usuario","Password","Edad","Telefono","Email","Permisos"};
    public Object[] arregloReserva(ClienteRegistrado $clientes){
		Object[] o = {$clientes.get$n_inventario(),
					$clientes.get$n_cliente(),
					$clientes.getNombres(),
					$clientes.getApellidos(),
					$clientes.get$nombre_usuario(),					
					$clientes.get$password(),
					$clientes.get$edad(),
					$clientes.getTelefono(),
					$clientes.get$email(),				
					$clientes.get$permisos()};		
		return o;
	}
	public Object[][] readAllArray(List<Cliente> list){
		Object[][] reservasArray = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			reservasArray[i] = arregloReserva((ClienteRegistrado)list.get(i));
		}
		return reservasArray;
	}
	
	
}
