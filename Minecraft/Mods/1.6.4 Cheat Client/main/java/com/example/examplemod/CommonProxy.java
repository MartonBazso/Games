package com.example.examplemod;


import com.example.examplemod.hacks.FullBright;
import com.example.examplemod.hacks.GhostMode;
import com.example.examplemod.hacks.NoFall;
import com.example.examplemod.utility.NoFallBlock;
import com.example.examplemod.utility.TestingListener;
import com.example.examplemod.utility.TheItem;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public static TheItem theItem = new TheItem(1000-256);
	public static Block cloud_block = new NoFallBlock(1001, Material.cloth).setUnlocalizedName("NoFallBlock").setTextureName(Main.MODID + ":NoFallBlock");
	public static KeyManager keyManager = new KeyManager();
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		GameRegistry.registerItem(theItem, "the_item");
		GameRegistry.registerBlock(cloud_block, "nofall_block");
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
	}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(keyManager);
		MinecraftForge.EVENT_BUS.register(new RekcahInterfaceDraw());
		MinecraftForge.EVENT_BUS.register(new NoFall());
		MinecraftForge.EVENT_BUS.register(new GhostMode());
		MinecraftForge.EVENT_BUS.register(new FullBright());
		MinecraftForge.EVENT_BUS.register(new TestingListener());
		
	}
	
}
