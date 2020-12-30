package com.ceiba.cita.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.servicio.testdatabuilder.ComandoCitaTestDataBuilder;
import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Clase de pruebas de integracion para el ente ComandoCita
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCita.class)
@Rollback
public class ComandoControladorCitaTest {

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

		ComandoCita cita = new ComandoCitaTestDataBuilder().conCliente(ConstantesInfraestructura.PRUEBA_ID)
				.conFechaHora(LocalDateTime.now().plusDays(1)).conSede(ConstantesInfraestructura.PRUEBA_ID)
				.conServicio(ConstantesInfraestructura.PRUEBA_ID).build();

		mocMvc.perform(post(ConstantesInfraestructura.REQUEST_COMANDO_CITA).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cita))).andExpect(status().isOk())
				.andExpect(content().json(ConstantesInfraestructura.VALOR_TEST_CREAR_CITA));
	}

	/**
	 * Prueba de integracion a la API de actualizar
	 * 
	 * @throws Exception
	 */
	@Test
	public void actualizar() throws Exception {

		Long id = ConstantesInfraestructura.ID_PARA_PRUEBA;
		ComandoCita cita = new ComandoCitaTestDataBuilder().conCliente(ConstantesInfraestructura.PRUEBA_ID)
				.conFechaHora(LocalDateTime.now().plusDays(1)).conSede(ConstantesInfraestructura.PRUEBA_ID)
				.conServicio(ConstantesInfraestructura.PRUEBA_ID).build();

		mocMvc.perform(put(ConstantesInfraestructura.REQUEST_COMANDO_CITA_CON_ID, id)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(cita)))
				.andExpect(status().isOk());
	}
}
