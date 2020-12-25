package com.ceiba.cliente.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
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
@RequestMapping(value = ConstantesInfraestructura.REQUEST_COMANDO_CLIENTE)
@Api(tags = { ConstantesInfraestructura.TAG_COMANDO_CLIENTE })
public class ComandoControladorCliente {

	/**
	 * Inyeccion del manejador de creacion
	 */
	private final ManejadorCrearCliente manejadorCrearCliente;

	/**
	 * Inyeccion del manejador de actualizacion
	 */
	private final ManejadorActualizarCliente manejadorActualizarCliente;

	/**
	 * Constructor de la clase
	 * 
	 * @param manejadorCrearCliente,      el valor de la propiedad
	 * @param manejadorActualizarCliente, el valor de la propiedad
	 */
	public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente,
			ManejadorActualizarCliente manejadorActualizarCliente) {
		super();
		this.manejadorCrearCliente = manejadorCrearCliente;
		this.manejadorActualizarCliente = manejadorActualizarCliente;
	}

	/**
	 * Servicio post de creacion
	 * 
	 * @param comandoCliente, cuerpo del metodo
	 * @return la respuesta al servicio
	 */
	@PostMapping
	@ApiOperation(value = ConstantesInfraestructura.API_CREAR_CLIENTE)
	public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
		return manejadorCrearCliente.ejecutar(comandoCliente);
	}

	/**
	 * Servicio put de actualizacion
	 * 
	 * @param comandoParametro, cuerpo del metodo
	 * @param id,               id del parametro
	 */
	@PutMapping(value = ConstantesInfraestructura.API_PARAM_ID)
	@ApiOperation(value = ConstantesInfraestructura.API_ACTUALIZAR_CLIENTE)
	public void actualizar(@RequestBody ComandoCliente comandoCliente, @PathVariable Long id) {
		comandoCliente.setId(id);
		manejadorActualizarCliente.ejecutar(comandoCliente);
	}
}
