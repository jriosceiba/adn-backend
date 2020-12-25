package com.ceiba.cita.servicio;

import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;

/**
 * Clase test para el domimio del actualizar cita
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioActualizarCitaTest {

	/**
	 * Test que permite corroborar duplicados
	 */
	@Test
	public void validarCitaExistenciaPreviaTest() {

		Cita cita = new CitaTestDataBuilder().conCliente(ConstantesDominio.PRUEBA_ID).conFechaHora(LocalDateTime.now())
				.conSede(ConstantesDominio.PRUEBA_ID).conServicio(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(), any(LocalDateTime.class))).thenReturn(true);
		ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);

		BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita), ExcepcionDuplicidad.class,
				ConstantesDominio.YA_EXISTE_CITA_EN_EL_HORARIO);
	}

	/**
	 * Test que permite ejecutar la accion de actualizar
	 */
	@Test
	public void ejecutarActualizarTest() {

		Cita cita = new CitaTestDataBuilder().conId(ConstantesDominio.PRUEBA_ID).conCliente(ConstantesDominio.PRUEBA_ID)
				.conFechaHora(LocalDateTime.now()).conSede(ConstantesDominio.PRUEBA_ID)
				.conServicio(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(), any(LocalDateTime.class))).thenReturn(false);
		doNothing().when(repositorioCita).actualizar(cita);
		ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);

		servicioActualizarCita.ejecutar(cita);
		verify(repositorioCita, times(1)).actualizar(cita);
	}
}
