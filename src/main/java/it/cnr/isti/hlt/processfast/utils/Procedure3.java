package it.cnr.isti.hlt.processfast.utils;

/**
 * A generic 3-input parameters procedure interface.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 * 
 * @param <I1> The input type 1.
 * @param <I2> The input type 2.
 * @param <I3> The input type 3.
 */
public interface Procedure3<I1, I2, I3> {
	/**
	 * Call the function.
	 * 
	 * @param par1 The parameter value 1.
	 * @param par2 The parameter value 2.
	 * @param par3 The parameter value 3.
	 */
	public void call(I1 par1, I2 par2, I3 par3);
}
