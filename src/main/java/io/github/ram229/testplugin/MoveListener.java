package io.github.ram229.testplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public final class MoveListener implements Listener 
{
	@EventHandler
	public void onMove(PlayerMoveEvent event)
	{
		String name = event.getPlayer().getDisplayName();
		if(TestPlugin.sponge.get(name)==null)
			TestPlugin.sponge.put(name, false);
		boolean state = TestPlugin.sponge.get(name);
		if(state)
		{
			Location loc = event.getPlayer().getLocation();
			loc.setY(loc.getY() - 1);
			Block b = loc.getBlock();
			b.setType(Material.SPONGE);
		}
	}

}
