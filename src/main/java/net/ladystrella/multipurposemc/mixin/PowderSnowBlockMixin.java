package net.ladystrella.multipurposemc.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.ladystrella.multipurposemc.item.ModdedItems;
import net.ladystrella.multipurposemc.util.ModdedTags;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.PowderSnowBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin {
    private static boolean CheckIfCantSink(ItemStack thisitem){
        return thisitem.is(ModdedTags.Items.CAN_WALK_ON_POWDER_SNOW);
    }
    @ModifyReturnValue(method = "canEntityWalkOnPowderSnow", at = @At(value = "RETURN", ordinal = 1))
    private static boolean PowderedSnowCheckIfCanSink(boolean original, Entity entity) {
        return original || entity instanceof LivingEntity livingEntity && CheckIfCantSink(livingEntity.getItemBySlot(EquipmentSlot.FEET));
    }
}
