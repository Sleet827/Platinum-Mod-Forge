package net.legiblesleet827.platinum.data;

import com.google.common.collect.ImmutableList;
import net.legiblesleet827.platinum.PlatinumMod;
import net.legiblesleet827.platinum.setup.ModBlocks;
import net.legiblesleet827.platinum.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public static final ImmutableList<ItemLike> PLATINUM_SMELTABLES = ImmutableList.of(ModBlocks.PLATINUM_ORE.get(), ModBlocks.DEEPSLATE_PLATINUM_ORE.get());

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.PLATINUM_INGOT.get())
                .define('.', ModItems.PLATINUM_NUGGET.get())
                .pattern("...")
                .pattern("...")
                .pattern("...")
                .unlockedBy("has_platinum_nugget", has(ModItems.PLATINUM_NUGGET.get()))
                .save(consumer, modId("platinum_ingot_from_platinum_nuggets"));
        ShapedRecipeBuilder.shaped(ModBlocks.PLATINUM_BLOCK.get())
                .define('#', ModItems.PLATINUM_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.PLATINUM_NUGGET.get(), 9)
                .requires(ModItems.PLATINUM_INGOT.get())
                .unlockedBy("has_platinum_nugget", has(ModItems.PLATINUM_NUGGET.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.PLATINUM_BLOCK.get())
                .unlockedBy("has_platinum_ingot", has(ModItems.PLATINUM_INGOT.get()))
                .save(consumer, modId("platinum_ingot_from_platinum_bloc"));

        for (ItemLike itemLike : PLATINUM_SMELTABLES) {
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemLike), ModItems.PLATINUM_INGOT.get(), 1.0F, 200)
                    .unlockedBy("has_platinum_ore", has(itemLike))
                    .save(consumer, modId("platinum_ingot_smelting" + "_" + ForgeRegistries.ITEMS.getKey(itemLike.asItem()).getPath()));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemLike), ModItems.PLATINUM_INGOT.get(), 1.0F, 100)
                    .unlockedBy("has_platinum_ore", has(itemLike))
                    .save(consumer, modId("platinum_ingot_blasting" + "_" + ForgeRegistries.ITEMS.getKey(itemLike.asItem()).getPath()));
        }

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