package com.project.multi.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jsondoc.core.annotation.ApiObject;

import java.io.Serializable;
import java.util.List;

/**
 * The Class ProductoJson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "ProductoJson", description = "ProductoJson domain")
public class FacturaJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	@JsonProperty("nombre")
	private String name;

	/** The imagen. */
	@JsonProperty("apellidos")
	private String apellidos;

	/** The nombre. */
	@JsonProperty("email")
	private String email;

	/** The precio. */
	@JsonProperty("listadoTelefonos")
	private List<String> teléfonos;

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets apellidos.
	 *
	 * @param apellidos the apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get teléfonos list.
	 *
	 * @return the list
	 */
	public List<String> getTeléfonos() {
		return teléfonos;
	}

	/**
	 * Set teléfonos.
	 *
	 * @param teléfonos the teléfonos
	 */
	public void setTeléfonos(List<String> teléfonos) {
		this.teléfonos = teléfonos;
	}
}
