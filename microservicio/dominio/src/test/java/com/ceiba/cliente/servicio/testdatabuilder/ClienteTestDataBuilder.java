package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.dominio.constantes.ConstantesDominio;
import com.ceiba.parametro.modelo.entidad.Parametro;

import java.time.LocalDate;

/**
 * Constructor del ente cliente, utilizado en las definiciones de las pruebas
 * unitarias
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private Parametro ciudad;
	private LocalDate fechaCreacion;

	/**
	 * Constructor general, con datos de prueba
	 */
	public ClienteTestDataBuilder() {
		nombre = ConstantesDominio.PRUEBA;
		email = ConstantesDominio.PRUEBA_CORREO;
		telefono = ConstantesDominio.PRUEBA_TELEFONO;
		fechaCreacion = LocalDate.now();
	}

	/**
	 * Personaliza el id
	 * 
	 * @param id, id a setear
	 * @return
	 */
	public ClienteTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Personaliza el nombre
	 * 
	 * @param nombre, nombre a setear
	 * @return
	 */
	public ClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Personaliza el email
	 * 
	 * @param email, email a setear
	 * @return
	 */
	public ClienteTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Personaliza el telefono
	 * 
	 * @param telefono, telefono a setear
	 * @return
	 */
	public ClienteTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	/**
	 * Personaliza la ciudad
	 * 
	 * @param ciudad, ciudad a setear
	 * @return
	 */
	public ClienteTestDataBuilder conCiudad(Parametro ciudad) {
		this.ciudad = ciudad;
		return this;
	}

	/**
	 * Personaliza la fecha de creacion
	 * 
	 * @param fechaCreacion, fecha a setear
	 * @return
	 */
	public ClienteTestDataBuilder conFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	/**
	 * Construye el objeto cliente, a partir de los datos suministrados por el data
	 * builder
	 * 
	 * @return, el cliente construido
	 */
	public Cliente build() {
		return new Cliente(id, nombre, email, telefono, ciudad, fechaCreacion);
	}
}
