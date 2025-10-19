package net.purejosh.pureberries.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class GoldenBerryItem extends Item {
    private final RegistryEntry<StatusEffect> effect;
    private final GameRules.Key<GameRules.IntRule> strengthRule;
    private final int duration;
    private final int maxAmplifier;

    public GoldenBerryItem(Settings settings, RegistryEntry<StatusEffect> effect, GameRules.Key<GameRules.IntRule> strengthRule, int duration, int maxAmplifier) {
        super(settings);
        this.effect = effect;
        this.duration = duration;
        this.maxAmplifier = maxAmplifier;
        this.strengthRule = strengthRule;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);

        if (world.isClient) return itemStack;

        if (user instanceof ServerPlayerEntity serverPlayer) {
            Criteria.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        MinecraftServer server = world.getServer();
        if (server != null) {
            int strength = server.getGameRules().getInt(strengthRule);

            // Skip if strength is 0
            if (strength == 0) return itemStack;

            StatusEffectInstance current = user.getStatusEffect(effect);
            int newAmp = (current == null) ? 0 : Math.min(current.getAmplifier() + 1, maxAmplifier);

            // Calculate duration
            int newDuration = this.duration * (newAmp + 1);

            user.addStatusEffect(new StatusEffectInstance(effect, newDuration, newAmp));
        }

        return itemStack;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        MinecraftClient client = MinecraftClient.getInstance();

        // Check strengthRule via client world
        if (client.world != null && client.world.getGameRules().getInt(strengthRule) == 0) {
            return; // early exit: skip all tooltip logic
        }

        String effectName = effect.value().getName().getString();
        int totalSeconds = duration / 20;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        String timeFormatted = String.format(" (%d:%02d)", minutes, seconds);

        tooltip.add(Text.of(effectName + timeFormatted).copy().styled(style ->
                style.withColor(Formatting.BLUE)));

        if (Screen.hasShiftDown()) {

            // build the description key from the effect's registry ID
            String effectId = Objects.requireNonNull(Registries.STATUS_EFFECT.getId(effect.value())).getPath();
            String descKey  = "item.pureberries.golden_berries." + effectId + ".tooltip";
            String rawDesc  = I18n.translate(descKey);

            // split on the real newline, add each line as its own Text
            for (String line : rawDesc.split("\n")) {
                tooltip.add(Text.literal(line)
                        .formatted(Formatting.GRAY));
            }

        } else {
            tooltip.add(Text.translatable("item.pureberries.hold")
                    .styled(style -> style.withColor(Formatting.DARK_GRAY))
                    .append(Text.literal(" ["))
                    .append(Text.translatable("item.pureberries.shift").formatted(Formatting.GRAY))
                    .append(Text.literal("] "))
                    .append(Text.translatable("item.pureberries.for_info").formatted(Formatting.DARK_GRAY))
            );
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
