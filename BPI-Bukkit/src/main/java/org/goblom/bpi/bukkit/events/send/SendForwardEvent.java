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

package org.goblom.bpi.bukkit.events.send;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import org.goblom.bpi.bukkit.events.BungeeSendEvent;
import org.goblom.bpi.bukkit.util.ForwardMessage;

/**
 *
 * @author Goblom
 */
public class SendForwardEvent extends BungeeSendEvent {
    
    private final String server, channel;
    
    private final ByteArrayOutputStream mainBytes;
    private final DataOutputStream mainOut;
    private final ForwardMessage message;
    
    public SendForwardEvent(ByteArrayOutputStream mainBytes, DataOutputStream mainOut, ForwardMessage message) {
        this.server = message.getServer();
        this.channel = message.getChannel();
        
        this.mainBytes = mainBytes;
        this.mainOut = mainOut;
        
        this.message = message;
        
    }
    
    public String getServer() {
        return server;
    }
    
    public String getChannel() {
        return channel;
    }
    
    public ByteArrayOutputStream getMainByteStream() {
        return mainBytes;
    }
    
    public DataOutputStream getMainDataStream() {
        return mainOut;
    }
    
    public ForwardMessage getSentMessage() {
        return message;
    }
}
