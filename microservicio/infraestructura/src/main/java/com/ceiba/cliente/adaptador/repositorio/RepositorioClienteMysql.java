package com.ceiba.cliente.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

/**
 * Implementacion del repositorio de cliente, permitiendo acceso a la capa de
 * persistencia
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

	/**
	 * Inyeccion de la plantilla que administra las querys
	 */
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	/**
	 * Configuracion de la accion a realizar desde la query de crear
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CLIENTE, value = ConstantesInfraestructura.CRUD_CREAR)
	private static String sqlCrear;

	/**
	 * Configuracion de la accion a realizar desde la query de actualizar
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CLIENTE, value = ConstantesInfraestructura.CRUD_ACTUALIZAR)
	private static String sqlActualizar;

	/**
	 * Configuracion de la accion a realizar desde la query de consultar existencia
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CLIENTE, value = ConstantesInfraestructura.CONSULTA_EXISTE)
	private static String sqlExiste;

	/**
	 * Configuracion de la accion a realizar desde la query de consultar existencia
	 * exluyendo id
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CLIENTE, value = ConstantesInfraestructura.CONSULTA_EXISTE_EXCLUYENDO_ID)
	private static String sqlExisteExcluyendoId;

	/**
	 * Constructor de la clase
	 * 
	 * @param customNamedParameterJdbcTemplate, el valor de la propiedad
	 */
	public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		super();
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long crear(Cliente parametro) {
		return this.customNamedParameterJdbcTemplate.crear(parametro, sqlCrear);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualizar(Cliente parametro) {
		this.customNamedParameterJdbcTemplate.actualizar(parametro, sqlActualizar);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existe(String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(ConstantesInfraestructura.EMAIL, nombre);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existeExcluyendoId(Long id, String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(ConstantesInfraestructura.ID, id);
		paramSource.addValue(ConstantesInfraestructura.NOMBRE, nombre);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
	}
}
