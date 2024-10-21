package net.ladystrella.wishfuldelight.datagen;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.customblock.CheeseBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockState extends BlockStateProvider {

    private static final int DEFAULT_ANGLE_OFFSET = 180;
    public ModBlockState(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WishfulDelight.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ModdedBlocks.CHEESE_WHEEL);
    }
    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
}
