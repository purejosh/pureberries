
package net.purejosh.pureberries.potion;

import net.purejosh.pureberries.procedures.FortifiedEyesOnEffectActiveTickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FortifiedEyesMobEffect extends MobEffect {
	public FortifiedEyesMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10329502);
	}

	@Override
	public String getDescriptionId() {
		return "effect.pureberries.fortified_eyes";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		FortifiedEyesOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
