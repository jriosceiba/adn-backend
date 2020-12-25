package com.ceiba.cita.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

/**
 * Implementacion del repositorio de cita, permitiendo acceso a la capa de
 * persistencia
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Repository
public class RepositorioCitaMysql implements RepositorioCita {

	/**
	 * Inyeccion de la plantilla que administra las querys
	 */
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	/**
	 * Configuracion de la accion a realizar desde la query de crear
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CITA, value = ConstantesInfraestructura.CRUD_CREAR)
	private static String sqlCrear;

	/**
	 * Configuracion de la accion a realizar desde la query de actualizar
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CITA, value = ConstantesInfraestructura.CRUD_ACTUALIZAR)
	private static String sqlActualizar;

	/**
	 * Configuracion de la accion a realizar desde la query de consultar existencia
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CITA, value = ConstantesInfraestructura.CONSULTA_EXISTE)
	private static String sqlExiste;

	/**
	 * Configuracion de la accion a realizar desde la query de consultar existencia
	 * exluyendo id
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CITA, value = ConstantesInfraestructura.CONSULTA_EXISTE_EXCLUYENDO_ID)
	private static String sqlExisteExcluyendoId;

	/**
	 * Constructor de la clase
	 * 
	 * @param customNamedParameterJdbcTemplate, el valor de la propiedad
	 */
	public RepositorioCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		super();
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long crear(Cita cita) {
		return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualizar(Cita cita) {
		this.customNamedParameterJdbcTemplate.actualizar(cita, sqlActualizar);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existe(LocalDateTime fechaHora) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(ConstantesInfraestructura.FECHA_HORA_CITA_PARAM, fechaHora);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existeExcluyendoId(Long id, LocalDateTime fechaHora) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(ConstantesInfraestructura.ID, id);
		paramSource.addValue(ConstantesInfraestructura.FECHA_HORA_CITA_PARAM, fechaHora);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
	}
}
