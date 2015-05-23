/*
 * *****************
 *  Copyright 2015 Tiziano Fagni (tiziano.fagni@isti.cnr.it)
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
 * *******************
 */

package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.Dictionary;
import it.cnr.isti.hlt.processfast.data.StorageManager;

/**
 * Information to be used with {@link RunnableDescriptor#onFailure(it.cnr.isti.hlt.processfast.utils.Function1)}.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public interface FailureInfo extends TaskIdentifier {


    /**
     * Get the log manager provided by the system.
     *
     * @return The log manager provided by the system.
     */
    LogManager getLogManager();


    /**
     * Get the storage manager available in the running system.
     *
     * @return The storage manager available in the running system.
     */
    StorageManager getStorageManager();

    /**
     * Get the private data dictionary used to this runnable.
     *
     * @return The data dictionary.
     */
    Dictionary getDataDictionary();
}
