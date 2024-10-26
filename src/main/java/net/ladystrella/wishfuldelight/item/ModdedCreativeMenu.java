package net.ladystrella.wishfuldelight.item;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModdedCreativeMenu {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WishfulDelight.MODID);

    public static final Supplier<CreativeModeTab> WISHFUL_DELIGHT_TAB = CREATIVE_MODE_TAB.register("wishful_delight_tab",()->CreativeModeTab.builder()
            .icon(()->new ItemStack(ModdedItems.CHEESE_WEDGE.get())).title(Component.translatable("creative_tab.wishfuldelight"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModdedBlocks.KEG);
                output.accept(ModdedBlocks.CHEESE_WHEEL);
                output.accept(ModdedItems.CHEESE_WEDGE);
                output.accept(ModdedBlocks.SOFT_CHEESE_WHEEL);
                output.accept(ModdedItems.SOFT_CHEESE_WEDGE);
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
