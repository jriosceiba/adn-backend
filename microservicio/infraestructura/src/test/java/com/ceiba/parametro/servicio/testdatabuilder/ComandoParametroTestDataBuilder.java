package com.ceiba.parametro.servicio.testdatabuilder;

import com.ceiba.dominio.enumeracion.TipoParametroEnum;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.parametro.comando.ComandoParametro;

import java.util.UUID;

/**
 * Constructor del ente ComandoParametro, utilizado en las definiciones de las
 * pruebas de integracion
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ComandoParametroTestDataBuilder {

	private Long id;
	private String nombre;
	private String valor;
	private String tipoParametro;

	/**
	 * Constructor general, con datos de prueba
	 */
	public ComandoParametroTestDataBuilder() {
		nombre = UUID.randomUUID().toString();
		valor = ConstantesInfraestructura.VALOR;
		tipoParametro = TipoParametroEnum.CIUDAD.toString();
	}

	/**
	 * Personaliza el nombre
	 * 
	 * @param nombre, nombre a setear
	 * @return
	 */
	public ComandoParametroTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Personaliza el valor
	 * 
	 * @param valor, valor a setear
	 * @return
	 */
	public ComandoParametroTestDataBuilder conValor(String valor) {
		this.valor = valor;
		return this;
	}

	/**
	 * Personaliza el tipoParametro
	 * 
	 * @param tipoParametro, tipoParametro a setear
	 * @return
	 */
	public ComandoParametroTestDataBuilder conTipoParametro(String tipoParametro) {
		this.tipoParametro = tipoParametro;
		return this;
	}

	/**
	 * Construye el objeto ComandoParametro, a partir de los datos suministrados por el data
	 * builder
	 * 
	 * @return, el ComandoParametro construido
	 */
	public ComandoParametro build() {
		return new ComandoParametro(id, nombre, valor, tipoParametro);
	}
}
