package com.example.examplemod.hacks;

import java.util.ArrayList;
import java.util.List;

import com.example.examplemod.CommonProxy;
import com.example.examplemod.KeyManager;
import com.example.examplemod.utility.GhostModeInput;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;


public class GhostMode {

	
	
	int[] wantedBlocks = new int[Block.blocksList.length];
	
	
	
	@ForgeSubscribe(priority = EventPriority.NORMAL, receiveCanceled = true)

	public void onEvent(LivingUpdateEvent event) {
		KeyManager Option = CommonProxy.keyManager;
		

		
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			
			
			
			
			
			if (KeyManager.GhostMode) {
				player.entityCollisionReduction = 100;
				player.isCollided = false;
				player.onGround = false;
				//Kiüríti az eltüntetni való blockok listáját, amugy bugos volt és mindig az elõzõ bekapcsolt, meanwhile benthagytam ezt a funkciót
				//De ez így cleanebb imo
				for(int i = 0 ; i < wantedBlocks.length ; i++) {
					
					wantedBlocks[i] = 0;
					
				}
				
				
				//Segítõ boolean, amúgy mindig egymásra rajzolta a gui-kat folyamatosan, így csak egyszer teszi
				if(GhostModeInput.shouldBeOn) {
				Minecraft.getMinecraft().displayGuiScreen( new GhostModeInput());
				
				GhostModeInput.shouldBeOn = false;
				}
				
				
				//Ezt akkor csináltam amikor beraktam az "egyszerre több ID funkciót, az eltüntetni való blockok idjeit összepárosítja az általunk beírt IDkkel
				for(String wantedText : GhostModeInput.text) {
						if(wantedText != null) {
							
							for(int i = 0 ; i < Block.blocksList.length ; i++) {
								if(Block.blocksList[i] != null && Block.blocksList[i].blockID != 0) {
									
									if(wantedText.equals(Integer.toString(Block.blocksList[i].blockID))) {
										
										wantedBlocks[i] = Block.blocksList[i].blockID;
									
									}
								}
											
							}
						}
					}
					
				
				
					
				//Ez meg maga az eltüntetés, megnézi hogy a player bizonyos rangében van e nekünk kellõ block, és destroyolja, megírni nagyobb pain vltm int most értelmezni imo :D 
				//Btw sorry az elég clusterfuck codeért, nem nagyon megy még ez a szépen csoportosítás stb, mint ahogy nálad láttam , de igyekszem, legalább már kommentelek xd
				
				for(Block block : Block.blocksList) {
					for(int wantedBlockId : wantedBlocks) {
						
						if(block != null && block.blockID != 0 && wantedBlockId != 0 && wantedBlockId == block.blockID) {
							for (int i = -10; i < 11; i++) {
								for (int j = -10; j < 11; j++) {
									for (int k = -10; k < 11; k++) {
									
									if (player.worldObj.getBlockId((int) player.posX + i,
											(int) player.posY + j, (int) player.posZ + k) == block.blockID ) {
				
										
										player.worldObj.setBlock( (int) player.posX + i,
												(int) player.posY + j, (int) player.posZ + k , 0);
										
										}	
									}
								}
							}
						}
					}
				}
			}
		}
	}
}