package junit.MVC.Model;

import javax.swing.JOptionPane;

import junit.MVC.Model.PersonaDao;
import junit.MVC.Model.Persona;
import junit.MVC.Controller.PersonaController;

public class PersonaServ {
	
	private PersonaController personaController; 
	public static boolean consultaPersona=false;
	public static boolean modificaPersona=false;
	
	//Metodo de vinculación con el controller principal
	public void setpersonaController(PersonaController personaController) {
		this.setController(personaController);		
	}


	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Persona validarConsulta(String codigoPersona) {
		PersonaDao miPersonaDao;
		
		try {
			int codigo=Integer.parseInt(codigoPersona);	
			if (codigo > 99) {
				miPersonaDao = new PersonaDao();
				consultaPersona=true;
				return miPersonaDao.buscarPersona(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaPersona=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Persona miPersona) {
		PersonaDao miPersonaDao;
		if (miPersona.getNombrePersona().length()>5) {
			miPersonaDao = new PersonaDao();
			miPersonaDao.modificarPersona(miPersona);	
			modificaPersona=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaPersona=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(int DNI) {
		PersonaDao miPersonaDao=new PersonaDao();
		miPersonaDao.eliminarPersona(DNI);
	}

	
	
	public PersonaController getPersonaController() {
		return personaController;
	}

	public void setController(PersonaController personaController) {
		this.personaController = personaController;
	}



}
