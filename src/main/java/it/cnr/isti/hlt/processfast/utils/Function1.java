package it.cnr.isti.hlt.processfast.utils;

/**
 * A generic 1-input parameter function interface.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <I> The input type.
 * @param <O> The output type.
 */
public interface Function1<I,O> {
	/**
	 * Call the function.
	 * 
	 * @param par The parameter value.
	 * @return The output of the function.
	 */
	public O call(I par);
}
