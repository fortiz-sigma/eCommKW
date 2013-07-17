package br.com.ecommkw.rest.helper;

import java.text.DecimalFormat;
import java.util.Locale;

public abstract class FormatHelper {
	
	public static String currencyFormatReal(Double currency) {
		DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"));
		decimalFormat.applyLocalizedPattern("###.###.###,00");
		return decimalFormat.format(currency);
	}
	
	public static Double RealToCurrency(String real) {
		real = real.replace(",", ".").replace(".", "");
		return (Double) new Double(real) / 100;
	}	
	
}
