package junit.MVC.Controller;

import junit.MVC.Model.Persona;
import junit.MVC.Model.PersonaServ;
import junit.MVC.View.VentanaBuscar;
import junit.MVC.View.VentanaPrincipal;
import junit.MVC.View.VentanaRegistro;

public class PersonaController {
	
	private PersonaServ personaServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistro miVentanaRegistro;
	private VentanaBuscar miVentanaBuscar;
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistro getMiVentanaRegistro() {
		return miVentanaRegistro;
	}
	public void setMiVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}
	public VentanaBuscar getMiVentanaBuscar() {
		return miVentanaBuscar;
	}
	public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
		this.miVentanaBuscar = miVentanaBuscar;
	}
	public PersonaServ getPersonaServ() {
		return personaServ;
	}
	public void setPersonaServ(PersonaServ personaServ) {
		this.personaServ = personaServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miVentanaBuscar.setVisible(true);
	}
	

	
	public Persona buscarPersona(String codigoPersona) {
		return personaServ.validarConsulta(codigoPersona);
	}
	
	public void modificarPersona(Persona miPersona) {
		personaServ.validarModificacion(miPersona);
	}
	
	public void eliminarPersona(int DNI) {
		personaServ.validarEliminacion(DNI);
	}

}
