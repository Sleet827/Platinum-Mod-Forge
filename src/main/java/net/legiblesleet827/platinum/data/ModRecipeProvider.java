package net.legiblesleet827.platinum.data;

import com.google.common.collect.ImmutableList;
import net.legiblesleet827.platinum.PlatinumMod;
import net.legiblesleet827.platinum.setup.ModBlocks;
import net.legiblesleet827.platinum.setup.ModItems;
import net.legiblesleet827.platinum.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public static final ImmutableList<ItemLike> PLATINUM_SMELTABLES = ImmutableList.of(ModBlocks.PLATINUM_ORE.get(), ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModItems.RAW_PLATINUM_INGOT.get());

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.PLATINUM_INGOT.get())
                .define('.', ModTags.Items.NUGGETS_PLATINUM)
                .pattern("...")
                .pattern("...")
                .pattern("...")
                .unlockedBy("has_platinum_nugget", has(ModTags.Items.NUGGETS_PLATINUM))
                .save(consumer, modId("platinum_ingot_from_platinum_nuggets"));
        ShapedRecipeBuilder.shaped(ModBlocks.PLATINUM_BLOCK.get())
                .define('#', ModTags.Items.INGOTS_PLATINUM)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_platinum_ingot", has(ModTags.Items.INGOTS_PLATINUM))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.PLATINUM_NUGGET.get(), 9)
                .requires(ModTags.Items.INGOTS_PLATINUM)
                .unlockedBy("has_platinum_nugget", has(ModTags.Items.INGOTS_PLATINUM))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.PLATINUM_INGOT.get(), 9)
                .requires(ModTags.Items.STORAGE_BLOCKS_PLATINUM)
                .unlockedBy("has_platinum_ingot", has(ModTags.Items.INGOTS_PLATINUM))
                .save(consumer, modId("platinum_ingot_from_platinum_block"));

        ShapedRecipeBuilder.shaped(ModItems.RAW_PLATINUM_INGOT.get())
                .define('.', ModItems.RAW_PLATINUM_NUGGET.get())
                .pattern("...")
                .pattern("...")
                .pattern("...")
                .unlockedBy("has_raw_platinum_nugget", has(ModItems.RAW_PLATINUM_NUGGET.get()))
                .save(consumer, modId("raw_platinum_ingot_from_raw_platinum_nuggets"));
        ShapedRecipeBuilder.shaped(ModBlocks.RAW_PLATINUM_BLOCK.get())
                .define('#', ModItems.RAW_PLATINUM_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_raw_platinum_ingot", has(ModItems.RAW_PLATINUM_INGOT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.RAW_PLATINUM_NUGGET.get(), 9)
                .requires(ModItems.RAW_PLATINUM_INGOT.get())
                .unlockedBy("has_raw_platinum_nugget", has(ModItems.RAW_PLATINUM_NUGGET.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.RAW_PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.RAW_PLATINUM_BLOCK.get())
                .unlockedBy("has_raw_platinum_ingot", has(ModItems.RAW_PLATINUM_INGOT.get()))
                .save(consumer, modId("raw_platinum_ingot_from_raw_platinum_block"));

        for (ItemLike itemLike : PLATINUM_SMELTABLES) {
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemLike), ModItems.RAW_PLATINUM_NUGGET.get(), 1.0F, 200)
                    .unlockedBy("has_platinum_ore", has(itemLike))
                    .save(consumer, modId("platinum_ingot_smelting" + "_" + ForgeRegistries.ITEMS.getKey(itemLike.asItem()).getPath()));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemLike), ModItems.RAW_PLATINUM_NUGGET.get(), 1.0F, 100)
                    .unlockedBy("has_platinum_ore", has(itemLike))
                    .save(consumer, modId("platinum_ingot_blasting" + "_" + ForgeRegistries.ITEMS.getKey(itemLike.asItem()).getPath()));
        }

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_PLATINUM_INGOT.get()), ModItems.PLATINUM_INGOT.get(), 1.0F, 200)
                .unlockedBy("has_raw_platinum_ingot", has(ModItems.RAW_PLATINUM_INGOT.get()))
                .save(consumer, "platinum_ingot_from_raw_platinum_ingot_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_PLATINUM_INGOT.get()), ModItems.PLATINUM_INGOT.get(), 1.0F, 100)
                .unlockedBy("has_raw_platinum_ingot", has(ModItems.RAW_PLATINUM_INGOT.get()))
                .save(consumer, "platinum_ingot_from_raw_platinum_ingot_blasting");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_SWORD), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_SWORD.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_sword"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_SHOVEL), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_SHOVEL.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_shovel"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_PICKAXE), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_PICKAXE.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_pickaxe"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_AXE), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_AXE.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_axe"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_HOE), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_HOE.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_hoe"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_HELMET), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_HELMET.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_helmet"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_CHESTPLATE), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_CHESTPLATE.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_chestplate"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_LEGGINGS), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_LEGGINGS.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_leggings"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_BOOTS), Ingredient.of(ModItems.PLATINUM_INGOT.get()), ModItems.PLATINUM_BOOTS.get())
                .unlocks("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_boots"));
    }

    private ResourceLocation modId(String path) {
        return new ResourceLocation(PlatinumMod.MOD_ID, path);
    }
}
