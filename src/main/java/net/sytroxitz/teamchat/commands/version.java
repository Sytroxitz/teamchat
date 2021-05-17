package net.sytroxitz.teamchat.commands;

import net.sytroxitz.teamchat.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class version extends Command {

    public version(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(main.prefix + "§cOnly Players can use this command!"); // Console exception on use in console
            return;
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        // Version message by execute the command
        if(p.getUniqueId().toString().equals(main.devuuid) || p.hasPermission("team.owner.send") || p.hasPermission("team.admin.send") || p.hasPermission("team.*")) { // Only this permission can use the command /tcv
            ((ProxiedPlayer) sender).sendMessage(main.prefix + "§fThis plugin runs on the Version §a" + main.version + "§f.");
            ((ProxiedPlayer) sender).sendMessage(main.prefix + "§fThis Version was Developed by §3" + main.author);
        }
    }
}
