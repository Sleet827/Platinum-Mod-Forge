package net.legiblesleet827.platinum.data;

import net.legiblesleet827.platinum.PlatinumMod;
import net.legiblesleet827.platinum.setup.ModItems;
import net.legiblesleet827.platinum.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, PlatinumMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(ModTags.Blocks.ORES_PLATINUM, ModTags.Items.ORES_PLATINUM);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(ModTags.Blocks.STORAGE_BLOCKS_PLATINUM, ModTags.Items.STORAGE_BLOCKS_PLATINUM);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.INGOTS_PLATINUM).add(ModItems.PLATINUM_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_PLATINUM);

        tag(ModTags.Items.NUGGETS_PLATINUM).add(ModItems.PLATINUM_NUGGET.get());
        tag(Tags.Items.NUGGETS).addTag(ModTags.Items.NUGGETS_PLATINUM);
    }
}
