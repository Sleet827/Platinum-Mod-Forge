package net.legiblesleet827.platinum.world;

import net.legiblesleet827.platinum.setup.ModBlocks;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.SquareDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        if (!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE,
                    ModBlocks.PLATINUM_ORE.get().defaultBlockState(), 1, 5, 10, 1);
            generateOre(event.getGeneration(), OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState(), 1, 5, 10, 1);
        }
    }

    private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
                                    int veinSize, int minHeight, int maxHeight, int amount) {
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(fillerType, state, veinSize))
                        .decorated(SquareDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)))))
                        .squared().count(amount));
    }
}
