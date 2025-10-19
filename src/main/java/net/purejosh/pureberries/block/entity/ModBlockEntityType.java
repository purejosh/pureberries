package net.purejosh.pureberries.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.PureBerries;
import net.purejosh.pureberries.block.ModBlocks;

public class ModBlockEntityType {
    public static final BlockEntityType<MortarBlockEntity> MORTAR = register("mortar", BlockEntityType.Builder.create(MortarBlockEntity::new,
            ModBlocks.ANDESITE_MORTAR,
            ModBlocks.BASALT_MORTAR,
            ModBlocks.BLACKSTONE_MORTAR,
            ModBlocks.CALCITE_MORTAR,
            ModBlocks.DEEPSLATE_MORTAR,
            ModBlocks.NETHER_BRICK_MORTAR,
            ModBlocks.QUARTZ_MORTAR,
            ModBlocks.SANDSTONE_MORTAR,
            ModBlocks.SMOOTH_STONE_MORTAR,
            ModBlocks.STONE_MORTAR,
            ModBlocks.TUFF_MORTAR
    ).build(null));

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(PureBerries.MOD_ID, name), type);
    }

    // Class initializer called from the entrypoint.
    public static void init() {}
}