package caiquessantos.com.github.converter;

public class conversor {
	public static double convert(String num) {
		
		if (num == null) {
			return 0D;
		}
		
		String nvnum = num.replaceAll(",", ".");
		
		if (isNumeric(nvnum)) {
			return Double.parseDouble(nvnum);	
		}
		
		return 0D;
	}
	
	public static boolean isNumeric(String num) {
		if (num == null) {
			return false;
		}
		
		String nvnum = num.replaceAll(",", ".");
		
		return nvnum.matches("[+-]?[0-9]*\\.?[0-9]+");
	}
}
