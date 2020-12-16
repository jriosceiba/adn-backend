package com.ceiba.parametro.puerto.repositorio;

import com.ceiba.parametro.modelo.entidad.Parametro;

/**
 * Puerto de entrada hacia las operaciones transaccionales del CRUD para los
 * parametros
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public interface RepositorioParametro {

	/**
	 * Permite crear un usuario
	 * 
	 * @param parametro, parametro a crear
	 * @return el parametro creado
	 */
	Parametro crear(Parametro parametro);

	/**
	 * Permite actualizar un parametro
	 * 
	 * @param parametro, parametro a actualizar
	 */
	Parametro actualizar(Parametro parametro);

	/**
	 * Permite validar si existe un parametro con el nombre registrado
	 * 
	 * @param nombre, nombre a buscar
	 * @return si existe o no
	 */
	boolean existe(String nombre);

	/**
	 * Permite validar si existe un parametro con un nombre excluyendo su id
	 * 
	 * @param nombre, nombre a validar
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String nombre);
}
