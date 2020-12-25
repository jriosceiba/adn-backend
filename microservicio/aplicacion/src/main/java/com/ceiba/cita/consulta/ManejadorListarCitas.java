package com.ceiba.cita.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;

/**
 * Manejador de la accion de consultar todas las citas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorListarCitas {

	/**
	 * Dao asociado
	 */
	private final DaoCita daoCita;

	/**
	 * Constructor de la clase
	 * 
	 * @param daoCita, el valor de la propiedad
	 */
	public ManejadorListarCitas(DaoCita daoCita) {
		super();
		this.daoCita = daoCita;
	}

	/**
	 * lista todas las citas registradas
	 * 
	 * @return el listado de citas
	 */
	public List<DtoCita> ejecutar() {
		return this.daoCita.listarTodas();
	}
}
