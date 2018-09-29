package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import xiaolin.showdown.effects.HanabiFire;
import xiaolin.showdown.effects.LightningBolt;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemDashi extends Item {

	public ItemDashi() {

		super();
		this.setUnlocalizedName("dashi");
		this.isDamageable();
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.maxStackSize = 1;

	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

		worldIn.spawnEntityInWorld(new LightningBolt(worldIn, playerIn));

		return itemStackIn;

	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}

	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("On Right click shoots" + EnumChatFormatting.GOLD+ " thunder");
	}

}
