package junit.MVC.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import junit.MVC.Model.Conexion;
import junit.MVC.Model.Persona;

/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class PersonaDao
{

	public void registrarPersona(Persona miPersona)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
//			String sql= "INSERT INTO persona VALUES ('"+miPersona.getIdPersona()+"', '"
//					+miPersona.getNombrePersona()+"', '"+miPersona.getEdadPersona()+"', '"
//					+miPersona.getProfesionPersona()+"', '"+miPersona.getTelefonoPersona()+"');";
			String sql="Insert Into persona Values("+
					"\""+miPersona.getNombrePersona()+"\","+
					"\""+miPersona.getApellidoPersona()+"\","+
					"\""+miPersona.getDireccionPersona()+"\","+
					miPersona.getDni()+
					"\""+miPersona.getFecha()+"\""+
					");";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public Persona buscarPersona(int dni) 
	{
		Conexion conex= new Conexion();
		Persona persona= new Persona();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM persona where DNI = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, dni);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				persona.setNombrePersona(res.getString("nombre"));
				persona.setApellidoPersona(res.getString("apellido"));
				persona.setDireccionPersona(res.getString("direccion"));
				persona.setDni(Integer.parseInt(res.getString("dni")));
				persona.setFecha(res.getString("fecha"));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return persona;
			}
			else return null;				
	}

	public void modificarPersona(Persona miPersona) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE persona SET nombre = ? , apellido=? , direccion=? , dni= ?, fecha= ? WHERE dni= ?";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miPersona.getNombrePersona());
            estatuto.setString(2, miPersona.getApellidoPersona());
            estatuto.setString(3, miPersona.getDireccionPersona());
            estatuto.setInt(4,miPersona.getDni());
            estatuto.setString(5, miPersona.getFecha());
            estatuto.setInt(6, miPersona.getDni());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarPersona(int dni)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM persona WHERE dni='"+dni+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
