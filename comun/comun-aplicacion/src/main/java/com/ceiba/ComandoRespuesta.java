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
	 * Estado de la respuesta
	 */
	private boolean ok;

	/**
	 * Mensaje a tener en cuenta
	 */
	private String mensaje;

	/**
	 * Contructor de la clase
	 * 
	 * @param valor
	 * @param ok
	 * @param mensaje
	 */
	public ComandoRespuesta(T valor, boolean ok, String mensaje) {
		this.valor = valor;
		this.ok = ok;
		this.mensaje = mensaje;
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

	/**
	 * @return the ok
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * @param ok the ok to set
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
