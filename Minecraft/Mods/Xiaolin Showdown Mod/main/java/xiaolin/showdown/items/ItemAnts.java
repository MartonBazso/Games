package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import xiaolin.showdown.effects.Ants;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemAnts extends Item{
	
	private boolean cast = false;
	public ItemAnts() {
		super();
		this.setUnlocalizedName("ants");
		this.maxStackSize = 1;
		this.isDamageable();
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	
	public boolean isDamageable()
    {
        return false;
    }
	
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		
		worldIn.spawnEntityInWorld(new Ants(worldIn, playerIn));
        return itemStackIn;
    }
	
	
	
	
	private EntityPlayer[] playersCloseToPlayer(Entity entityIn , int distance) {
		EntityPlayer playerIn = (EntityPlayer)entityIn;
		EntityPlayer[] closeplayers = new EntityPlayer[playerIn.worldObj.playerEntities.size()];
		
		for(int i = 0; i < playerIn.worldObj.playerEntities.size(); i++) {
			EntityPlayer player2 = (EntityPlayer)playerIn.worldObj.playerEntities.get(i);
			if(player2.getDistance(playerIn.posX, playerIn.posY, playerIn.posZ) <= distance ) {
				closeplayers[i] = player2;
			}
		}
		
		return closeplayers;
		
	}
	
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		/*if(cast && isSelected) {
			for(int j = 0 ; j < worldIn.playerEntities.size(); j++) {
				if(playersCloseToPlayer(entityIn, 5)[j] != null) {
					//playersCloseToPlayer(entityIn, 5)[j].jump();
					System.out.println(playersCloseToPlayer(entityIn, 5)[j]);
				}
			}
		} else {
			cast = false;
		}*/
		
		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("Make the enemy jump,");
		list.add("like he has ants in his pants!");
	}

}
