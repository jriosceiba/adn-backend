package com.ceiba;

import static org.junit.Assert.fail;

import java.util.function.Supplier;

import org.junit.Assert;

import com.ceiba.dominio.constantes.ConstantesDominio;

/**
 * Clase base para realizar pruebas unitarias
 * 
 * @author CEIBA Software
 */
public class BasePrueba {

	/**
	 * Comparacion a traves de un objeto recibido desde el proveedor
	 * 
	 * @param <T>
	 * @param supplier
	 * @param exception
	 * @param message
	 */
	public static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
		try {
			supplier.get();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(
					ConstantesDominio.SE_ESPERABA_LA_EXCEPCION + exception.getCanonicalName()
							+ ConstantesDominio.PERO_FUE_LANZADA + e.getClass().getCanonicalName(),
					exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	/**
	 * Comparacion a traves de una llamada a una subrutina o metodo
	 * 
	 * @param thunk
	 * @param exception
	 * @param message
	 */
	public static void assertThrows(Thunk thunk, Class<? extends Exception> exception, String message) {
		try {
			thunk.execute();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(
					ConstantesDominio.SE_ESPERABA_LA_EXCEPCION + exception.getCanonicalName()
							+ ConstantesDominio.PERO_FUE_LANZADA + e.getClass().getCanonicalName(),
					exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	/**
	 * Encargada de ejecutar la subrutina
	 *
	 */
	@FunctionalInterface
	public interface Thunk {
		void execute();
	}

}
