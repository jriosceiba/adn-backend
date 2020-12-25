package com.ceiba.cliente.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.MapperResult;

/**
 * Clase que permite la extraccion de datos a traves de un resultado obtenido
 * desde la bd y los setea en el dto de parametro
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DtoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long id = rs.getLong(ConstantesInfraestructura.ID);
		String nombre = rs.getString(ConstantesInfraestructura.NOMBRE);
		String email = rs.getString(ConstantesInfraestructura.EMAIL);
		String telefono = rs.getString(ConstantesInfraestructura.TELEFONO);
		Long idCiudad = rs.getLong(ConstantesInfraestructura.CIUDAD_ID);
		String nombreCiudad = rs.getString(ConstantesInfraestructura.CIUDAD_NOMBRE);
		LocalDate fechaCreacion = extraerLocalDate(rs, ConstantesInfraestructura.FECHA_CREACION);

		return new DtoCliente(id, nombre, email, telefono, idCiudad, nombreCiudad, fechaCreacion);
	}
}
