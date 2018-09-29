package xiaolin.showdown.items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemTebigong extends ItemTool {

	private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] { Blocks.activator_rail, Blocks.coal_ore,
			Blocks.cobblestone, Blocks.detector_rail, Blocks.diamond_block, Blocks.diamond_ore,
			Blocks.double_stone_slab, Blocks.golden_rail, Blocks.gold_block, Blocks.gold_ore, Blocks.ice,
			Blocks.iron_block, Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore, Blocks.lit_redstone_ore,
			Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.packed_ice, Blocks.rail, Blocks.redstone_ore,
			Blocks.sandstone, Blocks.red_sandstone, Blocks.stone, Blocks.stone_slab, Blocks.clay, Blocks.dirt,
			Blocks.farmland, Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer,
			Blocks.soul_sand, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin,
			Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder });

	protected ItemTebigong(ToolMaterial material) {
		super(2f, material, EFFECTIVE_ON);

		this.setUnlocalizedName("tebigong");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.isDamageable();
		super.efficiencyOnProperMaterial = 10f;
		this.setHarvestLevel("pickaxe", 3);
		this.setHarvestLevel("axe", 3);
		this.setHarvestLevel("shovel", 3);
		this.maxStackSize = 1;
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos,
			EntityLivingBase playerIn) {
		if (!worldIn.isRemote) {
			((WorldServer) worldIn).spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, true, playerIn.posX, playerIn.posY,
					playerIn.posZ, 1, 0.0D, 0.0D, 0.0D, 0, new int[0]);
		}

		return true;
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
		list.add("Just hit");
	}
	
	

}
