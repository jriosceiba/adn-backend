package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

/**
 * Puerto de entrada hacia las operaciones transaccionales del CRUD para los
 * clientes
 * 
 * @author jefferson.rios
 *
 */
public interface RepositorioCliente {

	/**
	 * Permite crear un cliente
	 * 
	 * @param cliente, cliente a crear
	 * @return el id del cliente creado
	 */
	Long crear(Cliente cliente);

	/**
	 * Permite actualizar un cliente
	 * 
	 * @param cliente, cliente a actualizar
	 * @return el cliente actualizado
	 */
	void actualizar(Cliente cliente);

	/**
	 * Permite validar si existe un cliente
	 * 
	 * @param email, email del cliente a buscar
	 * @return si existe o no
	 */
	boolean existe(String email);

	/**
	 * Permite validar si existe un cliente con un email excluyendo un id
	 * 
	 * @param email, email a buscar
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String email);
}
