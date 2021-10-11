package net.legiblesleet827.platinum.data.client;

import net.legiblesleet827.platinum.PlatinumMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, PlatinumMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("deepslate_platinum_ore", modLoc("block/deepslate_platinum_ore"));
        withExistingParent("platinum_block", modLoc("block/platinum_block"));
        withExistingParent("platinum_ore", modLoc("block/platinum_ore"));
        withExistingParent("raw_platinum_block", modLoc("block/raw_platinum_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

        builder("platinum_nugget", itemGenerated);
        builder("platinum_ingot", itemGenerated);
        builder("raw_platinum_nugget", itemGenerated);
        builder("raw_platinum_ingot", itemGenerated);
        builder("platinum_sword", itemHandheld);
        builder("platinum_shovel", itemHandheld);
        builder("platinum_pickaxe", itemHandheld);
        builder("platinum_axe", itemHandheld);
        builder("platinum_hoe", itemHandheld);
        builder("platinum_helmet", itemGenerated);
        builder("platinum_chestplate", itemGenerated);
        builder("platinum_leggings", itemGenerated);
        builder("platinum_boots", itemGenerated);
    }

    private ItemModelBuilder builder(String name, ModelFile parent) {
        return getBuilder(name).parent(parent).texture("layer0", "item/" + name);
    }
}
