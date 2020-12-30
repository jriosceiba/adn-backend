package com.ceiba.cita.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cita.comando.ComandoCita;

/**
 * Constructor del ente ComandoCita, utilizado en las definiciones de las
 * pruebas de integracion
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ComandoCitaTestDataBuilder {

	private Long id;
	private Long idServicio;
	private LocalDateTime fechaHora;
	private Long idSede;
	private Long idCliente;

	/**
	 * Constructor general
	 */
	public ComandoCitaTestDataBuilder() {
	}

	/**
	 * Personaliza el id
	 * 
	 * @param id, id a setear
	 * @return
	 */
	public ComandoCitaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Personaliza el servicio
	 * 
	 * @param idServicio, servicio a setear
	 * @return
	 */
	public ComandoCitaTestDataBuilder conServicio(Long idServicio) {
		this.idServicio = idServicio;
		return this;
	}

	/**
	 * Personaliza la fecha y hora
	 * 
	 * @param fechaHora, fecha y hora a setear
	 * @return
	 */
	public ComandoCitaTestDataBuilder conFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
		return this;
	}

	/**
	 * Personaliza la sede
	 * 
	 * @param idSede, sede a setear
	 * @return
	 */
	public ComandoCitaTestDataBuilder conSede(Long idSede) {
		this.idSede = idSede;
		return this;
	}

	/**
	 * Personaliza el cliente
	 * 
	 * @param idCliente, cliente a setear
	 * @return
	 */
	public ComandoCitaTestDataBuilder conCliente(Long idCliente) {
		this.idCliente = idCliente;
		return this;
	}

	/**
	 * Construye el objeto ComandoParametro, a partir de los datos suministrados por
	 * el data builder
	 * 
	 * @return, el ComandoParametro construido
	 */
	public ComandoCita build() {
		return new ComandoCita(id, idServicio, fechaHora, idSede, idCliente);
	}
}
