package com.ceiba.cita.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.cita.modelo.entidad.Cita;

/**
 * Puerto de entrada hacia las operaciones transaccionales del CRUD para las
 * citas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public interface RepositorioCita {

	/**
	 * Permite crear una cita
	 * 
	 * @param cita, cita a crear
	 * @return la cita creada
	 */
	Long crear(Cita cita);

	/**
	 * Permite actualizar una cita
	 * 
	 * @param cita, cita a actualizar
	 * @return la cita actualizada
	 */
	void actualizar(Cita cita);

	/**
	 * Permite validar si existe una cita en el rango de fecha y hora ingresado
	 * 
	 * @param fechaYHoraCita, tiempo a validar
	 * @return si existe o no
	 */
	boolean existe(LocalDateTime fechaYHoraCita);

	/**
	 * Permite validar si existe una cita en el rango de fecha y hora ingresado,
	 * excluyendose a ella misma por su id
	 * 
	 * @param id,             id a excluir
	 * @param fechaYHoraCita, fecha y hora a validar
	 * @return
	 */
	boolean existeExcluyendoId(Long id, LocalDateTime fechaYHoraCita);
}
