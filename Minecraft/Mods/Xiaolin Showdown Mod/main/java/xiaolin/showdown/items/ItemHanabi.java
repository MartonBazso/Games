package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import xiaolin.showdown.effects.HanabiFire;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemHanabi extends Item {

	int counter = 15;
	boolean isCounting = false;

	public ItemHanabi() {

		super();
		this.setUnlocalizedName("hanabi");
		this.isDamageable();
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.maxStackSize = 1;

	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	public boolean setBlockToFire(BlockPos pos, World worldIn) {

		if (worldIn.getBlockState(pos) == Blocks.air.getDefaultState()) {
			return worldIn.setBlockState(pos, Blocks.fire.getDefaultState(), 3);
		}
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

		// isCounting = true;

		// if(counter == 0 ) {

		worldIn.spawnEntityInWorld(new HanabiFire(worldIn, playerIn));

		/*
		 * counter = 60;
		 * 
		 * }
		 */

		return itemStackIn;

	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}

	public void RotationCounter(World worldIn, EntityPlayer playerIn, double rotationYaw) {

		// Ha egyenesen n�z
		// 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		if (playerIn.rotationPitch == 0) {

			// Get the index of this horizontal facing (0-3). The order is S-W-N-E
			// Ha a pozit�v x fel� n�z - east
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 3) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 1,
						-1 * playerIn.rotationPitch / 90, 0);

				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 100,
						-1 * playerIn.rotationPitch / 90, 0);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a pozit�v z fel� n�z - south
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 0) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 0,
						-1 * playerIn.rotationPitch / 90, 1);

				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 0,
						-1 * playerIn.rotationPitch / 90, 100);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a negat�v x fel� n�z - west
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 1) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, -1,
						-1 * playerIn.rotationPitch / 90, 0);
				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, -100,
						-1 * playerIn.rotationPitch / 90, 0);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a negat�v z fel� n�z - north
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 2) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 0,
						-1 * playerIn.rotationPitch / 90, -1);
				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 0,
						-1 * playerIn.rotationPitch / 90, -100);
				worldIn.spawnEntityInWorld(hanabifire);
			}

		}

		// Ha lefel� n�z
		// -----------------------------------------------------------------------------------------------------------
		if (playerIn.rotationPitch < 0) {
			// Get the index of this horizontal facing (0-3). The order is S-W-N-E
			// Ha a pozit�v x fel� n�z - east
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 3) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 1,
						-1 * playerIn.rotationPitch / 90, 0);

				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 100,
						-1 * playerIn.rotationPitch / 90, 0);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a pozit�v z fel� n�z - south
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 0) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 0,
						-1 * playerIn.rotationPitch / 90, 1);

				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 0,
						-1 * playerIn.rotationPitch / 90, 100);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a negat�v x fel� n�z - west
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 1) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, -1,
						-1 * playerIn.rotationPitch / 90, 0);
				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, -100,
						-1 * playerIn.rotationPitch / 90, 0);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a negat�v z fel� n�z - north
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 2) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 0,
						-1 * playerIn.rotationPitch / 90, -1);
				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 0,
						-1 * playerIn.rotationPitch / 90, -100);
				worldIn.spawnEntityInWorld(hanabifire);
			}

		}

		// Ha felfel� n�z
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (playerIn.rotationPitch > 0) {

			// Get the index of this horizontal facing (0-3). The order is S-W-N-E
			// Ha a pozit�v x fel� n�z - east
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 3) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 1,
						-1 * playerIn.rotationPitch / 90, 0);

				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 100,
						-1 * playerIn.rotationPitch / 90, 0);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a pozit�v z fel� n�z - south
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 0) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 0,
						-1 * playerIn.rotationPitch / 90, 1);

				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 0,
						-1 * playerIn.rotationPitch / 90, 100);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a negat�v x fel� n�z - west
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 1) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, -1,
						-1 * playerIn.rotationPitch / 90, 0);
				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, -100,
						-1 * playerIn.rotationPitch / 90, 0);
				worldIn.spawnEntityInWorld(hanabifire);
			}
			// Ha a negat�v z fel� n�z - north
			if (playerIn.getHorizontalFacing().getHorizontalIndex() == 2) {

				worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY + 1, playerIn.posZ, 0,
						-1 * playerIn.rotationPitch / 90, -1);
				EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 0,
						-1 * playerIn.rotationPitch / 90, -100);
				worldIn.spawnEntityInWorld(hanabifire);
			}

		}

	}

	public void FireBall(World worldIn, EntityPlayer playerIn, double rotationYaw) {
		EntitySmallFireball hanabifire = new EntitySmallFireball(worldIn, playerIn, 0, -1 * playerIn.rotationPitch, 0);

		worldIn.spawnEntityInWorld(hanabifire);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("Right click = " + EnumChatFormatting.RED + "FIRE");
	}

	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}
}
