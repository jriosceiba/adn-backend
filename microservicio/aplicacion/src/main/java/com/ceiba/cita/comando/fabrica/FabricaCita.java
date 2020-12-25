package com.ceiba.cita.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;

/**
 * Clase que permite la creacion de una cita a partir de su comando equivalente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class FabricaCita {

	/**
	 * Permite instanciar un objeto cita, a partir de los datos siminstrados por el
	 * comando
	 * 
	 * @param comandoCita, contenedor de los datos
	 * @return la cita creada
	 */
	public Cita crear(ComandoCita comandoCita) {
		return new Cita(comandoCita.getId(), comandoCita.getIdServicio(), comandoCita.getFechaHora(),
				comandoCita.getIdSede(), comandoCita.getIdCliente());
	}
}
