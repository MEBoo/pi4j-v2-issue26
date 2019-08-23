package com.pi4j.plugin.pigpio.provider.serial;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PLUGIN   :: PIGPIO I/O Providers
 * FILENAME      :  PiGpioSerial.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
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


import com.pi4j.context.Context;
import com.pi4j.exception.InitializeException;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialBase;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialProvider;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.library.pigpio.PiGpioMode;

import java.io.IOException;

public class PiGpioSerial extends SerialBase implements Serial {

    protected final PiGpio piGpio;
    protected final int handle;

    public PiGpioSerial(PiGpio piGpio, SerialProvider provider, SerialConfig config) throws IOException {
        super(provider, config);

        // set local reference instance
        this.piGpio = piGpio;

        // TODO :: HANDLE SERIAL PIN CONFIG FOR RASPBERRY PI SERIAL PORTS
        if(config.device().endsWith("ttyS0")) {
            // set pin ALT5 modes for SERIAL RX & TX PINS on RPI3B
            piGpio.gpioSetMode(14, PiGpioMode.ALT5);
            piGpio.gpioSetMode(15, PiGpioMode.ALT5);
        }

        // create SERIAL instance of PIGPIO SERIAL
        this.handle = piGpio.serOpen(config.device(), config.baud());

        // set open state flag
        this.isOpen = true;
    }

    @Override
    public Serial initialize(Context context) throws InitializeException {
        super.initialize(context);
        return this;
    }

    @Override
    public int available() throws IOException {
        return piGpio.serDataAvailable(this.handle);
    }

    @Override
    public void close() throws IOException {
        piGpio.serClose(this.handle);
        super.close();
    }

    // -------------------------------------------------------------------
    // DEVICE WRITE FUNCTIONS
    // -------------------------------------------------------------------

    @Override
    public int write(byte b) throws IOException {
        return piGpio.serWriteByte(this.handle, b);
    }

    @Override
    public int write(byte[] data, int offset, int length) throws IOException {
        return piGpio.serWrite(this.handle, data, offset, length);
    }


    // -------------------------------------------------------------------
    // RAW DEVICE READ FUNCTIONS
    // -------------------------------------------------------------------

    @Override
    public int read() throws IOException {
        return piGpio.serReadByte(this.handle);
    }

    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        return piGpio.serRead(this.handle, buffer, offset, length);
    }


//    @Override
//    public int read() throws IOException{
//        return piGpio.i2cReadByte(this.handle);
//    }
//
//    @Override
//    public int read(ByteBuffer buffer, int offset, int length) throws IOException{
//        Objects.checkFromIndexSize(offset, length, buffer.capacity());
//        return piGpio.i2cReadDevice(this.handle, buffer, offset, length);
//    }

}
