package net.purejosh.pureberries.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class BlueberryBushMobplayerCollidesWithPlantProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
			entity.fallDistance = 0;
		}
	}
}
