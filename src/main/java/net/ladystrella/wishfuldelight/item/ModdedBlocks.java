package net.ladystrella.wishfuldelight.item;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.customblock.CheeseBlock;
import net.ladystrella.wishfuldelight.customblock.KegBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EnchantingTableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModdedBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WishfulDelight.MODID);

    public static final DeferredBlock<Block> CHEESE_WHEEL = registerBlock("cheese_wheel",
            () -> new CheeseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModdedItems.CHEESE_WEDGE));
    public static final DeferredBlock<Block> SOFT_CHEESE_WHEEL = registerBlock("soft_cheese_wheel",
            () -> new CheeseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModdedItems.SOFT_CHEESE_WEDGE));
    public static final DeferredBlock<Block> KEG = registerBlock("keg",
            () -> new KegBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).noOcclusion()));


    private static <T extends  Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModdedItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
