package caiquessantos.com.github.exceptions;

import java.io.Serializable;
import java.util.Date;
/**
 * Classe construtora de uma excesçao
 * 
 * */

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;
	private String message;
	private String details;
		
	public ExceptionResponse(Date date, String message, String details) {
		this.date = date;
		this.message = message;
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
