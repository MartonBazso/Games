package xiaolin.showdown.items;

import java.util.List;
import java.util.Timer;

import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundList.SoundEntry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemMantis extends Item {

	int timer = 1000;

	public ItemMantis() {

		super();

		this.setUnlocalizedName("mantis");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.isDamageable();
		this.maxStackSize = 1;

	}

	public boolean isDamageable() {
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

		playerIn.swingItem();
		effectPlayer(playerIn, Potion.jump, 5);

		worldIn.playSoundAtEntity(playerIn, "xiaolin:coinflip", 0.3F, 0.7F);
		return itemStackIn;

	}

	private void effectPlayer(EntityLivingBase player, Potion potion, int amplifier) {
		// Always effect for 1 seconds, then refresh
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
			player.addPotionEffect(new PotionEffect(potion.id, 35, amplifier, true, true));
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		if (isSelected == true) {

			if (((EntityLivingBase) entityIn).getActivePotionEffect(Potion.jump) != null) {

				effectPlayer((EntityLivingBase) entityIn, Potion.jump, 5);

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
		list.add("Right click, then don't" );
		list.add("switch away from this item,");
		list.add("then get ready to juuuump!" );
	}
}
