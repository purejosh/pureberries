
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.pureberries.init;

import net.purejosh.pureberries.potion.FortifiedEyesMobEffect;
import net.purejosh.pureberries.PureberriesMod;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class PureberriesModMobEffects {
	public static MobEffect FORTIFIED_EYES;

	public static void load() {
		FORTIFIED_EYES = Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(PureberriesMod.MODID, "fortified_eyes"), new FortifiedEyesMobEffect());
	}
}
