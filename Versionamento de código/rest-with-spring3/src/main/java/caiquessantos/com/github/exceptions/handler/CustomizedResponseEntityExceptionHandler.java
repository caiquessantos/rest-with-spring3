package caiquessantos.com.github.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import caiquessantos.com.github.exceptions.ExceptionResponse;
import caiquessantos.com.github.exceptions.ResourceNotFoundExeption;


/**
 * Classe que trata as exceções de forma customizada
 * 
 * "Advice" (conselheiros), são usadas para manipular exceções lançadas 
 * por métodos em controladores (Controllers) de maneira global e consistente 
 * em toda a aplicação. Isso facilita o tratamento de exceções de uma maneira 
 * uniforme e evita a repetição de código de tratamento de exceções em vários controladores.
 * */

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	//trata as exceções mais genéricas
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleALLexceptions(Exception ex, WebRequest request){
		ExceptionResponse exrp = new ExceptionResponse(new Date()
				, ex.getMessage()
				, request.getDescription(false));
		
		return new ResponseEntity<>(exrp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//trata a exceção que criamos(nesse caso para caso não encvontre por id
	@ExceptionHandler(ResourceNotFoundExeption.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundexceptions(Exception ex, WebRequest request){
		ExceptionResponse exrp = new ExceptionResponse(new Date()
				, ex.getMessage()
				, request.getDescription(false));
		
		return new ResponseEntity<>(exrp, HttpStatus.NOT_FOUND);
	}
}
