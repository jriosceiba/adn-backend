package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.constantes.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

/**
 * Servicio para ejecucion de la actividad de creacion hacia las citas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioCrearCita {

	/**
	 * Inyeccion del repositorio asociado
	 */
	private final RepositorioCita repositorioCita;

	/**
	 * Constructor del servicio
	 * 
	 * @param repositorioCita, el valor de la propiedad
	 */
	public ServicioCrearCita(RepositorioCita repositorioCita) {
		this.repositorioCita = repositorioCita;
	}

	/**
	 * Accion especifica a realizarse desde el servicio
	 * 
	 * @param cita, cita a crear
	 * @return el id de la cita creada
	 */
	public Long ejecutar(Cita cita) {
		validarExistenciaPrevia(cita);
		return this.repositorioCita.crear(cita);
	}

	/**
	 * Permite validar la existencia de una cita en el sistema
	 * 
	 * @param cita, cita a buscar
	 */
	private void validarExistenciaPrevia(Cita cita) {
		boolean existe = this.repositorioCita.existe(cita.getFechaHora());
		if (existe) {
			throw new ExcepcionDuplicidad(ConstantesDominio.YA_EXISTE_CITA_EN_EL_HORARIO);
		}
	}
}
