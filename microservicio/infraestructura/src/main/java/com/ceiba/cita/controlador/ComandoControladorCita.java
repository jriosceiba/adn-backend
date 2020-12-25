package com.ceiba.cita.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.manejador.ManejadorActualizarCita;
import com.ceiba.cita.comando.manejador.ManejadorCrearCita;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controlador que maneja las APIS de acceso hacia la persitencia
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@RestController
@RequestMapping(value = ConstantesInfraestructura.REQUEST_COMANDO_CITA)
@Api(tags = { ConstantesInfraestructura.TAG_COMANDO_CITA })
public class ComandoControladorCita {

	/**
	 * Inyeccion del manejador de creacion
	 */
	private final ManejadorCrearCita manejadorCrearCita;

	/**
	 * Inyeccion del manejador de actualizacion
	 */
	private final ManejadorActualizarCita manejadorActualizarCita;

	/**
	 * Constructor de la clase
	 * 
	 * @param manejadorCrearCita,      el valor de la propiedad
	 * @param manejadorActualizarCita, el valor de la propiedad
	 */
	public ComandoControladorCita(ManejadorCrearCita manejadorCrearCita,
			ManejadorActualizarCita manejadorActualizarCita) {
		super();
		this.manejadorCrearCita = manejadorCrearCita;
		this.manejadorActualizarCita = manejadorActualizarCita;
	}

	/**
	 * Servicio post de creacion
	 * 
	 * @param comandoCita, cuerpo del metodo
	 * @return la respuesta al servicio
	 */
	@PostMapping
	@ApiOperation(value = ConstantesInfraestructura.API_CREAR_CITA)
	public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita) {
		return manejadorCrearCita.ejecutar(comandoCita);
	}

	/**
	 * Servicio put de actualizacion
	 * 
	 * @param comandoParametro, cuerpo del metodo
	 * @param id,               id del parametro
	 */
	@PutMapping(value = ConstantesInfraestructura.API_PARAM_ID)
	@ApiOperation(value = ConstantesInfraestructura.API_ACTUALIZAR_CITA)
	public void actualizar(@RequestBody ComandoCita comandoCita, @PathVariable Long id) {
		comandoCita.setId(id);
		manejadorActualizarCita.ejecutar(comandoCita);
	}
}
