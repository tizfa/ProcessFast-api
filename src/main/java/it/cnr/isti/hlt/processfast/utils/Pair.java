package it.cnr.isti.hlt.processfast.utils;

import java.io.Serializable;

/**
 * A generic [value1,value2] pair.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <T1> The type of value1.
 * @param <T2> The type of value2.
 */
public class Pair<T1, T2> implements Serializable {
	
	private static final long serialVersionUID = -6807143587008626934L;
	private final T1 v1;
	private final T2 v2;
	
	public Pair(T1 v1, T2 v2) {
		this.v1 = v1;
		this.v2 = v2;	
	}
	
	/**
	 * Get the value1 of this pair.
	 * 
	 * @return The value1 of this pair.
	 */
	public T1 getV1() {
		return v1;
	}
	
	/**
	 * Get the value2 of this pair.
	 * 
	 * @return The value2 of this pair.
	 */
	public T2 getV2() {
		return v2;
	}

    @Override
    public String toString() {
        return "(V1:"+v1.toString()+", V2:"+v2.toString()+")";
    }
}
