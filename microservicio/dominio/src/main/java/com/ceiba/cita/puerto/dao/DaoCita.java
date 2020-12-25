package com.ceiba.cita.puerto.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.cita.modelo.dto.DtoCita;

/**
 * Interface que representa el puerto de entrada hacia las operaciones basicas
 * con las citas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public interface DaoCita {

	/**
	 * Permite listar todas las citas que se encuentran en el sistema
	 * 
	 * @return, el listado de citas
	 */
	List<DtoCita> listarTodas();

	/**
	 * Valida si ya existen citas programas para el dia de la cita, para el mismo
	 * cliente
	 * 
	 * @param idCliente, id del cliente a validar
	 * @param fechaCita, fecha programada
	 * @return
	 */
	Integer cantidadCitasDiaMayorCero(Long idCliente, LocalDateTime fechaCita);
}
