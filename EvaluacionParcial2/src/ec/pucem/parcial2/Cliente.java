package ec.pucem.parcial2;

public class Cliente {

	private String Nombre;
	private String Apellido;
	private String Cedula;
	private String Direccion;
	private String Telefono;
	private String Email;
	
	
	public Cliente(String cedula,
			String nombre,
			String apellido,
			String telefono,
			String email,
			String direccion) {
		
		this.Cedula = cedula;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Telefono = telefono;
		this.Email = email;
		this.Direccion = direccion;
		
	}


	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		this.Cedula = cedula;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
}