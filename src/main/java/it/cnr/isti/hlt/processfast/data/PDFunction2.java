package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.core.TaskDataContext;

/**
 * A generic 2-input parameters function interface to be called on
 * partitionable dataset.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 *
 * @param <In1> The type of 1st parameter.
 * @param <In2> The type of 2nd parameter.
 * @param <Out> The type of function output.
 * 
 * @since 1.0.0
 */
public interface PDFunction2<In1, In2,Out> {
	
	/**
	 * Call the function.
	 * 
	 * @param ctx The task context where the function is called.
	 * @param par1 The first parameter of the function.
	 * @param par2 The second parameter of the function.
	 * @return The corresponding output.
	 */
	Out call(TaskDataContext ctx, In1 par1, In2 par2);
}
