package caiquessantos.com.github.math;

public class SimpleMath {

	public Double sum(double numUm, double numDois) throws Exception {
		return numUm + numDois;
	}
	
	public Double sub(double numUm, double numDois) {	
		return numUm-numDois;
	}
	
	public Double mult(double numUm, double numDois) {
		return numUm*numDois;
	}
	
	public Double div(double numUm, double numDois) {
		return numUm/numDois;
	}
	
	public Double media(double numUm, double numDois) {
		return (numUm+numDois)/2;
	}
	
	public Double raiz(double numUm) {
		return Math.sqrt(numUm);
	}
}
