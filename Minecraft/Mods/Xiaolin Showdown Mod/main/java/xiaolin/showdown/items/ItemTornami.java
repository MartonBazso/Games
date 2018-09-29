package xiaolin.showdown.items;

import java.util.List;
import java.util.concurrent.TimeUnit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemTornami extends Item {

	public BlockPos gonnaBeWater;
	public BlockPos test;

	// Instantiates this item
	public ItemTornami() {
		super();
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("tornami");
		this.maxStackSize = 1;
		this.setFull3D();
		
	}

	// Makes the orb unbreakable
	@Override
	public boolean isDamageable() {
		return false;

	}

	// Az adott blockot vízzé teszi, ha levegõ, semmit nem csinál, ha nem az.
	public boolean setBlockToWater(BlockPos pos, World worldIn) {

		if (worldIn.getBlockState(pos) == Blocks.air.getDefaultState()) {
			return worldIn.setBlockState(pos, Blocks.water.getDefaultState(), 3);
		}
		return false;
	}

	// A jobb-click event-kor vízzé teszi a playertõl a player nézése felé lévõ
	// blockokat

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		playerIn.swingItem();
		this.setBlockToWater(gonnaBeWater = new BlockPos(playerIn).up().offset(playerIn.getHorizontalFacing(), 1),
				worldIn);
		this.setBlockToWater(gonnaBeWater = new BlockPos(playerIn).up().offset(playerIn.getHorizontalFacing(), 2),
				worldIn);
		this.setBlockToWater(gonnaBeWater = new BlockPos(playerIn).up().offset(playerIn.getHorizontalFacing(), 3),
				worldIn);

		this.setBlockToWater(gonnaBeWater = new BlockPos(playerIn).offset(playerIn.getHorizontalFacing(), 1), worldIn);
		this.setBlockToWater(gonnaBeWater = new BlockPos(playerIn).offset(playerIn.getHorizontalFacing(), 2), worldIn);
		this.setBlockToWater(gonnaBeWater = new BlockPos(playerIn).offset(playerIn.getHorizontalFacing(), 3), worldIn);

		worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, gonnaBeWater.getX() + 1, playerIn.posY + 1,
				gonnaBeWater.getZ() + 1, 10, 110, 110, 11);

		worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, gonnaBeWater.getX(), playerIn.posY + 1,
				gonnaBeWater.getZ(), 110, 110, 110, 11);

		worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, gonnaBeWater.getX() - 1, playerIn.posY + 1,
				gonnaBeWater.getZ() - 1, 10, 10, 110, 11);

		return itemStackIn;

	}

	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("Just create infinite amount of" + EnumChatFormatting.AQUA + " WATER");
	}

}

/*
 * Experimenting saves, in case they will be useful later (but it wont be
 * spaghetti) : MovingObjectPosition kutya =
 * this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);
 * System.out.println(kutya.toString());
 * 
 * 
 * 
 * /*test = new BlockPos(playerIn.getLookVec()); MovingObjectPosition asd = new
 * MovingObjectPosition(); System.out.println(playerIn.getLookVec());
 * this.setBlockToWater(test, worldIn);
 */

/*
 * MovingObjectPosition movingobjectposition =
 * this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);
 * 
 * 
 * 
 * test = movingobjectposition.getBlockPos();
 * 
 * 
 * 
 * this.setBlockToWater(test , worldIn);
 * 
 * 
 * 
 * 
 * // MovingObjectPosition movingobjectposition =
 * this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true); //test =
 * movingobjectposition.getBlockPos();
 * 
 * 
 * 
 * /* public static void waterOut(BlockPos gonnaBeWater, World worldIn,
 * EntityPlayer playerIn) {
 * 
 * MovingObjectPosition player = new MovingObjectPosition(playerIn);
 * 
 * if (player.typeOfHit == MISS) {}
 * 
 * 
 * 
 * 
 * }
 */
