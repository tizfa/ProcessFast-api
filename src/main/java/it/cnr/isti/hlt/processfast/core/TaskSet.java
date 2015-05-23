package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.connector.ConnectorType;
import it.cnr.isti.hlt.processfast.data.Dictionary;
import it.cnr.isti.hlt.processfast.utils.Function1;
import it.cnr.isti.hlt.processfast.utils.Procedure1;

/**
 * This is the definition of a set of tasks which 
 * works together to perform some specific operations.
 * The context on which the defined tasks operate is private to this module. The set of declared 
 * tasks, connectors and barriers are visible only inside this module.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface TaskSet {


    /**
     * Define a new asynchronous task.
     *
     * @param task The task implementation.
     * @return A task descriptor for the defined task.
     */
    TaskDescriptor task(Task task);





    /**
     * Create a new input or output virtual connector.
     * <br/><br/>
     * A virtual connector which can be attached in a second moment to a real
     * physical connector. Useful to provide virtual input and output logical connectors.
     * <br/>
     * For each input virtual connector, the input data wrote on a physical connector linked to the
     * virtual connector is replicated among all readers of the considered virtual connector.
     * For each output virtual connector, the output data wrote on the virtual connector by tasks writers is queued
     * on the physical connector linked to the considered virtual connector.
     *
     * @param name The name of the virtual connector. The name must be unique among all declared connectors and
     * virtual connectors.
     */
    public void createVirtualConnector(String name);



    /**
     * Create a new virtual barrier.
     * <br/><br/>
     * A virtual barrier which can be attached in a second moment to a real
     * physical barrier declared in the parent tasks set. Useful to provide barriers for external point of
     * synchronization.
     *
     * @param name The name of the virtual barrier. The name must be unique among all declared real barriers and
     * virtual barriers.
     */
    public void createVirtualBarrier(String name);



    /**
     * Used to specify to the system which is the default behaviour of the tasks set
     * in cause of abnormal termination due to hardware failure of any of its contained tasks.
     * If the programmer does not specify anything, the default behaviour is
     * to return {@link it.cnr.isti.hlt.processfast.core.HardwareFailureAction#ASK_PARENT}. In case of
     * failure of the main tasks set and with no behaviour specified,
     * the application will be terminated. A specific task created in this tasks set can override the generic
     * behaviour specified by tasks set by providing an implementation of
     * {@link it.cnr.isti.hlt.processfast.core.RunnableDescriptor#onFailure(it.cnr.isti.hlt.processfast.utils.Function1)}.
     *
     *
     * @param func The function which specify to the system what to do when any declared runnable terminates
     *             due to hardware failure.
     */
    void onGenericTaskFailure(Function1<FailureInfo, HardwareFailureAction> func);


	
	/**
	 * Declare a new set of tasks provided by the specified task module.
	 * 
	 * @param taskSet The module containing the new set of tasks to declare.
	 * @return A task module descriptor for the defined task module.
	 */
	TaskSetDescriptor task(TaskSet taskSet);
	
	
	
	
	
	/**
	 * Suggest to the system how much computational resources should be allocated
	 * for tasks parallelism. The priority has a valid range of [0, 1] where 0 means
	 * that the minimum set of required resources will be allocated to tasks parallelism and 1 means
	 * that the maximum sets of available/required resources will be allocated to tasks parallelism. The
	 * resources not reserved for task parallelism will be allocated for data parallelism.
	 * 
	 * @param taskParallelismPriority The task parallelism priority.
	 */
	//public void setTaskParallelismResourcesPriority(double taskParallelismPriority);
	
	
	
	
	/**
	 * Create a data connector to be shared among application tasks. The created stream is
	 * open and ready to accept reads/writes from tasks. The maximum size of the storage connector is limited only
     * by available resources.
	 * 
	 * @param name The name of the connector. The name must be unique among all declared connectors.
	 * @param ctype The type of connector to create.
	 */
	public void createConnector(String name, ConnectorType ctype);


    /**
     * Create a data connector to be shared among application tasks. The created stream is
     * open and ready to accept reads/writes from tasks. The connector, at any time, will store at
     * maximum "maxSize" messages.
     *
     * @param name The name of the connector. The name must be unique among all declared connectors.
     * @param ctype The type of connector to create.
     */
    public void createConnector(String name, ConnectorType ctype, int maxSize);
	
	
	/**
	 * Create a logical barrier used from tasks to synchronize the execution.
	 * 
	 * @param name The name of the barrier. The name must be unique among all declared barriers.
	 */
	public void createBarrier(String name);
	
	
	
	/**
	 * Used to perform some initialization code before launching all defined tasks. The system
	 * will guarantee that the code will be performed sequentially by a single process and before
	 * the execution of all defined tasks.
	 * 
	 * @param func The procedure which will perform some initialization code.
	 */
	public void onTasksSetInitialization(Procedure1<SystemContext> func);
	
	
	/**
	 * Used to perform some cleanup code after all defined tasks have been terminated.
	 * The system
	 * will guarantee that the code will be performed sequentially by a single process and
	 * after all the defined tasks have been terminated.
	 * 
	 * @param func The procedure which will perform some cleanup code.
	 */
	public void onTasksSetTermination(Procedure1<SystemContext> func);
	
	
	/**
	 * Used to pass or return values to/from this tasks set.
	 * 
	 * @return A generic data dictionary.
	 */
	Dictionary getDataDictionary();
}
