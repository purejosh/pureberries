package net.purejosh.pureberries.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final Identifier NIMBUS_WHIRL_ID = Identifier.of("pureberries", "nimbus_whirl");
    public static final SoundEvent NIMBUS_WHIRL = SoundEvent.of(NIMBUS_WHIRL_ID);

    public static final Identifier NIMBUS_END_ID = Identifier.of("pureberries", "nimbus_end");
    public static final SoundEvent NIMBUS_END = SoundEvent.of(NIMBUS_END_ID);

    public static final Identifier MORTAR_USE_ID = Identifier.of("pureberries", "mortar_use");
    public static final SoundEvent MORTAR_USE = SoundEvent.of(MORTAR_USE_ID);

    public static final Identifier MORTAR_PLANT_ID = Identifier.of("pureberries", "mortar_plant");
    public static final SoundEvent MORTAR_PLANT = SoundEvent.of(MORTAR_PLANT_ID);

    public static final Identifier MORTAR_IMPACT_ID = Identifier.of("pureberries", "mortar_impact");
    public static final SoundEvent MORTAR_IMPACT = SoundEvent.of(MORTAR_IMPACT_ID);

    public static final Identifier MORTAR_SHATTER_ID = Identifier.of("pureberries", "mortar_shatter");
    public static final SoundEvent MORTAR_SHATTER = SoundEvent.of(MORTAR_SHATTER_ID);

    public static final Identifier MORTAR_HIT_ID = Identifier.of("pureberries", "mortar_hit");
    public static final SoundEvent MORTAR_HIT = SoundEvent.of(MORTAR_HIT_ID);

    public static void init() {
        Registry.register(Registries.SOUND_EVENT, NIMBUS_WHIRL_ID, NIMBUS_WHIRL);
    }
}
