package com.ceiba.parametro.modelo.entidad;

import com.ceiba.dominio.enumeracion.TipoParametroEnum;

import lombok.Getter;

/**
 * Clase que representa el objeto Parametro y todas sus propiedades
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
public class Parametro {

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
	private TipoParametroEnum tipoParametro;
}
