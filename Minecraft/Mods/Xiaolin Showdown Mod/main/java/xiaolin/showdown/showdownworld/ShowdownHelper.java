package xiaolin.showdown.showdownworld;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xiaolin.showdown.ItemRegister;
import xiaolin.showdown.items.ModItems;

public class ShowdownHelper {
	public static boolean showdownOn = false;
	public static ItemStack[] win = new ItemStack[ItemRegister.wuList.size()];
	
	
	
/*	public static void toOnUpdate(Entity entityIn, Item instance) {
	
		EntityPlayer playerIn = (EntityPlayer)entityIn;
		World worldIn = playerIn.getEntityWorld();
		
		//consumeInventoryItem(Item p_146026_1_)
		//setInventorySlotContents(int index, ItemStack stack)
	
	
	
	}
	//public float getDistanceToEntity(Entity entityIn) Entity.class
	//this.setEntityItemStack(new ItemStack(Blocks.air, 0));
*/	
	
	
	public static void deleteDimension(int dimId) {
		
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			WorldServer worldserver = minecraftserver.worldServerForDimension(dimId);
		
		
			File dim2save = new File(worldserver.getChunkSaveLocation().toString() + "/region");
			
			
			
			if(dim2save.exists()) {
				
				
				
			File[] filearray = dim2save.listFiles();
			for(int i = 0; i < filearray.length; i++ ) {
				
				
					
					filearray[i].delete();
					
					
				}
			
			}
		
		
	}
	
	public static void teleport(EntityPlayer playerIn, int dimensionId) {
		
		if (!playerIn.worldObj.isRemote){
			double posY0 = playerIn.posY;
			double posZ0 = playerIn.posZ;
			double posX0 = playerIn.posX;
			int i = 0;	
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			EntityPlayerMP playerMp = minecraftserver.getConfigurationManager().getPlayerByUUID(playerIn.getUniqueID());
			deleteDimension(2);
			playerMp.mcServer.getConfigurationManager().transferPlayerToDimension(playerMp, dimensionId , new ShowdownTp(minecraftserver.worldServerForDimension(2)));
			playerIn.setPositionAndUpdate(playerIn.posX, playerIn.posY  + 50, playerIn.posZ);
			
			if(playerIn.dimension == 0) {
				playerIn.setPositionAndUpdate(playerIn.posX, playerIn.worldObj.getTopSolidOrLiquidBlock(new BlockPos(playerIn)).getY() + 1, playerIn.posZ);
			}
				
			if(playerIn.dimension == 2) {
				while(playerIn.worldObj.getTopSolidOrLiquidBlock(new BlockPos(playerIn)).getY() == -1 ) {
					playerIn.setPositionAndUpdate(playerIn.posX + 1, playerIn.posY + 100, playerIn.posZ + 1);
				}
				playerIn.setPositionAndUpdate(playerIn.posX,playerIn.worldObj.getTopSolidOrLiquidBlock(new BlockPos(playerIn)).getY() + 1 , playerIn.posZ);
			}
			
			
			
			
			if(playerIn.dimension == 2) {
				
				playerMp.mcServer.getConfigurationManager().setViewDistance(3);
				
				
			}
			
			
			
			}
       
	}
	
	
	
