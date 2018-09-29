package xiaolin.showdown.effects;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;

public class EntityLightningBolt2 extends EntityLightningBolt{
	public int lightningState;
	public EntityLightningBolt2(World worldIn, double posX, double posY, double posZ) {
		super(worldIn, posX, posY, posZ);
		lightningState = 0;
	}

}
