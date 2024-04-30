package net.purejosh.pureberries.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CloudberryPlantAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) >= 94 && world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f <= -0.15) {
			return true;
		}
		return false;
	}
}
