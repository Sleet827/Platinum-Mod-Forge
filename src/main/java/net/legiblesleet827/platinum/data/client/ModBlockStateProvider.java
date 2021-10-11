package net.legiblesleet827.platinum.data.client;

import net.legiblesleet827.platinum.PlatinumMod;
import net.legiblesleet827.platinum.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, PlatinumMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        simpleBlock(ModBlocks.PLATINUM_BLOCK.get());
        simpleBlock(ModBlocks.PLATINUM_ORE.get());
        simpleBlock(ModBlocks.RAW_PLATINUM_BLOCK.get());
    }
}