	public static void onEntityItemUpdate(EntityItem entityItem, Item item) {
		
		int distance = 5;
		if(showdownOn == false) {
			for(int i = 0 ; i <entityItem.worldObj.getHeight(); i++) {
		 		
				entityItem.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, entityItem.posX, entityItem.posY+2 + i, entityItem.posZ, 0 ,0 ,0,0);
				
			}
		}
	    if(!entityItem.worldObj.isRemote) {
	    	entityItem.setNoDespawn();
	    	if(showdownOn == false) {
	    	EntityPlayer[] closePlayers = playersInRange(entityItem, distance);
	    	List<EntityPlayer> wuHolders = new ArrayList<EntityPlayer>();
	    	
	    	for(int i = 0;i < closePlayers.length; i++) {
	    		if(closePlayers[i] != null) {
	    			if(hasWu(closePlayers[i])) {
	    				
	    				wuHolders.add(closePlayers[i]);
	    				
	    				
	    			}
					}
				}
	    	
			    	if(wuHolders.size() >= 2) {
			    		
			    		for(int j = 0 ; j < wuHolders.size(); j++) {
			    			
			    			if(wuHolders.get(j) != null && wuHolders.get(j).dimension != 2) {
			    			teleport(wuHolders.get(j) , 2);
			    		
			    			MinecraftServer.getServer().getConfigurationManager()
			    			.sendChatMsg(new ChatComponentText("<"+wuHolders.get(j).getName()+"> " + "Gong Yi Tan Pai!"));
			    			}
			    			
			    		}
			    			showdownOn = true;
			    			
			    			MinecraftServer.getServer().getConfigurationManager()
			    			.sendChatMsg(new ChatComponentText(" A showdown has just started! You won't be able to start one, until they finish!"));
			    			wuHolders.clear();
			    			
			    			for(int x = 0; x < win.length; x++) {
			    				if(ShowdownHelper.win[x] == null) {
			    					ShowdownHelper.win[x] = new ItemStack(item);
			    					break;
			    				}
			    				
			    			}
			    			
			    			
			    			
			    			
	    		
			    	} 
			    	
	    	
	    	}
	    	
	    if(showdownOn == true)	
	    	for(int x = 0 ; x < win.length ; x++) {
	    		if(win[x] != null) {
	    		if(win[x].getItem() == item) {
	    			entityItem.setDead();
	    		}
	    		}
	    	}
	    	 
	    }
	    
	    
	}
		
	public static void createBeam(EntityItem entityItem) {
		int q = 10;
		while(q < entityItem.worldObj.getHeight()) {
			BlockPos blockpos = new BlockPos(entityItem).up(q);
			if(entityItem.worldObj.isAirBlock(blockpos)) {
				entityItem.worldObj.setBlockState(blockpos, Blocks.wool.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED) );
				
			}
			
			q++;
		}
		
	}
	
	
	public static void destroyBeam(EntityItem entityItem) {
		int q = 10;
		while(q < entityItem.worldObj.getHeight()) {
			BlockPos blockpos = new BlockPos(entityItem).up(q);
			if(entityItem.worldObj.getBlockState(blockpos) == Blocks.wool.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED)) {
				entityItem.worldObj.setBlockState(blockpos, Blocks.air.getDefaultState() );
				
			}
			
			q++;
		}
		
	}
	
	
	private static boolean hasWu(EntityPlayer player) {
		
		
		for(int i = 0; i < player.inventory.mainInventory.length; i++) {	
			
			if(player.inventory.mainInventory[i] != null) {
				
				for(int j = 0 ; j < ItemRegister.wuList.size(); j++) {
					
					
					if(player.inventory.mainInventory[i].getItem() == ItemRegister.wuList.get(j)) {
						
						return true;
						
						
					}
					
					
					
				}
				
				
			}
		}
			

		for(int k = 0; k < player.inventory.armorInventory.length; k++) {	
			
			if(player.inventory.armorInventory[k] != null) {
				
				for(int l = 0 ; l < ItemRegister.wuList.size(); l++) {
					
					
					if(player.inventory.armorInventory[k].getItem() == ItemRegister.wuList.get(l)) {
						
						return true;
						
						
					}
					
					
					
				}
				
				
			}
		
		}	
			
		
		
		return false;
		
	}
	
	
	
	
	
	
	private static EntityPlayer[] playersInRange(EntityItem entityItem, int distance) {
		
		EntityPlayer[] closePlayers = new EntityPlayer[entityItem.worldObj.playerEntities.size()];
		int arrayElement = 0;
		for(int i = 0; i < entityItem.worldObj.playerEntities.size(); i++) {
			
			
			if(entityItem.getDistanceToEntity((EntityPlayer) entityItem.worldObj.playerEntities.get(i)) <= distance) {
				
				
				closePlayers[arrayElement] = (EntityPlayer) entityItem.worldObj.playerEntities.get(i);
				arrayElement +=1;
				
				
			}
			
			
		}
		
		
		
		return closePlayers;
	
		
	}
	
	
	
	
	public static void onUpdate1(Entity entityIn, Item itemIn) {
		
		if(!entityIn.worldObj.isRemote) {
			if(entityIn.dimension == 2 && entityIn.isDead == true) {
				for(int x = 0; x < win.length; x++) {
    				if(ShowdownHelper.win[x] == null) {
    					ShowdownHelper.win[x] = new ItemStack(itemIn);
    					
    					break;
    				}
    				
    			}
				
				((EntityPlayer)entityIn).inventory.consumeInventoryItem(itemIn);		
			}
			
		
		}
		
		
		
	}
	
	public static void onArmorTick(Entity entityIn, Item itemIn) {
		
		if(!entityIn.worldObj.isRemote) {
			if(entityIn.dimension == 2 && entityIn.isDead == true) {
				for(int x = 0; x < win.length; x++) {
    				if(ShowdownHelper.win[x] == null) {
    					ShowdownHelper.win[x] = new ItemStack(itemIn);
    					break;
    				}
    				
    			}
				
				for(int i = 0 ; i < ((EntityPlayer)entityIn).inventory.armorInventory.length; i++) {
					
					if(((EntityPlayer)entityIn).inventory.armorInventory[i] != null) {
						for(int j = 0 ; j < ItemRegister.wuList.size(); j++) {
							if(((EntityPlayer)entityIn).inventory.armorInventory[i].getItem() ==  ItemRegister.wuList.get(j)) {
								((EntityPlayer)entityIn).inventory.armorInventory[i] = null;
								break;
								
							}
						}
						break;
					}
					
					
				}
				
			}
			
		
		}
		
		
		
	}
	
	
	
	public static void onUpdate2(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)  {
		if(!entityIn.worldObj.isRemote) {
		EntityPlayer playerIn = (EntityPlayer)entityIn;
			if(entityIn.dimension == 2) {
				if(entityIn.worldObj.playerEntities.size() == 1) {
					teleport(playerIn, 0);
					
					showdownOn = false;
					for(int i = 0 ; i < win.length ; i++) {
						if(ShowdownHelper.win[i] != null) {
							
							playerIn.inventory.setInventorySlotContents(playerIn.inventory.getFirstEmptyStack(), ShowdownHelper.win[i]);
							ShowdownHelper.win[i] = null;
						}
						
					}
					
				}
				
				
				
				
			}
			
			
			
			
		}
		
		
		
	}
	
	
	private static void preparePlayerToSpawn(Entity entityIn) {
		
		if (entityIn.worldObj != null)
        {
			entityIn.setPositionAndUpdate(entityIn.posX,entityIn.posY -40,entityIn.posZ);
			while(entityIn.worldObj.isAirBlock(new BlockPos(entityIn.posX,entityIn.posY - 1,entityIn.posZ))) {
				entityIn.posY -= 1;
			}
			entityIn.posY += 1;
        
        }
		
		
	}
	
	
}
