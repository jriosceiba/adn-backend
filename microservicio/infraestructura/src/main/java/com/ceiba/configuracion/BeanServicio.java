package com.ceiba.configuracion;

import com.ceiba.parametro.puerto.repositorio.RepositorioParametro;
import com.ceiba.parametro.servicio.ServicioActualizarParametro;
import com.ceiba.parametro.servicio.ServicioCrearParametro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
