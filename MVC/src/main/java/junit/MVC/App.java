package junit.MVC;

/**
 * Hello world!
 *
 */
import junit.MVC.Controller.PersonaController;
import junit.MVC.Model.PersonaServ;
import junit.MVC.View.VentanaBuscar;
import junit.MVC.View.VentanaPrincipal;
import junit.MVC.View.VentanaRegistro;

public class App {
	
	PersonaServ mipersonaServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaRegistro miVentanaRegistro;
	PersonaController personaController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App miPrincipal=new App();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaRegistro=new VentanaRegistro();
		miVentanaBuscar= new VentanaBuscar();
		mipersonaServ=new PersonaServ();
		personaController= new PersonaController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(personaController);
		miVentanaRegistro.setCoordinador(personaController);
		miVentanaBuscar.setCoordinador(personaController);
		mipersonaServ.setpersonaController(personaController);
		
		/*Se establecen relaciones con la clase coordinador*/
		personaController.setMiVentanaPrincipal(miVentanaPrincipal);
		personaController.setMiVentanaRegistro(miVentanaRegistro);
		personaController.setMiVentanaBuscar(miVentanaBuscar);
		personaController.setPersonaServ(mipersonaServ);
				
		miVentanaPrincipal.setVisible(true);
	}

}

