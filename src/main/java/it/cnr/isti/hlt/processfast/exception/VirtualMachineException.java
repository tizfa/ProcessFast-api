package it.cnr.isti.hlt.processfast.exception;

import java.util.List;

/**
 * An exception occurred when one or more logical virtual machines
 * died unexpectedly.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface VirtualMachineException {
	/**
	 * Get the list of virtual machines died unexpectedly.
	 * 
	 * @return The list of virtual machines died unexpectedly.
	 */
	List<String> getVMs();
	
	
	
	/**
	 * Get the throwable which describes the exception occurred. 
	 * 
	 * @return The throwable which describes the exception occurred. 
	 */
	Throwable getCausingThrowable();
}
