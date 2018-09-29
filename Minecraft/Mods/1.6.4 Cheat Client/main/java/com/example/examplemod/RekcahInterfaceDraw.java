package com.example.examplemod;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import org.lwjgl.input.Keyboard;

import com.google.common.eventbus.Subscribe;
import com.example.examplemod.KeyManager;


import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;



public class RekcahInterfaceDraw {
    	//Általánosítottam ezt, hogyha tfh a bal felsõ sarokban jobban tetszene, könnyen át tudjuk rakni :D 
		int x1 = 4;
		int y1 = 24;
		int x2;
		int y2;

		@ForgeSubscribe(priority=EventPriority.NORMAL, receiveCanceled=true)
		
		
		
		
		
		public void onRenderExperienceBar(RenderGameOverlayEvent.Chat event) {
			KeyManager Option = CommonProxy.keyManager; //Getting the Keymanager's var
			
			
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Rekcah OS", 4, 4, 0xFF0000);
			
			
			if (Option.ShowHacks) {	//FONT RENDERER
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("NoFall - ", x1, y1, 0xFF0000);
					if (Option.NoFall == 1) {
						Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("[ENABLED] ", 52, 24, 0x00ff00);
										} else if (Option.NoFall == 2) {
											Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("[Sky Jump] ", 50, 24, 0x00ff00);											
										} else if (Option.NoFall == 3) {
											Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("[Bridge] ", 50, 24, 0x00ff00);											
										} else if (Option.NoFall == 4) {
											Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("[Disabled] ", 50, 24, 0x660066);	
										}
				
				//Itt megláttam, hogy kb repetativan ugyan azt kell csinálni, szóval gondoltam általánosítom
					//params: Szöveg, maga a trigger boolean, és hanyadik ehlyen legyen.
					Draw("AutoMine", Option.AutoMine, 1);
					Draw("GhostMode", Option.GhostMode,2);
					Draw("FullBright", Option.FullBright, 3);
					
			}
			
			Minecraft.getMinecraft().ingameGUI.drawRect(2, 2, 57, 14, 0x80000000);

		
			if (Option.ShowHacks) { // BOX RENDERER
				Minecraft.getMinecraft().ingameGUI.drawRect(x1 - 2, y1 - 2, x2, y2, 0x80000000);
				
				
			}
			
			
		}
		
		
		//próbáltam jól kiszámolgatni a helyüket, de ha nagyon hosszú a string felborította, ezért kellett a safety measure
		private void Draw(String name , boolean option , int place) {
			int length = 0;
			if(name.length() > 10) { // Ez a safety measure
				length = name.length() * 6 + 10;
			} else {
				length = name.length() * 5 + 10;
			}
			
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(name + " - ", x1, y1 + place*10, 0xFF0000);
			
			if (option) {
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("[Enabled] ", x1 + length + 10, y1 + place*10, 0x00ff00);							
			} else if (!option) {
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("[Disabled] ",x1 + length + 10, y1 + place*10, 0x660066);
			}
			
			if(!(x2 >=  x1 + 78 + length)) {
				x2 = x1 + 78 + length;
			}
			
				y2 = y1+place*10 + 10;
			
			
			
		}
		
		
		
			


}