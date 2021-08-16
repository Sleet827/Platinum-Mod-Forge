package net.legiblesleet827.platinum.setup;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> PLATINUM_NUGGET = Registration.ITEMS.register("platinum_nugget", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_INGOT = Registration.ITEMS.register("platinum_ingot", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_SWORD = Registration.ITEMS.register("platinum_sword", () ->
            new SwordItem(ModTiers.PLATINUM, 3, -2.4F, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = Registration.ITEMS.register("platinum_shovel", () ->
            new ShovelItem(ModTiers.PLATINUM, 1.5F, -3.0F, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = Registration.ITEMS.register("platinum_pickaxe", () ->
            new PickaxeItem(ModTiers.PLATINUM, 1, -2.8F, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_AXE = Registration.ITEMS.register("platinum_axe", () ->
            new AxeItem(ModTiers.PLATINUM, 5.0F, -3.0F, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_HOE = Registration.ITEMS.register("platinum_hoe", () ->
            new HoeItem(ModTiers.PLATINUM, -5, 0.0F, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_HELMET = Registration.ITEMS.register("platinum_helmet", () ->
            new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = Registration.ITEMS.register("platinum_chestplate", () ->
            new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = Registration.ITEMS.register("platinum_leggings", () ->
            new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));
    public static final RegistryObject<Item> PLATINUM_BOOTS = Registration.ITEMS.register("platinum_boots", () ->
            new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.PLATINUM_TAB)));

    static void register() {}
}