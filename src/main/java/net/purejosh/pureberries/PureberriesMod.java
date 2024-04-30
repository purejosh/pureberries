/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.purejosh.pureberries;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.purejosh.pureberries.init.PureberriesModProcedures;
import net.purejosh.pureberries.init.PureberriesModMobEffects;
import net.purejosh.pureberries.init.PureberriesModItems;
import net.purejosh.pureberries.init.PureberriesModItemExtensions;
import net.purejosh.pureberries.init.PureberriesModFeatures;
import net.purejosh.pureberries.init.PureberriesModBlocks;

import net.fabricmc.api.ModInitializer;

public class PureberriesMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "pureberries";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing PureberriesMod");

		PureberriesModMobEffects.load();

		PureberriesModBlocks.load();
		PureberriesModItems.load();

		PureberriesModFeatures.load();

		PureberriesModProcedures.load();

		PureberriesModItemExtensions.load();

	}
}
