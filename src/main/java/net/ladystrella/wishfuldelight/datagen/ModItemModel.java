package net.ladystrella.wishfuldelight.datagen;

import com.google.common.collect.Sets;
import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.item.ModdedBlocks;
import net.ladystrella.wishfuldelight.item.ModdedItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Set;

public class ModItemModel extends ItemModelProvider {
    public ModItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WishfulDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModdedItems.CHEESE_WEDGE.get());
        basicItem(Item.byBlock(ModdedBlocks.CHEESE_WHEEL.get()));
        basicItem(ModdedItems.SOFT_CHEESE_WEDGE.get());
        basicItem(Item.byBlock(ModdedBlocks.SOFT_CHEESE_WHEEL.get()));
    }
}
