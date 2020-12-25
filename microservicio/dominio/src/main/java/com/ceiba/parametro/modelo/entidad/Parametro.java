package com.ceiba.parametro.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import com.ceiba.dominio.constante.ConstantesDominio;

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
	private String tipoParametro;

	/**
	 * Constructor de la clase
	 * 
	 * @param id,            el valor de la propiedad
	 * @param nombre,        el valor de la propiedad
	 * @param valor,         el valor de la propiedad
	 * @param tipoParametro, el valor de la propiedad
	 */
	public Parametro(Long id, String nombre, String valor, String tipoParametro) {
		validarObligatorio(nombre, ConstantesDominio.OBLIGATORIO_NOMBRE_PARAMETRO);
		validarObligatorio(tipoParametro, ConstantesDominio.OBLIGATORIO_TIPO_PARAMETRO);
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.tipoParametro = tipoParametro;
	}
}
