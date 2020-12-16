package com.ceiba.cita.puerto.dao;

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
}
