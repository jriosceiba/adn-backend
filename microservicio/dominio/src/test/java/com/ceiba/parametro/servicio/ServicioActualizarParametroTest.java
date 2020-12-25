package com.ceiba.parametro.servicio;

import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parametro.modelo.entidad.Parametro;
import com.ceiba.parametro.puerto.repositorio.RepositorioParametro;
import com.ceiba.parametro.servicio.testdatabuilder.ParametroTestDataBuilder;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

/**
 * Clase test para el domimio del actualizar parametro
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioActualizarParametroTest {

	/**
	 * Test que permite corroborar duplicados
	 */
	@Test
	public void validarParametroExistenciaPreviaTest() {

		Parametro parametro = new ParametroTestDataBuilder().conId(ConstantesDominio.PRUEBA_ID)
				.conNombre(ConstantesDominio.PRUEBA).conValor(ConstantesDominio.PRUEBA)
				.conTipoParametro(ConstantesDominio.PRUEBA).build();
		RepositorioParametro repositorioParametro = Mockito.mock(RepositorioParametro.class);
		Mockito.when(repositorioParametro.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
		ServicioActualizarParametro servicioActualizarParametro = new ServicioActualizarParametro(repositorioParametro);

		BasePrueba.assertThrows(() -> servicioActualizarParametro.ejecutar(parametro), ExcepcionDuplicidad.class,
				ConstantesDominio.EL_PARAMETRO_YA_EXISTE_EN_EL_SISTEMA);
	}

	/**
	 * Test que permite ejecutar la accion de actualizar
	 */
	@Test
	public void ejecutarActualizarTest() {

		Parametro parametro = new ParametroTestDataBuilder().conId(ConstantesDominio.PRUEBA_ID)
				.conNombre(ConstantesDominio.PRUEBA).conValor(ConstantesDominio.PRUEBA)
				.conTipoParametro(ConstantesDominio.PRUEBA).build();
		RepositorioParametro repositorioParametro = Mockito.mock(RepositorioParametro.class);
		Mockito.when(repositorioParametro.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
		doNothing().when(repositorioParametro).actualizar(parametro);
		ServicioActualizarParametro servicioActualizarParametro = new ServicioActualizarParametro(repositorioParametro);

		servicioActualizarParametro.ejecutar(parametro);
		verify(repositorioParametro, times(1)).actualizar(parametro);
	}
}
