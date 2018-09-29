package xiaolin.showdown.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class LightningBolt extends EntityThrowable {

	World world;
	double positionX = -0.2;
	double positionZ = -0.2;

	public LightningBolt(World worldIn, EntityLivingBase throwerIn) {

		super(worldIn, throwerIn);
		this.setSize(0f, 0f);
		world = worldIn;
	}

	
	protected float getGravityVelocity()
    {
        return 0F;
    }
	
	@Override
	public void onUpdate() {

		

		super.onUpdate();
		// ((WorldServer)this.worldObj).spawnParticle(EnumParticleTypes.SMOKE_NORMAL,
		// true, this.posX, this.posY + 0.5D, this.posZ,1, 0.0D, 0.0D, 0.0D,0, new
		// int[0]);
		/*
		 * Minecraft minecraft = Minecraft.getMinecraft();
		 * 
		 * EntityFireworkSparkFX lightning = new EntityFireworkSparkFX(world, x +
		 * positionX, y, z, 0, 0, 0, minecraft.effectRenderer);
		 * 
		 * lightning.setRBGColorF(215, 215, 0); lightning.setFadeColour(8);
		 * lightning.setTwinkle(true);
		 */

		// minecraft.effectRenderer.addEffect(lightning);

		if (!world.isRemote) {
			((WorldServer) this.worldObj).spawnParticle(EnumParticleTypes.CRIT, true, this.posX + positionX, this.posY,
					this.posZ, 1, 0.0D, 0.0D, 0.0D, 0, new int[0]);
			// ((WorldServer)this.worldObj).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
			// true, this.posX+ positionX, this.posY, this.posZ,1, 0.0D, 0.0D, 0.0D,0, new
			// int[0]);
		}
		
		

		positionX += 0.4;

		if (positionX > 0.5) {

			positionX = -0.5;

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
		if (p_70184_1_.entityHit != null) {

			p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.7f);
			
			

		}

		

		
		if (!this.worldObj.isRemote) {
			this.setDead();
		}

	}

}
