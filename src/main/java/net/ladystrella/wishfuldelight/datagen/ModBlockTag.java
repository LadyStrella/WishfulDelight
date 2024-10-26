package net.ladystrella.wishfuldelight.datagen;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.item.ModdedBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTag extends BlockTagsProvider {
    public ModBlockTag(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WishfulDelight.MODID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.MINEABLE_WITH_KNIFE)
                .add(ModdedBlocks.CHEESE_WHEEL.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModdedBlocks.KEG.get());
    }
}