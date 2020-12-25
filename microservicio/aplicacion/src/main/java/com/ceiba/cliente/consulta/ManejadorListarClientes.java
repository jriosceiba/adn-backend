package com.ceiba.cliente.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;

/**
 * Manejador de la accion de consultar todos los clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorListarClientes {

	/**
	 * Dao asociado
	 */
	private final DaoCliente daoCliente;

	/**
	 * Constructor de la clase
	 * 
	 * @param daoCliente, el valor de la propiedad
	 */
	public ManejadorListarClientes(DaoCliente daoCliente) {
		super();
		this.daoCliente = daoCliente;
	}

	/**
	 * lista todos los clientes registrados
	 * 
	 * @return el listado de clientes
	 */
	public List<DtoCliente> ejecutar() {
		return this.daoCliente.listarTodos();
	}
}
