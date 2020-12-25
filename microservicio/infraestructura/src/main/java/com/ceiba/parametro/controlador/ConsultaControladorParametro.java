package com.ceiba.parametro.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.infraestructura.constante.ConstantesInfraestructura;
import com.ceiba.parametro.consulta.ManejadorListarParametros;
import com.ceiba.parametro.modelo.dto.DtoParametro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controlador para las consultas relacionadas a los parametros
 * 
 * @author jefferson.rios
 *
 */
@RestController
@RequestMapping(value = ConstantesInfraestructura.REQUEST_COMANDO_PARAMETRO)
@Api(tags = { ConstantesInfraestructura.TAG_CONSULTA_PARAMETRO })
public class ConsultaControladorParametro {

	/**
	 * Inyeccion del manejador para consultas
	 */
	private final ManejadorListarParametros manejadorListarParametros;

	/**
	 * Constructor de la clase
	 * 
	 * @param manejadorListarParametros, el valor de la propiedad
	 */
	@Autowired
	public ConsultaControladorParametro(ManejadorListarParametros manejadorListarParametros) {
		this.manejadorListarParametros = manejadorListarParametros;
	}

	/**
	 * End point para obtener el listado completo de parametros
	 * 
	 * @return el listado de parametros
	 */
	@GetMapping
	@ApiOperation(value = ConstantesInfraestructura.API_LISTAR_PARAMETROS)
	public List<DtoParametro> listar() {
		return this.manejadorListarParametros.ejecutar();
	}

	/**
	 * End point para obtener el listado de parametros por tipo
	 * 
	 * @return el listado de parametros filtrado por tipo
	 */
	@GetMapping(value = ConstantesInfraestructura.API_PARAM_TIPO)
	@ApiOperation(value = ConstantesInfraestructura.API_LISTAR_PARAMETROS)
	public List<DtoParametro> listar(@PathVariable String tipo) {
		return this.manejadorListarParametros.ejecutar(tipo);
	}
}
