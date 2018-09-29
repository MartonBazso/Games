package xiaolin.showdown.effects;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockAnvil.Anvil;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.entity.RenderLightningBolt;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Slot;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xiaolin.showdown.ItemRegister;
import xiaolin.showdown.items.ItemHanabi;
import xiaolin.showdown.items.ModItems;
import xiaolin.showdown.jack.EntityJackbot;
import xiaolin.showdown.showdownworld.ChunkProviderSd;
import xiaolin.showdown.showdownworld.ShowdownHelper;
import xiaolin.showdown.showdownworld.ShowdownTp;
import xiaolin.showdown.showdownworld.WorldShowdownProvider;

public class ItemTest extends Item{
	
	private boolean serpent;
	private int counter = 0;

	//KeyBinding asdasd = new KeyBinding("test", 45, "key.categories.misc");
	
	public ItemTest() {
		/*this.getEntityLifespan(itemStack, world)*/
		this.setUnlocalizedName("testitem");
		//this.setCreativeTab(CreativeTabs.tabCombat);
		this.setFull3D();
		
		
	}

	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		
		
//		for(ItemStack asd : playerIn.inventory.mainInventory) {
//			System.out.println(asd);
//		}
//			BlockPos plant = new BlockPos(playerIn).down();
//			IProperty[] properties = (IProperty[]) worldIn.getBlockState(plant).getPropertyNames().toArray( new IProperty[worldIn.getBlockState(plant).getPropertyNames().size()]);
//			//for(int x = 0; x < properties.length; x++) {
				
			for(int x = 0 ;x < ShowdownHelper.win.length;x++) {
				System.out.println(ShowdownHelper.win[x]);
			}
			
			
		
//		if(!worldIn.isRemote) {
//		switch (counter) {
//		case 0:
//			counter = 1;
//			break;
//		case 1: 
//			counter = 0;
//			break;
//		default:
//			counter = 0;
//			break;
//		}}
//		
//		MinecraftServer minecraftserver = MinecraftServer.getServer();
//		EntityPlayerMP playerMp = minecraftserver.getConfigurationManager().getPlayerByUUID(playerIn.getUniqueID());
//		
	//playerMp.theItemInWorldManager.setGameType(GameType.SPECTATOR);}
		
		
		
		
	/*	counter++;
		if(counter == 2) {
			serpent = true;
			counter = 0;
		}*/

		
		//((EntityPlayer)entityIn).capabilities.setFlySpeed(0.05f);
		
		
		

		
		
	//ShowdownHelper.teleport(playerIn, 2);	
	//if(!playerIn.worldObj.isRemote) {	
		//MinecraftServer minecraftserver = MinecraftServer.getServer();
		//System.out.println(minecraftserver);
		//EntityPlayerMP playerMp = (EntityPlayerMP) minecraftserver.getEntityFromUuid(playerIn.getUniqueID());
		
		//ShowdownHelper.teleport(playerIn, 2);
	//	        }
	//	EntityPlayerMP playerMp = minecraftserver.getConfigurationManager().getPlayerByUUID(playerIn.getUniqueID());
		//playerMp.playerNetServerHandler.setPlayerLocation(playerMp.posX + 10, playerMp.posY+3, playerMp.posZ, playerMp.rotationYaw,playerMp.rotationPitch);
		
		/*playerIn.timeUntilPortal = 1000;
		//playerIn.timeUntilPortal = 1000;
		ShowdownHelper.deleteDimension(2);
		//playerIn.travelToDimension(2);
		ShowdownHelper.teleport(playerIn, 2);
		if(playerIn.isSneaking()) {ShowdownHelper.teleport(playerIn, 0);}
		
		
		/*System.out.println("asd");
		playerIn.worldObj.theProfiler.endStartSection("asd");
		playerIn.worldObj.theProfiler.endSection();
        world.resetUpdateEntityTick();
        showdown.resetUpdateEntityTick();
        playerIn.worldObj.theProfiler.endSection();
		
		
		/*MinecraftServer minecraftserver = MinecraftServer.getServer();
		WorldServer worldserver = minecraftserver.worldServerForDimension(0);
		worldserver.getPlayerManager().setPlayerViewRadius(2);
		
		
		/*	MinecraftServer minecraftserver = MinecraftServer.getServer();
		this.worldserver = minecraftserver.worldServerForDimension(2);
		WorldServer worldserver1 = minecraftserver.worldServerForDimension(2);
		
		EntityPlayerMP playerMP = minecraftserver.getConfigurationManager().getPlayerByUUID(playerIn.getUniqueID());
		worldIn.theProfiler.startSection("reposition");
		minecraftserver.getConfigurationManager().transferPlayerToDimension(playerMP, 2, new ShowdownTp(worldserver));
		worldIn.theProfiler.endSection();
		
	/*	
		File dim2save = new File(worldserver.getChunkSaveLocation().toString() + "/region");
		
		File[] filearray = dim2save.listFiles();
		for(int i = 0; i < filearray.length; i++ ) {
			
			filearray[i].delete();
			
			
		}*/
		
		
	
		
		
		
		
	
		//DimensionManager.setWorld(2, WorldShowdown.worldserver); worldserver1.getPlayerEntityByUUID(playerIn.getUniqueID())

		
		//System.out.println(DimensionManager.isDimensionRegistered(2));
		//System.out.println(DimensionManager.getProvider(2));
		//System.out.println(Blocks.portal.getStateId(Blocks.portal.getDefaultState()));
		
