package com.ceiba.cliente.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

/**
 * Implementacion del acceso a los datos de la tabla cliente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class DaoClienteMysql implements DaoCliente {

	/**
	 * Inyeccion de la plantilla que administra las querys
	 */
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	/**
	 * Configuracion de la accion a realizar desde la query de listar
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CLIENTE, value = ConstantesInfraestructura.CONSULTA_LISTAR_TODOS)
	private static String sqlListar;

	/**
	 * Configuracion de la accion a realizar desde la query de aniversario
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CLIENTE, value = ConstantesInfraestructura.CONSULTA_CUMPLIENDO_ANIO)
	private static String sqlCumpliendoAnio;

	/**
	 * Constructor de la clase
	 * 
	 * @param customNamedParameterJdbcTemplate, el valor de la propiedad
	 */
	public DaoClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		super();
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DtoCliente> listarTodos() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoCliente());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean cumpliendoAnio(Long idCliente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(ConstantesInfraestructura.ID_CLIENTE_CUMPLIENDO_ANIO, idCliente);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCumpliendoAnio,
				paramSource, Boolean.class);
	}
}
