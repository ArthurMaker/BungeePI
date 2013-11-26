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

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.event.Event;
import org.goblom.bungee.api.BungeePI;
import org.goblom.bungee.api.events.BungeeEvent;

/**
 *
 * @author Goblom
 */
public class Controller {
    
    private final List<BungeeServer> bungeeServers = new ArrayList<BungeeServer>();
    private final List<BungeePlayer> bungeePlayers = new ArrayList<BungeePlayer>();
    
    public List<BungeeServer> getBungeeServers() {
        return bungeeServers;
    }
    
    public List<BungeePlayer> getBungeePlayers() {
        return bungeePlayers;
    }
    
    public void addBungeeServer(String server) {
        if (!server.toLowerCase().equals("all")) {
            if (!bungeeServers.contains(server)) {
                bungeeServers.add(new BungeeServer(server));
            } else BungeePI.getPlugin().getLogger().info("A Bungee Server with that name has already been registered.");
        } else BungeePI.getPlugin().getLogger().warning("A plugin has just attempted to register a server with the name '" + server + "'. That name is not allowed because it is a major factor with some Bungee Channels");
    }
    
    public void addBungeePlayer(String playerName) {
        if (!bungeePlayers.contains(playerName)) {
            bungeePlayers.add(new BungeePlayer(playerName));
        } else BungeePI.getPlugin().getLogger().info("A Bungee Player with that name has already been registered.");
    }
    
    public BungeeServer getBungeeServer(String server) {
        for (BungeeServer bs : getBungeeServers()) {
            if (bs.getName().equals(server)) return bs;
        }
        return null;
    }
    
    public BungeePlayer getBungeePlayer(String playerName) {
        for (BungeePlayer bp : getBungeePlayers()) {
            if (bp.getPlayerName().equals(playerName)) return bp;
        }
        return null;
    }
    
    public void removeBungeePlayer(String playerName) {
        for (BungeePlayer bp : getBungeePlayers()) {
            if (bp.getPlayerName().equals(playerName)) getBungeePlayers().remove(bp);
        }
    }
    
    public void removeBungeeServer(String server) {
        for (BungeeServer bs : getBungeeServers()) {
            if (bs.getName().equals(server)) getBungeeServers().remove(bs);
        }
    }
    
    public void callEvent(BungeeEvent event) {
        BungeePI.getPlugin().getServer().getPluginManager().callEvent(event);
    }
    
    public void sendPluginMessage(ByteArrayOutputStream message) {
        BungeePI.getPlugin().getFirstPlayer().sendPluginMessage(BungeePI.getPlugin(), "BungeeCord", message.toByteArray());
    }
}
