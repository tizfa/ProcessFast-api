package it.cnr.isti.hlt.processfast.utils;

import java.io.Serializable;

/**
 * A generic [value1,value2,value3] triple.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <T1> The type of value1.
 * @param <T2> The type of value2.
 * @param <T3> The type of value3.
 */
public class Triple<T1, T2, T3> implements Serializable {
	
	private static final long serialVersionUID = -6807143587008626934L;
	private final T1 v1;
	private final T2 v2;
	private final T3 v3;
	
	public Triple(T1 v1, T2 v2, T3 v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	
	/**
	 * Get the value1 of this triple.
	 * 
	 * @return The value1 of this triple.
	 */
	public T1 getV1() {
		return v1;
	}
	
	/**
	 * Get the value2 of this triple.
	 * 
	 * @return The value2 of this triple.
	 */
	public T2 getV2() {
		return v2;
	}

	/**
	 * Get the value3 of this triple.
	 * 
	 * @return The value3 of this triple.
	 */
	public T3 getV3() {
		return v3;
	}
}
