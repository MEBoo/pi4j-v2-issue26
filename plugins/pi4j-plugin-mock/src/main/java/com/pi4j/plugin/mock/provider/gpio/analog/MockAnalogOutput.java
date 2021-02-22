package com.pi4j.plugin.mock.provider.gpio.analog;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PLUGIN   :: Mock Platform & Providers
 * FILENAME      :  MockAnalogOutput.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2021 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */


import com.pi4j.io.exception.IOBoundsException;
import com.pi4j.io.exception.IOIllegalValueException;
import com.pi4j.io.gpio.analog.AnalogOutput;
import com.pi4j.io.gpio.analog.AnalogOutputBase;
import com.pi4j.io.gpio.analog.AnalogOutputConfig;
import com.pi4j.io.gpio.analog.AnalogOutputProvider;

/**
 * <p>MockAnalogOutput class.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public class MockAnalogOutput extends AnalogOutputBase implements AnalogOutput {

    /**
     * <p>Constructor for MockAnalogOutput.</p>
     *
     * @param provider a {@link com.pi4j.io.gpio.analog.AnalogOutputProvider} object.
     * @param config a {@link com.pi4j.io.gpio.analog.AnalogOutputConfig} object.
     */
    public MockAnalogOutput(AnalogOutputProvider provider, AnalogOutputConfig config){
        super(provider, config);
    }

    /**
     * <p>mockValue.</p>
     *
     * @param number a {@link java.lang.Number} object.
     * @return a {@link com.pi4j.plugin.mock.provider.gpio.analog.MockAnalogOutput} object.
     */
    public MockAnalogOutput mockValue(Number number){
        try {
            this.value(value);
        } catch (IOIllegalValueException | IOBoundsException e) {
            logger.error(e.getMessage(), e);
        }
        return this;
    }
}
