package xiaolin.showdown;

import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xiaolin.showdown.items.ModItems;
import xiaolin.showdown.items.TunicTwoTon;
import xiaolin.showdown.jack.BlockJackbot;
import xiaolin.showdown.jack.EntityJackbot;
import xiaolin.showdown.showdownworld.WorldShowdownProvider;


public class CommonProxy {
	
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.registerItems();
		GameRegistry.registerBlock(ModItems.jackbottop, "jackbottop");
		
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		EntityRegistry.registerModEntity(EntityJackbot.class, "jackbot", 1,
				Main.instance, 100, 1, true);
		EntityRegistry.addSpawn(EntityJackbot.class, 8, 2,
				5, EnumCreatureType.MONSTER, BiomeGenBase.desert , BiomeGenBase.jungle, BiomeGenBase.birchForest, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.savanna);
		
	}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		DimensionManager.registerProviderType(2, WorldShowdownProvider.class, false);
		DimensionManager.registerDimension( 2,  2);
		
	}
	


}
