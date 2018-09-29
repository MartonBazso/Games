package xiaolin.showdown;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Main.MODID,name= Main.NAME ,version= Main.V)


public class Main {
	
	public static final String MODID = "xiaolin";
	public static final String NAME = "Xiaolin Showdown Mod";
	public static final String V = "0.0.1";

	
	@Instance(Main.MODID)
public static Main instance;
	
	
	@SidedProxy(clientSide = "xiaolin.showdown.ClientProxy", serverSide = "xiaolin.showdown.CommonProxy")
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
