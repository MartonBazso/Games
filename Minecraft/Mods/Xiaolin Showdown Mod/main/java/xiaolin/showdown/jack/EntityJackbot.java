package xiaolin.showdown.jack;

import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIDefendVillage;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookAtVillager;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xiaolin.showdown.items.ModItems;

public class EntityJackbot extends EntityGolem {

	 private EntityLivingBase attackTarget;
	 protected EntityJackbot jackbot;
	  
	public EntityJackbot(World worldIn)
	    {
	        super(worldIn);
	        
	        this.setSize(1.1F, 1.9F);
	        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
	        jackbot = this;
	        this.tasks.addTask(0,new EntityAISwimming(this)); 
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
	        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.6D, 32.0F));
	        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6D, true));
	        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.tasks.addTask(8, new EntityAIFollowJack(this, 0.8D));
	        this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
	        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
	        this.tasks.addTask(5, new EntityAILookIdle(this));
	        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true, new Class[0]));
	        //this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, false, true, IMob.field_175450_e));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTargetNonJack(jackbot, EntityPlayer.class, true , true));
	       
	    }

	    protected void entityInit()
	    {
	        super.entityInit();
	        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	    }
	    
	    
	    
	    protected void updateAITasks()
	    {

	            
	        

	        super.updateAITasks();
	    }

	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	    }

	    /**
	     * Decrements the entity's air supply when underwater
	     */
	    protected int decreaseAirSupply(int p_70682_1_)
	    {
	        return p_70682_1_;
	    }
	    
	    
	    

	    

	    public void spawnRunningParticles()
	    {
	        if (this.isSprinting() && !this.isInWater())
	        {
	            this.createRunningParticles();
	        }
	    }
	    
	    protected void createRunningParticles()
	    {
	        int i = MathHelper.floor_double(this.posX);
	        int j = MathHelper.floor_double(this.posY - 0.20000000298023224D);
	        int k = MathHelper.floor_double(this.posZ);
	        BlockPos blockpos = new BlockPos(i, j, k);
	        IBlockState iblockstate = this.worldObj.getBlockState(blockpos);
	        Block block = iblockstate.getBlock();

	        if (block.getRenderType() != -1)
	        {
	            this.worldObj.spawnParticle(EnumParticleTypes.DRIP_LAVA, this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, -this.motionX * 4.0D, 1.5D, -this.motionZ * 4.0D, new int[] {Block.getStateId(iblockstate)});
	        }
	    }
	    
	    protected void collideWithEntity(Entity p_82167_1_)
	    {
	        
	            this.setAttackTarget((EntityLivingBase)p_82167_1_);
	        

	        super.collideWithEntity(p_82167_1_);
	    }
	    
	    
	    
	    public EntityLivingBase getAttackTarget()
	    {
	        return this.attackTarget;
	    }
	    
	    
	    public void setAttackTarget(EntityLivingBase p_70624_1_)
	    {
	        if(p_70624_1_ instanceof EntityPlayer && p_70624_1_.getEquipmentInSlot(4) != null && p_70624_1_.getEquipmentInSlot(4).getItem() == ModItems.jackglasses) {
	        	
	        	if(p_70624_1_.getLastAttacker() != null) {
	        		this.attackTarget = p_70624_1_.getLastAttacker();
		            net.minecraftforge.common.ForgeHooks.onLivingSetAttackTarget(this, p_70624_1_.getLastAttacker());
	        	}
	        		
	        	
	        }else if(p_70624_1_ instanceof EntityJackbot){
	        	
	        }else {

	            this.attackTarget = p_70624_1_;
	            net.minecraftforge.common.ForgeHooks.onLivingSetAttackTarget(this, p_70624_1_);
	            
	        }
	    	
	    }

	    /**
	     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	     * use this to react to sunlight and start to burn.
	     */
	    public void onLivingUpdate()
	    {
	        super.onLivingUpdate();

	        this.worldObj.spawnParticle(EnumParticleTypes.FLAME,this.posX, this.posY + 0.7, this.posZ,0,0,0);

	        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0)
	        {
	            int i = MathHelper.floor_double(this.posX);
	            int j = MathHelper.floor_double(this.posY - 0.20000000298023224D);
	            int k = MathHelper.floor_double(this.posZ);
	            IBlockState iblockstate = this.worldObj.getBlockState(new BlockPos(i, j, k));
	            Block block = iblockstate.getBlock();

	            if (block.getMaterial() != Material.air)
	            {
	                this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 0,0,0, new int[] {Block.getStateId(iblockstate)});
	            }
	        }
	    }

	    /**
	     * Returns true if this entity can attack entities of the specified class.
	     */
	    public boolean canAttackClass(Class p_70686_1_)
	    {
	    	if(p_70686_1_ == EntityJackbot.class) {
	    		return false;
	    	}else {
	    		return true;
	    	}
	        
	    }

	   

	    public boolean attackEntityAsMob(Entity p_70652_1_)
	    {
	        
	        this.worldObj.setEntityState(this, (byte)4);
	        boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(0.5 + this.rand.nextInt(4)));

	        if (flag)
	        {
	            p_70652_1_.motionY += 0.4000000059604645D;
	            this.func_174815_a(this, p_70652_1_);
	        }

	        this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
	        return flag;
	    }

	    @SideOnly(Side.CLIENT)
	    public void handleHealthUpdate(byte p_70103_1_)
	    {
	        if (p_70103_1_ == 4)
	        {
	            
	            this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
	        }
	        else if (p_70103_1_ == 11)
	        {
	            
	        }
	        else
	        {
	            super.handleHealthUpdate(p_70103_1_);
	        }
	    }







	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "mob.irongolem.hit";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "mob.irongolem.death";
	    }

	    protected void playStepSound(BlockPos p_180429_1_, Block p_180429_2_)
	    {
	    	
	    }

	    /**
	     * Drop 0-2 items of this living's type
	     */
	    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	    	this.dropItem(Item.getItemFromBlock(ModItems.jackbottop),1);
	    }


	    


	    /**
	     * Called when the mob's health reaches 0.
	     */
	    public void onDeath(DamageSource cause)
	    {

	    	
	        super.onDeath(cause);
	    }



	
}
