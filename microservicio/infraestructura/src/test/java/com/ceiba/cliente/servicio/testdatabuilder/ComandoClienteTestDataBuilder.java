package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

/**
 * Constructor del ente ComandoParametro, utilizado en las definiciones de las
 * pruebas de integracion
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ComandoClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private Long ciudad;

	/**
	 * Constructor general
	 */
	public ComandoClienteTestDataBuilder() {
	}

	/**
	 * Personaliza el id
	 * 
	 * @param id, id a setear
	 * @return
	 */
	public ComandoClienteTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Personaliza el nombre
	 * 
	 * @param nombre, nombre a setear
	 * @return
	 */
	public ComandoClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Personaliza el email
	 * 
	 * @param email, email a setear
	 * @return
	 */
	public ComandoClienteTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Personaliza el telefono
	 * 
	 * @param telefono, telefono a setear
	 * @return
	 */
	public ComandoClienteTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	/**
	 * Personaliza la ciudad
	 * 
	 * @param ciudad, ciudad a setear
	 * @return
	 */
	public ComandoClienteTestDataBuilder conCiudad(Long ciudad) {
		this.ciudad = ciudad;
		return this;
	}

	/**
	 * Construye el objeto ComandoParametro, a partir de los datos suministrados por
	 * el data builder
	 * 
	 * @return, el ComandoParametro construido
	 */
	public ComandoCliente build() {
		return new ComandoCliente(id, nombre, email, telefono, ciudad);
	}
}
