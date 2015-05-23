package it.cnr.isti.hlt.processfast.utils;

/**
 * A generic 4-input parameters procedure interface.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 * 
 * @param <I1> The input type 1.
 * @param <I2> The input type 2.
 * @param <I3> The input type 3.
 * @param <I4> The input type 4.
 */
public interface Procedure4<I1, I2, I3, I4> {
	/**
	 * Call the function.
	 * 
	 * @param par1 The parameter value 1.
	 * @param par2 The parameter value 2.
	 * @param par3 The parameter value 3.
	 * @param par4 The parameter value 4.
	 */
	public void call(I1 par1, I2 par2, I3 par3, I4 par4);
}
