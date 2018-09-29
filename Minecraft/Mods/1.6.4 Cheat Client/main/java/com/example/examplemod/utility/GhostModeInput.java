package com.example.examplemod.utility;

import org.lwjgl.input.Keyboard;

import com.example.examplemod.KeyManager;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;

public class GhostModeInput extends GuiScreen{

	public static boolean shouldBeOn = false;
	GuiTextField input;
	public static String[] text = new String[Block.blocksList.length];
	
	
	public GhostModeInput() {
		
		
	}
	
	public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	public void drawScreen(int par1, int par2, float par3)
    {
		 	this.drawDefaultBackground();
	        this.drawString(Minecraft.getMinecraft().fontRenderer, "Please enter the block IDs separated with commas,", this.width / 2 - 120, 20,  0xffffff);
	        this.drawString(Minecraft.getMinecraft().fontRenderer, "Or keep the previous settings by pressing 'Escape'!", this.width / 2 - 125, 30,  0xffffff);
	        this.input.drawTextBox();
	        
	        super.drawScreen(par1, par2, par3);
    	
    }
	
	
	
	public void updateScreen() {
		//
		this.input.updateCursorCounter();
		
	
	}
	
	 public void initGui()
    {
		 
		 
    Keyboard.enableRepeatEvents(true);
    this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Input"));
    this.input = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 90, 200, 20);
    this.input.setMaxStringLength(100);
    this.input.setEnableBackgroundDrawing(false);
    this.input.setFocused(true);
    
    this.input.setCanLoseFocus(false);
		 
		 
		 
    }
	 
	 
	 //szerintem innen csak ez érdekes, a beírt key-t a textboxba is beleírja, kb ennyi a guiscreen methodját írtam át,
	 //pretty much copypaste az "addserver" classból, mert ott találtam guitextfieldet
	 protected void keyTyped(char par1, int par2)
	    {
		 	
		 	input.textboxKeyTyped(par1, par2);
	        if (par2 == 1)
	        {
	        	this.shouldBeOn = false;
	            this.mc.displayGuiScreen((GuiScreen)null);
	            this.mc.setIngameFocus();
	        }
	    }

	 
	 
	 //ez akkor triggerelõdik, ha bármilyen gombot megnyomnak a guin, vesszõknél string arrayebe bontja a stringet
	protected void actionPerformed(GuiButton par1GuiButton)
    {
		
		for(int i = 0 ; i < text.length ; i++) {
			if(text[i] != null) {
				
				text[i] = null;
			}
			
		}
		

		
		
		String fullText = input.getText();
		int j = 0;
		for(int i = 0; i < fullText.length() ; i++) {
			
			if(fullText.charAt(i) == ',') {
				
				
				text[j] = fullText.substring(0, i);
				
				fullText = fullText.substring(i+1);
				i=0;
				j++;
				
			}
			
		}
			
		text[j+1] = fullText;
		
		
		


		
	}
	
}
