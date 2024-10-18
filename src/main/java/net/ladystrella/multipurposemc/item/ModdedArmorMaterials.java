package net.ladystrella.multipurposemc.item;

import net.ladystrella.multipurposemc.MultipurposeMc;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModdedArmorMaterials {

    public static final Holder<ArmorMaterial> MODDED_ARMADILLO = register("modded_armadillo", Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
        attribute.put(ArmorItem.Type.BOOTS, 3);
        attribute.put(ArmorItem.Type.LEGGINGS, 6);
        attribute.put(ArmorItem.Type.CHESTPLATE, 8);
        attribute.put(ArmorItem.Type.HELMET, 3);
        attribute.put(ArmorItem.Type.BODY, 11);
    }), 10, 0.0f, 0.0f, SoundEvents.ARMOR_EQUIP_WOLF, () -> Items.ARMADILLO_SCUTE);

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance, Holder<SoundEvent> equipsoundevent,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(MultipurposeMc.MODID, name);
        Holder<SoundEvent> equipSound = equipsoundevent;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(
                        ResourceLocation.fromNamespaceAndPath(MultipurposeMc.MODID, name), "", true
                ),
                new ArmorMaterial.Layer(
                        ResourceLocation.fromNamespaceAndPath(MultipurposeMc.MODID, name), "_overlay", false
                )
        );

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}