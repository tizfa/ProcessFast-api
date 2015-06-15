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

import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * A log manager based on SLF4J logging framework. The
 * implementation is thread-safe.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class SLF4JLogManager implements LogManager {

    /**
     * The set of declared loggers.
     */
    private HashMap<String, Logger> declaredLoggers = new HashMap<String, Logger>();

    @Override
    public synchronized Logger getLogger(String loggerName) {
        if (loggerName == null || loggerName.isEmpty())
            throw new IllegalArgumentException("The specified logger name is 'null' or empty");
        if (declaredLoggers.containsKey(loggerName))
            return declaredLoggers.get(loggerName);

        declaredLoggers.put(loggerName, new SLF4JLogger(LoggerFactory.getLogger(loggerName)));
        return declaredLoggers.get(loggerName);
    }

    @Override
    public synchronized void removeLogger(String loggerName) {
        if (loggerName == null || loggerName.isEmpty())
            throw new IllegalArgumentException("The specified logger name is 'null' or empty");
        if (!declaredLoggers.containsKey(loggerName))
            return;
        declaredLoggers.remove(loggerName);
    }
}
