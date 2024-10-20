package net.ladystrella.wishfuldelight.datagen;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.item.ModdedBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockState extends BlockStateProvider {

    public ModBlockState(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WishfulDelight.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModdedBlocks.CHEESE_WHEEL);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
}
