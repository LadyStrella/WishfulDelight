package net.ladystrella.wishfuldelight.util;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModdedTags {

    public static class Items{

        private static TagKey<Item> createModTag(String tagname){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(WishfulDelight.MODID,tagname));
        }
    }
}
