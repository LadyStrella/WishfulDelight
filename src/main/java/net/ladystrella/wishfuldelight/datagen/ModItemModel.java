package net.ladystrella.wishfuldelight.datagen;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.item.ModdedItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModel extends ItemModelProvider {
    public ModItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WishfulDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModdedItems.CHEESE_WEDGE.get());
    }
}
