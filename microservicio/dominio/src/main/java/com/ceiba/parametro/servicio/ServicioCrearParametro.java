package com.ceiba.parametro.servicio;

import com.ceiba.dominio.constantes.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parametro.modelo.entidad.Parametro;
import com.ceiba.parametro.puerto.repositorio.RepositorioParametro;

/**
 * Servicio para ejecucion de la actividad de creacion hacia los parametros
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioCrearParametro {

	/**
	 * Inyeccion del repositorio asociado
	 */
	private final RepositorioParametro repositorioParametro;

	/**
	 * Constructor del servicio
	 * 
	 * @param repositorioParametro, el valor de la propiedad
	 */
	public ServicioCrearParametro(RepositorioParametro repositorioParametro) {
		this.repositorioParametro = repositorioParametro;
	}

	/**
	 * Accion especifica a realizarse desde el servicio
	 * 
	 * @param parametro, parametro a crear
	 * @return el parametro creado
	 */
	public Parametro ejecutar(Parametro parametro) {
		validarExistenciaPrevia(parametro);
		return this.repositorioParametro.crear(parametro);
	}

	/**
	 * Permite validar la existencia de un parametro en el sistema
	 * 
	 * @param parametro, parametro a buscar
	 */
	private void validarExistenciaPrevia(Parametro parametro) {
		boolean existe = this.repositorioParametro.existe(parametro.getNombre());
		if (existe) {
			throw new ExcepcionDuplicidad(ConstantesDominio.EL_PARAMETRO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
