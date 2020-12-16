package com.ceiba.cita.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.parametro.modelo.dto.DtoParametro;

import lombok.Getter;

/**
 * Dto para transferencia - correspondiente al objeto Cita
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
public class DtoCita {

	/**
	 * Corresponde al identificador primario del objeto
	 */
	private Long id;

	/**
	 * Corresponde al servicio a prestar
	 */
	private DtoParametro servicio;

	/**
	 * Corresponde a la fecha y hora de la cita
	 */
	private LocalDateTime fechaHora;

	/**
	 * Corresponde a la sede relacionada a prestar el servicio
	 */
	private DtoParametro sede;

	/**
	 * Corresponde al cliente relacionado
	 */
	private DtoCliente cliente;
}
