package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemLunar extends Item{
	
	int time = 13000;
	int timechange = 150;
	
	public ItemLunar() {
		
		this.setUnlocalizedName("lunar");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.maxStackSize = 1;
		this.isDamageable();
		
		
	}

	
	@Override
	public boolean isDamageable() {
		return false;
	}
	
	
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		
		
		
		worldIn.setWorldTime(time);
		
		
		time+= timechange;
		if(time > 22350) {
			timechange = -150;
		}
		
		
		if( time < 14000 ) {
			timechange = 150;
		}
		return itemStackIn;
		
	}
	
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}
	
	 public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
	    {
	    		
	    		ShowdownHelper.onEntityItemUpdate(entityItem, this);
	    		
	    		return false;
	    }
	 
		@Override
		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced)
		{
		list.add("You can move the moon");
		}
}
