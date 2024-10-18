package net.ladystrella.multipurposemc.util;

import net.ladystrella.multipurposemc.MultipurposeMc;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModdedTags {

    public static class Items{
        public static final TagKey<Item> CAN_WALK_ON_POWDER_SNOW = createModTag("can_walk_on_powder_snow");

        private static TagKey<Item> createModTag(String tagname){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MultipurposeMc.MODID,tagname));
        }
    }
}
