
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.sweetberryfoods.init;

import net.purejosh.sweetberryfoods.procedures.SweetBerryJuicePlayerFinishesUsingItemProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryJuicePlayerFinishesUsingItemProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushUpdateTickProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage3PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage2PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage1PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberryBushPlantStage0PlantRightClickedProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberriesRightclickedOnBlockProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SweetberryfoodsModProcedures {
	public static void load() {
		new BlueberryBushUpdateTickProcedure();
		new BlueberriesRightclickedOnBlockProcedure();
		new BlueberryBushPlantStage0PlantRightClickedProcedure();
		new BlueberryBushPlantStage1PlantRightClickedProcedure();
		new BlueberryBushPlantStage2PlantRightClickedProcedure();
		new BlueberryBushPlantStage3PlantRightClickedProcedure();
		new SweetBerryJuicePlayerFinishesUsingItemProcedure();
		new BlueberryJuicePlayerFinishesUsingItemProcedure();
	}
}
