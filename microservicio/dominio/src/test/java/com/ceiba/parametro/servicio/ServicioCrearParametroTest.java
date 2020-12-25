package com.ceiba.parametro.servicio;

import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parametro.modelo.entidad.Parametro;
import com.ceiba.parametro.puerto.repositorio.RepositorioParametro;
import com.ceiba.parametro.servicio.testdatabuilder.ParametroTestDataBuilder;

import static org.mockito.Matchers.anyLong;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

/**
 * Clase test para el domimio del crear parametro
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioCrearParametroTest {

	/**
	 * Test que permite corroborar duplicados
	 */
	@Test
	public void validarParametroExistenciaPreviaTest() {

		Parametro parametro = new ParametroTestDataBuilder().conNombre(ConstantesDominio.PRUEBA)
				.conValor(ConstantesDominio.PRUEBA).conTipoParametro(ConstantesDominio.PRUEBA).build();
		RepositorioParametro repositorioParametro = Mockito.mock(RepositorioParametro.class);
		Mockito.when(repositorioParametro.existe(Mockito.anyString())).thenReturn(true);
		ServicioCrearParametro servicioCrearParametro = new ServicioCrearParametro(repositorioParametro);

		BasePrueba.assertThrows(() -> servicioCrearParametro.ejecutar(parametro), ExcepcionDuplicidad.class,
				ConstantesDominio.EL_PARAMETRO_YA_EXISTE_EN_EL_SISTEMA);
	}

	/**
	 * Test que permite ejecutar la accion de crear
	 */
	@Test
	public void ejecutarCrearTest() {

		Parametro parametro = new ParametroTestDataBuilder().conNombre(ConstantesDominio.PRUEBA)
				.conValor(ConstantesDominio.PRUEBA).conTipoParametro(ConstantesDominio.PRUEBA).build();
		RepositorioParametro repositorioParametro = Mockito.mock(RepositorioParametro.class);
		Mockito.when(repositorioParametro.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioParametro.crear(parametro)).thenReturn(anyLong());
		ServicioCrearParametro servicioCrearParametro = new ServicioCrearParametro(repositorioParametro);

		Long idEsperado = servicioCrearParametro.ejecutar(parametro);

		Assert.assertNotNull(idEsperado);
	}
}
