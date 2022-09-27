package net.purejosh.sweetberryfoods.procedures;

import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.Map;

public class BlueberryBushPlantMobplayerCollidesWithPlantProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency entity for procedure BlueberryBushPlantMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
			entity.fallDistance = 0;
		}
	}
}
