package com.example.examplemod.utility;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class NoFallBlock extends Block{

	
	
	public NoFallBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4)  {
		
		
		
		helper(par1World, par2,par3,par4);
		
		
		
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		
		
		
		helper(par1World, par2,par3,par4);
		
		
		
	}
	
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		
		
		
		helper(par1World, par2,par3,par4);
			
		
		
		
		
	}
	
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		
		helper(par1World, par2,par3,par4);
		
		
	}
		
	
	
	
	private void helper(World world , int x , int y , int z ) {
		
			for(int i = -3 ; i <5 ; i++) {
				for(int j = -3 ; j < 3 ; j++) {
					for(int k = -3 ; k < 3 ; k++) {
						
					
							if(world.getBlockId(x + i, y + j , z + k) == this.blockID) {
								
								world.destroyBlock(x + i, y + j , z + k ,false);
								world.setBlockToAir(x + i, y + j , z + k);
								world.notifyBlockChange(x + i, y + j , z + k, this.blockID);
								world.markBlockForRenderUpdate(x + i, y + j , z + k);
								world.markBlockForUpdate(x + i, y + j , z + k);
								
							}
						}
					}
				}
			
	}
	
    public int tickRate(World par1World)
    {
        return 1;
    }
}
