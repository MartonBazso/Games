package xiaolin.showdown.effects;

import java.util.Random;

import net.minecraft.block.BlockFire;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import xiaolin.showdown.ClientProxy;

public class HanabiFire extends EntityThrowable{
	
	EntityLivingBase thrower;
	World world;
	Random rand = new Random();
    public HanabiFire(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        this.setSize(0f, 0f);
        this.thrower = throwerIn;
        this.world = worldIn; 
    }


    protected float getGravityVelocity()
    {
        return 0F;
    }

    
    @Override
    public void onUpdate()
    {
    	
    	
    	super.onUpdate();
    	if(!world.isRemote) {
    		((WorldServer)this.worldObj).spawnParticle(EnumParticleTypes.FLAME, true, this.posX-rand.nextDouble(), this.posY-rand.nextDouble(),
    				this.posZ+rand.nextDouble(),10, 0.0D, 0.0D, 0.0D,0, new int[0]);
    		((WorldServer)this.worldObj).spawnParticle(EnumParticleTypes.LAVA, true, this.posX, this.posY, this.posZ,1, 0.0D, 0.0D, 0.0D,0, new int[0]);
        	
    	}
    	
    	if (!this.worldObj.isRemote) {
    		if(ticksExisted > 150) {
        		this.setDead();
        		}
    		}
    }
    
	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		
		
		BlockPos entity = new BlockPos(this.posX, this.posY, this.posZ);
		if (p_70184_1_.entityHit != null)
        {
            

            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2f);
            p_70184_1_.entityHit.setFire(1);
            this.setDead();
            
        }

        for (int i = 0; i < 8; ++i)
        {
        	
        	if(this.worldObj.isAirBlock(entity)) {
        	this.worldObj.setBlockState(entity, Blocks.fire.getDefaultState().withProperty(BlockFire.AGE, 15));}
            this.worldObj.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    
		
	}

}
