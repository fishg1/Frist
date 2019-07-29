package fishg.frist.entities;

import fishg.frist.init.FristEntities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;

public class Tundran extends CreatureEntity
{
	@SuppressWarnings("unchecked")
	public Tundran(EntityType<? extends CreatureEntity> type, World worldIn)
	{
		super((EntityType<? extends CreatureEntity>) FristEntities.TUNDRAN, worldIn);
	}
	
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.5d));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
	}
	
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5d);
	}
	
}
