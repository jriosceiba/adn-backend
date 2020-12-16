package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.parametro.modelo.entidad.Parametro;

import java.time.LocalDateTime;

/**
 * Constructor del ente cita, utilizado en las definiciones de las pruebas
 * unitarias
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class CitaTestDataBuilder {

	private Long id;
	private Parametro servicio;
	private LocalDateTime fechaHora;
	private Parametro sede;
	private Cliente cliente;

	/**
	 * Constructor general, con datos de prueba
	 */
	public CitaTestDataBuilder() {
		fechaHora = LocalDateTime.now();
	}

	/**
	 * Personaliza el id
	 * 
	 * @param id, id a setear
	 * @return
	 */
	public CitaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Personaliza el servicio
	 * 
	 * @param servicio, servicio a setear
	 * @return
	 */
	public CitaTestDataBuilder conServicio(Parametro servicio) {
		this.servicio = servicio;
		return this;
	}

	/**
	 * Personaliza la fecha y hora
	 * 
	 * @param fechaHora, fecha y hora a setear
	 * @return
	 */
	public CitaTestDataBuilder conFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
		return this;
	}

	/**
	 * Personaliza la sede
	 * 
	 * @param telefono, telefono a setear
	 * @return
	 */
	public CitaTestDataBuilder conSede(Parametro sede) {
		this.sede = sede;
		return this;
	}

	/**
	 * Personaliza el cliente
	 * 
	 * @param cliente, cliente a setear
	 * @return
	 */
	public CitaTestDataBuilder conCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	/**
	 * Construye el objeto cita, a partir de los datos suministrados por el data
	 * builder
	 * 
	 * @return, la cita construida
	 */
	public Cita build() {
		return new Cita(id, servicio, fechaHora, sede, cliente);
	}
}
