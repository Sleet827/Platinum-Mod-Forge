package net.legiblesleet827.platinum.setup;

import net.legiblesleet827.platinum.PlatinumMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final Tier PLATINUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3000, 10.0F, 5.0F, 20, ModTags.Blocks.NEEDS_PLATINUM_TOOL, () -> Ingredient.of(new ItemLike[]{ModItems.PLATINUM_INGOT.get()})),
            new ResourceLocation(PlatinumMod.MOD_ID, "platinum_tier"),
            List.of(Tiers.NETHERITE), List.of());

    static void register() {
    }
}
