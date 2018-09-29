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
				//Ki�r�ti az elt�ntetni val� blockok list�j�t, amugy bugos volt �s mindig az el�z� bekapcsolt, meanwhile benthagytam ezt a funkci�t
				//De ez �gy cleanebb imo
				for(int i = 0 ; i < wantedBlocks.length ; i++) {
					
					wantedBlocks[i] = 0;
					
				}
				
				
				//Seg�t� boolean, am�gy mindig egym�sra rajzolta a gui-kat folyamatosan, �gy csak egyszer teszi
				if(GhostModeInput.shouldBeOn) {
				Minecraft.getMinecraft().displayGuiScreen( new GhostModeInput());
				
				GhostModeInput.shouldBeOn = false;
				}
				
				
				//Ezt akkor csin�ltam amikor beraktam az "egyszerre t�bb ID funkci�t, az elt�ntetni val� blockok idjeit �sszep�ros�tja az �ltalunk be�rt IDkkel
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
					
				
				
					
				//Ez meg maga az elt�ntet�s, megn�zi hogy a player bizonyos rang�ben van e nek�nk kell� block, �s destroyolja, meg�rni nagyobb pain vltm int most �rtelmezni imo :D 
				//Btw sorry az el�g clusterfuck code�rt, nem nagyon megy m�g ez a sz�pen csoportos�t�s stb, mint ahogy n�lad l�ttam , de igyekszem, legal�bb m�r kommentelek xd
				
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