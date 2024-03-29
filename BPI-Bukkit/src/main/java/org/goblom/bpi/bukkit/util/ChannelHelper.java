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

package org.goblom.bpi.bukkit.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.goblom.bpi.bukkit.BungeePI;
import org.goblom.bpi.bukkit.events.send.SendConnectEvent;
import org.goblom.bpi.bukkit.events.send.SendConnectOtherEvent;
import org.goblom.bpi.bukkit.events.send.SendForwardEvent;
import org.goblom.bpi.bukkit.events.send.SendMessageEvent;
import org.goblom.bpi.bukkit.util.BungeeChannels;

/**
 *
 * @author Goblom
 */
public class ChannelHelper {
    
    public static String playerAddress, bungeeServer, serverPlayerList;
    public static int playerPort, serverPlayerCount;
        
    public static void setPlayerAddress(String address, int port) {
        playerAddress = address;
        playerPort = port;
    }
    
    public static void setServerPlayerCount(String server, int playerCount) {
        bungeeServer = server;
        serverPlayerCount = playerCount;
    }
    
    public static void setServerPlayerList(String serverPlayers) {
        serverPlayerList = serverPlayers;
    }
    
    public static void setServerName(String server) {
        bungeeServer = server;
    }
    
    public static void connect(Player player, String server) throws IOException {
        if (server.length() == 0) return;

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);

        out.writeUTF(BungeeChannels.CONNECT.getChannel());
        out.writeUTF(server);

        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        BungeePI.getPlugin().getController().callEvent(new SendConnectEvent(player, server));
    }
    
    public static void connectOther(String player, String server) throws IOException {
        if (server.length() == 0) return;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF(BungeeChannels.CONNECT_OTHER.getChannel());
        out.writeUTF(player);
        out.writeUTF(server);
        
        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        BungeePI.getPlugin().getController().callEvent(new SendConnectOtherEvent(player, server));
    }
    
    public static String getIP() throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF(BungeeChannels.IP.getChannel());
        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        
        return playerAddress + ":" + playerPort;
    }
    
    public static void sendMessage(String player, String message) throws IOException {
        if ((player == null) || (player.equals(""))) return;
        if ((message == null) || (message.equals(""))) return;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF(BungeeChannels.MESSAGE.getChannel());
        out.writeUTF(player);
        out.writeUTF(message);
        
        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        BungeePI.getPlugin().getController().callEvent(new SendMessageEvent(player, message));
    }
    
    public static int getPlayerCount(String server) throws IOException {
        if ((server == null) || (server.equals(""))) return 0;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF(BungeeChannels.PLAYER_COUNT.getChannel());
        out.writeUTF(server);
        
        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        
        return serverPlayerCount;
    }
    
    public static String getPlayerList(String server) throws IOException {
        if ((server == null) || (server.equals(""))) return null;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF(BungeeChannels.PLAYER_LIST.getChannel());
        out.writeUTF(server);
        
        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        
        return serverPlayerList;
    }
    
    public static String getServerName(String server) throws IOException {
        if ((server == null) || (server.equals(""))) return null;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF(BungeeChannels.GET_SERVER.getChannel());
        
        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        
        return bungeeServer;
    }
    
    public static void forward(ForwardMessage message) throws IOException {
        if (message == null) return;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF(BungeeChannels.FORWARD.getChannel());
        out.writeUTF(message.getServer());
        out.writeUTF(message.getChannel());
        
        out.writeShort(message.getBytesToForward().toByteArray().length);
        out.write(message.getBytesToForward().toByteArray());
        
        BungeePI.getPlugin().getController().sendPluginMessage(byteArray);
        BungeePI.getPlugin().getController().callEvent(new SendForwardEvent(byteArray, out, message));
    }
}
