package com.ceiba.parametro.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.parametro.comando.ComandoParametro;
import com.ceiba.parametro.comando.fabrica.FabricaParametro;
import com.ceiba.parametro.modelo.entidad.Parametro;
import com.ceiba.parametro.servicio.ServicioActualizarParametro;

/**
 * Permite hacer las veces de puente entre el servicio y la fabrica de los
 * parametros
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorActualizarParametro implements ManejadorComando<ComandoParametro> {

	/**
	 * Inyeccion de la fabrica relacionada
	 */
	private final FabricaParametro fabricaParametro;

	/**
	 * Inyeccion del servicio relacionado
	 */
	private final ServicioActualizarParametro servicioActualizarParametro;

	/**
	 * Constructor de la clase
	 * 
	 * @param fabricaParametro,            el valor de la propiedad
	 * @param servicioActualizarParametro, el valor de la propiedad
	 */
	public ManejadorActualizarParametro(FabricaParametro fabricaParametro,
			ServicioActualizarParametro servicioActualizarParametro) {
		this.fabricaParametro = fabricaParametro;
		this.servicioActualizarParametro = servicioActualizarParametro;
	}

	/**
	 * Permite ejecutar la accion del actualizar
	 */
	public void ejecutar(ComandoParametro comandoParametro) {
		Parametro parametro = this.fabricaParametro.crear(comandoParametro);
		this.servicioActualizarParametro.ejecutar(parametro);
	}
}
