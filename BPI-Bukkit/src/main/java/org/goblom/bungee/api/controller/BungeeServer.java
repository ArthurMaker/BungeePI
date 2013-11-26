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

package org.goblom.bungee.api.controller;

import org.goblom.bungee.api.util.ChannelHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.goblom.bungee.api.util.ForwardMessage;

/**
 *
 * @author Goblom
 */
public class BungeeServer {
    
    private final String bungeeServer;
    
    public BungeeServer(String bungeeServer) {
        this.bungeeServer = bungeeServer;
    }
    
    public String getName() {
        return bungeeServer;
    }
    
    public void connect(Player player) throws IOException {
        ChannelHelper.connect(player, getName());
    }
    
    public int getPlayerCount() throws IOException {
        return ChannelHelper.getPlayerCount(getName());
    }
    
    public String getPlayerList() throws IOException {
        return ChannelHelper.getPlayerList(getName());
    }
    
    public String[] getPlayerListAsArray() throws IOException {
        return getPlayerList().split(", ");
    }
    
    public void sendMessageToPlayer(String player, String message) throws IOException {
        ChannelHelper.sendMessage(player, message);
    }
    
    public String getServerName() throws IOException {
        return ChannelHelper.getServerName(getName());
    }
    
    public void forward(ForwardMessage message) throws IOException {
        ChannelHelper.forward(message);
    }
}
