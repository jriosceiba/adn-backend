package com.ceiba.cita.servicio;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.enumeracion.TipoParametroEnum;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parametro.modelo.dto.DtoParametro;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.parametro.servicio.testdatabuilder.ParametroTestDataBuilder;

/**
 * Clase test para el domimio del crear cita
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioCrearCitaTest {

	/**
	 * Test que permite corroborar duplicados
	 */
	@Test
	public void validarCitaExistenciaPreviaTest() {

		Cita cita = new CitaTestDataBuilder().conCliente(ConstantesDominio.PRUEBA_ID).conFechaHora(LocalDateTime.now())
				.conSede(ConstantesDominio.PRUEBA_ID).conServicio(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		DaoCliente daoCliente = Mockito.mock(DaoCliente.class);
		DaoCita daoCita = Mockito.mock(DaoCita.class);
		Mockito.when(repositorioCita.existe(any(LocalDateTime.class))).thenReturn(true);
		ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoParametro, daoCita, daoCliente);

		BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,
				ConstantesDominio.YA_EXISTE_CITA_EN_EL_HORARIO);
	}

	/**
	 * Test que permite corroborar descuento por cantidad
	 */
	@Test
	public void validarDescuentoCantidadTest() {

		Cita cita = new CitaTestDataBuilder().conCliente(ConstantesDominio.PRUEBA_ID).conFechaHora(LocalDateTime.now())
				.conSede(ConstantesDominio.PRUEBA_ID).conServicio(ConstantesDominio.PRUEBA_ID).build();
		DtoParametro parametro = new ParametroTestDataBuilder().conId(ConstantesDominio.PRUEBA_ID)
				.conNombre(ConstantesDominio.PRUEBA).conValor(ConstantesDominio.PRUEBA_PORCENTAJE)
				.conTipoParametro(ConstantesDominio.PRUEBA).buildDto();
		List<DtoParametro> listaParam = new ArrayList<>();
		listaParam.add(parametro);
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		DaoCliente daoCliente = Mockito.mock(DaoCliente.class);
		DaoCita daoCita = Mockito.mock(DaoCita.class);
		Mockito.when(repositorioCita.existe(any(LocalDateTime.class))).thenReturn(false);
		Mockito.when(daoCita.cantidadCitasDiaMayorCero(cita.getIdCliente(), cita.getFechaHora()))
				.thenReturn(ConstantesDominio.PRUEBA_CANTIDAD);
		Mockito.when(daoParametro.listarPorTipo(TipoParametroEnum.DESCUENTO_CANTIDAD.toString()))
				.thenReturn(listaParam);
		Mockito.when(daoCliente.cumpliendoAnio(ConstantesDominio.PRUEBA_ID)).thenReturn(false);
		ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoParametro, daoCita, daoCliente);

		servicioCrearCita.ejecutar(cita);

		Assert.assertEquals(ConstantesDominio.PRUEBA_PORCENTAJE_DOUBLE, cita.getPorcentajeDescuento());
	}

	/**
	 * Test que permite corroborar descuento por aniversario
	 */
	@Test
	public void validarDescuentoAnualTest() {

		Cita cita = new CitaTestDataBuilder().conCliente(ConstantesDominio.PRUEBA_ID).conFechaHora(LocalDateTime.now())
				.conSede(ConstantesDominio.PRUEBA_ID).conServicio(ConstantesDominio.PRUEBA_ID).build();
		DtoParametro parametro = new ParametroTestDataBuilder().conId(ConstantesDominio.PRUEBA_ID)
				.conNombre(ConstantesDominio.PRUEBA).conValor(ConstantesDominio.PRUEBA_PORCENTAJE)
				.conTipoParametro(ConstantesDominio.PRUEBA).buildDto();
		List<DtoParametro> listaParam = new ArrayList<>();
		listaParam.add(parametro);
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		DaoCliente daoCliente = Mockito.mock(DaoCliente.class);
		DaoCita daoCita = Mockito.mock(DaoCita.class);
		Mockito.when(repositorioCita.existe(any(LocalDateTime.class))).thenReturn(false);
		Mockito.when(daoCita.cantidadCitasDiaMayorCero(cita.getIdCliente(), cita.getFechaHora()))
				.thenReturn(ConstantesDominio.PRUEBA_CANTIDAD_CERO);
		Mockito.when(daoCliente.cumpliendoAnio(cita.getIdCliente())).thenReturn(true);
		Mockito.when(daoParametro.listarPorTipo(TipoParametroEnum.DESCUENTO_ANUAL.toString())).thenReturn(listaParam);
		ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoParametro, daoCita, daoCliente);

		servicioCrearCita.ejecutar(cita);

		Assert.assertEquals(ConstantesDominio.PRUEBA_PORCENTAJE_DOUBLE, cita.getPorcentajeDescuento());
	}

	/**
	 * Test que permite ejecutar la accion de crear
	 */
	@Test
	public void ejecutarCrearTest() {

		Cita cita = new CitaTestDataBuilder().conCliente(ConstantesDominio.PRUEBA_ID).conFechaHora(LocalDateTime.now())
				.conSede(ConstantesDominio.PRUEBA_ID).conServicio(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		DaoCliente daoCliente = Mockito.mock(DaoCliente.class);
		DaoCita daoCita = Mockito.mock(DaoCita.class);
		Mockito.when(repositorioCita.existe(any(LocalDateTime.class))).thenReturn(false);
		Mockito.when(repositorioCita.crear(cita)).thenReturn(anyLong());
		ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoParametro, daoCita, daoCliente);

		Long idEsperado = servicioCrearCita.ejecutar(cita);

		Assert.assertNotNull(idEsperado);
	}
}
