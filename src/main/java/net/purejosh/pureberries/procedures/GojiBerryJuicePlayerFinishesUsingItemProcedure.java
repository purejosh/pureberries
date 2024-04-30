package net.purejosh.pureberries.procedures;

import net.purejosh.pureberries.init.PureberriesModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class GojiBerryJuicePlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PureberriesModMobEffects.FORTIFIED_EYES, 1200, 0, false, false));
	}
}
