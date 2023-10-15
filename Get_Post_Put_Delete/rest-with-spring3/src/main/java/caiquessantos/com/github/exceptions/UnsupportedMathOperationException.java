package caiquessantos.com.github.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Classe da exceção específica que iremos tratar
 * 
 * HttpStatus.BAD_REQUEST é um valor que representa o código de status HTTP 400, 
 * que indica uma solicitação inválida ou malformada.
 * */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

	public UnsupportedMathOperationException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
