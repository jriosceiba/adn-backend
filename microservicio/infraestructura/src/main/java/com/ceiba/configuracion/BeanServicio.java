package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.parametro.puerto.dao.DaoParametro;
import com.ceiba.parametro.puerto.repositorio.RepositorioParametro;
import com.ceiba.parametro.servicio.ServicioActualizarParametro;
import com.ceiba.parametro.servicio.ServicioCrearParametro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

/**
 * Clase de configuracion, aqui se registran todos los beans a cargar desde el
 * contexto
 * 
 * @author CEIBA Software
 *
 */
@Configuration
public class BeanServicio {

	/**
	 * Registro del servicio para crear usuarios en el contexto
	 * 
	 * @param repositorioUsuario, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	/**
	 * Registro del servicio para eliminar usuarios en el contexto
	 * 
	 * @param repositorioUsuario, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioEliminarUsuario(repositorioUsuario);
	}

	/**
	 * Registro del servicio para actualizar usuarios en el contexto
	 * 
	 * @param repositorioUsuario, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioActualizarUsuario(repositorioUsuario);
	}

	/**
	 * Registro del servicio para crear parametros en el contexto
	 * 
	 * @param repositorioParametro, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioCrearParametro servicioCrearParametro(RepositorioParametro repositorioParametro) {
		return new ServicioCrearParametro(repositorioParametro);
	}

	/**
	 * Registro del servicio para actualizar parametros en el contexto
	 * 
	 * @param repositorioCita, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioActualizarParametro servicioActualizarParametro(RepositorioParametro repositorioParametro) {
		return new ServicioActualizarParametro(repositorioParametro);
	}
	
	/**
	 * Registro del servicio para crear usuarios en el contexto
	 * 
	 * @param repositorioCliente, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
		return new ServicioCrearCliente(repositorioCliente);
	}

	/**
	 * Registro del servicio para actualizar usuarios en el contexto
	 * 
	 * @param repositorioCliente
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
		return new ServicioActualizarCliente(repositorioCliente);
	}
	
	/**
	 * Registro del servicio para crear citas en el contexto
	 * 
	 * @param repositorioCita, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita, DaoParametro daoParametro, DaoCita daoCita,
			DaoCliente daoCliente) {
		return new ServicioCrearCita(repositorioCita, daoParametro, daoCita, daoCliente);
	}

	/**
	 * Registro del servicio para actualizar citas en el contexto
	 * 
	 * @param repositorioCita, repositorio asociado
	 * @return el servicio instanciado
	 */
	@Bean
	public ServicioActualizarCita servicioActualizarCita(RepositorioCita repositorioCita) {
		return new ServicioActualizarCita(repositorioCita);
	}
}
