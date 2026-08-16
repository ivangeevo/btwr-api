package org.btwr.api.api.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.btwr.api.BTWRApi;
import org.btwr.api.api.recipe.recipes.ExtendedShapelessRecipe;

public class BTWRApiRecipes {
    public static final ExtendedShapelessRecipe.Serializer EXTENDED_SHAPELESS_RECIPE_SERIALIZER = new ExtendedShapelessRecipe.Serializer();
    public static final RecipeType<ExtendedShapelessRecipe> EXTENDED_SHAPELESS_RECIPE_TYPE = new RecipeType<>() {};

    public static void initialize() {
        BTWRApi.LOGGER.info("Initializing mod recipes for {}",  BTWRApi.MOD_NAME);

        // Extended shapeless recipe
        registerRecipe("crafting_shapeless_extended", EXTENDED_SHAPELESS_RECIPE_TYPE, EXTENDED_SHAPELESS_RECIPE_SERIALIZER);
    }

    private static void registerRecipe(String path, RecipeType<?> type, RecipeSerializer<?> serializer) {
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(BTWRApi.MOD_ID, path), type);
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(BTWRApi.MOD_ID, path), serializer);
    }
}