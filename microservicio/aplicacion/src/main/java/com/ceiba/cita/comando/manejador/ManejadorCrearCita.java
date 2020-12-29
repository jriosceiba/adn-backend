package com.ceiba.cita.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioCrearCita;
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
		Cita cita = this.fabricaCita.crear(comandoCita);
		return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita));
	}
}
