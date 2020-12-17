package com.ceiba.cita.servicio;

import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;

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

		Cita cita = new CitaTestDataBuilder().build();
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		Mockito.when(repositorioCita.existe(any(LocalDateTime.class))).thenReturn(true);
		ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

		BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,
				ConstantesDominio.YA_EXISTE_CITA_EN_EL_HORARIO);
	}

	/**
	 * Test que permite ejecutar la accion de crear
	 */
	@Test
	public void ejecutarCrearTest() {

		Cita cita = new CitaTestDataBuilder().build();
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		Mockito.when(repositorioCita.existe(any(LocalDateTime.class))).thenReturn(false);
		Mockito.when(repositorioCita.crear(cita)).thenReturn(anyLong());
		ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

		Long idEsperado = servicioCrearCita.ejecutar(cita);

		Assert.assertNotNull(idEsperado);
	}
}
