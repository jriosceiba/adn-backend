package com.ceiba.parametro.servicio;

import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parametro.modelo.entidad.Parametro;
import com.ceiba.parametro.puerto.repositorio.RepositorioParametro;

/**
 * Servicio para ejecucion de la actividad de actualizacion hacia los parametros
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioActualizarParametro {

	/**
	 * Inyeccion del repositorio asociado
	 */
	private final RepositorioParametro repositorioParametro;

	/**
	 * Constructor del servicio
	 * 
	 * @param repositorioParametro, el valor de la propiedad
	 */
	public ServicioActualizarParametro(RepositorioParametro repositorioParametro) {
		this.repositorioParametro = repositorioParametro;
	}

	/**
	 * Accion especifica a realizarse desde el servicio
	 * 
	 * @param parametro
	 */
	public void ejecutar(Parametro parametro) {
		validarExistenciaPrevia(parametro);
		this.repositorioParametro.actualizar(parametro);
	}

	/**
	 * Permite validar la existencia de un parametro en el sistema, excluyendo su id
	 * 
	 * @param parametro, parametro a buscar
	 */
	private void validarExistenciaPrevia(Parametro parametro) {
		boolean existe = this.repositorioParametro.existeExcluyendoId(parametro.getId(), parametro.getNombre());
		if (existe) {
			throw new ExcepcionDuplicidad(ConstantesDominio.EL_PARAMETRO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
