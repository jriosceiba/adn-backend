package com.ceiba.cliente.modelo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Dto para transferencia - correspondiente al objeto Cliente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
@AllArgsConstructor
public class DtoCliente {

	/**
	 * Representa el identificador primario del cliente
	 */
	private Long id;

	/**
	 * Representa el nombre del cliente
	 */
	private String nombre;

	/**
	 * Representa el correo del cliente
	 */
	private String email;

	/**
	 * Representa el telefono del cliente
	 */
	private String telefono;

	/**
	 * Representa el id de la ciudad del cliente
	 */
	private Long idCiudad;

	/**
	 * Representa el nombre de la ciudad del cliente
	 */
	private String nombreCiudad;

	/**
	 * Representa la fecha de creacion del cliente
	 */
	private LocalDate fechaCreacion;
}
