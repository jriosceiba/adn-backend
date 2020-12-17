package com.ceiba.parametro.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.puerto.dao.DaoParametro;

/**
 * Implementacion del acceso a los datos de la tabla parametro
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class DaoParametroMysql implements DaoParametro {

	/**
	 * Inyeccion de la plantilla que administra las querys
	 */
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	/**
	 * Configuracion de la accion a realizar desde la query de listar
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_PARAMETRO, value = ConstantesInfraestructura.CONSULTA_LISTAR_TODOS)
	private static String sqlListar;

	/**
	 * Constructor de la clase
	 * 
	 * @param customNamedParameterJdbcTemplate, el valor de la propiedad
	 */
	public DaoParametroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		super();
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DtoParametro> listarTodos() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoParametro());
	}
}
