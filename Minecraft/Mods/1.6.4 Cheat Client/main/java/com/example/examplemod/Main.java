package com.example.examplemod;



import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;



@Mod(modid = Main.MODID,name = Main.NAME, version = Main.V)
public class Main {

	public static final String MODID = "rekcah";
	public static final String NAME = "Official Rekcah Mod";
	public static final String V = "0.0.69";

	
	@Instance(Main.MODID)
	public static Main instance;
	
	
	@SidedProxy(clientSide = "com.example.examplemod.ClientProxy", serverSide = "com.example.examplemod.CommonProxy")
	public static CommonProxy proxy;
	
	

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
		
		
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		this.proxy.init(e);
	}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.proxy.postInit(e);
		
	}
	
	
}
	
	

