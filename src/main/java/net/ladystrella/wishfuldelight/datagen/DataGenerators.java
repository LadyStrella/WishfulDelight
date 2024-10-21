package net.ladystrella.wishfuldelight.datagen;


import net.ladystrella.wishfuldelight.WishfulDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = WishfulDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(),new LootTableProvider(packOutput,
                Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLoot::new,
                LootContextParamSets.BLOCK)), lookUpProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTag(packOutput,lookUpProvider,existingFileHelper);
        generator.addProvider(event.includeServer(),blockTagsProvider);
        generator.addProvider(event.includeServer(),new ModItemTag(packOutput,lookUpProvider,blockTagsProvider.contentsGetter(),existingFileHelper));
        generator.addProvider(event.includeServer(),new ModRecipe(packOutput,lookUpProvider));

        generator.addProvider(event.includeClient(), new ModItemModel(packOutput,existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockState(packOutput,existingFileHelper));
    }
}
