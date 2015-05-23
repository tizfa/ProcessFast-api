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
