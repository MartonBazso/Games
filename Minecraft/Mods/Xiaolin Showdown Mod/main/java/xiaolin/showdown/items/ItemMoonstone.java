package xiaolin.showdown.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockTallGrass.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import xiaolin.showdown.ItemRegister;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ItemMoonstone extends Item{
	
	Random random = new Random();
	private Block[] plantList = {Blocks.yellow_flower ,Blocks.red_flower ,Blocks.brown_mushroom ,Blocks.red_mushroom ,Blocks.tallgrass ,
			Blocks.deadbush ,Blocks.wheat ,Blocks.cactus ,Blocks.pumpkin ,Blocks.brown_mushroom_block ,
			Blocks.red_mushroom_block ,Blocks.melon_block ,Blocks.waterlily ,Blocks.cocoa ,
			Blocks.carrots ,Blocks.potatoes ,Blocks.hay_block , Blocks.leaves, Blocks.leaves2 , Blocks.grass , Blocks.sapling , Blocks.double_plant};
	private IProperty[] properties;
	public ItemMoonstone() {
		this.setUnlocalizedName("moonstone");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.maxStackSize = 1;
		
	}
	
	
	public boolean isDamageable()
    {
		return false;
    }
	
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		playerIn.swingItem();
		
		int distance = 6;
		int height = 4;
		int width = 5;
		EnumFacing[] facing = {EnumFacing.EAST,EnumFacing.WEST,EnumFacing.NORTH,EnumFacing.SOUTH};
	for(int l = -5 ; l < width; l++) {	
		for(int i = 0 ; i < facing.length ; i++ ) {
			
			for(int j = 0; j < distance ;j++) {
				
				for(int k = -1; k < height ; k++) {
				BlockPos plant = new BlockPos(playerIn).offset(facing[i], j).up(k).west(l - random.nextInt(3)).north(l - random.nextInt(3));
				properties = (IProperty[]) worldIn.getBlockState(plant).getPropertyNames().toArray( new IProperty[worldIn.getBlockState(plant).getPropertyNames().size()]);
				if(worldIn.getBlockState(plant).getBlock() == Blocks.grass) {
									worldIn.setBlockState(plant, Blocks.farmland.getDefaultState() );
									
					}
				
				if(worldIn.getBlockState(plant) == Blocks.mossy_cobblestone.getDefaultState()) {
					worldIn.setBlockState(plant, Blocks.cobblestone.getDefaultState() );
					
				}
				
//				if(worldIn.getBlockState(plant).getBlock() == Blocks.double_plant) 
//				{
//					worldIn.setBlockState(plant, Blocks.air.getDefaultState() );
//					
//				}
				
				
				for(Block plantBlock : plantList) {
					
						if(worldIn.getBlockState(plant).getBlock() == plantBlock) {
							worldIn.setBlockState(plant, Blocks.air.getDefaultState() );
					
						}
					
				}
				
				
				
				if (!worldIn.isRemote) {
				if(random.nextInt(50) == 0) {
					((WorldServer) worldIn).spawnParticle(EnumParticleTypes.CLOUD, true, plant.getX() + random.nextDouble(),
						plant.getY() + random.nextInt(height - 2), plant.getZ() + random.nextDouble(),1,1, 1, 1.0D,0, new int[0]);
							}
					}
						
					
					}
					
				}
				
			}
			
		}	
		
		
        return itemStackIn;
    }

	
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("Release an army of locust");
		list.add("that eats any plants in sight.");
	}
}
