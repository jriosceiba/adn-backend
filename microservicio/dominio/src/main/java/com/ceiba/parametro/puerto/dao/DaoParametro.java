package com.ceiba.parametro.puerto.dao;

import java.util.List;

import com.ceiba.parametro.modelo.dto.DtoParametro;

/**
 * Interface que representa el puerto de entrada hacia las operaciones basicas
 * con los parametros
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public interface DaoParametro {

	/**
	 * Permite obtener el listado de los parametros registrados en el sistema
	 * 
	 * @return, el listado de parametros registrados
	 */
	List<DtoParametro> listarTodos();

	/**
	 * Permite listar los parametros por su tipo
	 * 
	 * @param tipo, tipo de parametro a buscar
	 * @return el listado de parametros por el tipo filtrado
	 */
	List<DtoParametro> listarPorTipo(String tipo);
}
