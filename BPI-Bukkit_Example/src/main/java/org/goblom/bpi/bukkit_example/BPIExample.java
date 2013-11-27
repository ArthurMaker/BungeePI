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

package org.goblom.bpi.bukkit_example;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.goblom.bpi.bukkit_example.listener.BPIEventListener;
import org.goblom.bpi.bukkit_example.listener.BukkitEventListener;

/**
 *
 * @author Goblom
 */
public class BPIExample extends JavaPlugin {
    
    private static BPIExample plugin;
    public static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "BungeePI" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;
    
    public void onEnable() {
        plugin = this;
        
        new BPICommand("bpi");
        getServer().getPluginManager().registerEvents(new BukkitEventListener(), this);
        getServer().getPluginManager().registerEvents(new BPIEventListener(), this);
    }
    
    public static BPIExample getPlugin() {
        return plugin;
    }
}
