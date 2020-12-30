package com.ceiba.cliente.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Clase de pruebas de integracion para el ente ComandoCliente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorUsuario.class)
public class ComandoControladorClienteTest {

	/**
	 * Mapeador de objetos JSON
	 */
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Mockeador de servlet
	 */
	@Autowired
	private MockMvc mocMvc;

	/**
	 * Prueba de integracion a la API de crear
	 * 
	 * @throws Exception
	 */
	@Test
	public void crear() throws Exception {

		ComandoCliente cliente = new ComandoClienteTestDataBuilder().conNombre(ConstantesInfraestructura.PRUEBA)
				.conEmail(ConstantesInfraestructura.PRUEBA_CORREO).conCiudad(ConstantesInfraestructura.PRUEBA_ID)
				.conTelefono(ConstantesInfraestructura.PRUEBA_TELEFONO).build();

		mocMvc.perform(post(ConstantesInfraestructura.REQUEST_COMANDO_CLIENTE).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente))).andExpect(status().isOk())
				.andExpect(content().json(ConstantesInfraestructura.VALOR_TEST_CREAR_CLIENTE));
	}

	/**
	 * Prueba de integracion a la API de actualizar
	 * 
	 * @throws Exception
	 */
	@Test
	public void actualizar() throws Exception {

		Long id = ConstantesInfraestructura.ID_PARA_PRUEBA;
		ComandoCliente cliente = new ComandoClienteTestDataBuilder().conNombre(ConstantesInfraestructura.PRUEBA)
				.conEmail(ConstantesInfraestructura.PRUEBA_CORREO).conCiudad(ConstantesInfraestructura.PRUEBA_ID)
				.conTelefono(ConstantesInfraestructura.PRUEBA_TELEFONO).build();

		mocMvc.perform(put(ConstantesInfraestructura.REQUEST_COMANDO_CLIENTE_CON_ID, id)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(cliente)))
				.andExpect(status().isOk());
	}
}
