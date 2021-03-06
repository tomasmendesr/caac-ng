package ar.gov.sedronar.aplicacion.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {

	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String username;
	private Date fechaDeNacimiento;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fecha) {
		this.fechaDeNacimiento = fecha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
