package com.ceiba.cliente.comando.fabrica;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;

/**
 * Clase que permite la creacion de un cliente a partir de su comando
 * equivalente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class FabricaCliente {

	/**
	 * Permite instanciar un objeto cliente, a partir de los datos siminstrados por
	 * el comando
	 * 
	 * @param comandoCliente, contenedor de los datos
	 * @return el cliente creado
	 */
	public Cliente crear(ComandoCliente comandoCliente) {
		return new Cliente(comandoCliente.getId(), comandoCliente.getNombre(), comandoCliente.getEmail(),
				comandoCliente.getTelefono(), comandoCliente.getIdCiudad(), LocalDate.now());
	}
}
