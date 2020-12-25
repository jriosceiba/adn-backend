package com.ceiba.parametro.servicio.testdatabuilder;

import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.modelo.entidad.Parametro;

/**
 * Constructor del ente parametro, utilizado en las definiciones de las pruebas
 * unitarias
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ParametroTestDataBuilder {

	private Long id;
	private String nombre;
	private String valor;
	private String tipoParametro;

	/**
	 * Constructor general, con datos de prueba
	 */
	public ParametroTestDataBuilder() {
	}

	/**
	 * Personaliza el id
	 * 
	 * @param id, id a setear
	 * @return
	 */
	public ParametroTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Personaliza el nombre
	 * 
	 * @param nombre, nombre a setear
	 * @return
	 */
	public ParametroTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Personaliza el valor
	 * 
	 * @param valor, valor a setear
	 * @return
	 */
	public ParametroTestDataBuilder conValor(String valor) {
		this.valor = valor;
		return this;
	}

	/**
	 * Personaliza el tipo de parametro
	 * 
	 * @param tipoParametro, tipo de parametro a setear
	 * @return
	 */
	public ParametroTestDataBuilder conTipoParametro(String tipoParametro) {
		this.tipoParametro = tipoParametro;
		return this;
	}

	/**
	 * Construye el objeto parametro, a partir de los datos suministrados por el
	 * data builder
	 * 
	 * @return, el parametro construido
	 */
	public Parametro build() {
		return new Parametro(id, nombre, valor, tipoParametro);
	}
	
	/**
	 * Construye el objeto parametro, a partir de los datos suministrados por el
	 * data builder
	 * 
	 * @return, el parametro construido
	 */
	public DtoParametro buildDto() {
		return new DtoParametro(id, nombre, valor, tipoParametro);
	}
}
