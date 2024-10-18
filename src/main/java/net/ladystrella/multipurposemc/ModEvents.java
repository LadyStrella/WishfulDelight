package net.ladystrella.multipurposemc;

import net.ladystrella.multipurposemc.item.ModdedItems;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.bus.api.SubscribeEvent;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;


public class ModEvents {

    @SubscribeEvent
    public static void colorItems(RegisterColorHandlersEvent.Item event)
    {
        event.register((stack, tintIndex) -> tintIndex != 0 ? -1 : DyedItemColor.getOrDefault(stack, -6265536), ModdedItems.ARMADILLO_BOOTS.get());
    }
}
