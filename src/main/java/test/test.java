package test;
import services.PacienteDao;
import model.Paciente;

public class test {
public static void main(String[] args) {
		
		PacienteDao pdao = new PacienteDao();
		Paciente p = new Paciente();
		
		//System.out.println(u.calcularProm(3, 4)); 
		
		for(Paciente s: pdao.list()) {
			System.out.println(s.toString());
		}
		
		
	}
}
