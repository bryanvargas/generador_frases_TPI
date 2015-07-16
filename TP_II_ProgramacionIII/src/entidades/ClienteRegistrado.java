package entidades;


public class ClienteRegistrado extends Cliente {
	private int $n_cliente; 	
	private String $nombre_usuario;
	private String $password;
	private int $edad;	
	private int $permisos;
	private String $email;
	public ClienteRegistrado(Object $n_inventario, TipoCliente tipo, String nombres,
			String apellidos, String telefono,int $n_cliente, String $nombre_usuario,
			String $password, int $edad, int $permisos,String $email) {
		super($n_inventario, tipo, nombres, apellidos, telefono);
		this.$n_cliente = $n_cliente;
		this.$nombre_usuario = $nombre_usuario;
		this.$password = $password;
		this.$edad = $edad;
		this.$permisos = $permisos;
		this.$email = $email;
		
	}

	public int get$n_cliente() {
		return $n_cliente;
	}
	public void set$n_cliente(int $n_cliente) {
		this.$n_cliente = $n_cliente;
	}
	public String get$nombre_usuario() {
		return $nombre_usuario;
	}
	public void set$nombre_usuario(String $nombre_usuario) {
		this.$nombre_usuario = $nombre_usuario;
	}
	public String get$password() {
		return $password;
	}
	public void set$password(String $password) {
		this.$password = $password;
	}
	public int get$edad() {
		return $edad;
	}
	public void set$edad(int $edad) {
		this.$edad = $edad;
	}
	public int get$permisos() {
		return $permisos;
	}
	public void set$permisos(int $permisos) {
		this.$permisos = $permisos;
	}
	public String get$email() {
		return $email;
	}
	public void set$email(String $email) {
		this.$email = $email;
	}









	@Override
	public String toString() {
		return "ClienteRegistrado"+super.toString() +"[$n_cliente=" + $n_cliente
				+ ", $nombre_usuario=" + $nombre_usuario + ", $password="
				+ $password + ", $edad=" + $edad + ", $permisos=" + $permisos
				+ ", $email=" + $email + "]";
	}
	
	
	
	
	
	
}
