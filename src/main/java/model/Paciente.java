package model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paciente")
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String apellido;

	private String direccion;

	private String documento;

	private String email;

	private BigDecimal estatura;
	
	private Date fechanacimiento;

	private String genero;

	private String nombre;

	private BigDecimal peso;

	private String telefono;
	
	@Transient
	private double imc;
	private String estado;

	public Paciente(String apellido, String direccion, String documento, String email, BigDecimal estatura,
			Date fechanacimiento, String genero, String nombre, BigDecimal peso, String telefono) {
		super();
		this.apellido = apellido;
		this.direccion = direccion;
		this.documento = documento;
		this.email = email;
		this.estatura = estatura;
		this.fechanacimiento = fechanacimiento;
		this.genero = genero;
		this.nombre = nombre;
		this.peso = peso;
		this.telefono = telefono;
	}
	
	public double calcularImc() {
		this.setImc(((this.peso).doubleValue()/(this.estatura).doubleValue()));
		return imc;
	}
	public String calcularEstado() {
		if(imc<18.5) {
			this.setEstado( "Bajo peso");
		}else if(imc>18.5 && imc<24.9) {
			this.setEstado("Normal");
		}else if(imc>25 && imc<29.9) {
			this.setEstado("SObrpeso");
		}else if(imc>30 && imc<34.9) {
			this.setEstado("Obesidad 1");
		}else if(imc>35 && imc<39.9) {
			this.setEstado("Obseidad 2");
		}else if(imc>40) {
			this.setEstado("Obesidad 3");
		}
		return estado;
	}


}
