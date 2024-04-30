package net.purejosh.pureberries.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GojiBerryBushAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f >= 0.4) {
			return true;
		}
		return false;
	}
}
