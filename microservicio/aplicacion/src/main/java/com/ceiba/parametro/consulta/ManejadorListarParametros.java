package com.ceiba.parametro.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.puerto.dao.DaoParametro;

/**
 * Manejador de la accion de consultar todos los parametros
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorListarParametros {

	/**
	 * Dao asociado
	 */
	private final DaoParametro daoParametro;

	/**
	 * Constructor de la clase
	 * 
	 * @param daoParametro, el valor de la propiedad
	 */
	public ManejadorListarParametros(DaoParametro daoParametro) {
		super();
		this.daoParametro = daoParametro;
	}

	/**
	 * lista todos los parametros registrados
	 * 
	 * @return el listado de parametros
	 */
	public List<DtoParametro> ejecutar() {
		return this.daoParametro.listarTodos();
	}

	/**
	 * lista todos los parametros registrados
	 * 
	 * @return el listado de parametros filtados por tipo
	 */
	public List<DtoParametro> ejecutar(String tipo) {
		return this.daoParametro.listarPorTipo(tipo);
	}
}
