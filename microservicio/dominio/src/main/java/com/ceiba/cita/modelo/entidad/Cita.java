package com.ceiba.cita.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import com.ceiba.dominio.constante.ConstantesDominio;

import lombok.Getter;

/**
 * Clase que representa el objeto cita y todas sus propiedades
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Getter
public class Cita {

	/**
	 * Corresponde al identificador primario del objeto
	 */
	private Long id;

	/**
	 * Corresponde al servicio a prestar
	 */
	private Long idServicio;

	/**
	 * Corresponde a la fecha y hora de la cita
	 */
	private LocalDateTime fechaHora;

	/**
	 * Corresponde a la sede relacionada a prestar el servicio
	 */
	private Long idSede;

	/**
	 * Corresponde al cliente relacionado
	 */
	private Long idCliente;

	/**
	 * Corresponde al porcentaje del descuento aplicado
	 * 
	 * @return
	 */
	private Double porcentajeDescuento;

	/**
	 * Corresponde al id del descuento aplicado
	 */
	private Long idDescuento;

	/**
	 * Constructor de la clase
	 * 
	 * @param id,        llave primaria
	 * @param servicio,  servicio relacionado
	 * @param fechaHora, fecha y hora del servicio
	 * @param sede,      sede relacionada
	 * @param cliente,   cliente relacionado
	 */
	public Cita(Long id, Long idServicio, LocalDateTime fechaHora, Long idSede, Long idCliente) {
		validarObligatorio(idServicio, ConstantesDominio.OBLIGATORIO_SERVICIO_CITA);
		validarObligatorio(fechaHora, ConstantesDominio.OBLIGATORIO_FECHA_HORA_CITA);
		validarObligatorio(idSede, ConstantesDominio.OBLIGATORIO_SEDE_CITA);
		validarObligatorio(idCliente, ConstantesDominio.OBLIGATORIO_CLIENTE_CITA);
		this.id = id;
		this.idServicio = idServicio;
		this.fechaHora = fechaHora;
		this.idSede = idSede;
		this.idCliente = idCliente;
	}

	/**
	 * @param porcentajeDescuento the porcentajeDescuento to set
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * @param idDescuento the idDescuento to set
	 */
	public void setIdDescuento(Long idDescuento) {
		this.idDescuento = idDescuento;
	}
}
