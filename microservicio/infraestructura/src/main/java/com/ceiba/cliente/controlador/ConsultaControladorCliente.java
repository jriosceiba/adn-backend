package com.ceiba.cliente.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controlador para las consultas relacionadas a los clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@RestController
@RequestMapping(value = ConstantesInfraestructura.REQUEST_COMANDO_CLIENTE)
@Api(tags = { ConstantesInfraestructura.TAG_CONSULTA_CLIENTE })
public class ConsultaControladorCliente {

	/**
	 * Inyeccion del manejador para consultas
	 */
	private final ManejadorListarClientes manejadorListarClientes;

	/**
	 * Constructor de la clase
	 * 
	 * @param manejadorListarClientes, el valor de la propiedad
	 */
	@Autowired
	public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes) {
		this.manejadorListarClientes = manejadorListarClientes;
	}

	/**
	 * End point para obtener el listado completo de clientes
	 * 
	 * @return el listado de clientes
	 */
	@GetMapping
	@ApiOperation(value = ConstantesInfraestructura.API_LISTAR_CLIENTES)
	public List<DtoCliente> listar() {
		return this.manejadorListarClientes.ejecutar();
	}
}
