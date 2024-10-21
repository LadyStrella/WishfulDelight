package net.ladystrella.wishfuldelight.customblock;

import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class CheeseBlock extends PieBlock {

    public CheeseBlock(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }
}
