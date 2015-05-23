package it.cnr.isti.hlt.processfast.utils;

/**
 * A generic 0-input parameter function interface.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <O> The output type.
 */
public interface Function0<O> {
	/**
	 * Call the function.
	 * 
	 * @return The output of the function.
	 */
	public O call();
}
