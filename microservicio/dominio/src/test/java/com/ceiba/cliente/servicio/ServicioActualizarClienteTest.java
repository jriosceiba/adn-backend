package com.ceiba.cliente.servicio;

import com.ceiba.dominio.constante.ConstantesDominio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

/**
 * Clase test para el domimio del actualizar cliente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ServicioActualizarClienteTest {

	/**
	 * Test que permite corroborar duplicados
	 */
	@Test
	public void validarClienteExistenciaPreviaTest() {

		Cliente cliente = new ClienteTestDataBuilder().conId(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
		ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);

		BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,
				ConstantesDominio.EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
	}

	/**
	 * Test que permite ejecutar la accion de actualizar
	 */
	@Test
	public void ejecutarActualizarTest() {

		Cliente cliente = new ClienteTestDataBuilder().conId(ConstantesDominio.PRUEBA_ID).build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
		doNothing().when(repositorioCliente).actualizar(cliente);
		ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);

		servicioActualizarCliente.ejecutar(cliente);
		verify(repositorioCliente, times(1)).actualizar(cliente);
	}
}
