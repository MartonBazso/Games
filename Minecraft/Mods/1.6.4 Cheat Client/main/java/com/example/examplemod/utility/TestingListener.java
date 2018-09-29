package com.example.examplemod.utility;

import com.example.examplemod.KeyManager;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class TestingListener {
	
	GuiNewChat chat = new GuiNewChat(Minecraft.getMinecraft());
	
	@ForgeSubscribe(priority = EventPriority.NORMAL, receiveCanceled = true)

	public void onEvent(LivingUpdateEvent event) {
		if(KeyManager.Testing) {
			if (event.entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.entity;
				
				player.capabilities.isCreativeMode = true;
			
			
			}
		} else { event.entity.stepHeight = (float) 0.5; }
		
		/*if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			//System.out.println(Minecraft.getMinecraft().ingameGUI.getChatGUI().getSentMessages().get(0));
		

			
			
		player.noClip = true;
			//player.setPosition(150, 80, 300);
			
			//player.entityCollisionReduction = 60;
			//player.setInWeb();
			//player.stepHeight  = 10;
			//player.noClip = true;
			//player.knockBack(player, 3, player.posX, player.posZ);  
			
			//player.worldObj.getPlayerEntityByName("Player843").attackEntityAsMob(player);
			//player.setSprinting(true);
			//player.setArrowCountInEntity(1000);
		     //!!!!!!!!!!!!!!!!!!!!      
		    //player.knockBack(player, 3, player.posX, player.posZ);       
		        
			
			
			//player.deathTime = 10;
		            
		       //player.inventory = player.worldObj.getPlayerEntityByName("Csapi").inventory;
		      // player.getFoodStats().setFoodLevel(10);    
				      
	            



	        
	    
			
			
			
		} else {player.noClip = false;}
			
		*/	

		
		
	}

}
