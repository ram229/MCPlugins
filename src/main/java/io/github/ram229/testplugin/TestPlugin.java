package io.github.ram229.testplugin;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin 
{
	public static Map<String, Boolean> sponge = new HashMap<String, Boolean>();
	public void onEnable()
	{
		getLogger().info("Hello Ryan, This proves that making plugins does work and you didn't waste your time. The Enable Command has been invoked.");
		getServer().getPluginManager().registerEvents(new MoveListener(), this);
	}
	
	public void onDisable()
	{
		getLogger().info("The Disable Command has been invoked. Goodnight Ryan and good work today.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("ryan"))
		{ 
			if(sender instanceof Player)
			{
				Player play = (Player) sender;
				play.sendMessage("Hello Ryan. Commands work. Yay!");
			}
			else
				getLogger().info("This command must be executed by ram229!");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("toggle"))
		{
			if(sender instanceof Player)
			{
				Player play = (Player) sender;
				sponge.put(play.getDisplayName(), !(sponge.get(play.getDisplayName())));
				if(sponge.get(play.getDisplayName()))
				{
					play.sendMessage("Sponge walk has been turned on.");
				}
				else
				{
					play.sendMessage("Sponge walk has been turned off");
				}
			}
			else
				getLogger().info("This is a player only command");
			return true;
		}
		return false; 
	}
}