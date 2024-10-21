package net.ladystrella.wishfuldelight.datagen;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.item.ModdedItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTag extends ItemTagsProvider {

    public ModItemTag(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                      CompletableFuture<TagLookup<Block>> blockTags,
                      @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, WishfulDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.BEE_FOOD)
                .add(ModdedItems.CHEESE_WEDGE.get());
    }
}
