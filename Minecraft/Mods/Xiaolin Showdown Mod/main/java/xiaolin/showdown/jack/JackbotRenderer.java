package xiaolin.showdown.jack;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import xiaolin.showdown.Main;

public class JackbotRenderer extends RenderLiving {

	public JackbotRenderer(RenderManager p_i46153_1_, ModelBase p_i46153_2_, float p_i46153_3_) {
		super(p_i46153_1_, p_i46153_2_, p_i46153_3_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return new ResourceLocation(Main.MODID + ":textures/entity/jackbot" + ".png");
	}
	
	
	

}
