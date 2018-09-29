package xiaolin.showdown.jack;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelJackbot extends ModelBase
{
	//fields
    ModelRenderer mainbody;
    ModelRenderer arm1;
    ModelRenderer arm2;
    ModelRenderer arm22;
    ModelRenderer arm21;
    ModelRenderer head1;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer head4;
    ModelRenderer head5;
    ModelRenderer rocket1;
    ModelRenderer rocket2;
  
  public ModelJackbot()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      mainbody = new ModelRenderer(this, 0, 48);
      mainbody.addBox(-7F, -4F, -4F, 14, 8, 8);
      mainbody.setRotationPoint(0F, 4F, 0F);
      mainbody.setTextureSize(128, 64);
      mainbody.mirror = true;
      setRotation(mainbody, 0F, 0F, 0F);
      arm1 = new ModelRenderer(this, 26, 36);
      arm1.addBox(-1F, -3F, -3F, 2, 6, 6);
      arm1.setRotationPoint(-8F, 4F, 0F);
      arm1.setTextureSize(128, 64);
      arm1.mirror = true;
      setRotation(arm1, 0F, 0F, 0F);
      arm2 = new ModelRenderer(this, 0, 36);
      arm2.addBox(0F, -3F, -3F, 2, 6, 6);
      arm2.setRotationPoint(7F, 4F, 0F);
      arm2.setTextureSize(128, 64);
      arm2.mirror = true;
      setRotation(arm2, 0F, 0F, 0F);
      arm22 = new ModelRenderer(this, 16, 40);
      arm22.addBox(0F, -2F, -2F, 1, 4, 4);
      arm22.setRotationPoint(9F, 4F, 0F);
      arm22.setTextureSize(128, 64);
      arm22.mirror = true;
      setRotation(arm22, 0F, 0F, 0F);
      arm21 = new ModelRenderer(this, 16, 40);
      arm21.addBox(-1F, -2F, -2F, 1, 4, 4);
      arm21.setRotationPoint(-9F, 4F, 0F);
      arm21.setTextureSize(128, 64);
      arm21.mirror = true;
      setRotation(arm21, 0F, 0F, 0F);
      head1 = new ModelRenderer(this, 44, 57);
      head1.addBox(-2F, -5F, -2F, 4, 3, 4);
      head1.setRotationPoint(0F, 0F, 0F);
      head1.setTextureSize(128, 64);
      head1.mirror = true;
      setRotation(head1, 0F, 0F, 0F);
      head2 = new ModelRenderer(this, 44, 50);
      head2.addBox(-3F, -1F, -3F, 6, 1, 6);
      head2.setRotationPoint(0F, -5F, 0F);
      head2.setTextureSize(128, 64);
      head2.mirror = true;
      setRotation(head2, 0F, 0F, 0F);
      head3 = new ModelRenderer(this, 90, 59);
      head3.addBox(-2F, -1F, -2F, 4, 1, 4);
      head3.setRotationPoint(0F, -6F, 0F);
      head3.setTextureSize(128, 64);
      head3.mirror = true;
      setRotation(head3, 0F, 0F, 0F);
      head4 = new ModelRenderer(this, 44, 43);
      head4.addBox(-3F, 0F, -3F, 6, 1, 6);
      head4.setRotationPoint(0F, -2F, 0F);
      head4.setTextureSize(128, 64);
      head4.mirror = true;
      setRotation(head4, 0F, 0F, 0F);
      head5 = new ModelRenderer(this, 0, 27);
      head5.addBox(-4F, -1F, -4F, 8, 1, 8);
      head5.setRotationPoint(0F, 0F, 0F);
      head5.setTextureSize(128, 64);
      head5.mirror = true;
      setRotation(head5, 0F, 0F, 0F);
      rocket1 = new ModelRenderer(this, 28, 15);
      rocket1.addBox(-2F, 0F, -2F, 4, 2, 4);
      rocket1.setRotationPoint(0F, 10F, 0F);
      rocket1.setTextureSize(128, 64);
      rocket1.mirror = true;
      setRotation(rocket1, 0F, 0F, 0F);
      rocket2 = new ModelRenderer(this, 44, 35);
      rocket2.addBox(-3F, 0F, -3F, 6, 2, 6);
      rocket2.setRotationPoint(0F, 8F, 0F);
      rocket2.setTextureSize(128, 64);
      rocket2.mirror = true;
      setRotation(rocket2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    mainbody.render(f5);
    arm1.render(f5);
    arm2.render(f5);
    arm22.render(f5);
    arm21.render(f5);
    head1.render(f5);
    head2.render(f5);
    head3.render(f5);
    head4.render(f5);
    head5.render(f5);
    rocket1.render(f5);
    rocket2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}