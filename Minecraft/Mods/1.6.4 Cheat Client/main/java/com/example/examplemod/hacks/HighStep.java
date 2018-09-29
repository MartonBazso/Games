package com.example.examplemod.hacks;

import com.example.examplemod.CommonProxy;
import com.example.examplemod.KeyManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class HighStep {
	
@ForgeSubscribe(priority=EventPriority.NORMAL, receiveCanceled=true)
	
	public void onEvent(LivingUpdateEvent event) {
		KeyManager Option = CommonProxy.keyManager;
		
		
		if(Option.HighStep) {
			
		
			if (event.entity instanceof EntityPlayer)
		    {
		    	EntityPlayer player =(EntityPlayer) event.entity;
		    	
		    	player.stepHeight = 60f;
		    	
	    	}
		} else {
			event.entityLiving.stepHeight = 0.5f;
		}
	}

}
