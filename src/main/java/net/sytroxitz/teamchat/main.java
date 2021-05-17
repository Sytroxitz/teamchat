package net.sytroxitz.teamchat;

import net.sytroxitz.teamchat.commands.version;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.event.EventHandler;

public class main extends Plugin implements Listener {

    // Plugin stuff
    public static String version = "v1.3.2"; // Here you can change the version. (but you also need to change it in the bungee.yml)
    public static String author = "Sytroxitz"; // Author what is shown in the console/version cmd. (but you also need to change it in the bungee.yml)

    // Chat stuff
    public static String prefix = "§8| §b§lTeamChat §8| "; // Chat Plugin Prefix
    public static String ownersuffix = "§7 - §4"; // Only owner suffix
    public static String ranksuffix = "§7 - §7"; // Other rank suffixes
    public static String intomessage = "§8 » §7"; // From user to message syntax

    // Command stuff
    public static String command = "#tc"; // First command prefix
    public static String command2 = "/tc"; // Second command prefix
    public static String vercommand = "tcv"; // version command (/tcv)

    // Everything for the different Prefix
    public static String devuuid = "dd57314c-15de-44c9-bdff-b3bf4c558eb3"; // Maybe the Developer/Special UUID
    public static String devprefix = "§8| §f§lTeamChat §3§lDEV"; // Prefix for the UUID
    public static String devsuffix = "§8 | §3§l"; // Suffix for the UUID

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = ProxyServer.getInstance().getPluginManager();
        getLogger().info("§aPlugin developed from " + author + " was started!");
        getProxy().getPluginManager().registerListener(this, this);
        pm.registerCommand(this, new version(vercommand));
    }

    // TeamChat command/message with the rank
    @EventHandler
    public void onTeamChat(ChatEvent e) {
        ProxiedPlayer p = (ProxiedPlayer) e.getSender();
        String[] str = e.getMessage().split(" ");
        // Uses my UUID to make a different Prefix
        if(p.getUniqueId().toString().equals(devuuid)) {
            if(str[0].equalsIgnoreCase(command) || str[0].equalsIgnoreCase(command2)) {
                e.setCancelled(true);
                String msg = devprefix + devsuffix + p.getName() + intomessage;
                for(int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for(ProxiedPlayer online : getProxy().getPlayers()) {
                    if(online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) {
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
            return;
        }
        // All rank prefixes/permissions
        if(p.hasPermission("team.owner.send") || p.hasPermission("team.*")) { // Permission to use this prefix
            if (str[0].equalsIgnoreCase(command)) {
                e.setCancelled(true);
                String msg = prefix + "§4Owner" + ownersuffix + p.getName() + intomessage;
                for (int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for (ProxiedPlayer online : getProxy().getPlayers()) {
                    if (online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) { // Permission to use the command
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
            return;
        }
        if(p.hasPermission("team.admin.send")) {
            if(str[0].equalsIgnoreCase(command)) {
                e.setCancelled(true);
                String msg = prefix + "§cAdmin" + ranksuffix + p.getName() + intomessage;
                for(int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for(ProxiedPlayer online : getProxy().getPlayers()) {
                    if(online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) {
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
            return;
        }
        if(p.hasPermission("team.dev.send")) {
            if(str[0].equalsIgnoreCase(command)) {
                e.setCancelled(true);
                String msg = prefix + "§9Dev" + ranksuffix + p.getName() + intomessage;
                for(int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for(ProxiedPlayer online : getProxy().getPlayers()) {
                    if(online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) {
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
            return;
        }
        if(p.hasPermission("team.mod.send")) {
            if(str[0].equalsIgnoreCase(command)) {
                e.setCancelled(true);
                String msg = prefix + "§5Mod" + ranksuffix + p.getName() + intomessage;
                for(int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for(ProxiedPlayer online : getProxy().getPlayers()) {
                    if(online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) {
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
            return;
        }
        if(p.hasPermission("team.sup.send")) {
            if(str[0].equalsIgnoreCase(command)) {
                e.setCancelled(true);
                String msg = prefix + "§eSupporter" + ranksuffix + p.getName() + intomessage;
                for(int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for(ProxiedPlayer online : getProxy().getPlayers()) {
                    if(online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) {
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
            return;
        }
        if(p.hasPermission("team.tsup.send")) {
            if(str[0].equalsIgnoreCase(command)) {
                e.setCancelled(true);
                String msg = prefix + "§eT-Supporter" + ranksuffix + p.getName() + intomessage;
                for(int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for(ProxiedPlayer online : getProxy().getPlayers()) {
                    if(online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) {
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
            return;
        }
        if(p.hasPermission("team.builder.send")) {
            if(str[0].equalsIgnoreCase(command)) {
                e.setCancelled(true);
                String msg = prefix + "§2Builder" + ranksuffix + p.getName() + intomessage;
                for(int i = 1; i < str.length; i++) {
                    msg = msg + "§7" + str[i] + " ";
                }
                for(ProxiedPlayer online : getProxy().getPlayers()) {
                    if(online.hasPermission("team.send") || online.getUniqueId().toString().equals(devuuid)) {
                        online.sendMessage(new TextComponent(msg));
                    }
                }
            }
        } else
            return;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("§cPlugin developed from " + author + " was stopped!");
    }
}
