package it.cnr.isti.hlt.processfast.core;

/**
 * An enumeration indicating the possible set of actions
 * the system could handle in relation to a task or tasks set
 * hardware failure.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public enum HardwareFailureAction {
    /**
     * Ask to the system to terminate the application.
     */
    APPLICATION_TERMINATION,

    /**
     * Ask to the system to forward the decision to take to the parent tasks set  of this task
     * or tasks set.
     */
    ASK_PARENT,

    /**
     * Ask to the system to restart from start the considered task or tasks set. The task or tasks set will
     * be restarted with the same message to process as when the task has been crashed.
     */
    RESTART_TASK,

    /**
     * Ask to the system to restart from start the parent tasks set of this task or tasks set. The tasks set will
     * be restarted with the same message to process as when the failure occurred.
     */
    RESTART_TASKS_SET,

    /**
     * Ask to the system to restart the application from start.
     */
    APPLICATION_RESTART
}
