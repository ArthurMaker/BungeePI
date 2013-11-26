/*
 * The MIT License
 *
 * Copyright 2013 Goblom.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.goblom.bungee.api.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Goblom
 */
public class ForwardMessage {
    
    private final String server, customChannel;
    
    private final ByteArrayOutputStream msgBytes2Forward;
    private final DataOutputStream msgData2Forward;
    
    public ForwardMessage(String server, String customChannel) {
        this.server = server;
        this.customChannel = customChannel;
        
        msgBytes2Forward = new ByteArrayOutputStream();
        msgData2Forward = new DataOutputStream(msgBytes2Forward);
    }
    
    public String getServer() {
        return server;
    }
    
    public String getChannel() {
        return customChannel;
    }
    
    public ByteArrayOutputStream getBytesToForward() { 
        return msgBytes2Forward; 
    }
    
    public DataOutputStream getDataToForward() { 
        return msgData2Forward; 
    }
    
    public void write(byte[] b) throws IOException { msgData2Forward.write(b); }
    public void write(int b) throws IOException { msgData2Forward.write(b); }
    public void write(byte[] b, int off, int len) throws IOException { msgData2Forward.write(b, off, len); }
    public void writeBoolean(boolean bool) throws IOException { msgData2Forward.writeBoolean(bool); }
    public void writeByte(int v) throws IOException { msgData2Forward.writeByte(v); }
    public void writeBytes(String s) throws IOException { msgData2Forward.writeBytes(s); }
    public void writeChar(int v) throws IOException { msgData2Forward.writeChar(v); }
    public void writeChars(String s) throws IOException { msgData2Forward.writeChars(s); }
    public void writeDouble(double v) throws IOException { msgData2Forward.writeDouble(v); }
    public void writeFloat(float f) throws IOException { msgData2Forward.writeFloat(f); }
    public void writeInt(int v) throws IOException { msgData2Forward.writeInt(v); }
    public void writeLong(long v) throws IOException { msgData2Forward.writeLong(v); }
    public void writeShort(int v) throws IOException { msgData2Forward.writeShort(v); }
    public void writeUTF(String str) throws IOException { msgData2Forward.writeUTF(str); }
}
