package com.ceiba.cliente.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;

/**
 * Permite hacer las veces de puente entre el servicio y la fabrica de los
 * clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<Long>> {

	/**
	 * Inyeccion de la fabrica relacionada
	 */
	private final FabricaCliente fabricaCliente;

	/**
	 * Inyeccion del servicio relacionado
	 */
	private final ServicioCrearCliente servicioCrearCliente;

	/**
	 * Constructor de la clase
	 * 
	 * @param fabricaCliente,       el valor de la propieda
	 * @param servicioCrearCliente, el valor de la propiedad
	 */
	public ManejadorCrearCliente(FabricaCliente fabricaCliente, ServicioCrearCliente servicioCrearCliente) {
		this.fabricaCliente = fabricaCliente;
		this.servicioCrearCliente = servicioCrearCliente;
	}

	/**
	 * Permite ejecutar la accion del crear y dar una respuesta a traves del comando
	 */
	public ComandoRespuesta<Long> ejecutar(ComandoCliente comandoCliente) {
		Cliente cliente = this.fabricaCliente.crear(comandoCliente);
		return new ComandoRespuesta<>(this.servicioCrearCliente.ejecutar(cliente));
	}
}
