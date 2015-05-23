package it.cnr.isti.hlt.processfast.core;

import java.io.Serializable;

/**
 * A generic asynchronous task.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface Task extends Serializable {
	
	/**
	 * Define the body task to be executed.
	 * 
	 * @param ctx The task context.
	 */
	void exec(TaskContext ctx);
}
