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


}
