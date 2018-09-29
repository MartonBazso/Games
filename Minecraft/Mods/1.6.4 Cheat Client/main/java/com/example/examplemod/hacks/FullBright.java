package com.example.examplemod.hacks;

import com.example.examplemod.CommonProxy;
import com.example.examplemod.KeyManager;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class FullBright {
	
	//ezen nem gondolom, hogy bármit magyarázni kéne :3 
	//az alattad lévõ block -> redstone lamp ( átírhatod nyugodtan, de nekem a redstone lamp a kedvenc fényadó shitem) 
	
@ForgeSubscribe(priority=EventPriority.NORMAL, receiveCanceled=true)
	
	public void onEvent(LivingUpdateEvent event) {
		KeyManager Option = CommonProxy.keyManager;
		
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player =  (EntityPlayer) event.entity;
			
    		int x = (int)player.posX;
    		int y = (int)player.posY;
    		int z = (int)player.posZ;
			if(Option.FullBright) {
				
				if(x >= 0) {
					
					if(!player.worldObj.isAirBlock(x , y - 2,z)) {
						
						player.worldObj.setBlock(x , y - 2,z, Block.redstoneLampActive.blockID);
				
				
						}
					
					} else { 
						
						if(!player.worldObj.isAirBlock(x - 1 , y - 2,z)) {
							
								player.worldObj.setBlock(x - 1, y - 2,z, Block.redstoneLampActive.blockID);
						
						
						}
					}
				
			
			
			if(z >= 0) {
				
				if(!player.worldObj.isAirBlock(x , y - 2,z)) {
					
					player.worldObj.setBlock(x , y - 2,z, Block.redstoneLampActive.blockID);
			
			
					}
				
				} else { 
					
					if(!player.worldObj.isAirBlock(x , y - 2,z - 1)) {
						
							player.worldObj.setBlock(x, y - 2,z - 1, Block.redstoneLampActive.blockID);
					
					
					}
				}
			
			}
		

		}


	}

}
