package com.ceiba.cita.modelo.entidad;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.parametro.modelo.entidad.Parametro;

import lombok.Getter;

/**
 * Clase que representa el objeto cita y todas sus propiedades
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
public class Cita {

	/**
	 * Corresponde al identificador primario del objeto
	 */
	private Long id;

	/**
	 * Corresponde al servicio a prestar
	 */
	private Parametro servicio;

	/**
	 * Corresponde a la fecha y hora de la cita
	 */
	private LocalDateTime fechaHora;

	/**
	 * Corresponde a la sede relacionada a prestar el servicio
	 */
	private Parametro sede;

	/**
	 * Corresponde al cliente relacionado
	 */
	private Cliente cliente;

	/**
	 * Constructor de la clase
	 * 
	 * @param id,        llave primaria
	 * @param servicio,  servicio relacionado
	 * @param fechaHora, fecha y hora del servicio
	 * @param sede,      sede relacionada
	 * @param cliente,   cliente relacionado
	 */
	public Cita(Long id, Parametro servicio, LocalDateTime fechaHora, Parametro sede, Cliente cliente) {
		super();
		this.id = id;
		this.servicio = servicio;
		this.fechaHora = fechaHora;
		this.sede = sede;
		this.cliente = cliente;
	}
}
