package services;



import model.Paciente;
import util.conexion;

public class PacienteDao 
extends conexion<Paciente> 
implements genericdao<Paciente> {
	public PacienteDao() {
		super(Paciente.class);
	}

}
