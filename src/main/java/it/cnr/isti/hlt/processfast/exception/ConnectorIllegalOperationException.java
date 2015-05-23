package it.cnr.isti.hlt.processfast.exception;

/**
 * An illegal operation has been called on a tasks connector.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class ConnectorIllegalOperationException extends  RuntimeException {

	private static final long serialVersionUID = 3330023728549998673L;

	private final String taskName;
	private final String connectorName;
	
	/**
	 * Build new instance.
	 * 
	 * @param taskName The name of task causing the exception.
	 * @param connectorName The name of the connector involved.
	 * @param msg The message details.
	 */
	public ConnectorIllegalOperationException(String taskName, String connectorName, String msg) {
		super(msg);
		
		this.taskName = taskName;
		this.connectorName = connectorName;
	}

	/**
	 * Get the name of the task causing the exception.
	 * 
	 * @return The name of the task causing the exception.
	 */
	public String getTaskName() {
		return taskName;
	}

	
	/**
	 * Get the name of the connector involved.
	 * 
	 * @return The name of the connector involved.
	 */
	public String getConnectorName() {
		return connectorName;
	}
	
	
}
