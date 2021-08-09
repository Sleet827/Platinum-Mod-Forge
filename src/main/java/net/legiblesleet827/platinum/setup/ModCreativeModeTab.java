package net.legiblesleet827.platinum.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class ModCreativeModeTab {
    public static final CreativeModeTab PLATINUM_TAB = new CreativeModeTab("platinum_tab") {
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PLATINUM_INGOT.get());
        }
    };
}
