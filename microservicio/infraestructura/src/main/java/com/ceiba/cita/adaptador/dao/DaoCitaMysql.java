package com.ceiba.cita.adaptador.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

/**
 * Implementacion del acceso a los datos de la tabla cita
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class DaoCitaMysql implements DaoCita {

	/**
	 * Inyeccion de la plantilla que administra las querys
	 */
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	/**
	 * Configuracion de la accion a realizar desde la query de listar
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CITA, value = ConstantesInfraestructura.CONSULTA_LISTAR_TODOS)
	private static String sqlListar;

	/**
	 * Configuracion de la accion a realizar desde la query consultar cantidad de
	 * citas
	 */
	@SqlStatement(namespace = ConstantesInfraestructura.NAMESPACE_CITA, value = ConstantesInfraestructura.CONSULTA_CITAS_DIA)
	private static String sqlCantidadCitas;

	/**
	 * Constructor de la clase
	 * 
	 * @param customNamedParameterJdbcTemplate, el valor de la propiedad
	 */
	public DaoCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		super();
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DtoCita> listarTodas() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCita());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer cantidadCitasDiaMayorCero(Long idCliente, LocalDateTime fechaCita) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(ConstantesInfraestructura.ID_CLIENTE_CUMPLIENDO_ANIO, idCliente);
		paramSource.addValue(ConstantesInfraestructura.FECHA_HORA_CITA_PARAM, fechaCita);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadCitas,
				paramSource, Integer.class);
	}
}
