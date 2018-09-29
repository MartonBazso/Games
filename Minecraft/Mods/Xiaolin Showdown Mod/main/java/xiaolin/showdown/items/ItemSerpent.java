package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemSerpent extends Item{
	
	private int serpent = 0;
	
	
	public ItemSerpent() {
		
		this.setUnlocalizedName("serpent");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
		this.isDamageable();
	
		
		
	}
	
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
			
			switch (serpent) {
			case 0:
				serpent = 1;
				break;
			case 1: 
				serpent = 0;
				break;
			default:
				serpent = 0;
				break;
				}
		
		
		
		
		return itemStackIn;
	}
	
	
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		EntityPlayer playerIn = ((EntityPlayer)entityIn);
		
		if(isSelected && playerIn.capabilities.isCreativeMode == false) {
		
			
				switch (serpent) {
				case 1:
					
					playerIn.capabilities.allowFlying = true;
					//playerIn.capabilities.isCreativeMode = false;
					playerIn.capabilities.disableDamage = true;
					playerIn.capabilities.isFlying = true;
					playerIn.noClip = true;
					playerIn.onGround = false;
					playerIn.fallDistance = 0;
					if(!playerIn.isSneaking()) {
					playerIn.moveEntityWithHeading(0, 1);
					}
					
					break;
					
				case 0:
					
					playerIn.capabilities.allowFlying = false;
					//playerIn.capabilities.isCreativeMode = false;
					playerIn.capabilities.disableDamage = false;
					playerIn.capabilities.isFlying = false;
					playerIn.noClip = false;
					break;
					
				default:
					playerIn.capabilities.allowFlying = false;
					playerIn.capabilities.isCreativeMode = false;
					playerIn.capabilities.disableDamage = false;
					playerIn.capabilities.isFlying = false;
					break;
				}
				
		}
				
				
		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("Move through objects");
		
	}



}
