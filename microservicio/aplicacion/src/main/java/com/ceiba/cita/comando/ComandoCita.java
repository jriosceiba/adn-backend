package com.ceiba.cita.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa el objeto Cita desde el punto de vista de la
 * aplicacion
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

	/**
	 * Corresponde al identificador primario de la clase
	 */
	private Long id;

	/**
	 * Corresponde al servicio a prestar
	 */
	private Long idServicio;

	/**
	 * Corresponde a la fecha y hora de la cita
	 */
	private LocalDateTime fechaHora;

	/**
	 * Corresponde a la sede relacionada a prestar el servicio
	 */
	private Long idSede;

	/**
	 * Corresponde al cliente relacionado
	 */
	private Long idCliente;
}
