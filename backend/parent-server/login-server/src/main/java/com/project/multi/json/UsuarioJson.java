package com.project.multi.json;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ProductoJson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "UsuarioJson", description = "UsuarioJson domain")
public class UsuarioJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@JsonProperty("id")
	private Long id;

	/** The nombre. */
	@JsonProperty("nombre")
	private String nombre;

	/** The precio. */
	@JsonProperty("activo")
	private Boolean activo;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the activo.
	 *
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * Sets the activo.
	 *
	 * @param activo the new activo
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
