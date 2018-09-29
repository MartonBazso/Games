package xiaolin.showdown.effects;

import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityTornado extends EntityWeatherEffect{

	private World worldIn;
	private EntityPlayer playerIn;

	public EntityTornado(World worldIn, EntityPlayer playerIn) {
		super(worldIn);
		
		this.worldIn = worldIn;
		this.playerIn = playerIn;
		
		 this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0F, 0.5F + this.rand.nextFloat() * 0.2F);
	}

	private void Tornado(World worldIn, EntityPlayer playerIn, double range) {
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX, playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX , playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, (-1) * (playerIn.posX + range), playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX + range, playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX + range, playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX + range, playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX + range, playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
		worldIn.spawnParticle(EnumParticleTypes.SPELL, playerIn.posX + range, playerIn.posY - (range - 4), playerIn.posZ + range,
				10000, 10000, 10000, 30000);
		
	}
	
	
	public void onUpdate() {
		super.onUpdate();
		
		double i = 0.0001 ;
		while( i > 100) {
		
		Tornado(this.worldIn, this.playerIn, i);
		i += 0.0001;
		}
		
		
		
	}
	
	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		// TODO Auto-generated method stub
		
	}

}
