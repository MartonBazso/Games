package xiaolin.showdown.jack;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xiaolin.showdown.Main;

public class ItemJackGlasses extends ItemArmor{

	public ItemJackGlasses(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName("jackglasses");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
		
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Main.MODID + ":textures/items/" + "jackglasses_1" + ".png";
	}
	
	
	@Override
	public boolean isDamageable() {

		return false;
	}
		
	
	

}
