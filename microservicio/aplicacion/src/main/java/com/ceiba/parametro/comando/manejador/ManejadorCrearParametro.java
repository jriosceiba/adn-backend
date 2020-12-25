package com.ceiba.parametro.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.constantes.ConstantesAplicacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.parametro.comando.ComandoParametro;
import com.ceiba.parametro.comando.fabrica.FabricaParametro;
import com.ceiba.parametro.modelo.entidad.Parametro;
import com.ceiba.parametro.servicio.ServicioCrearParametro;

/**
 * Permite hacer las veces de puente entre el servicio y la fabrica de los
 * parametros
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorCrearParametro implements ManejadorComandoRespuesta<ComandoParametro, ComandoRespuesta<Long>> {

	/**
	 * Inyeccion de la fabrica relacionada
	 */
	private final FabricaParametro fabricaParametro;

	/**
	 * Inyeccion del servicio relacionado
	 */
	private final ServicioCrearParametro servicioCrearParametro;

	/**
	 * Constructor de la clase
	 * 
	 * @param fabricaParametro,       el valor de la propieda
	 * @param servicioCrearParametro, el valor de la propiedad
	 */
	public ManejadorCrearParametro(FabricaParametro fabricaParametro, ServicioCrearParametro servicioCrearParametro) {
		this.fabricaParametro = fabricaParametro;
		this.servicioCrearParametro = servicioCrearParametro;
	}

	/**
	 * Permite ejecutar la accion del crear y dar una respuesta a traves del comando
	 */
	public ComandoRespuesta<Long> ejecutar(ComandoParametro comandoParametro) {
		Parametro parametro = this.fabricaParametro.crear(comandoParametro);
		try {
			return new ComandoRespuesta<>(this.servicioCrearParametro.ejecutar(parametro), true,
					ConstantesAplicacion.REGISTRO_CREADO_CORRECTAMENTE);
		} catch (ExcepcionDuplicidad e) {
			return new ComandoRespuesta<>(null, false, e.getMessage());
		} catch (ExcepcionValorObligatorio e) {
			return new ComandoRespuesta<>(null, false, ConstantesAplicacion.HAY_CAMPOS_POR_DILIGENCIAR);
		} catch (Exception e) {
			return new ComandoRespuesta<>(null, false, ConstantesAplicacion.OCURRIO_ERROR_EN_EL_SISTEMA);
		}
	}
}
