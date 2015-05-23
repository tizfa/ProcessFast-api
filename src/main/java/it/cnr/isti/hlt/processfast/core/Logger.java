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


/**
 * A generic logger interface.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface Logger {
    /**
     * Log the specified INFO message.
     *
     * @param msg The message to be logged.
     */
    void info(String msg);


    /**
     * Log the specified INFO message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void info(String msg, Throwable t);

    /**
     * Log the specified WARNING message.
     *
     * @param msg The message to be logged.
     */
    void warning(String msg);

    /**
     * Log the specified WARNING message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void warning(String msg, Throwable t);


    /**
     * Log the specified ERROR message.
     *
     * @param msg The message to be logged.
     */
    void error(String msg);


    /**
     * Log the specified ERROR message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void error(String msg, Throwable t);


    /**
     * Log the specified DEBUG message.
     *
     * @param msg The message to be logged.
     */
    void debug(String msg);


    /**
     * Log the specified DEBUG message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void debug(String msg, Throwable t);


    /**
     * Set the log level of the logger (see {@link LogLevel}
     * for more details about levels).
     *
     * @param level The level to be set.
     */
    void setLogLevel(LogLevel level);


    /**
     * Get the current log level.
     *
     * @return The current log level.
     */
    LogLevel getLogLevel();
}
