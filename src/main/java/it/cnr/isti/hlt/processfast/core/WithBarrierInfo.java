/*
 *
 * ****************
 * Copyright 2015 Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ******************
 */

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
