package com.ceiba.cita.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.constantes.ConstantesAplicacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.manejador.ManejadorComandoRespuesta;

/**
 * Permite hacer las veces de puente entre el servicio y la fabrica de los
 * clientes
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorCrearCita implements ManejadorComandoRespuesta<ComandoCita, ComandoRespuesta<Long>> {

	/**
	 * Inyeccion de la fabrica relacionada
	 */
	private final FabricaCita fabricaCita;

	/**
	 * Inyeccion del servicio relacionado
	 */
	private final ServicioCrearCita servicioCrearCita;

	/**
	 * Constructor de la clase
	 * 
	 * @param fabricaCliente,       el valor de la propieda
	 * @param servicioCrearCliente, el valor de la propiedad
	 */
	public ManejadorCrearCita(FabricaCita fabricaCita, ServicioCrearCita servicioCrearCita) {
		this.fabricaCita = fabricaCita;
		this.servicioCrearCita = servicioCrearCita;
	}

	/**
	 * Permite ejecutar la accion del crear y dar una respuesta a traves del comando
	 */
	public ComandoRespuesta<Long> ejecutar(ComandoCita comandoCita) {
		try {
			Cita cita = this.fabricaCita.crear(comandoCita);
			return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita), true,
					ConstantesAplicacion.REGISTRO_CREADO_CORRECTAMENTE);
		} catch (ExcepcionDuplicidad | ExcepcionValorInvalido e) {
			return new ComandoRespuesta<>(null, false, e.getMessage());
		} catch (ExcepcionValorObligatorio e) {
			return new ComandoRespuesta<>(null, false, ConstantesAplicacion.HAY_CAMPOS_POR_DILIGENCIAR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ComandoRespuesta<>(null, false, ConstantesAplicacion.OCURRIO_ERROR_EN_EL_SISTEMA);
		}
	}
}
