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

package org.goblom.bpi.bukkit_example.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


import org.goblom.bpi.bukkit.events.recieve.RecieveForwardEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveGetServerEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveGetServersEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveIPEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveOtherEvent;
import org.goblom.bpi.bukkit.events.recieve.RecievePlayerCountEvent;
import org.goblom.bpi.bukkit.events.recieve.RecievePlayerListEvent;
import org.goblom.bpi.bukkit.events.send.SendConnectEvent;
import org.goblom.bpi.bukkit.events.send.SendConnectOtherEvent;
import org.goblom.bpi.bukkit.events.send.SendForwardEvent;
import org.goblom.bpi.bukkit.events.send.SendMessageEvent;
import org.goblom.bpi.bukkit_example.BPIExample;

/**
 *
 * @author Goblom
 */
public class BPIEventListener implements Listener {
    
    @EventHandler
    public void onRecieveForward(RecieveForwardEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Recieved Forward Channel");
    }
    
    @EventHandler
    public void onRecieveGetServer(RecieveGetServerEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Recieved GetServer Channel");
    }
    
    @EventHandler
    public void onRecieveGetServers(RecieveGetServersEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Recieved GetServers Channel");
    }
    
    @EventHandler
    public void onRecieveIP(RecieveIPEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Recieved IP Channel");
    }
    
    @EventHandler
    public void onRecieveOther(RecieveOtherEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Recieved a non-normal channel");
    }
    
    @EventHandler
    public void onRecievePlayerCount(RecievePlayerCountEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Recieved PlayerCount Channel");
    }
    
    @EventHandler
    public void onRecievePlayerList(RecievePlayerListEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Recieved PlayerList Channel");
    }
    
    @EventHandler
    public void onSendConnect(SendConnectEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Sent Connect Channel");
    }
    
    @EventHandler
    public void onSendConnectOther(SendConnectOtherEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Sent ConnectOther Channel");
    }
    
    @EventHandler
    public void onSendForwardEvent(SendForwardEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Sent Forward Channel");
    }
    
    @EventHandler
    public void onSendMessage(SendMessageEvent event) {
        Bukkit.broadcastMessage(BPIExample.prefix + "Sent Message Channel");
    }
}
