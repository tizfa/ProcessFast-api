package it.cnr.isti.hlt.processfast.utils;

/**
 * A generic 1-input parameters procedure interface.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 * 
 * @param <I1> The input type 1.
 */
public interface Procedure1<I1> {
	/**
	 * Call the function.
	 * 
	 * @param par1 The parameter value 1.
	 */
	public void call(I1 par1);
}
