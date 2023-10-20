package caiquessantos.com.github.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Classe da exceção específica que iremos tratar
 * not found é quando nao encontra o valor
 * */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException {

	public ResourceNotFoundExeption(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
