package com.ceiba.parametro.controlador;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test para realizar pruebas de integracion a las consultas de los parametros
 * 
 * @author jefferson.rios
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorParametro.class)
public class ConsultaControladorParametroTest {

	@Autowired
	private MockMvc mocMvc;

	/**
	 * Prueba de integracion a la api de listar
	 * 
	 * @throws Exception
	 */
	@Test
	public void listar() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/parametros").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", is(not(empty())))).andExpect(jsonPath("$[0].nombre", is("test")));
	}
}
