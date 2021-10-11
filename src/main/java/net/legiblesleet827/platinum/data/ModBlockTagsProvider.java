package net.legiblesleet827.platinum.data;

import net.legiblesleet827.platinum.PlatinumMod;
import net.legiblesleet827.platinum.setup.ModBlocks;
import net.legiblesleet827.platinum.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, PlatinumMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_PLATINUM).add(ModBlocks.PLATINUM_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_PLATINUM);

        tag(ModTags.Blocks.STORAGE_BLOCKS_PLATINUM).add(ModBlocks.PLATINUM_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_PLATINUM);

        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTags(ModTags.Blocks.ORES_PLATINUM).add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get()).addTags(ModTags.Blocks.STORAGE_BLOCKS_PLATINUM).add(ModBlocks.RAW_PLATINUM_BLOCK.get());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).addTags(ModTags.Blocks.ORES_PLATINUM).add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get()).addTags(ModTags.Blocks.STORAGE_BLOCKS_PLATINUM).add(ModBlocks.RAW_PLATINUM_BLOCK.get());
    }
}