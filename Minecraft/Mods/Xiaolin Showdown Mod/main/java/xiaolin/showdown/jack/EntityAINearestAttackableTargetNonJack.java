package xiaolin.showdown.jack;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.BlockPos;
import xiaolin.showdown.items.ModItems;

public class EntityAINearestAttackableTargetNonJack extends EntityAINearestAttackableTarget{
	 private int targetUnseenTicks;
	 
	public EntityAINearestAttackableTargetNonJack(EntityCreature p_i45879_1_, Class p_i45879_2_, boolean p_i45879_3_,
			boolean p_i45879_4_) {
		super(p_i45879_1_, p_i45879_2_, p_i45879_3_, p_i45879_4_);
		// TODO Auto-generated constructor stub
	}

	
        
	public boolean continueExecuting()
    {
        EntityLivingBase entitylivingbase = this.taskOwner.getAttackTarget();

        if (entitylivingbase == null)
        {
            return false;
        }
        else if (!entitylivingbase.isEntityAlive())
        {
            return false;
        }
        else if (entitylivingbase instanceof EntityPlayer && entitylivingbase.getEquipmentInSlot(4) != null && entitylivingbase.getEquipmentInSlot(4).getItem() == ModItems.jackglasses)
        {
        	
            return false;
        }
        else
        {
            Team team = this.taskOwner.getTeam();
            Team team1 = entitylivingbase.getTeam();

            if (team != null && team1 == team)
            {
                return false;
            }
            else
            {
                double d0 = this.getTargetDistance();

                if (this.taskOwner.getDistanceSqToEntity(entitylivingbase) > d0 * d0)
                {
                    return false;
                }
                else
                {
                    if (this.shouldCheckSight)
                    {
                        if (this.taskOwner.getEntitySenses().canSee(entitylivingbase))
                        {
                            this.targetUnseenTicks = 0;
                        }
                        else if (++this.targetUnseenTicks > 60)
                        {
                            return false;
                        }
                    }

                    return !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer)entitylivingbase).capabilities.disableDamage;
                }
            }
        }
    }
	
}