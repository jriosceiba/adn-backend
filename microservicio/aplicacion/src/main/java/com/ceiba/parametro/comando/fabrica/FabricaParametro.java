package com.ceiba.parametro.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.parametro.comando.ComandoParametro;
import com.ceiba.parametro.modelo.entidad.Parametro;

/**
 * Clase que permite la creacion de un parametro a partir de su comando
 * equivalente
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
@Component
public class FabricaParametro {

	/**
	 * Permite instanciar un objeto parametro, a pertir de los datos siminstrados
	 * por el comando
	 * 
	 * @param comandoParametro, contenedor de los datos
	 * @return el parametro creado
	 */
	public Parametro crear(ComandoParametro comandoParametro) {
		return new Parametro(comandoParametro.getId(), comandoParametro.getNombre(), comandoParametro.getValor(),
				comandoParametro.getTipoParametro());
	}
}
