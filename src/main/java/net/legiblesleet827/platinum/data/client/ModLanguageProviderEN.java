package net.legiblesleet827.platinum.data.client;

import net.legiblesleet827.platinum.PlatinumMod;
import net.legiblesleet827.platinum.setup.ModBlocks;
import net.legiblesleet827.platinum.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProviderEN extends LanguageProvider {
    public ModLanguageProviderEN(DataGenerator gen) {
        super(gen, PlatinumMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        this.add(ModItems.PLATINUM_NUGGET.get(), "Platinum Nugget");
        this.add(ModItems.PLATINUM_INGOT.get(), "Platinum Ingot");
        this.add(ModItems.RAW_PLATINUM_NUGGET.get(), "Raw Platinum Nugget");
        this.add(ModItems.RAW_PLATINUM_INGOT.get(), "Raw Platinum Ingot");
        this.add(ModItems.PLATINUM_SWORD.get(), "Platinum Sword");
        this.add(ModItems.PLATINUM_SHOVEL.get(), "Platinum Shovel");
        this.add(ModItems.PLATINUM_PICKAXE.get(), "Platinum Pickaxe");
        this.add(ModItems.PLATINUM_AXE.get(), "Platinum Axe");
        this.add(ModItems.PLATINUM_HOE.get(), "Platinum Hoe");
        this.add(ModItems.PLATINUM_HELMET.get(), "Platinum Helmet");
        this.add(ModItems.PLATINUM_CHESTPLATE.get(), "Platinum Chestplate");
        this.add(ModItems.PLATINUM_LEGGINGS.get(), "Platinum Leggings");
        this.add(ModItems.PLATINUM_BOOTS.get(), "Platinum Boots");

        // Blocks
        this.add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), "Deepslate Platinum Ore");
        this.add(ModBlocks.PLATINUM_BLOCK.get(), "Platinum Block");
        this.add(ModBlocks.PLATINUM_ORE.get(), "Platinum Ore");
        this.add(ModBlocks.RAW_PLATINUM_BLOCK.get(), "Raw Platinum Block");
    }
}
