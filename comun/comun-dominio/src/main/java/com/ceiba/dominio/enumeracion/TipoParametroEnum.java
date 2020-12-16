package com.ceiba.dominio.enumeracion;

/**
 * 
 * Enumeracion que representa los diferentes tipos de parametros a registrar en
 * la aplicacion
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public enum TipoParametroEnum {

	SEDE("Sede"), CIUDAD("Ciudad"), DESCUENTO_CUMPLEANIOS("Descuento cumpleanios"),
	DESCUENTO_CANTIDAD("Descuento cantidad servicios"), DIA_FESTIVO("Dia festivo"), SERVICIO("Servicio");

	/**
	 * Valor asignado al enum
	 */
	String valor;

	/**
	 * Constructor del enum
	 * 
	 * @param valor
	 */
	private TipoParametroEnum(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
}
