package com.project.multi.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jsondoc.core.annotation.ApiObject;

import java.io.Serializable;
import java.util.List;

/**
 * The Class ResultProductoJson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "ResultFacturaJson", description = "ResultFacturaJson domain")
public class ResultFacturaJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The code. */
	@JsonProperty("code")
	private int code;

	/** The status. */
	@JsonProperty("status")
	private String status;

	/** The message. */
	@JsonProperty("message")
	private String message;

	/** The complete name */
	@JsonProperty("name")
	private String name;

	/** The email name */
	@JsonProperty("email")
	private String email;

	/** The lst productos. */
	@JsonProperty("lstProductos")
	private List<ProductoJson> lstProductos;

	/** The total */
	@JsonProperty("total")
	private Double total;

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code the code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets message.
	 *
	 * @param message the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

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
	 * Gets lst productos.
	 *
	 * @return the lst productos
	 */
	public List<ProductoJson> getLstProductos() {
		return lstProductos;
	}

	/**
	 * Sets lst productos.
	 *
	 * @param lstProductos the lst productos
	 */
	public void setLstProductos(List<ProductoJson> lstProductos) {
		this.lstProductos = lstProductos;
	}

	/**
	 * Gets total.
	 *
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * Sets total.
	 *
	 * @param total the total
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
}
