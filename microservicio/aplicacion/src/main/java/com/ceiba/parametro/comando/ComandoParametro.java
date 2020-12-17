package com.ceiba.parametro.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa el objeto Parametro desde el punto de vista de la
 * aplicacion
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoParametro {

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
