package com.ceiba.cliente.modelo.entidad;

import java.time.LocalDate;

import com.ceiba.parametro.modelo.entidad.Parametro;

import lombok.Getter;

/**
 * Clase que representa el objeto cliente y todas sus propiedades
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
public class Cliente {

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

	/**
	 * Constructor de la clase
	 * 
	 * @param id,            llave primaria
	 * @param nombre,        nombre del cliente
	 * @param email,         correo del cliente
	 * @param telefono,      telefono del cliente
	 * @param ciudad,        ciudad del cliente
	 * @param fechaCreacion, fecha de creacion del cliente
	 */
	public Cliente(Long id, String nombre, String email, String telefono, Parametro ciudad, LocalDate fechaCreacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.fechaCreacion = fechaCreacion;
	}
}
