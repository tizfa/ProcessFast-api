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

package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
import java.util.List;


/**
 * A sparse matrix containing items of a specific type.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <T> The type of items stored on the matrix.
 */
public interface Matrix<T extends Serializable> {

	/**
	 * Get the array name.
	 *
	 * @return The array name.
	 */
	String getName();

	/**
	 * Get the number of columns defined in the matrix. A valid column
	 * index value ranges from 0 included to ({@link #getNumCols}-1) included. 
	 * 
	 * @return The number of columns defined in the matrix.
	 */
	long getNumCols();
	
	/**
	 * Get the number of rows defined in the matrix. A valid row
	 * index value ranges from 0 included to ({@link #getNumRows}-1) included.
	 * 
	 * @return The number of rows defined in the matrix.
	 */
	long getNumRows();

	/**
	 * Resize the matrix to the specified number of rows and cols. The matrix will be reset and all
	 * the new cells will get as value the value specified in {@link @getDefaultValue} method.
	 * @param numRows The new number of rows in the matrix.
	 */
	void resize(long numRows, long numColumns);




	/**
	 * Get the matrix value stored at specified row and column indexes.
	 * 
	 * @param row The row index.
	 * @param column The column index.
	 * @return The value stored at row and column indexes.
	 */
	T getValue(long row, long column);
	
	
	/**
	 * Set the matrix value at specified row and column indexes. 
	 * 
	 * @param row The row index.
	 * @param column The column index.
	 * @param value The value to store. 
	 */
	void setValue(long row, long column, T value);
	
	
	/**
	 * Set the default value to return when try to accessing an undefined item but with a valid
	 * requested couple index (row,column).
	 * 
	 * @param value The default value to return.
	 */
	void setDefaultValue(T value);
	
	/**
	 * Get the default value returned when try to accessing an undefined item but with a valid
	 * requested couple index (row,column).
	 * 
	 * @return The returned default value.
	 */
	T getDefaultValue();


	/**
	 * Get an iterator over the set of matrix rows. Every read on the iterator read all data available for
	 * that row, so you you must be sure that you have sufficient RAM available for the operation.
	 *
	 * @return The iterator for the rows in the matrix. Each iterator item is a pair which
	 * specify 1) the row index and 2) An iterator provider over the column values for that row.
	 */
	//Iterator<Pair<Long, DataIterable<T>>> asRowIterator();



	/**
	 * Get an iterator over the set of matrix columns. Every read on the iterator read all data available for
	 * that column, so you you must be sure that you have sufficient RAM available for the operation.
	 *
	 * @return The iterator over a specific column in the matrix. Each iterator item is a pair which
	 * specify 1) the column index and 2) An iterator provider for rows values for that column.
	 */
	//Iterator<Pair<Long, DataIterable<T>>> asColumnIterator();


	/**
	 * Get an iterator provider for matrix rows. The provider wraps the method {@link #asRowIterator()}.
	 *
	 * @return An iterator provider for matrix rows.
	 */
	//ImmutableDataSourceIteratorProvider<Pair<Long, DataIterable<T>>> asRowIteratorProvider();


	/**
	 * Get an iterator provider for matrix columns. The provider wraps the method {@link #asColumnIterator()}.
	 *
	 * @return An iterator provider for matrix columns.
	 */
	//ImmutableDataSourceIteratorProvider<Pair<Long, DataIterable<T>>> asColumnIteratorProvider();


	/**
	 * Get from the specified row in the matrix the values contained in the columns [startCol, endCol).
	 *
	 * @param row The row index.
	 * @param startCol The included start column.
	 * @param endCol The excluded end column.
	 * @return The set of read values.
	 */
	List<T> getRowValues(long row, long startCol, long endCol);


	/**
	 * Get from the specified column in the matrix the values contained in the rows [startRow, endRow).
	 *
	 * @param col The column index.
	 * @param startCol The included start column.
	 * @param endCol The excluded end column.
	 * @return The set of read values.
	 */
	List<T> getColValues(long col, long startCol, long endCol);
	
	
	/**
	 * Enable or disable local cache on the specified block of data in the matrix. The local cache is immediately loaded
	 * or unloaded with requested data.
	 *
	 * @param enabled True to enable cache, false to disable cache.
	 * @param fromRowIndex The included row starting index.
	 * @param toRowIndex The excluded row end index.
	 * @param fromColumnIndex The included column start index.
	 * @param toColumnIndex The excluded column end index.
	 */
	void enableLocalCache(boolean enabled, long fromRowIndex, long toRowIndex, long fromColumnIndex, long toColumnIndex);
	
	/**
	 * Check if the given matrix item is or not local cached.
	 *
	 * @param row The row index.
	 * @param col The column index.
	 * @return True if the specified item is cached, false otherwise.
	 */
	boolean isLocalCacheEnabled(long row, long col);
	
	/**
	 * Flush cached data to destination storage. After this call, the storage
	 * will reflect all changes applied previously in cache. If the matrix does not use
	 * cache then the method will do nothing.
	 */
	void flush();
}
