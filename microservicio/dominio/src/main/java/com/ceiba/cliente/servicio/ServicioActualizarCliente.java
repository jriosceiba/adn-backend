package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.constantes.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

/**
 * Servicio para ejecucion de la actividad de actualizacion hacia los clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioActualizarCliente {

	/**
	 * Inyeccion del repositorio asociado
	 */
	private final RepositorioCliente repositorioCliente;

	/**
	 * Constructor del servicio
	 * 
	 * @param repositorioCliente, el valor de la propiedad
	 */
	public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}

	/**
	 * Accion especifica a realizarse desde el servicio
	 * 
	 * @param cliente, cliente a actualizar
	 * @return el cliente actualizado
	 */
	public void ejecutar(Cliente cliente) {
		validarExistenciaPrevia(cliente);
		this.repositorioCliente.actualizar(cliente);
	}

	/**
	 * Permite validar la existencia de un cliente en el sistema, excluyendo el id
	 * 
	 * @param cliente, cliente a buscar
	 */
	private void validarExistenciaPrevia(Cliente cliente) {
		boolean existe = this.repositorioCliente.existeExcluyendoId(cliente.getId(), cliente.getEmail());
		if (existe) {
			throw new ExcepcionDuplicidad(ConstantesDominio.EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
