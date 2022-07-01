package com.pi4j.test.provider;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: TESTING  :: Unit/Integration Tests
 * FILENAME      :  TestI2CProvider.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2021 Pi4J
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

import com.pi4j.io.i2c.I2CProvider;
import com.pi4j.test.provider.impl.TestI2CProviderImpl;

/**
 * <p>TestI2CProvider interface.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public interface TestI2CProvider extends I2CProvider {
    /**
     * <p>newInstance.</p>
     *
     * @return a {@link com.pi4j.test.provider.TestI2CProvider} object.
     */
    static TestI2CProvider newInstance(){
        return new TestI2CProviderImpl();
    }
    /**
     * <p>newInstance.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @return a {@link com.pi4j.test.provider.TestI2CProvider} object.
     */
    static TestI2CProvider newInstance(String id){
        return new TestI2CProviderImpl(id);
    }
    /**
     * <p>newInstance.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @param name a {@link java.lang.String} object.
     * @return a {@link com.pi4j.test.provider.TestI2CProvider} object.
     */
    static TestI2CProvider newInstance(String id, String name){
        return new TestI2CProviderImpl(id, name);
    }
}
