package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.connector.ConnectorManager;
import it.cnr.isti.hlt.processfast.data.ReadableDictionary;

/**
 * Information to be used with {@link TaskDescriptor#withConnectors}
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface WithBarrierInfo extends TaskIdentifier {

    /**
     * Get the data dictionary specific for a given instance of a task. The data
     * passed to each task instance is specified by using method
     * {@link RunnableDescriptor#withDataDictionary(it.cnr.isti.hlt.processfast.data.Dictionary, it.cnr.isti.hlt.processfast.utils.Function2)}.
     *
     * @return The data dictionary.
     */
    ReadableDictionary getDataDictionary();
}
