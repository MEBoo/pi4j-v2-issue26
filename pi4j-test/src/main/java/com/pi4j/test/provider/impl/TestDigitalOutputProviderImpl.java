package com.pi4j.test.provider.impl;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: TESTING  :: Unit/Integration Tests
 * FILENAME      :  TestDigitalOutputProviderImpl.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfig;
import com.pi4j.io.gpio.digital.DigitalOutputProviderBase;
import com.pi4j.test.provider.TestDigitalOutput;
import com.pi4j.test.provider.TestDigitalOutputProvider;

/**
 * <p>TestDigitalOutputProviderImpl class.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public class TestDigitalOutputProviderImpl extends DigitalOutputProviderBase implements TestDigitalOutputProvider {

    /**
     * <p>Constructor for TestAnalogOutputProviderImpl.</p>
     */
    public TestDigitalOutputProviderImpl(){ super(); }

    /**
     * <p>Constructor for TestAnalogOutputProviderImpl.</p>
     *
     * @param id a {@link String} object.
     */
    public TestDigitalOutputProviderImpl(String id){
        super(id);
    }

    /**
     * <p>Constructor for TestAnalogOutputProviderImpl.</p>
     *
     * @param id a {@link String} object.
     * @param name a {@link String} object.
     */
    public TestDigitalOutputProviderImpl(String id, String name){
        super(id, name);
    }

    /** {@inheritDoc} */
    @Override
    public DigitalOutput create(DigitalOutputConfig config) {
        return new TestDigitalOutput(this, config);
    }
}
