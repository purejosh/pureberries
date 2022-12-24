
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.sweetberryfoods.init;

import net.purejosh.sweetberryfoods.procedures.SweetBerryJuicePlayerFinishesUsingItemProcedure;
import net.purejosh.sweetberryfoods.procedures.HoneyDippedSweetBerriesPlayerFinishesUsingItemProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryJuicePlayerFinishesUsingItemProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushUpdateTickProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage3PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage2PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage1PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage0PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantMobplayerCollidesWithPlantProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberriesRightclickedOnBlockProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberriesPlayerFinishesUsingItemProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SweetberryfoodsModProcedures {
	public static void load() {
		new BlueberriesRightclickedOnBlockProcedure();
		new BlueberryBushUpdateTickProcedure();
		new BlueberryBushPlantStage0PlantRightClickedProcedure();
		new BlueberryBushPlantStage1PlantRightClickedProcedure();
		new BlueberryBushPlantStage2PlantRightClickedProcedure();
		new BlueberryBushPlantStage3PlantRightClickedProcedure();
		new SweetBerryJuicePlayerFinishesUsingItemProcedure();
		new BlueberryJuicePlayerFinishesUsingItemProcedure();
		new BlueberryBushPlantMobplayerCollidesWithPlantProcedure();
		new BlueberriesPlayerFinishesUsingItemProcedure();
		new HoneyDippedSweetBerriesPlayerFinishesUsingItemProcedure();
	}
}
