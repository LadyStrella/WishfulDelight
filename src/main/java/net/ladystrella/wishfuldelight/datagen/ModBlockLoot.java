package net.ladystrella.wishfuldelight.datagen;

import net.ladystrella.wishfuldelight.item.ModdedBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLoot extends BlockLootSubProvider {
    protected ModBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModdedBlocks.CHEESE_WHEEL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModdedBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
