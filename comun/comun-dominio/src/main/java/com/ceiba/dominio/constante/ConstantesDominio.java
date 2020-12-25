package com.ceiba.dominio.constante;

/**
 * Clase con constantes para usarse en el modulo de dominio
 * 
 * @author jefferson.rios, empresa CEIBA Software
 *
 */
public class ConstantesDominio {

	/**
	 * Constante estatica con el valor = El cliente ya existe en el sistema.
	 */
	public static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema.";

	/**
	 * Constante estatica con el valor = El parametro ya existe en el sistema.
	 */
	public static final String EL_PARAMETRO_YA_EXISTE_EN_EL_SISTEMA = "El parametro ya existe en el sistema.";

	/**
	 * Constante estatica con el valor = Ya existe una cita en el horario
	 * especificado.
	 */
	public static final String YA_EXISTE_CITA_EN_EL_HORARIO = "Ya existe una cita en el horario especificado.";

	/**
	 * Constante estatica con el valor = Pero fue lanzada.
	 */
	public static final String PERO_FUE_LANZADA = " Pero fue lanzada ";

	/**
	 * Constante estatica con el valor = Se esperaba la excepcion
	 */
	public static final String SE_ESPERABA_LA_EXCEPCION = "Se esperaba la excepcion ";

	/**
	 * Constante estatica con el valor = Prueba
	 */
	public static final String PRUEBA = "prueba@mail.com";

	/**
	 * Constante estatica con el valor = Se esperaba la excepcion
	 */
	public static final String PRUEBA_CORREO = "prueba@mail.com";

	/**
	 * Constante estatica con el valor = Se esperaba la excepcion
	 */
	public static final String PRUEBA_TELEFONO = "3101111111";

	/**
	 * Constante estatica con el valor = Se debe especificar el nombre del cliente.
	 */
	public static final String OBLIGATORIO_NOMBRE_CLIENTE = "Se debe especificar el nombre del cliente.";

	/**
	 * Constante estatica con el valor = Se debe especificar el nombre del
	 * parametro.
	 */
	public static final String OBLIGATORIO_NOMBRE_PARAMETRO = "Se debe especificar el nombre del parametro.";

	/**
	 * Constante estatica con el valor = Se debe especificar el tipo del parametro.
	 */
	public static final String OBLIGATORIO_TIPO_PARAMETRO = "Se debe especificar el tipo del parametro.";

	/**
	 * Constante estatica con el valor = Se debe especificar el email del cliente.
	 */
	public static final String OBLIGATORIO_EMAIL_CLIENTE = "Se debe especificar el email del cliente.";

	/**
	 * Constante estatica con el valor = Se debe especificar el telefono del
	 * cliente.
	 */
	public static final String OBLIGATORIO_TELEFONO_CLIENTE = "Se debe especificar el tel\u00E9fono del cliente.";

	/**
	 * Constante estatica con el valor = Se debe especificar el identificador de la
	 * ciudad del cliente.
	 */
	public static final String OBLIGATORIO_CIUDAD_CLIENTE = "Se debe especificar el identificador de la ciudad del cliente.";

	/**
	 * Constante estatica con el valor = Se debe especificar el identificador del
	 * servicio.
	 */
	public static final String OBLIGATORIO_SERVICIO_CITA = "Se debe especificar el identificador del servicio.";

	/**
	 * Constante estatica con el valor = Se debe especificar la fecha y hora de la
	 * cita.
	 */
	public static final String OBLIGATORIO_FECHA_HORA_CITA = "Se debe especificar la fecha y hora de la cita.";

	/**
	 * Constante estatica con el valor = Se debe especificar el identificador de la
	 * sede de la cita.
	 */
	public static final String OBLIGATORIO_SEDE_CITA = "Se debe especificar el identificador de la sede de la cita.";

	/**
	 * Constante estatica con el valor = Se debe especificar el identificador del
	 * cliente de la cita.
	 */
	public static final String OBLIGATORIO_CLIENTE_CITA = "Se debe especificar el identificador del cliente de la cita.";

	/**
	 * Constante estatica con el valor =
	 * ^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$
	 */
	public static final String REGEX_VALIDADOR_EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

	/**
	 * Constante estatica con el valor = Debe especificar un email v\u00E1lido.
	 */
	public static final String FORMATO_EMAIL_INCORRECTO = "Debe especificar un email v\u00E1lido.";

	/**
	 * Constante estatica con el valor = 1L
	 */
	public static final Long PRUEBA_ID = 1L;

	/**
	 * Constante estatica con el valor entero 1
	 */
	public static final Integer PRUEBA_CANTIDAD = 1;

	/**
	 * Constante estatica con el valor entero 0
	 */
	public static final Integer PRUEBA_CANTIDAD_CERO = 0;

	/**
	 * Constante estatica con el valor = 10
	 */
	public static final String PRUEBA_PORCENTAJE = "10";

	/**
	 * Constante estatica con el valor = 10
	 */
	public static final Double PRUEBA_PORCENTAJE_DOUBLE = 10.0;

	/**
	 * Constructor general
	 */
	private ConstantesDominio() {
		super();
	}
}
