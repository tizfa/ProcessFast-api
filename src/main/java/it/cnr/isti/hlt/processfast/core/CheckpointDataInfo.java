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

import java.util.ArrayList;
import java.util.List;


/**
 * Information on a specific storage part to save during a
 * checkpoint phase.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 */
public class CheckpointDataInfo {

	/**
	 * The storage name.
	 */
	final String storage;
	
	/**
	 * The names of arrays to save.
	 */
	final List<String> arrays;
	
	/**
	 * The names of data streams to save.
	 */
	final List<String> dataStreams;
	
	/**
	 * The names of dictionaries to save.
	 */
	final List<String> dictionaries;
	
	/**
	 * The names of matrixes to save.
	 */
	final List<String> matrixes;
	
	/**
	 * Indicate if all the storage content must be saved or just a part of it.
	 */
	final boolean savingAllStorage;

	public CheckpointDataInfo(String storage) {
		if (storage == null)
			throw new NullPointerException("The storage name is 'null'");
		this.storage = storage;
		this.arrays = new ArrayList<String>();
		this.dataStreams = new ArrayList<String>();
		this.dictionaries = new ArrayList<String>();
		this.matrixes = new ArrayList<String>();
		savingAllStorage = true;
	}


	public CheckpointDataInfo(String storage, List<String> arrays, List<String> dataStreams, List<String> dictionaries, List<String> matrixes) {
		if (storage == null)
			throw new NullPointerException("The storage name is 'null'");
		this.storage = storage;
		this.arrays = new ArrayList<String>(arrays);
		this.dataStreams = new ArrayList<String>(dataStreams);
		this.dictionaries = new ArrayList<String>(dictionaries);
		this.matrixes = new ArrayList<String>(matrixes);
		this.savingAllStorage = false;
	}
}
