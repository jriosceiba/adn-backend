package com.ceiba.parametro.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parametro.modelo.dto.DtoParametro;

/**
 * Clase que permite la extraccion de datos a traves de un resultado obtenido
 * desde la bd y los setea en el dto de parametro
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class MapeoParametro implements RowMapper<DtoParametro>, MapperResult {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DtoParametro mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long id = rs.getLong(ConstantesInfraestructura.ID);
		String nombre = rs.getString(ConstantesInfraestructura.NOMBRE);
		String valor = rs.getString(ConstantesInfraestructura.VALOR);
		String tipoParametro = rs.getString(ConstantesInfraestructura.TIPO_PARAMETRO);

		return new DtoParametro(id, nombre, valor, tipoParametro);
	}
}
