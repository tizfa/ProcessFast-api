package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.Dictionary;
import it.cnr.isti.hlt.processfast.data.ReadableDictionary;

/**
 * Information to be used with {@link it.cnr.isti.hlt.processfast.core.RunnableDescriptor#withDataDictionary(it.cnr.isti.hlt.processfast.data.Dictionary, it.cnr.isti.hlt.processfast.utils.Function1)}.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public interface WithDataDictionaryInfo extends TaskIdentifier {

    /**
     * Get the data dictionary passed from the declaring tasks set.
     *
     * @return The data dictionary.
     */
    Dictionary getDataDictionary();
}
