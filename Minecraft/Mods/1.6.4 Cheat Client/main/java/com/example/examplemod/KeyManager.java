package com.example.examplemod;



import org.lwjgl.input.Keyboard;

import com.example.examplemod.utility.GhostModeInput;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;







public class KeyManager {
	
	
	public static boolean ShowHacks = true;
	public static int NoFall = 4;
	public static boolean Brightness = false;
	public static boolean Sprint = false;
	public static boolean GhostMode = false;
	public static boolean AutoMine = false;
	public static boolean FullBright = false;
	public static boolean HighStep = false;
	public static boolean Testing = false;
	
	
	

	
	
	
		//KeyBindings
		
		KeyBinding ShowHacksKey = new KeyBinding("togglehacks", Keyboard.KEY_O);
		KeyBinding NoFallKey = new KeyBinding("nofall", Keyboard.KEY_ADD);
		KeyBinding GhostModeKey = new KeyBinding("ghostmode", Keyboard.KEY_P);
		KeyBinding AutoMineKey = new KeyBinding("automine", Keyboard.KEY_H);
		KeyBinding FullBrightKey = new KeyBinding("fullbright", Keyboard.KEY_J);
		KeyBinding HighStepKey = new KeyBinding("highstep", Keyboard.KEY_G);
		public static KeyBinding TestingKey = new KeyBinding("testing", Keyboard.KEY_U);
		
		
		
		@ForgeSubscribe(priority=EventPriority.NORMAL, receiveCanceled=true)
		public void onEvent(LivingUpdateEvent event) {
		
		
			//Toggle hax visibility
			if(ShowHacksKey.isPressed()) {
				if(KeyManager.ShowHacks) {
					KeyManager.ShowHacks = false;
				} else {
					KeyManager.ShowHacks = true;
				}
			}
			//*************************************
			
			
			
			
			
			
			
			//Toggle between Nofall Options	
			if(NoFallKey.isPressed()) {
				
				if(KeyManager.NoFall != 4) {
					KeyManager.NoFall += 1;
				} else {
					KeyManager.NoFall = 1;
				}
			}
			//***********************************
			
			
			
			
			//Toggle ghost mode
			if(GhostModeKey.isPressed()) {
				GhostModeInput.shouldBeOn = true;
				if(KeyManager.GhostMode) {
					KeyManager.GhostMode = false;
				} else {
					KeyManager.GhostMode = true;
				}
			}
			//*************************************
		
			
			
			
			//Toggle automine
			if(AutoMineKey.isPressed()) {
				
				if(KeyManager.AutoMine) {
					AutoMineKey.setKeyBindState(-100, false);
					KeyManager.AutoMine = false;
				} else {
					AutoMineKey.setKeyBindState(-100, true);
					KeyManager.AutoMine = true;
				}
			}
			//********************************
			
			
			
			//Toggle fullbright
			if(FullBrightKey.isPressed()) {
				if(KeyManager.FullBright) {
					KeyManager.FullBright = false;
				} else {
					KeyManager.FullBright = true;
				}
			}
			//*************************************
			
			
			//Toggle highstep
			if(HighStepKey.isPressed()) {
				if(KeyManager.HighStep) {
					KeyManager.HighStep = false;
				} else {
					KeyManager.HighStep = true;
				}
			}
			//*************************************
			
			
			
			
			if(TestingKey.isPressed()) {
				
				if(KeyManager.Testing) {
					KeyManager.Testing = false;
				} else {
					KeyManager.Testing = true;
				}
				
				
				
				
			} 
			

		
		

		
		}

		

	
	
	
	
	
	

}
