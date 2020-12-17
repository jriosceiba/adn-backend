package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

/**
 * Servicio para ejecucion de la actividad de actualizacion hacia las citas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioActualizarCita {

	/**
	 * Inyeccion del repositorio asociado
	 */
	private final RepositorioCita repositorioCita;

	/**
	 * Constructor del servicio
	 * 
	 * @param repositorioCita, el valor de la propiedad
	 */
	public ServicioActualizarCita(RepositorioCita repositorioCita) {
		this.repositorioCita = repositorioCita;
	}

	/**
	 * Accion especifica a realizarse desde el servicio
	 * 
	 * @param cita, cita a actualizar
	 */
	public void ejecutar(Cita cita) {
		validarExistenciaPrevia(cita);
		this.repositorioCita.actualizar(cita);
	}

	/**
	 * Permite validar la existencia de una cita en el sistema, excluyendose ella
	 * misma
	 * 
	 * @param cita, cita a buscar
	 */
	private void validarExistenciaPrevia(Cita cita) {
		boolean existe = this.repositorioCita.existeExcluyendoId(cita.getId(), cita.getFechaHora());
		if (existe) {
			throw new ExcepcionDuplicidad(ConstantesDominio.YA_EXISTE_CITA_EN_EL_HORARIO);
		}
	}
}
