package xiaolin.showdown.items;

import java.util.List;
import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.util.EnumHelper;
import xiaolin.showdown.effects.EntityTornado;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemStormSword extends ItemSword {

	boolean shouldTornado = false;
	double rotation = 8;
	double height = 6;
	double range = 4;

	public ItemStormSword(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("stormsword");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.isDamageable();
		this.maxStackSize = 1;

	}

	@Override
	public boolean isDamageable() {
		return false;

	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

		Random rand = new Random();
		int value = rand.nextInt(50);
		int value2 = rand.nextInt(50);

		if (!playerIn.capabilities.isFlying) {
			playerIn.jump();
			playerIn.fallDistance = 0;
		}
		if (!playerIn.worldObj.isRemote) {
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			EntityPlayerMP playerMp = (EntityPlayerMP) minecraftserver.getEntityFromUuid(playerIn.getUniqueID());

			worldIn.rainingStrength = 2;
		}
		// worldIn.addWeatherEffect(playerIn);
		if (value < 10 && value2 < 10) {
			playerIn.worldObj.addWeatherEffect(new EntityLightningBolt(playerIn.worldObj, playerIn.posX + 1 + value,
					playerIn.posY + 1, playerIn.posZ + 1 + value2));
		}

		shouldTornado = true;

		return itemStackIn;
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		EntityPlayer playerIn = (EntityPlayer) entityIn;
		if (!entityIn.worldObj.isRemote) {
			if (playerIn.onGround) {
				shouldTornado = false;
			}
			if (shouldTornado == true && !((EntityPlayer) entityIn).onGround) {

				if (rotation == 8) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX + range, playerIn.posY - height + 1,
							playerIn.posZ, 0, 0, 0);
				}
				if (rotation == 7) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX + range, playerIn.posY - height + 1,
							playerIn.posZ - range, 0, 0, 0);
				}
				if (rotation == 6) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX, playerIn.posY - height + 1,
							playerIn.posZ - range, 0, 0, 0);
				}
				if (rotation == 5) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX - range, playerIn.posY - height + 1,
							playerIn.posZ - range, 0, 0, 0);
				}
				if (rotation == 4) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX - range, playerIn.posY - height + 1,
							playerIn.posZ, 0, 0, 0);
				}
				if (rotation == 3) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX - range, playerIn.posY - height + 1,
							playerIn.posZ + range, 0, 0, 0);
				}
				if (rotation == 2) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX, playerIn.posY - height + 1,
							playerIn.posZ + range, 0, 0, 0);
				}
				if (rotation == 1) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX + range, playerIn.posY - height + 1,
							playerIn.posZ + range, 0, 0, 0);
				}

				if (rotation == 0) {
					worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX, playerIn.posY - height + 1,
							playerIn.posZ, 0, 0, 0);

					rotation = 8;
					height += 1;
					range -= 0.25;
				}

				rotation -= 0.5;

				if (range < 0) {
					range = 3;
					height = -1;

				}

			}

		}

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}

	public void tornadoAroundPlayer(World worldIn, EntityPlayer playerIn, int range, int height) {

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX, playerIn.posY - height + 1, playerIn.posZ, 0, 0,
				0);

	}

	/*
	 * public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer
	 * playerIn) {
	 * 
	 * 
	 * 
	 * worldIn.setRainStrength(0f); return stack; }
	 */
	public void Tornado(World worldIn, EntityPlayer playerIn, double range, double height) {

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX + range, playerIn.posY - height + 1, playerIn.posZ,
				0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX, playerIn.posY - height + 1, playerIn.posZ + range,
				0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX + range, playerIn.posY - height + 1, playerIn.posZ,
				0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX - range, playerIn.posY - height + 1, playerIn.posZ,
				0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX, playerIn.posY - height + 1, playerIn.posZ - range,
				0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX + range, playerIn.posY - height + 1,
				playerIn.posZ + range, 0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX + range, playerIn.posY - height + 1,
				playerIn.posZ - range, 0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX - range, playerIn.posY - height + 1,
				playerIn.posZ - range, 0, 0, 0);

		worldIn.spawnParticle(EnumParticleTypes.CLOUD, playerIn.posX - range, playerIn.posY - height + 1,
				playerIn.posZ + range, 0, 0, 0);

	}

	/*
	 * public void Tornado(World worldIn, EntityPlayer playerIn) {
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX + 1,
	 * playerIn.posY - 2, playerIn.posZ, 0,0,0);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX - 1,
	 * playerIn.posY - 2, playerIn.posZ, 0,0,0);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX, playerIn.posY -
	 * 2, playerIn.posZ + 1, 10000, 10000, 10000, 30000);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX, playerIn.posY -
	 * 2, playerIn.posZ - 1, 10000, 10000, 10000, 30000);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX + 1,
	 * playerIn.posY - 2, playerIn.posZ + 1, 10000, 10000, 10000, 30000);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX - 1,
	 * playerIn.posY - 2, playerIn.posZ - 1, 10000, 10000, 10000, 30000);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX +1 ,
	 * playerIn.posY - 2, playerIn.posZ - 1, 10000, 10000, 10000, 30000);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX - 1,
	 * playerIn.posY - 2 , playerIn.posZ + 1, 10000, 10000, 10000, 30000);
	 * 
	 * worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX, playerIn.posY -
	 * 3, playerIn.posZ, 10000, 10000, 10000, 30000);
	 * 
	 * 
	 * }
	 */

	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		
		list.add("So yeah... a " + EnumChatFormatting.ITALIC+"sword,");
		list.add("makes"+ EnumChatFormatting.GOLD+" thunder,");
		list.add("and you can "+ EnumChatFormatting.UNDERLINE+"fly,");
		list.add("what are you waiting for?");
		list.add("Just right click");	
		
	}

}
