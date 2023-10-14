package caiquessantos.com.github.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import caiquessantos.com.github.converter.conversor;
import caiquessantos.com.github.exceptions.UnsupportedMathOperationException;
import caiquessantos.com.github.math.SimpleMath;

@RestController
public class mathController {
	
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath sm = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numUm}/{numDois}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numUm")String numUm,
			@PathVariable(value = "numDois") String numDois) throws Exception {
		
		if (!conversor.isNumeric(numUm) || !conversor.isNumeric(numDois)) {
			throw new UnsupportedMathOperationException("Please set a valid number!");
		}
		
		return sm.sum(conversor.convert(numUm), conversor.convert(numDois));
	}
	
	@RequestMapping(value = "/sub/{numUm}/{numDois}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numUm")String numUm,
			@PathVariable(value = "numDois")String numDois) {
		
		if (!conversor.isNumeric(numUm) || !conversor.isNumeric(numDois)) {
			throw new UnsupportedMathOperationException("Please set a valid number!");
		}
		
		return sm.sub(conversor.convert(numUm), conversor.convert(numDois));
	}
	
	@RequestMapping(value = "/mult/{numUm}/{numDois}")
	public Double mult(@PathVariable(value = "numUm")String numUm,
			@PathVariable(value = "numDois")String numDois) {
		
		if (!conversor.isNumeric(numUm) || !conversor.isNumeric(numDois)) {
			throw new UnsupportedMathOperationException("Please set a valid number!");
		}
		
		return sm.mult(conversor.convert(numUm), conversor.convert(numDois));
	}
	
	@RequestMapping(value = "/div/{numUm}/{numDois}", method = RequestMethod.GET)
	public double div(@PathVariable(value = "numUm")String numUm,
			@PathVariable(value = "numDois")String numDois) {
		
		if (!conversor.isNumeric(numUm) || !conversor.isNumeric(numDois)) {
			throw new UnsupportedMathOperationException("Please set a valid number!");
		}
		return sm.div(conversor.convert(numUm),conversor.convert(numDois));
	}
	
	@RequestMapping(value = "/media/{numUm}/{numDois}", method = RequestMethod.GET)
	public double media(@PathVariable(value = "numUm")String numUm,
			@PathVariable(value = "numDois")String numDois) {
		if (!conversor.isNumeric(numUm) || !conversor.isNumeric(numDois)) {
			throw new UnsupportedMathOperationException("Please set a valid number!");
		}
		
		return sm.media(conversor.convert(numUm), conversor.convert(numDois));
	}
	
	@RequestMapping(value = "/raiz/{numUm}", method = RequestMethod.GET)
	private double raiz(@PathVariable(value = "numUm")String numUm) {
		if (!conversor.isNumeric(numUm)) {
			throw new UnsupportedMathOperationException("Please set a valid number!");
		}
		return sm.raiz(conversor.convert(numUm));
	}
	
}
