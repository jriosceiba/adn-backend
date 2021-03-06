package com.ceiba.parametro.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Dto para transferencia - correspondiente al objeto Parametro
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
@AllArgsConstructor
public class DtoParametro {

	/**
	 * Corresponde al identificador primario de la clase
	 */
	private Long id;

	/**
	 * Corresponde al nombre del parametro
	 */
	private String nombre;

	/**
	 * Corresponde al valor o contenido del parametro
	 */
	private String valor;

	/**
	 * Corresponde al tipo de parametro asociado
	 */
	private String tipoParametro;
}
