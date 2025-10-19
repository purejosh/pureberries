package net.purejosh.pureberries;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.block.ModBlocks;
import net.purejosh.pureberries.block.entity.ModBlockEntityType;
import net.purejosh.pureberries.entity.effect.ModStatusEffects;
import net.purejosh.pureberries.item.ModItemGroups;
import net.purejosh.pureberries.item.ModItems;
import net.purejosh.pureberries.recipe.MortarRecipeManager;
import net.purejosh.pureberries.sound.ModSoundEvents;
import net.purejosh.pureberries.world.ModGameRules;
import net.purejosh.pureberries.world.gen.ModWorldGeneration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PureBerries implements ModInitializer {
	public static final String MOD_ID = "pureberries";
	public static final String MOD_NAME = "Pure Berries";
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
	private static final boolean DEV_MODE = FabricLoader.getInstance().isDevelopmentEnvironment();

	// Allows for logging in dev environments, but won't log in release environments.
	public static void devLogging(LivingEntity entity, String message) {
		if (DEV_MODE) {
			((PlayerEntity) entity).sendMessage(Text.literal(message), true);
		}
	}

	// This code is executed when the mod is loaded.
	@Override
	public void onInitialize() {
		// Capture start time
		long startTime = System.currentTimeMillis();

		// Begin initializations
		ModGameRules.init();
		ModSoundEvents.init();
		ModStatusEffects.init();
		ModBlocks.init();
		ModItems.init();
		ModItemGroups.init();
		ModWorldGeneration.init();
		ModBlockEntityType.init();
		MortarRecipeManager.init();

		// Log elapsed time
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
        LOGGER.info(PureBerries.MOD_NAME + " by purejosh has been loaded! Initialization took {} milliseconds.", elapsedTime);
	}

	// This is used in the configured features and placed features registry. No idea why.
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
