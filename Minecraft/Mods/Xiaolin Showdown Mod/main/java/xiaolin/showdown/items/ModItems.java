package xiaolin.showdown.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundList.SoundEntry;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xiaolin.showdown.ItemRegister;
import xiaolin.showdown.Main;
import xiaolin.showdown.effects.HanabiFire;
import xiaolin.showdown.effects.ItemTest;
import xiaolin.showdown.jack.BlockJackbot;
import xiaolin.showdown.jack.ItemJackGlasses;

	public class ModItems{
		
		
	public static ToolMaterial ShenMaterial = EnumHelper.addToolMaterial(null, 1, 0, 4.0F, 6.0F, 0);
	public static ArmorMaterial ShenArmorMaterial1 = EnumHelper.addArmorMaterial(null,"xiaolin:twoton" ,100000, new int[] {0,20, 0, 0}, 0);
	public static ArmorMaterial ShenArmorMaterial2 = EnumHelper.addArmorMaterial(null,"xiaolin:twoton" ,100000, new int[] {0,0, 0, 0}, 0);
	public static ItemTornami tornami = new ItemTornami();//"diamond", 33, new int[]{3, 8, 6, 3}, 10
	public static Item stormsword = new ItemStormSword(ModItems.ShenMaterial);
	public static Item twoton = new ArmorTwoTon(ModItems.ShenArmorMaterial1);
	public static Item tunictwo = new TunicTwoTon(ShenArmorMaterial2);
	public static Item hanabi = new ItemHanabi();
	public static Item shroud = new ShadowShroud();
	public static Item mantis = new ItemMantis();
	public static Item tigerclaws = new ItemTigerClaw();
	public static Item testitem = new ItemTest();
	public static Item tebigong = new ItemTebigong(ShenMaterial);
	public static Item dashi = new ItemDashi();
	public static Item jackglasses = new ItemJackGlasses(ShenArmorMaterial2, 0, 0);
	public static Block jackbottop = new BlockJackbot(Material.iron);
	public static Item lunar = new ItemLunar();
	public static Item ants = new ItemAnts();
	public static Item serpent = new ItemSerpent();
	public static Item moonstone = new ItemMoonstone();
	
    public static void registerItems() {
    	
    	ItemRegister.registerItem(testitem, "testitem");
    	ItemRegister.registerItem(stormsword, "stormsword");
		ItemRegister.registerItem(tornami, "tornami");
		ItemRegister.registerItem(twoton, "twoton");
		ItemRegister.registerItem(tunictwo, "tunictwo");
		ItemRegister.registerItem(hanabi, "hanabi");
		ItemRegister.registerItem(shroud, "shroud");
		ItemRegister.registerItem(mantis, "mantis");
		ItemRegister.registerItem(tigerclaws, "tigerclaws");
		ItemRegister.registerItem(tebigong, "tebigong");
		ItemRegister.registerItem(dashi, "dashi");
		ItemRegister.registerItem(lunar, "lunar");
		//ItemRegister.registerItem(ants, "ants");
		ItemRegister.registerItem(serpent, "serpent");
		ItemRegister.registerItem(moonstone, "moonstone");
		GameRegistry.registerItem(jackglasses, "jackglasses");
		
    }
	
    public static void registerItemModels() {
    	
    	
    	ItemRegister.registerItemModel(tornami);
    	ItemRegister.registerItemModel(stormsword);
    	ItemRegister.registerItemModel(twoton);
    	ItemRegister.registerItemModel(tunictwo);
    	ItemRegister.registerItemModel(hanabi);
    	ItemRegister.registerItemModel(shroud);
    	ItemRegister.registerItemModel(mantis);
    	ItemRegister.registerItemModel(tigerclaws);
    	ItemRegister.registerItemModel(tebigong);
    	ItemRegister.registerItemModel(dashi);
    	ItemRegister.registerItemModel(jackglasses);
    	ItemRegister.registerItemModel(lunar);
    	//ItemRegister.registerItemModel(ants);
    	ItemRegister.registerItemModel(serpent);
       	ItemRegister.registerItemModel(moonstone);
    	
    }
    

}
