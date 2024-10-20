package net.ladystrella.wishfuldelight.item;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModdedItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WishfulDelight.MODID);

    public static final DeferredItem<Item> CHEESE_WEDGE = ITEMS.register("cheese_wedge",() -> new Item(new Item.Properties().food(ModdedFood.CHEESE)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
