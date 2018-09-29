package com.example.examplemod.utility;

import java.awt.Color;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class TheItem extends Item
{

	
	
	
	public TheItem(int par1) {
		super(par1);
		this.setUnlocalizedName("TheItem");
	}
	
	
	@SideOnly(Side.CLIENT)
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		
		
		
		
		
		if(par2World.isRemote == true) {
			
				Minecraft.getMinecraft().fontRenderer.drawString("Hello There!", 100, 10, 0xffFFFFFF);
			
			//Minecraft.getMinecraft().displayGuiScreen(new RekcahGui(par3EntityPlayer,par2World));	
			
		}
	
		
        return par1ItemStack;
    }
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		
		if(par2World.isRemote == true) {
			
		//Minecraft.getMinecraft().fontRenderer.drawString("Hello There!", 100, 10, 0xffFFFFFF);
		
		}
	}

}
