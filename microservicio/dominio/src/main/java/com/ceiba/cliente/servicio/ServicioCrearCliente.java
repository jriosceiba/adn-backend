package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

/**
 * Servicio para ejecucion de la actividad de creacion hacia los clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioCrearCliente {

	/**
	 * Inyeccion del repositorio asociado
	 */
	private final RepositorioCliente repositorioCliente;

	/**
	 * Constructor del servicio
	 * 
	 * @param repositorioCliente, el valor de la propiedad
	 */
	public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}

	/**
	 * Accion especifica a realizarse desde el servicio
	 * 
	 * @param cliente, cliente a crear
	 * @return el cliente creado
	 */
	public Long ejecutar(Cliente cliente) {
		validarExistenciaPrevia(cliente);
		return this.repositorioCliente.crear(cliente);
	}

	/**
	 * Permite validar la existencia de un cliente en el sistema
	 * 
	 * @param cliente, cliente a buscar
	 */
	private void validarExistenciaPrevia(Cliente cliente) {
		boolean existe = this.repositorioCliente.existe(cliente.getEmail());
		if (existe) {
			throw new ExcepcionDuplicidad(ConstantesDominio.EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
