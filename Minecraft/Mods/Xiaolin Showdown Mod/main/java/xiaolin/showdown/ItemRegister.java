package xiaolin.showdown;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegister {
	
	
	public static String modid = Main.MODID;
	public static List<Item> wuList = new ArrayList<Item>();
	
	
	public static void registerItem(Item item, String name) {
		
		GameRegistry.registerItem(item, name);
		wuList.add(item);
	}


	public static void registerItemModel(Item item) {
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	     .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
		
		
		
	}	
	
	


}
