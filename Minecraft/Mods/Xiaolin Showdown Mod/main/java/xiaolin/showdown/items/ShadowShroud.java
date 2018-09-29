package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ShadowShroud extends Item {

	public ShadowShroud() {
		super();
		this.setUnlocalizedName("shroud");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.isDamageable();
		this.maxStackSize = 1;

	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

		playerIn.swingItem();
		effectPlayer(playerIn, Potion.invisibility, 4);

		return itemStackIn;

	}

	private void effectPlayer(Entity player, Potion potion, int amplifier) {
		// Always effect for 1 seconds, then refresh
		if (((EntityLivingBase) player).getActivePotionEffect(potion) == null
				|| ((EntityLivingBase) player).getActivePotionEffect(potion).getDuration() <= 1)
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(potion.id, 35, amplifier, true, true));
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		if (isSelected == false) {

			if (entityIn.isInvisible()) {

				this.effectPlayer(entityIn, Potion.invisibility, 4);
			}

		}

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}

	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("Right click then switch away");
		list.add("to become "+EnumChatFormatting.BOLD+"invisible");
		list.add("(Do not wear any armor,");
		list.add("because no one guarantees your safety)");
		
	}
}
