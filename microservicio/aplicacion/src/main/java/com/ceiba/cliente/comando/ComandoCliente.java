package com.ceiba.cliente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa el objeto Cliente desde el punto de vista de la
 * aplicacion
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {

	/**
	 * Corresponde al identificador primario de la clase
	 */
	private Long id;

	/**
	 * Corresponde al nombre del cliente
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
	private Long idCiudad;
}
