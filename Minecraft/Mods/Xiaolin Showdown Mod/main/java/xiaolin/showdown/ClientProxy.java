package xiaolin.showdown;



import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import xiaolin.showdown.items.ModItems;
import xiaolin.showdown.items.TunicTwoTon;
import xiaolin.showdown.jack.EntityJackbot;

import xiaolin.showdown.jack.JackbotRenderer;
import xiaolin.showdown.jack.ModelJackbot;

public class ClientProxy extends CommonProxy{
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		

	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		super.init(e);
		ModItems.registerItemModels();
		RenderingRegistry.registerEntityRenderingHandler(EntityJackbot.class, new JackbotRenderer(
				Minecraft.getMinecraft().getRenderManager(), new ModelJackbot(), 1));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(ModItems.jackbottop), 0, new ModelResourceLocation("xiaolin:jackbottop", "inventory"));

		}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		
		
	}
	


}
