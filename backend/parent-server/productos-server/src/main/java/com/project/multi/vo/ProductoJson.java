package com.project.multi.vo;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ProductoJson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "ProductoJson", description = "ProductoJson domain")
public class ProductoJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@JsonProperty("id")
	private Long id;

	/** The description. */
	@JsonProperty("description")
	private String description;

	/** The imagen. */
	@JsonProperty("imagen")
	private String imagen;

	/** The nombre. */
	@JsonProperty("nombre")
	private String nombre;

	/** The precio. */
	@JsonProperty("precio")
	private String precio;

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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the imagen.
	 *
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Sets the imagen.
	 *
	 * @param imagen the new imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
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
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}	
	
}
