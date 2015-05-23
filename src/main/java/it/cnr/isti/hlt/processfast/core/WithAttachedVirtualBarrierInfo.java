package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.ReadableDictionary;

/**
 * Information to be used with {@link TaskSetDescriptor#withAttachedVirtualBarriers(it.cnr.isti.hlt.processfast.utils.Function1)}.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface WithAttachedVirtualBarrierInfo extends TaskIdentifier {

    /**
     * Get the data dictionary specific for a given instance of a task. The data
     * passed to each task instance is specified by using method
     * {@link RunnableDescriptor#withDataDictionary(it.cnr.isti.hlt.processfast.data.Dictionary, it.cnr.isti.hlt.processfast.utils.Function1)}.
     *
     * @return The data dictionary.
     */
    ReadableDictionary getDataDictionary();
}
