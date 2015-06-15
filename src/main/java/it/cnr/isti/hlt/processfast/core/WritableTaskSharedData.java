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

import it.cnr.isti.hlt.processfast.data.Dictionary;

/**
 * The data shared by a task in a call of a transformation or an action on a
 * partitionable dataset. This interface allow to define which data must share
 * with a transformation or action in a partitionable dataset.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface WritableTaskSharedData {
	/**
	 * Get the data dictionary to share in a transformation or action in
	 * a partitionable dataset.
	 * 
	 * @return The data dictionary to share
	 */
	Dictionary getDataDictionary();
}
