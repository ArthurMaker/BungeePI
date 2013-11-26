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

package org.goblom.bpi.bukkit.listener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.goblom.bpi.bukkit.BungeePI;
import org.goblom.bpi.bukkit.util.ChannelHelper;
import org.goblom.bpi.bukkit.events.recieve.RecieveForwardEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveGetServerEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveGetServersEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveIPEvent;
import org.goblom.bpi.bukkit.events.recieve.RecieveOtherEvent;
import org.goblom.bpi.bukkit.events.recieve.RecievePlayerCountEvent;
import org.goblom.bpi.bukkit.events.recieve.RecievePlayerListEvent;

/**
 *
 * @author Goblom
 */
public class BungeeChannelListener implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;
        
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        try {
            String subChannel = in.readUTF();
            switch (subChannel) {
                case "IP":
                    RecieveIPEvent bri = new RecieveIPEvent(in);
                    BungeePI.getPlugin().getController().callEvent(bri);
                    ChannelHelper.setPlayerAddress(in.readUTF(), in.readInt()); // Lets set the IP as soon as its recieved
                    break;
                case "PlayerCount":
                    RecievePlayerCountEvent brpc = new RecievePlayerCountEvent(in);
                    BungeePI.getPlugin().getController().callEvent(brpc);
                    ChannelHelper.setServerPlayerCount(in.readUTF(), in.readInt()); // Lets set the player count as soon as its recieved
                    break;
                case "PlayerList":
                    RecievePlayerListEvent brpl = new RecievePlayerListEvent(in);
                    BungeePI.getPlugin().getController().callEvent(brpl);
                    ChannelHelper.setServerPlayerList(in.readUTF()); // Lets set the player list as soon as it is recieved
                    break;
                case "GetServers":
                    RecieveGetServersEvent brgss = new RecieveGetServersEvent(in);
                    BungeePI.getPlugin().getController().callEvent(brgss);
                    break;
                case "GetServer":
                    RecieveGetServerEvent brgs = new RecieveGetServerEvent(in);
                    BungeePI.getPlugin().getController().callEvent(brgs);
                    ChannelHelper.setServerName(in.readUTF()); // Lets set the server name as soon as its recieved
                    break;
                case "Forward":
                    RecieveForwardEvent brf = new RecieveForwardEvent(in);
                    BungeePI.getPlugin().getController().callEvent(brf);
                    break;
                case "Connect": break; // No Response
                case "ConnectOther": break; // No Response
                case "Message": break; // No Response
                default:
                    RecieveOtherEvent bro = new RecieveOtherEvent(in);
                    BungeePI.getPlugin().getController().callEvent(bro);
                    break;
            }
        } catch (IOException ex) {
            BungeePI.getPlugin().getLogger().warning("Unable to read incoming Bungee Plugin Message.");
        }
    }
}
