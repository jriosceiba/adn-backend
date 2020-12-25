package com.ceiba.parametro.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.parametro.comando.ComandoParametro;
import com.ceiba.parametro.comando.manejador.ManejadorActualizarParametro;
import com.ceiba.parametro.comando.manejador.ManejadorCrearParametro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controlador que maneja las APIS de acceso hacia la persitencia
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@RestController
@RequestMapping(value = ConstantesInfraestructura.REQUEST_COMANDO_PARAMETRO)
@Api(tags = { ConstantesInfraestructura.TAG_COMANDO_PARAMETRO })
public class ComandoControladorParametro {

	/**
	 * Inyeccion del manejador de creacion
	 */
	private final ManejadorCrearParametro manejadorCrearParametro;

	/**
	 * Inyeccion del manejador de actualizacion
	 */
	private final ManejadorActualizarParametro manejadorActualizarParametro;

	/**
	 * Constructor de la clase
	 * 
	 * @param manejadorCrearParametro,      el valor de la propiedad
	 * @param manejadorActualizarParametro, el valor de la propiedad
	 */
	public ComandoControladorParametro(ManejadorCrearParametro manejadorCrearParametro,
			ManejadorActualizarParametro manejadorActualizarParametro) {
		super();
		this.manejadorCrearParametro = manejadorCrearParametro;
		this.manejadorActualizarParametro = manejadorActualizarParametro;
	}

	/**
	 * Servicio post de creacion
	 * 
	 * @param comandoParametro, cuerpo del metodo
	 * @return
	 */
	@PostMapping
	@ApiOperation(value = ConstantesInfraestructura.API_CREAR_PARAMETRO)
	public ComandoRespuesta<Long> crear(@RequestBody ComandoParametro comandoParametro) {
		return manejadorCrearParametro.ejecutar(comandoParametro);
	}

	/**
	 * Servicio put de actualizacion
	 * 
	 * @param comandoParametro, cuerpo del metodo
	 * @param id,               id del parametro
	 */
	@PutMapping(value = ConstantesInfraestructura.API_PARAM_ID)
	@ApiOperation(value = ConstantesInfraestructura.API_ACTUALIZAR_PARAMETRO)
	public void actualizar(@RequestBody ComandoParametro comandoParametro, @PathVariable Long id) {
		comandoParametro.setId(id);
		manejadorActualizarParametro.ejecutar(comandoParametro);
	}
}
