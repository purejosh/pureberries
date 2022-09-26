package net.purejosh.sweetberryfoods.procedures;

import net.purejosh.sweetberryfoods.init.SweetberryfoodsModItems;
import net.purejosh.sweetberryfoods.init.SweetberryfoodsModBlocks;
import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class BlueberriesRightclickedOnBlockProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency world for procedure BlueberriesRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency x for procedure BlueberriesRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency y for procedure BlueberriesRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency z for procedure BlueberriesRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SweetberryfoodsMod.LOGGER.warn("Failed to load dependency entity for procedure BlueberriesRightclickedOnBlock!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SweetberryfoodsModItems.BLUEBERRIES
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)
						.getItem() == SweetberryfoodsModItems.BLUEBERRIES) {
			if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRASS_BLOCK
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DIRT
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.COARSE_DIRT
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.PODZOL
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ROOTED_DIRT
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.FARMLAND)
					&& (world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
				world.setBlock(new BlockPos(x, y + 1, z), SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_0.defaultBlockState(), 3);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getItem() == SweetberryfoodsModItems.BLUEBERRIES) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft
									.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getItem() == SweetberryfoodsModItems.BLUEBERRIES) {
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					} else {
						((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).shrink(1);
					}
				}
			}
		}
	}
}
