package xiaolin.showdown.effects;

import java.util.Random;

import net.minecraft.block.BlockFire;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class Ants extends EntityThrowable{
	
	private World world;
	private Random random = new Random();
	public Ants(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		world = worldIn;
		this.setSize(0, 0);
		// TODO Auto-generated constructor stub
	}
	
	public void onUpdate()
    {
    	
    	super.motionY += 0.03;
    	this.setPositionAndUpdate(this.posX,world.getTopSolidOrLiquidBlock(new BlockPos(this)).getY(), this.posZ);
    	super.onUpdate();
    	if(!world.isRemote) {
    		((WorldServer)this.worldObj).spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, this.posX-rand.nextDouble(), this.posY-1,
    				this.posZ+rand.nextDouble(),10, 0.0D, 0.0D, 0.0D,0, new int[0]);
    		
    	}
    	
    	
    	
    }
	
	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		BlockPos entity = new BlockPos(this.posX, this.posY, this.posZ);
		if (p_70184_1_.entityHit != null)
        {
            

            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.1f);
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, p_70184_1_.entityHit.posX + random.nextDouble(),
            		p_70184_1_.entityHit.posY +1 + random.nextDouble(), p_70184_1_.entityHit.posZ+ random.nextDouble(), 0, 0, 0);
           
        }



        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
	}

}
