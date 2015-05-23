package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
import java.util.List;


/**
 * A generic storage interface.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface Storage {

    /**
     * Get the storage name.
     * @return The storage name.
     */
    String getName();

    /**
	 * Get the list of names of arrays defined in this storage.
	 *
	 * @return The list of names of arrays defined in this storage.
	 */
	List<String> getArrayNames();
	
	/**
	 * Indicate if the array with the given name is or not available in this storage.
	 *
	 * @param name The name of the array.
	 * @return True if the array is available, false otherwise.
	 */
	boolean containsArrayName(String name);
	
	
	/**
	 * Create the array with the given name. If an array with this name already exists, the
	 * method will return it.
	 * 
	 * @param name The name of the array to create.
	 * @param cl The class type of the items stored on the array.
	 * @return The corresponding array.
	 */
	public <T extends Serializable> Array<T> createArray(String name, Class<T> cl);
	
	
	/**
	 * Remove the array with the given name. If the specified array does not exist, the method
	 * does nothing.
	 *
	 * @param name The array name to be removed.
	 */
	public void removeArray(String name);
	
	
	/**
	 * Get the array specified by given name.
	 *
	 * @param name The name of the array to be retrieved.
	 * @param name The type of items stored in the array.
	 * @return The requested array, or 'null' if the array can not be retrieved.
	 */
	public <T extends Serializable> Array<T> getArray(String name, Class<T> cl);
	
	
	
	/**
	 * Get the list of names of matrixes defined in this storage.
	 *
	 * @return The list of names of matrixes defined in this storage.
	 */
	List<String> getMatrixNames();
	
	/**
	 * Indicate if the matrix with the given name is or not available in this storage.
	 *
	 * @param name The name of the matrix.
	 * @return True if the matrix is available, false otherwise.
	 */
	boolean containsMatrixName(String name);
	
	/**
	 * Create a new matrix with the specified name, type and dimensions. If a
	 * matrix with this name already exists, the
	 * method will return it.
	 * @param name The name of the matrix.
	 * @param cl The class type of the items stored in the matrix.
	 * @param numRows The number of rows in the matrix.
	 * @param numCols The number of columns in the matrix.
	 * @return The corresponding matrix.
	 */
	public <T extends Serializable> Matrix<T> createMatrix(String name, Class<T> cl, long numRows, long numCols);
	
	
	/**
	 * Remove the matrix with the given name. If the specified matrix does not exist, the method
	 * does nothing.
	 *
	 * @param name The matrix name to be removed.
	 */
	public void removeMatrix(String name);
	
	
	/**
	 * Get the matrix specified by given name.
	 *
	 * @param name The name of the matrix to be retrieved.
	 * @param cl The type of items stored in the matrix.
	 * @return The requested matrix, or 'null' if the array can not be retrieved.
	 */
	public <T extends Serializable> Matrix<T> getMatrix(String name, Class<T> cl);
	
	
	/**
	 * Get the set of created dictionaries.
	 * 
	 * @return The set of created dictionaries. 
	 */
	List<String> getDictionaryNames();
	
	
	/**
	 * Check if a dictionary with the specified name is existent
	 * on this storage.
	 * 
	 * @param name The name of the dictionary to check.
	 * @return True if the requested dictionary exists, false otherwise.
	 */
	boolean containsDictionaryName(String name);
	
	
	/**
	 * Create a new dictionary. If the requested dictionary already exists, the method
	 * will return it.
	 * 
	 * @param name The name of dictionary.
	 * @return The corresponding dictionary.
	 */
	public Dictionary createDictionary(String name);
	
	
	/**
	 * Remove the dictionary with the specified name.
	 * 
	 * @param name The name of dictionary to remove.
	 */
	public void removeDictionary(String name);
	
	
	/**
	 * Get the dictionary with the given name.
	 * 
	 * @param name The name of the dictionary to get.
	 * @return The corresponding dictionary.
	 */
	public Dictionary getDictionary(String name);
	
	
	/**
	 * Get the set of declared data streams.
	 * 
	 * @return The set of declared data streams.
	 */
	List<String> getDataStreamNames();
	
	
	/**
	 * Check if the specified data stream exists.
	 * 
	 * @param name The name of data stream.
	 * @return True if the requested data stream is contained on
	 * this storage, false otherwise.
	 */
	boolean containsDataStreamName(String name);
	
	/**
	 * Create a new data stream. If the requested data stream already exists, the method
	 * will return it.
	 * 
	 * @param name The name of data stream to create.
	 * @return The corresponding data stream.
	 */
	public DataStream createDataStream(String name);
	
	/**
	 * Remove a data stream from storage.
	 * 
	 * @param name The name of data stream to remove.
	 */
	public void removeDataStream(String name);
	
	
	/**
	 * Get a specific data stream.
	 * 
	 * @param name The name of data stream to retrieve.
	 * @return The corresponding data stream.
	 */
	public DataStream getDataStream(String name);
	
	
	
	
	/**
	 * Flush the data of all contained data structures, eventually stored locally in memory, to 
	 * the destination storage.
	 */
	public void flushData();
}
