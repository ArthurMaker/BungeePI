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

package org.goblom.bpi.bukkit_example.utils;

import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.goblom.bpi.bukkit.BungeePI;
import org.goblom.bpi.bukkit.controller.BungeePlayer;
import org.goblom.bpi.bukkit_example.BPIExample;

/**
 *
 * @author Goblom
 */
public class CommandController {
    
    public static void addServer(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            BungeePI.getPlugin().getController().addBungeeServer(args[1]);
            sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + "Successfully added server " + ChatColor.GOLD + args[1] + ChatColor.DARK_GREEN + ".");
        } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "You are missing the server, or have too many arguments.");
    }
    
    public static void getServer(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                try {
                    String server = BungeePI.getPlugin().getController().getBungeePlayer(sender.getName()).getServer();
                    sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + "You are in server " + ChatColor.GOLD + server);
                } catch (IOException e) { e.printStackTrace(); }
            } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "Too many arguments.");
        } else sender.sendMessage(BPIExample.prefix + "Only players can use this command.");
    }
    
    public static void playerList(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            try {
                String playerList = BungeePI.getPlugin().getController().getBungeeServer(args[1]).getPlayerList();
                sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + "Players for server... " + ChatColor.GOLD + args[1]);
                sender.sendMessage(BPIExample.prefix + ChatColor.LIGHT_PURPLE + playerList);
            } catch (IOException e) { e.printStackTrace(); }
        } else if (args.length == 1) {
            try {
                String server = BungeePI.getPlugin().getController().getBungeePlayer(sender.getName()).getServer();
                String playerList = BungeePI.getPlugin().getController().getBungeeServer(server).getPlayerList();
                
                sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + "Players for server... " + ChatColor.GOLD + server);
                sender.sendMessage(BPIExample.prefix + ChatColor.LIGHT_PURPLE + playerList);
            } catch (IOException e) { e.printStackTrace(); }
        } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "You are missing the server, or have too many arguments.");
    }
    
    public static void findPlayer(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            try {
                String server = BungeePI.getPlugin().getController().getBungeePlayer(args[1]).getServer();
                sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + args[1] + " is in " + server);
            } catch (IOException e) { e.printStackTrace(); }
        } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "You are missing the player, or have too many arguments.");
    }
    
    public static void getIP(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            try {
                String ip = BungeePI.getPlugin().getController().getBungeePlayer(args[1]).getIP();
                sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + args[1] + "'s ip is " + ip);
            } catch (Exception e) { e.printStackTrace(); }
        } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "You are missing the player, or have too many arguments.");
    }
    
    public static void playerCount(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            try {
                int playerCount = BungeePI.getPlugin().getController().getBungeeServer(args[1]).getPlayerCount();
                sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + "Therea are " + playerCount + " in server " + args[1]);
            } catch (IOException e) { e.printStackTrace(); }
        } else if (args.length == 1) {
            try {
                String server = BungeePI.getPlugin().getController().getBungeePlayer(sender.getName()).getServer();
                int playerCount = BungeePI.getPlugin().getController().getBungeeServer(server).getPlayerCount();
                sender.sendMessage(BPIExample.prefix + ChatColor.DARK_GREEN + "Therea are " + playerCount + " in server " + server);
            } catch (IOException e) { e.printStackTrace(); }
        } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "You are missing the server, or have too many arguments.");
    }
    
    public static void send(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 3) {
            try {
                BungeePI.getPlugin().getController().getBungeePlayer(args[1]).moveToServer(args[2]);
            } catch (IOException e) { e.printStackTrace(); }
        } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "You are missing the server, the player, or have too many arguments.");
    }
    
    public static void sendMessage(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 3) {
            try {
                StringBuilder message = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    message.append(args[i]);
                    message.append(" ");
                }
                
                BungeePI.getPlugin().getController().getBungeePlayer(args[1]).sendMessage(
                        message.toString()
                                .replaceFirst(args[1], "")
                                .replaceFirst(args[2], "")
                );
            } catch (IOException e) { e.printStackTrace(); }
        } else sender.sendMessage(BPIExample.prefix + ChatColor.RED + "You are missing the player, or you don't enough arguments.");
    }
}
