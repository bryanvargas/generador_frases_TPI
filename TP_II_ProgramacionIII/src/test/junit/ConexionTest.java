package test.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import conexion.Conexion;

public class ConexionTest {
	Conexion conn;
	@Before
	public void setUp(){
		
	}
//
//	@Test
//	public void testGetConn() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetConn() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testSaberEstado() {
		conn = Conexion.saberEstado();
		assertTrue(conn!=null);
	}

	@Test
	public void testCerrarConexion() {	
//		conn = Conexion.saberEstado();
		conn.cerrarConexion();
//		assertEquals(conn.cerrarConexion(), conn.cerrarConexion());
		assertTrue(conn==null);
	}

	

}
