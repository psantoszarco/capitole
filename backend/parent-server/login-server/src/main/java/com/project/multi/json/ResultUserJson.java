package com.project.multi.json;

import java.io.Serializable;
import java.util.List;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ResultUserJson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "ResultUserJson", description = "ResultUserJson domain")
public class ResultUserJson implements Serializable {

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

	/** The lst productos. */
	@JsonProperty("lstUsuarios")
	private List<UsuarioJson> lstUsuarios;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the lst usuarios.
	 *
	 * @return the lst usuarios
	 */
	public List<UsuarioJson> getLstUsuarios() {
		return lstUsuarios;
	}

	/**
	 * Sets the lst usuarios.
	 *
	 * @param lstUsuarios the new lst usuarios
	 */
	public void setLstUsuarios(List<UsuarioJson> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}

	
}
