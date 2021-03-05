package junit.MVC.Model;

public class Persona {
	private String nombrePersona;
	private String apellidoPersona;
	private String direccionPersona;
	private Integer dni;
	private String fecha;
	
	public String getNombrePersona() {
		return nombrePersona;
	}
	public String getApellidoPersona() {
		return apellidoPersona;
	}
	public String getDireccionPersona() {
		return direccionPersona;
	}
	public Integer getDni() {
		return dni;
	}
	public String getFecha() {
		return fecha;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}
	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	

}
