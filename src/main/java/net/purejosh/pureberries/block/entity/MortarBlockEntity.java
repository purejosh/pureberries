package net.purejosh.pureberries.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.purejosh.pureberries.block.MortarBlock;
import net.purejosh.pureberries.sound.ModSoundEvents;

public class MortarBlockEntity extends BlockEntity {
    private int durability;

    public MortarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.MORTAR, pos, state);
        this.durability = getBlockMaxDurability();
    }

    public void decrementDurability() {
        if (--durability <= 0 && world != null) {
            world.breakBlock(pos, false);
            world.playSound(null, pos, ModSoundEvents.MORTAR_IMPACT, SoundCategory.BLOCKS, 0.8f, 0.5f);
            world.playSound(null, pos, ModSoundEvents.MORTAR_SHATTER, SoundCategory.BLOCKS, 0.8f, 0.5f);
            world.addBlockBreakParticles(pos, this.getCachedState());
            return;
        }

        // warning at ≤10%
        int warningThreshold = getBlockMaxDurability() / 10;
        if (durability <= warningThreshold && world != null) {
            if (world instanceof ServerWorld s) {
                s.playSound(null, pos, ModSoundEvents.MORTAR_HIT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                s.spawnParticles(ParticleTypes.DUST_PLUME, pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5,
                        8, 0.05, 0.1, 0.05, 0.0);
            }
        }
        markDirty();
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    private int getBlockMaxDurability() {
        return ((MortarBlock) getCachedState().getBlock()).getMaxDurability();
    }

    @Override
    public void writeNbt(NbtCompound tag, RegistryWrapper.WrapperLookup lookup) {
        super.writeNbt(tag, lookup);
        tag.putInt("durability", durability);
    }

    @Override
    public void readNbt(NbtCompound tag, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(tag, lookup);
        if (tag.contains("durability")) {
            durability = tag.getInt("durability");
        } else {
            durability = getBlockMaxDurability();
        }
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}
