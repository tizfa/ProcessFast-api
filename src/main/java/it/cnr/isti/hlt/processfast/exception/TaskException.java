package it.cnr.isti.hlt.processfast.exception;

/**
 * An exception thrown by a specific task.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface TaskException {
	/**
	 * Get the task name that has thrown the exception.
	 * 
	 * @return The task name.
	 */
	String getTaskName();
	
	/**
	 * Get more details about this exception.
	 * 
	 * @return The details about this exception.
	 */
	String getMessage();
	
	
	/**
	 * Get the throwable which describes the exception occurred. 
	 * 
	 * @return The throwable which describes the exception occurred. 
	 */
	Throwable getCausingThrowable();

    /**
     *  Get the virtual machine name where the task was running.
     *
     * @return The virtual machine name where the task was running.
     */
    String getVirtualMachineName();
}
