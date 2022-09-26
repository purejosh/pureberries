package net.purejosh.sweetberryfoods.procedures;

import net.purejosh.sweetberryfoods.init.SweetberryfoodsModBlocks;
import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class BlueberryBushUpdateTickProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency world for procedure BlueberryBushUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency x for procedure BlueberryBushUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency y for procedure BlueberryBushUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency z for procedure BlueberryBushUpdateTick!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!world.isClientSide()) {
			if (Math.random() <= 0.3 && world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) >= 10
					&& world.getBlockState(new BlockPos(x, y + 1, z)).canOcclude() == false) {
				if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_0
						&& SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_1.defaultBlockState().canSurvive(world, new BlockPos(x, y, z))) {
					world.setBlock(new BlockPos(x, y, z), SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_1.defaultBlockState(), 3);
				} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_1
						&& SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_2.defaultBlockState().canSurvive(world, new BlockPos(x, y, z))) {
					world.setBlock(new BlockPos(x, y, z), SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_2.defaultBlockState(), 3);
				} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_2
						&& SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_3.defaultBlockState().canSurvive(world, new BlockPos(x, y, z))) {
					world.setBlock(new BlockPos(x, y, z), SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_3.defaultBlockState(), 3);
				}
			}
		}
	}
}
