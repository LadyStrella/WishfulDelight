package net.ladystrella.multipurposemc.item;

import net.ladystrella.multipurposemc.MultipurposeMc;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModdedItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MultipurposeMc.MODID);

    public static final DeferredItem<ArmorItem> ARMADILLO_BOOTS = ITEMS.register(
            "armadillo_boots",()->new ArmorItem(ModdedArmorMaterials.MODDED_ARMADILLO,ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(16))));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
