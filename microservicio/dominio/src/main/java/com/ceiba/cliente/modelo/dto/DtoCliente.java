package com.ceiba.cliente.modelo.dto;

import java.time.LocalDate;

import com.ceiba.parametro.modelo.entidad.Parametro;

import lombok.Getter;

/**
 * Dto para transferencia - correspondiente al objeto Cliente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
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
	 * Representa la ciudad del cliente
	 */
	private Parametro ciudad;

	/**
	 * Representa la fecha de creacion del cliente
	 */
	private LocalDate fechaCreacion;
}
