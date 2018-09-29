package xiaolin.showdown.showdownworld;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ShowdownTp extends Teleporter{
	private WorldServer worldserver;
	public ShowdownTp(WorldServer worldIn) {
		
			
			super(worldIn);
			worldIn.customTeleporters.add(this);
			this.worldserver = worldIn;
			
	    }
	
	
	
	public void placeInPortal(Entity entityIn, float rotationYaw)
    {
		
		
		
		
    }
	

}
