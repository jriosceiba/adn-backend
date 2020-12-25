package com.ceiba.infraestructura.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Clase con metodos de utilidad para las fechas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class DateUtil {

	/**
	 * Convierte un dato date en uno localdate
	 * 
	 * @param fecha, entrada
	 * @return salida como LocalDate
	 */
	public static LocalDate toLocalDate(Date fecha) {
		return LocalDate.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
	}

	/**
	 * Constructor de la clase
	 */
	private DateUtil() {
		super();
	}
}