		//IProperty property;
		
		
		
	/*	try {
		Formatter f = new Formatter("C:\\Users\\Marci\\Desktop\\asd.txt");
			
		f.format("%s", "Your PC is corrupted :) Thanks for using my mod :)");
		f.close();
		}catch(Exception e)
		{System.out.println("Error");}*/
		
		//worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX +0.3,playerIn.posY +1, playerIn.posZ, 0, 0, 0);
			
		/*for(int k = 0; k < worldIn.playerEntities.size(); k++) {
			
			
				if(((EntityPlayer)worldIn.playerEntities.get(k)) != playerIn) {
				System.out.println(((EntityPlayer)worldIn.playerEntities.get(k)) + "   aaaaaand me:    " + playerIn);
				}
				
			}*/
		
		
		return itemStackIn;
		
		
	}
	
	
	
	
	

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		
		
		
	/*	System.out.println("Counter: " + counter);
		EntityPlayer playerIn = ((EntityPlayer)entityIn);
		MinecraftServer minecraftserver = MinecraftServer.getServer();
		EntityPlayerMP playerMp = minecraftserver.getConfigurationManager().getPlayerByUUID((playerIn).getUniqueID());
		
			
				switch (counter) {
				case 1:
					playerIn.capabilities.allowFlying = true;
					playerIn.capabilities.isCreativeMode = false;
					playerIn.capabilities.disableDamage = true;
					playerIn.capabilities.isFlying = true;
					playerIn.noClip = true;
					playerIn.onGround = false;
					playerIn.fallDistance = 0;
					playerIn.moveEntityWithHeading(0, 1);
					
					break;
					
				case 0:
					playerIn.capabilities.allowFlying = false;
					playerIn.capabilities.isCreativeMode = false;
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
				}*/
				
			
		//((EntityPlayer)entityIn).moveEntityWithHeading(0, 50);
		/*EntityPlayer playerIn = (EntityPlayer)entityIn;
		if(playerIn.inventory.hasItemStack(new ItemStack(ModItems.hanabi))) {
			System.out.println("Hanabiiiiiii yeah");
			for(int k = 0; k < worldIn.playerEntities.size(); k++) {
				
				if(((EntityPlayer)worldIn.playerEntities.get(k)).getDistanceToEntity(playerIn) < 10 && (EntityPlayer)worldIn.playerEntities.get(k) != playerIn) {
					
					System.out.println("Test");
					
					
				}
				
				
			}
			//consumeInventoryItem(Item p_146026_1_)
			//setInventorySlotContents(int index, ItemStack stack)
		}*/
		/*if(!worldIn.isRemote) {
		MinecraftServer minecraftserver = MinecraftServer.getServer();
		EntityPlayerMP playerMp = minecraftserver.getConfigurationManager().getPlayerByUUID(((EntityPlayer)entityIn).getUniqueID());
		
		
		playerMp.moveForward = 10f;
		if(((EntityPlayer)entityIn).isSneaking()) {
			entityIn.fallDistance = 0;
			playerMp.theItemInWorldManager.setGameType(GameType.SURVIVAL);
		}}*/
		if(entityIn.isSneaking()) {System.out.println("playerdimension = " + entityIn.dimension);}
		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);
		
		
		
		
		
		//System.out.println("player dimension = " + entityIn.dimension);
		//System.out.println("Deathness xd = " + entityIn.isDead);
		
	}
	
	

    /**
     * Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner
     * control over the update of the item without having to write a subclass.
     *
     * @param entityItem The entity Item
     * @return Return true to skip any further update code.
     */
    public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
    {
			

    		ShowdownHelper.onEntityItemUpdate(entityItem, this);
    		
    		return false;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced)
	{
	list.add("Tooltip stuff goes here");
	}
	

	
/*	private void method() {
		
		
		if (asdasd.isPressed()) {System.out.println("Teeeeeeeeeeeeeeeeeeest");}
	}*/
}
