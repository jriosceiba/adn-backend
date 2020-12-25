package com.ceiba.cita.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Dto para transferencia - correspondiente al objeto Cita
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
@AllArgsConstructor
public class DtoCita {

	/**
	 * Corresponde al identificador primario del objeto
	 */
	private Long id;

	/**
	 * Corresponde al id del servicio a prestar
	 */
	private Long idServicio;

	/**
	 * Corresponde al nombre del servicio
	 */
	private String nombreServicio;

	/**
	 * Corresponde a la fecha y hora de la cita
	 */
	private LocalDateTime fechaHora;

	/**
	 * Corresponde al id de la sede relacionada a prestar el servicio
	 */
	private Long idSede;

	/**
	 * Corresponde al nombre de la sede a prestar el servicio
	 */
	private String nombreSede;

	/**
	 * Corresponde al id del cliente relacionado
	 */
	private Long idCliente;

	/**
	 * Corresponde al nombre del cliente relacionado
	 */
	private String nombreCliente;

	/**
	 * Corresponde al valor del servicio
	 */
	private Double valorServicio;

	/**
	 * Corresponde al valor del descuento aplicado
	 */
	private Double valorDescuento;

	/**
	 * Corresponde al nombre del descuento si aplica
	 */
	private String nombreDescuento;
}
