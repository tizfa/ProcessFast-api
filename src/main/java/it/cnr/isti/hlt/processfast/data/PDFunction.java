package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.core.TaskDataContext;





/**
 * A generic 1-input parameter function interface to be called on partitionable
 * dataset.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 *
 * @param <In> The type of input parameter.
 * @param <Out> The type of function output.
 * @since 1.0.0
 */
public interface PDFunction<In,Out> {
	
	/**
	 * Call the function.
	 * 
	 * @param ctx The task context where the function is called.
	 * @param par1 The parameter of the function.
	 * @return The corresponding output.
	 */
	Out call(TaskDataContext ctx, In par1);
}




