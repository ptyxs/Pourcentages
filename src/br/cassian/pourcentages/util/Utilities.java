package br.cassian.pourcentages.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utilities {
	private static final BigDecimal CENT = new BigDecimal(100);
	private static final NumberFormat df = new DecimalFormat("#,###.00");
	
	public static String trimNumberString(String numberString) {
		return numberString.replaceAll(",", ".").replaceAll(" ", "");
	}
	
	public static BigDecimal stringToBigDecimal(String numberString) {
		BigDecimal BD;
		
		Double number = Double.parseDouble(numberString);
		if (number.doubleValue() == 0.0 ) {
			BD = BigDecimal.ZERO;
		} else {
			BD = new BigDecimal(number);
		}
			
		return BD;
	}

	public static BigDecimal calculatePercentChange (BigDecimal from, BigDecimal to) {
		BigDecimal difference = to.subtract(from);
		return difference.divide(from, 8, RoundingMode.HALF_UP).multiply(CENT);
	}
	
	public static String formatPercent (BigDecimal percent) {
		return df.format(Double.parseDouble(percent.toString())) + " %";
	}
}
