package xiaolin.showdown.jack;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import xiaolin.showdown.items.ModItems;

public class EntityAIFollowJack extends EntityAIBase {

	EntityCreature jackbot;
    EntityLivingBase jack;
    double field_75347_c;
    private int field_75345_d;
    private static final String __OBFID = "CL_00001586";

    public EntityAIFollowJack(EntityCreature p_i1626_1_, double p_i1626_2_)
    {
        this.jackbot = p_i1626_1_;
        this.field_75347_c = p_i1626_2_;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	 
            List list = this.jackbot.worldObj.playerEntities;
            EntityPlayer entityjack = null;
            double d0 = Double.MAX_VALUE;
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                EntityPlayer entitypotentialjack = (EntityPlayer) iterator.next();
                
                //Checks wheter the player has jackglasses on or not
                if(entitypotentialjack.getEquipmentInSlot(4) != null && entitypotentialjack.getEquipmentInSlot(4).getItem() == ModItems.jackglasses) {
                
                    double d1 = this.jackbot.getDistanceSqToEntity(entitypotentialjack);

                    if (d1 <= d0)
                    {
                    	
                    	d0 = d1;
                        entityjack = entitypotentialjack;
                    }
                }
                
            }

            if (entityjack == null)
            {
                return false;
            }
            else if (d0 < 20D)
            {
                return false;
            }
            else
            {
            	
            	this.jack = entityjack;
                return true;
            }
        
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	
        if (!this.jack.isEntityAlive())
        {
            return false;
        }
        else
        {
            double d0 = this.jackbot.getDistanceSqToEntity(this.jack);
           
            return d0 >= 25D && d0 <= 256.0D;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    	
        this.field_75345_d = 0;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
    	
        this.jack = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	 
        if (--this.field_75345_d <= 0)
        {
            this.field_75345_d = 10;
            
            this.jackbot.getNavigator().tryMoveToEntityLiving(this.jack, this.field_75347_c);
        }
    }
}