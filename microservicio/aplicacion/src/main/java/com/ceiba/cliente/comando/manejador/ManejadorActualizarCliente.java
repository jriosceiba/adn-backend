package com.ceiba.cliente.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.manejador.ManejadorComando;

/**
 * Permite hacer las veces de puente entre el servicio y la fabrica de los
 * clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoCliente> {

	/**
	 * Inyeccion de la fabrica relacionada
	 */
	private final FabricaCliente fabricaCliente;

	/**
	 * Inyeccion del servicio relacionado
	 */
	private final ServicioActualizarCliente servicioActualizarCliente;

	/**
	 * Constructor de la clase
	 * 
	 * @param fabricaCliente,            el valor de la propiedad
	 * @param servicioActualizarCliente, el valor de la propiedad
	 */
	public ManejadorActualizarCliente(FabricaCliente fabricaCliente,
			ServicioActualizarCliente servicioActualizarCliente) {
		this.fabricaCliente = fabricaCliente;
		this.servicioActualizarCliente = servicioActualizarCliente;
	}

	/**
	 * Permite ejecutar la accion del actualizar
	 */
	public void ejecutar(ComandoCliente comandoCliente) {
		Cliente cliente = this.fabricaCliente.crear(comandoCliente);
		this.servicioActualizarCliente.ejecutar(cliente);
	}
}
