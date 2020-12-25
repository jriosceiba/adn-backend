package com.ceiba.cita.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.MapperResult;

/**
 * Clase que permite la extraccion de datos a traves de un resultado obtenido
 * desde la bd y los setea en el dto de parametro
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DtoCita mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long id = rs.getLong(ConstantesInfraestructura.ID);
		Long idServicio = rs.getLong(ConstantesInfraestructura.ID_SERVICIO_CITA);
		String nombreServicio = rs.getString(ConstantesInfraestructura.NOMBRE_SERVICIO_CITA);
		LocalDateTime fechaHora = extraerLocalDateTime(rs, (ConstantesInfraestructura.FECHA_HORA_CITA));
		Long idSede = rs.getLong(ConstantesInfraestructura.ID_SEDE_CITA);
		String nombreSede = rs.getString(ConstantesInfraestructura.NOMBRE_SEDE_CITA);
		Long idCliente = rs.getLong(ConstantesInfraestructura.ID_CLIENTE_CITA);
		String nombreCliente = rs.getString(ConstantesInfraestructura.NOMBRE_CLIENTE_CITA);
		Double valorServicio = rs.getDouble(ConstantesInfraestructura.VALOR_SERVICIO_CITA);
		Double valorDescuento = rs.getDouble(ConstantesInfraestructura.VALOR_DESCUENTO_CITA);
		String nombreDescuento = rs.getString(ConstantesInfraestructura.NOMBRE_DESCUENTO_CITA);

		return new DtoCita(id, idServicio, nombreServicio, fechaHora, idSede, nombreSede, idCliente, nombreCliente,
				valorServicio, valorDescuento, nombreDescuento);
	}
}
