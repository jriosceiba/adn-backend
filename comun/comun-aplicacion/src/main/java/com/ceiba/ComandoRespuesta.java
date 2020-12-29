package com.ceiba;

/**
 * Comando de respuestas para los end points que contienen retorno
 * 
 * @author CEIBA Software
 * @author jefferson.rios
 *
 * @param <T>, cual clase representativa de un objeto
 */
public class ComandoRespuesta<T> {

	/**
	 * Valor u objeto retornado
	 */
	private T valor;

	/**
	 * Contructor de la clase
	 * 
	 * @param valor
	 * @param ok
	 * @param mensaje
	 */
	public ComandoRespuesta(T valor) {
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public T getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(T valor) {
		this.valor = valor;
	}
}
