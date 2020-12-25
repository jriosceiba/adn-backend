package com.ceiba.cita.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.manejador.ManejadorComando;

/**
 * Permite hacer las veces de puente entre el servicio y la fabrica de las citas
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class ManejadorActualizarCita implements ManejadorComando<ComandoCita> {

	/**
	 * Inyeccion de la fabrica relacionada
	 */
	private final FabricaCita fabricaCita;

	/**
	 * Inyeccion del servicio relacionado
	 */
	private final ServicioActualizarCita servicioActualizarCita;

	/**
	 * Constructor de la clase
	 * 
	 * @param fabricaCita,            el valor de la propiedad
	 * @param servicioActualizarCita, el valor de la propiedad
	 */
	public ManejadorActualizarCita(FabricaCita fabricaCita, ServicioActualizarCita servicioActualizarCita) {
		this.fabricaCita = fabricaCita;
		this.servicioActualizarCita = servicioActualizarCita;
	}

	/**
	 * Permite ejecutar la accion del actualizar
	 * 
	 * @param comandoCita, el valor de la propiedad
	 */
	public void ejecutar(ComandoCita comandoCita) {
		Cita cita = this.fabricaCita.crear(comandoCita);
		this.servicioActualizarCita.ejecutar(cita);
	}
}
