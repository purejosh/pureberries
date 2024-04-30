package net.purejosh.pureberries.procedures;

import net.purejosh.pureberries.init.PureberriesModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BlueberryBushUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() <= 0.25 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 10 && world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() == false) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_0 && PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_1.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(x, y, z), PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_1.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_1
						&& PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_2.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(x, y, z), PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_2.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_2
						&& PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_3.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(x, y, z), PureberriesModBlocks.BLUEBERRY_BUSH_STAGE_3.defaultBlockState(), 3);
				}
			}
		}
	}
}
