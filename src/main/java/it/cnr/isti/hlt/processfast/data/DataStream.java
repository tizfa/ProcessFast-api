package it.cnr.isti.hlt.processfast.data;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * A container of data streams.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface DataStream {

	/**
	 * Get the data stream name.
	 *
	 * @return The data stream name.
	 */
	String getName();

	/**
	 * Get an input stream for the specified named resource. It is
	 * responsibility of the caller to close the returned input stream when he
	 * has finished using it.
	 *
	 * @param resourceName
	 *            The named resource to access.
	 * @return The input stream for the specified resource.
	 *
	 */
	public InputStream getInputStreamForResource(String resourceName);

	/**
	 * Get an output stream for the specified named resource. It is
	 * responsibility of the caller to close the returned output stream when he
	 * has finished using it. If the resource with the specified name does not
	 * exist, it will be created. If the requested resource already exists, it
	 * will be overwritten.
	 *
	 * @param resourceName
	 *            The named resource to access.
	 * @return The output stream for the specified resource.
	 */
	public OutputStream getOutputStreamForResource(String resourceName);

	/**
	 * Delete the specified named resource from this storage manager.
	 *
	 * @param resourceName
	 *            The resource to delete.
	 *
	 *
	 */
	public void deleteResource(String resourceName);

	/**
	 * Delete all declared resources from this storage manager.
	 *
	 * @throws IllegalStateException
	 *             Raised if the storage manager is not open.
	 */
	public void deleteAllResources();
}
