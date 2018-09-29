package com.example.examplemod.hacks;

import com.example.examplemod.CommonProxy;
import com.example.examplemod.KeyManager;

import cpw.mods.fml.common.Mod.EventHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class NoFall {

	
	@ForgeSubscribe(priority=EventPriority.NORMAL, receiveCanceled=true)
	
	public void onEvent(LivingUpdateEvent event) {
		KeyManager Option = CommonProxy.keyManager;
		
		
		int NoFallMode = 2;
		
	if (Option.NoFall < 4) {
		
		
		
		switch (Option.NoFall)  {
		case 1: NoFallMode = 2;
		break;
		case 2: NoFallMode = 1;
		break;
		case 3: NoFallMode = -1;
		break;
		}
		
		
	if (event.entity instanceof EntityPlayer)
    {
    	EntityPlayer player =(EntityPlayer) event.entity;
    	
    	
    	if(player.fallDistance > NoFallMode) {
    		int x = (int)player.posX;
    		int y = (int)player.posY;
    		int z = (int)player.posZ;
    		int block = 1001;
    		
    		
    		if(x >= 0) {
    			if(z >= 0) {
    				
    				if(player.worldObj.isAirBlock(x , y - 2,z)) {
		    			
		    				player.worldObj.setBlock(x , y - 2,z , block);
		    			
	    				}
    				
		    		} else {	
		    			
		    			if(player.worldObj.isAirBlock(x , y - 2,z - 1)) {
		    			
		    				player.worldObj.setBlock(x , y - 2,z - 1, block);
		    			
	    				}
		    			
		    		}
    			
    		} else {
    			
    			if(z >= 0) {
    				
    				if(player.worldObj.isAirBlock(x - 1, y - 2,z)) {
		    			
		    				player.worldObj.setBlock(x - 1, y - 2,z , block);
		    			
	    				}
    				
		    		} else {	
		    			
			    			if(player.worldObj.isAirBlock(x - 1 , y - 2,z - 1)) {
			    			
			    				player.worldObj.setBlock(x - 1 , y - 2,z - 1, block);
		    			
	    					}
		    			
		    			}
    				}
    			}
    		}
	    }
	}
}
