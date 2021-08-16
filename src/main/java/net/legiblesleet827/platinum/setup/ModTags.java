package net.legiblesleet827.platinum.setup;

import net.legiblesleet827.platinum.PlatinumMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final class Blocks {
        public static final Tag.Named<Block> ORES_PLATINUM = forge("ores/platinum");
        public static final Tag.Named<Block> STORAGE_BLOCKS_PLATINUM = forge("storage_blocks/platinum");
        public static final Tag.Named<Block> NEEDS_PLATINUM_TOOL = mod("needs_platinum_tool");

        private static Tag.Named<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static Tag.Named<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(PlatinumMod.MOD_ID, path).toString());
        }
    }

    public static final class Items {
        public static final Tag.Named<Item> ORES_PLATINUM = forge("ores/platinum");
        public static final Tag.Named<Item> STORAGE_BLOCKS_PLATINUM = forge("storage_blocks/platinum");

        public static final Tag.Named<Item> NUGGETS_PLATINUM = forge("nuggets/platinum");
        public static final Tag.Named<Item> INGOTS_PLATINUM = forge("ingots/platinum");

        private static Tag.Named<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static Tag.Named<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(PlatinumMod.MOD_ID, path).toString());
        }
    }
}