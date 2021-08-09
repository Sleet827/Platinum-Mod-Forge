package net.legiblesleet827.platinum.data.advancements;

import net.legiblesleet827.platinum.PlatinumMod;
import net.legiblesleet827.platinum.setup.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class PlatinumAdvancements implements Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement root = Advancement.Builder.advancement().display(ModItems.PLATINUM_INGOT.get(), new TranslatableComponent("advancements.platinum.root.title"), new TranslatableComponent("advancements.platinum.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), FrameType.GOAL, true, true, false).rewards(AdvancementRewards.Builder.experience(100)).addCriterion("platinum_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINUM_INGOT.get())).save(advancementConsumer, modId("platinum/root").toString());
        Advancement.Builder.advancement().parent(root).display(ModItems.PLATINUM_HOE.get(), new TranslatableComponent("advancements.platinum.platinum_hoe.title"), new TranslatableComponent("advancements.platinum.platinum_hoe.description"), (ResourceLocation) null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(100)).addCriterion("platinum_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINUM_HOE.get())).save(advancementConsumer, modId("platinum/platinum_hoe").toString());
        Advancement.Builder.advancement().parent(root).display(ModItems.PLATINUM_CHESTPLATE.get(), new TranslatableComponent("advancements.platinum.platinum_armor.title"), new TranslatableComponent("advancements.platinum.platinum_armor.description"), (ResourceLocation) null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(100)).addCriterion("platinum_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINUM_HELMET.get(), ModItems.PLATINUM_CHESTPLATE.get(), ModItems.PLATINUM_LEGGINGS.get(), ModItems.PLATINUM_BOOTS.get())).save(advancementConsumer, modId("platinum/platinum_armor").toString());
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(PlatinumMod.MOD_ID, path);
    }
}
