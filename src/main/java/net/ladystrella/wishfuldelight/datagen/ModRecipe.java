package net.ladystrella.wishfuldelight.datagen;

import net.ladystrella.wishfuldelight.item.ModdedBlocks;
import net.ladystrella.wishfuldelight.item.ModdedItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;


import java.util.concurrent.CompletableFuture;

public class ModRecipe extends RecipeProvider implements IConditionBuilder {

    public ModRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput){

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModdedBlocks.CHEESE_WHEEL.get())
                .pattern("WW")
                .pattern("WW")
                .define('W',ModdedItems.CHEESE_WEDGE.get())
                .unlockedBy("has_wedge",has(ModdedItems.CHEESE_WEDGE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,
                ModdedItems.CHEESE_WEDGE.get(),4)
                .requires(ModdedBlocks.CHEESE_WHEEL)
                .unlockedBy("has_cheese_wheel",has(ModdedBlocks.CHEESE_WHEEL))
                .save(recipeOutput, "wishfuldelight:cut_cheese");

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(new ItemLike[]{(ItemLike) ModdedBlocks.CHEESE_WHEEL.get().asItem()}), Ingredient.of(CommonTags.TOOLS_KNIFE), (ItemLike)ModdedItems.CHEESE_WEDGE.get(), 4).build(recipeOutput);
    }
}
