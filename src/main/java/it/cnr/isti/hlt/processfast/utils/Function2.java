package it.cnr.isti.hlt.processfast.utils;

/**
 * A generic 2-input parameters function interface.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 * 
 * @param <I1> The input type 1.
 * @param <I2> The input type 2.
 * @param <O> The output type.
 */
public interface Function2<I1, I2,O> {
	/**
	 * Call the function.
	 * 
	 * @param par1 The parameter value 1.
	 * @param par2 The parameter value 2.
	 * @return The output of the function.
	 */
	public O call(I1 par1, I2 par2);
}
