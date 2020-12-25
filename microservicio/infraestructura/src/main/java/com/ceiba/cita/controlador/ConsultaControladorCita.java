package com.ceiba.cita.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cita.consulta.ManejadorListarCitas;
import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controlador para las consultas relacionadas a las citas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@RestController
@RequestMapping(value = ConstantesInfraestructura.REQUEST_COMANDO_CITA)
@Api(tags = { ConstantesInfraestructura.TAG_CONSULTA_CITA })
public class ConsultaControladorCita {

	/**
	 * Inyeccion del manejador para consultas
	 */
	private final ManejadorListarCitas manejadorListarCitas;

	/**
	 * Constructor de la clase
	 * 
	 * @param manejadorListarCitas, el valor de la propiedad
	 */
	@Autowired
	public ConsultaControladorCita(ManejadorListarCitas manejadorListarCitas) {
		this.manejadorListarCitas = manejadorListarCitas;
	}

	/**
	 * End point para obtener el listado completo de citas
	 * 
	 * @return el listado de citas
	 */
	@GetMapping
	@ApiOperation(value = ConstantesInfraestructura.API_LISTAR_CITAS)
	public List<DtoCita> listar() {
		return this.manejadorListarCitas.ejecutar();
	}
}
