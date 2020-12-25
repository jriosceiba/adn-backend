package com.ceiba.cita.servicio;

import java.util.List;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.enumeracion.TipoParametroEnum;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.puerto.dao.DaoParametro;

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
	 * Inyeccion del data access de parametros
	 */
	private final DaoParametro daoParametro;

	/**
	 * Inyeccion del data access de citas
	 */
	private DaoCita daoCita;

	/**
	 * Inyeccion del data access de clientes
	 */
	private DaoCliente daoCliente;

	/**
	 * Constructor del servicio
	 * 
	 * @param repositorioCita, el valor de la propiedad
	 * @param daoParametro,    el valor de la propiedad
	 * @param daoCita,         el valor de la propiedad
	 * @param daoCliente,      el valor de la propiedad
	 */
	public ServicioCrearCita(RepositorioCita repositorioCita, DaoParametro daoParametro, DaoCita daoCita,
			DaoCliente daoCliente) {
		this.repositorioCita = repositorioCita;
		this.daoParametro = daoParametro;
		this.daoCita = daoCita;
		this.daoCliente = daoCliente;
	}

	/**
	 * Accion especifica a realizarse desde el servicio
	 * 
	 * @param cita, cita a crear
	 * @return el id de la cita creada
	 */
	public Long ejecutar(Cita cita) {
		validarExistenciaPrevia(cita);
		validarDescuentoCantidad(cita);
		validarDescuentoAnual(cita);
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

	/**
	 * Permite validar el descuento a aplicar por cantidad
	 * 
	 * @param cita, cita a validar
	 */
	private void validarDescuentoCantidad(Cita cita) {
		Integer hayCitas = daoCita.cantidadCitasDiaMayorCero(cita.getIdCliente(), cita.getFechaHora());
		double porcentajeDescuento = 0;

		if (hayCitas != null && hayCitas > 0) {
			List<DtoParametro> descuentos = daoParametro.listarPorTipo(TipoParametroEnum.DESCUENTO_CANTIDAD.toString());
			if (descuentos != null && !descuentos.isEmpty()) {
				porcentajeDescuento = Double.valueOf(descuentos.get(0).getValor()) * hayCitas;
				cita.setIdDescuento(descuentos.get(0).getId());
			}
		}
		cita.setPorcentajeDescuento(porcentajeDescuento);
	}

	/**
	 * Permite validar el descuento a aplicar por tiempo de ingreso
	 * 
	 * @param cita, cita a validar
	 */
	private void validarDescuentoAnual(Cita cita) {
		boolean aniversario = daoCliente.cumpliendoAnio(cita.getIdCliente());

		if (aniversario) {
			List<DtoParametro> descuentos = daoParametro.listarPorTipo(TipoParametroEnum.DESCUENTO_ANUAL.toString());
			if (descuentos != null && !descuentos.isEmpty()) {
				cita.setIdDescuento(descuentos.get(0).getId());
				cita.setPorcentajeDescuento(Double.valueOf(descuentos.get(0).getValor()));
			}
		}
	}
}
