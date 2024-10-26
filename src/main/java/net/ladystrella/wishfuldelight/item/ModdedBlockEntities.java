package net.ladystrella.wishfuldelight.item;

import net.ladystrella.wishfuldelight.WishfulDelight;
import net.ladystrella.wishfuldelight.customblock.KegBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModdedBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, WishfulDelight.MODID);

    public static final Supplier<BlockEntityType<KegBlockEntity>> KEG_BE =
            BLOCK_ENTITIES.register("keg_be",()-> BlockEntityType.Builder.of(
                    KegBlockEntity::new,ModdedBlocks.KEG.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
