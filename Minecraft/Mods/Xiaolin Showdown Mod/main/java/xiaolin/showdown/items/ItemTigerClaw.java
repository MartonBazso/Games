package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemTigerClaw extends Item {

	boolean spawnPortal = false;
	boolean timerOn = false;
	public static final PropertyEnum AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class,
			new EnumFacing.Axis[] { EnumFacing.Axis.X, EnumFacing.Axis.Z });
	int timer;

	public ItemTigerClaw() {

		this.setUnlocalizedName("tigerclaws");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.isDamageable();

		this.maxStackSize = 1;

	}

	public boolean isDamageable() {

		return false;
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

		timer = 20 * 4;
		// if(timer == 0) {
		playerIn.swingItem();
		spawnPortal = true;
		playerIn.timeUntilPortal = 100;

		// }

		return itemStackIn;

	}

	public boolean setBlockToPortal(BlockPos pos, World worldIn, boolean X) {

		if (X == true) {
			if (worldIn.getBlockState(pos) == Blocks.air.getDefaultState()) {
				return worldIn.setBlockState(pos, Blocks.portal.getDefaultState().withProperty(AXIS, EnumFacing.Axis.Z),
						4);
			}
		}

		if (X == false) {
			if (worldIn.getBlockState(pos) == Blocks.air.getDefaultState()) {
				return worldIn.setBlockState(pos, Blocks.portal.getDefaultState(), 4);
			}
		}
		return false;
	}

	public void GateBlocks(int x, int y, int z, Entity entityIn, World worldIn, boolean X) {

		setBlockToPortal(new BlockPos(((EntityPlayer) entityIn).posX + x, ((EntityPlayer) entityIn).posY + y,
				((EntityPlayer) entityIn).posZ + z), worldIn, X);

	}

	public void playerTp(Entity entityIn, int distance) {

		EntityPlayer playerIn = (EntityPlayer) entityIn;

		if (playerIn.getHorizontalFacing() == EnumFacing.NORTH) {

			playerIn.setPositionAndUpdate(playerIn.posX, playerIn.posY, playerIn.posZ - distance);

		}
		if (playerIn.getHorizontalFacing() == EnumFacing.SOUTH) {

			playerIn.setPositionAndUpdate(playerIn.posX, playerIn.posY, playerIn.posZ + distance);

		}
		if (playerIn.getHorizontalFacing() == EnumFacing.WEST) {

			playerIn.setPositionAndUpdate(playerIn.posX - distance, playerIn.posY, playerIn.posZ);
		}
		if (playerIn.getHorizontalFacing() == EnumFacing.EAST) {

			playerIn.setPositionAndUpdate(playerIn.posX + distance, playerIn.posY, playerIn.posZ);
		}

	}

	public void GateOpen(Entity entityIn, World worldIn) {
		int distance = 25;
		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.NORTH) /* Towards negative Z */ {

			if (((EntityPlayer) entityIn).swingProgressInt == 1) {

				GateBlocks(-2, 4, -4, entityIn, worldIn, false);
				GateBlocks(-3, 3, -4, entityIn, worldIn, false);
				GateBlocks(-2, 3, -4, entityIn, worldIn, false);
				GateBlocks(-1, 3, -4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 2) {

				GateBlocks(0, 3, -4, entityIn, worldIn, false);
				GateBlocks(-2, 2, -4, entityIn, worldIn, false);
				GateBlocks(-1, 2, -4, entityIn, worldIn, false);
				GateBlocks(0, 2, -4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 3) {

				GateBlocks(1, 2, -4, entityIn, worldIn, false);
				GateBlocks(-1, 1, -4, entityIn, worldIn, false);
				GateBlocks(0, 1, -4, entityIn, worldIn, false);
				GateBlocks(1, 1, -4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 4) {

				GateBlocks(2, 1, -4, entityIn, worldIn, false);
				GateBlocks(0, 0, -4, entityIn, worldIn, false);
				GateBlocks(1, 0, -4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 5) {

				GateBlocks(2, 0, -4, entityIn, worldIn, false);
				GateBlocks(3, 0, -4, entityIn, worldIn, false);
				this.playerTp(entityIn, distance);
			}
		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.SOUTH) /* Towards positive Z */ {

			if (((EntityPlayer) entityIn).swingProgressInt == 1) {

				GateBlocks(-2, 4, 4, entityIn, worldIn, false);
				GateBlocks(-3, 3, 4, entityIn, worldIn, false);
				GateBlocks(-2, 3, 4, entityIn, worldIn, false);
				GateBlocks(-1, 3, 4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 2) {

				GateBlocks(0, 3, 4, entityIn, worldIn, false);
				GateBlocks(-2, 2, 4, entityIn, worldIn, false);
				GateBlocks(-1, 2, 4, entityIn, worldIn, false);
				GateBlocks(0, 2, 4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 3) {

				GateBlocks(1, 2, 4, entityIn, worldIn, false);
				GateBlocks(-1, 1, 4, entityIn, worldIn, false);
				GateBlocks(0, 1, 4, entityIn, worldIn, false);
				GateBlocks(1, 1, 4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 4) {

				GateBlocks(2, 1, 4, entityIn, worldIn, false);
				GateBlocks(0, 0, 4, entityIn, worldIn, false);
				GateBlocks(1, 0, 4, entityIn, worldIn, false);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 5) {

				GateBlocks(2, 0, 4, entityIn, worldIn, false);
				GateBlocks(3, 0, 4, entityIn, worldIn, false);
				this.playerTp(entityIn, distance);

			}
		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.WEST) /* Towards negative X */ {

			if (((EntityPlayer) entityIn).swingProgressInt == 1) {

				GateBlocks(-4, 0, 3, entityIn, worldIn, true);
				GateBlocks(-4, 0, 2, entityIn, worldIn, true);
				GateBlocks(-4, 0, 1, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 2) {

				GateBlocks(-4, 0, 0, entityIn, worldIn, true);
				GateBlocks(-4, 1, 2, entityIn, worldIn, true);
				GateBlocks(-4, 1, 1, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 3) {
				GateBlocks(-4, 1, 0, entityIn, worldIn, true);
				GateBlocks(-4, 2, 1, entityIn, worldIn, true);
				GateBlocks(-4, 2, 0, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 4) {

				GateBlocks(-4, 1, -1, entityIn, worldIn, true);
				GateBlocks(-4, 2, -1, entityIn, worldIn, true);
				GateBlocks(-4, 3, -1, entityIn, worldIn, true);
				GateBlocks(-4, 3, 0, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 5) {
				GateBlocks(-4, 2, -2, entityIn, worldIn, true);
				GateBlocks(-4, 3, -2, entityIn, worldIn, true);
				GateBlocks(-4, 4, -2, entityIn, worldIn, true);
				GateBlocks(-4, 3, -3, entityIn, worldIn, true);
				this.playerTp(entityIn, distance);
			}

		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.EAST)/* Towards positive X */ {

			if (((EntityPlayer) entityIn).swingProgressInt == 1) {

				GateBlocks(4, 0, 3, entityIn, worldIn, true);
				GateBlocks(4, 0, 2, entityIn, worldIn, true);
				GateBlocks(4, 0, 1, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 2) {

				GateBlocks(4, 0, 0, entityIn, worldIn, true);
				GateBlocks(4, 1, 2, entityIn, worldIn, true);
				GateBlocks(4, 1, 1, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 3) {
				GateBlocks(4, 1, 0, entityIn, worldIn, true);
				GateBlocks(4, 2, 1, entityIn, worldIn, true);
				GateBlocks(4, 2, 0, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 4) {

				GateBlocks(4, 1, -1, entityIn, worldIn, true);
				GateBlocks(4, 2, -1, entityIn, worldIn, true);
				GateBlocks(4, 3, -1, entityIn, worldIn, true);
				GateBlocks(4, 3, 0, entityIn, worldIn, true);

			}

			if (((EntityPlayer) entityIn).swingProgressInt == 5) {
				GateBlocks(4, 2, -2, entityIn, worldIn, true);
				GateBlocks(4, 3, -2, entityIn, worldIn, true);
				GateBlocks(4, 4, -2, entityIn, worldIn, true);
				GateBlocks(4, 3, -3, entityIn, worldIn, true);
				this.playerTp(entityIn, distance);

			}

		}

	}

	public boolean destroyPortalBlock(BlockPos pos, World worldIn, boolean X) {

		if (X == true) {
			if (worldIn.getBlockState(pos) == Blocks.portal.getDefaultState().withProperty(AXIS, EnumFacing.Axis.Z)) {
				return worldIn.setBlockState(pos, Blocks.air.getDefaultState(), 4);
			}
		}

		if (X == false) {
			if (worldIn.getBlockState(pos) == Blocks.portal.getDefaultState()) {
				return worldIn.setBlockState(pos, Blocks.air.getDefaultState(), 4);
			}
		}
		return false;
	}

	public void destroyGate(int x, int y, int z, Entity entityIn, World worldIn, boolean X) {

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.NORTH) /* Towards negative Z */ {
			destroyPortalBlock(new BlockPos(((EntityPlayer) entityIn).posX + x, ((EntityPlayer) entityIn).posY + y,
					((EntityPlayer) entityIn).posZ + z + 25), worldIn, X);
		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.SOUTH) /* Towards positive Z */ {
			destroyPortalBlock(new BlockPos(((EntityPlayer) entityIn).posX + x, ((EntityPlayer) entityIn).posY + y,
					((EntityPlayer) entityIn).posZ + z - 25), worldIn, X);
		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.WEST) /* Towards negative X */ {
			destroyPortalBlock(new BlockPos(((EntityPlayer) entityIn).posX + x + 25, ((EntityPlayer) entityIn).posY + y,
					((EntityPlayer) entityIn).posZ + z), worldIn, X);
		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.EAST) /* Towards positive X */ {
			destroyPortalBlock(new BlockPos(((EntityPlayer) entityIn).posX + x - 25, ((EntityPlayer) entityIn).posY + y,
					((EntityPlayer) entityIn).posZ + z), worldIn, X);
		}

	}

	public void destroyFullGate(Entity entityIn, World worldIn) {
		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.NORTH) /* Towards negative Z */ {

			destroyGate(-2, 4, -4, entityIn, worldIn, false);
			destroyGate(-3, 3, -4, entityIn, worldIn, false);
			destroyGate(-2, 3, -4, entityIn, worldIn, false);
			destroyGate(-1, 3, -4, entityIn, worldIn, false);
			destroyGate(0, 3, -4, entityIn, worldIn, false);
			destroyGate(-2, 2, -4, entityIn, worldIn, false);
			destroyGate(-1, 2, -4, entityIn, worldIn, false);
			destroyGate(0, 2, -4, entityIn, worldIn, false);
			destroyGate(1, 2, -4, entityIn, worldIn, false);
			destroyGate(-1, 1, -4, entityIn, worldIn, false);
			destroyGate(0, 1, -4, entityIn, worldIn, false);
			destroyGate(1, 1, -4, entityIn, worldIn, false);
			destroyGate(2, 1, -4, entityIn, worldIn, false);
			destroyGate(0, 0, -4, entityIn, worldIn, false);
			destroyGate(1, 0, -4, entityIn, worldIn, false);
			destroyGate(2, 0, -4, entityIn, worldIn, false);
			destroyGate(3, 0, -4, entityIn, worldIn, false);

		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.SOUTH) /* Towards positive Z */ {

			destroyGate(-2, 4, 4, entityIn, worldIn, false);
			destroyGate(-3, 3, 4, entityIn, worldIn, false);
			destroyGate(-2, 3, 4, entityIn, worldIn, false);
			destroyGate(-1, 3, 4, entityIn, worldIn, false);
			destroyGate(0, 3, 4, entityIn, worldIn, false);
			destroyGate(-2, 2, 4, entityIn, worldIn, false);
			destroyGate(-1, 2, 4, entityIn, worldIn, false);
			destroyGate(0, 2, 4, entityIn, worldIn, false);
			destroyGate(1, 2, 4, entityIn, worldIn, false);
			destroyGate(-1, 1, 4, entityIn, worldIn, false);
			destroyGate(0, 1, 4, entityIn, worldIn, false);
			destroyGate(1, 1, 4, entityIn, worldIn, false);
			destroyGate(2, 1, 4, entityIn, worldIn, false);
			destroyGate(0, 0, 4, entityIn, worldIn, false);
			destroyGate(1, 0, 4, entityIn, worldIn, false);
			destroyGate(2, 0, 4, entityIn, worldIn, false);
			destroyGate(3, 0, 4, entityIn, worldIn, false);

		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.WEST) /* Towards negative X */ {

			destroyGate(-4, 0, 3, entityIn, worldIn, true);
			destroyGate(-4, 0, 2, entityIn, worldIn, true);
			destroyGate(-4, 0, 1, entityIn, worldIn, true);
			destroyGate(-4, 0, 0, entityIn, worldIn, true);
			destroyGate(-4, 1, 2, entityIn, worldIn, true);
			destroyGate(-4, 1, 1, entityIn, worldIn, true);
			destroyGate(-4, 1, 0, entityIn, worldIn, true);
			destroyGate(-4, 2, 1, entityIn, worldIn, true);
			destroyGate(-4, 2, 0, entityIn, worldIn, true);
			destroyGate(-4, 1, -1, entityIn, worldIn, true);
			destroyGate(-4, 2, -1, entityIn, worldIn, true);
			destroyGate(-4, 3, -1, entityIn, worldIn, true);
			destroyGate(-4, 3, 0, entityIn, worldIn, true);
			destroyGate(-4, 2, -2, entityIn, worldIn, true);
			destroyGate(-4, 3, -2, entityIn, worldIn, true);
			destroyGate(-4, 4, -2, entityIn, worldIn, true);
			destroyGate(-4, 3, -3, entityIn, worldIn, true);

		}

		if (((EntityPlayer) entityIn).getHorizontalFacing() == EnumFacing.EAST) /* Towards positive X */ {

			destroyGate(4, 0, 3, entityIn, worldIn, true);
			destroyGate(4, 0, 2, entityIn, worldIn, true);
			destroyGate(4, 0, 1, entityIn, worldIn, true);
			destroyGate(4, 0, 0, entityIn, worldIn, true);
			destroyGate(4, 1, 2, entityIn, worldIn, true);
			destroyGate(4, 1, 1, entityIn, worldIn, true);
			destroyGate(4, 1, 0, entityIn, worldIn, true);
			destroyGate(4, 2, 1, entityIn, worldIn, true);
			destroyGate(4, 2, 0, entityIn, worldIn, true);
			destroyGate(4, 1, -1, entityIn, worldIn, true);
			destroyGate(4, 2, -1, entityIn, worldIn, true);
			destroyGate(4, 3, -1, entityIn, worldIn, true);
			destroyGate(4, 3, 0, entityIn, worldIn, true);
			destroyGate(4, 2, -2, entityIn, worldIn, true);
			destroyGate(4, 3, -2, entityIn, worldIn, true);
			destroyGate(4, 4, -2, entityIn, worldIn, true);
			destroyGate(4, 3, -3, entityIn, worldIn, true);

		}
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		if (spawnPortal == true && isSelected == true) {
			timer--;
			worldIn.getClosestPlayerToEntity(entityIn, 20).timeUntilPortal = 100;
			worldIn.getClosestPlayerToEntity(entityIn, 25).timeUntilPortal = 100;

			GateOpen(entityIn, worldIn);
			destroyFullGate(entityIn, worldIn);
			if (timer == 0) {

				spawnPortal = false;
				timer = 20 * 4;
			}

		}

		/*
		 * if(timerOn == true ) {
		 * 
		 * timer--;
		 * 
		 * if(timer ==0 ) { timerOn = false; }
		 * 
		 * }
		 */

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}

	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("On Right click you can teleport to a faraway land,");
		list.add("ooor to a 25 block distance,");
		list.add("well the latter is more likely to happen :/");
	}

}