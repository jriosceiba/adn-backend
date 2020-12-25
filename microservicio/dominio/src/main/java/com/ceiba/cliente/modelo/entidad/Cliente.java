package com.ceiba.cliente.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarRegex;

import java.time.LocalDate;
import com.ceiba.dominio.constante.ConstantesDominio;

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
	private Long ciudad;

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
	public Cliente(Long id, String nombre, String email, String telefono, Long ciudad, LocalDate fechaCreacion) {
		validarObligatorio(nombre, ConstantesDominio.OBLIGATORIO_NOMBRE_CLIENTE);
		validarObligatorio(email, ConstantesDominio.OBLIGATORIO_EMAIL_CLIENTE);
		validarObligatorio(telefono, ConstantesDominio.OBLIGATORIO_TELEFONO_CLIENTE);
		validarObligatorio(ciudad, ConstantesDominio.OBLIGATORIO_CIUDAD_CLIENTE);
		validarRegex(email, ConstantesDominio.REGEX_VALIDADOR_EMAIL, ConstantesDominio.FORMATO_EMAIL_INCORRECTO);
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.fechaCreacion = fechaCreacion;
	}
}
