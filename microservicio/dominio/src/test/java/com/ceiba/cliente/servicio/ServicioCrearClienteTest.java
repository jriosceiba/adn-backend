package com.ceiba.cliente.servicio;

import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import static org.mockito.Matchers.anyLong;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

/**
 * Clase test para el domimio del crear cliente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioCrearClienteTest {

	/**
	 * Test que permite corroborar duplicados
	 */
	@Test
	public void validarClienteExistenciaPreviaTest() {

		Cliente cliente = new ClienteTestDataBuilder().conNombre(ConstantesDominio.PRUEBA)
				.conEmail(ConstantesDominio.PRUEBA_CORREO).conTelefono(ConstantesDominio.PRUEBA_TELEFONO)
				.conFechaCreacion(LocalDate.now()).conCiudad(ConstantesDominio.PRUEBA_ID)
				.conCiudad(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(true);
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);

		BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class,
				ConstantesDominio.EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
	}

	/**
	 * Test que permite ejecutar la accion de crear
	 */
	@Test
	public void ejecutarCrearTest() {

		Cliente cliente = new ClienteTestDataBuilder().conNombre(ConstantesDominio.PRUEBA)
				.conEmail(ConstantesDominio.PRUEBA_CORREO).conTelefono(ConstantesDominio.PRUEBA_TELEFONO)
				.conFechaCreacion(LocalDate.now()).conCiudad(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioCliente.crear(cliente)).thenReturn(anyLong());
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);

		Long idEsperado = servicioCrearCliente.ejecutar(cliente);

		Assert.assertNotNull(idEsperado);
	}
}
