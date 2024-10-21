package net.ladystrella.wishfuldelight.item;

import com.google.common.base.Preconditions;
import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.customblock.CheeseBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.model.generators.IGeneratedBlockState;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;

public class ModdedBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WishfulDelight.MODID);

    public static final DeferredBlock<Block> CHEESE_WHEEL = registerBlock("cheese_wheel",
            () -> new CheeseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModdedItems.CHEESE_WEDGE));

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
