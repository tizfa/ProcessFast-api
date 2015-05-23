package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.ReadableDictionary;

/**
 * Information to be used with {@link TaskSetDescriptor#withAttachedVirtualConnectors(it.cnr.isti.hlt.processfast.utils.Function2)}
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface WithAttachedVirtualConnectorInfo extends TaskIdentifier {

    /**
     * Get the data dictionary specific for a given instance of a task. The data
     * passed to each task instance is specified by using method
     * {@link it.cnr.isti.hlt.processfast.core.RunnableDescriptor#withDataDictionary(it.cnr.isti.hlt.processfast.data.Dictionary, it.cnr.isti.hlt.processfast.utils.Function1)}.
     *
     * @return The data dictionary.
     */
    ReadableDictionary getDataDictionary();
}
