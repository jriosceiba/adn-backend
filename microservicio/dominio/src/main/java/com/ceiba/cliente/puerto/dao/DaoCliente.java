package com.ceiba.cliente.puerto.dao;

import java.util.List;

import com.ceiba.cliente.modelo.dto.DtoCliente;


/**
 * Interface que representa el puerto de entrada hacia las operaciones basicas
 * con los clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public interface DaoCliente {

	/**
	 * Permite listar todos los clientes que se encuentran dentro de la aplicacion
	 * 
	 * @return, el listado general de clientes
	 */
	List<DtoCliente> listarTodos();
}
