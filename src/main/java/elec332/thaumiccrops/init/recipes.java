package elec332.thaumiccrops.init;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.OredictHelper;
import elec332.core.helper.RecipeHelper;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.main.ThaumicCrops;
import net.minecraft.item.crafting.IRecipe;

/**
 * Created by Elec332 on 4-1-2015.
 */
public class recipes extends Data{

    public static IRecipe[] PageRecipes(){
        IRecipe[] recipes = new IRecipe[miscItemShardsString.length];
        int q = 0;
        for (String itemName : miscItemShardsString) {
            IRecipe recipe = RecipeHelper.addStorageRecipe(GameRegistry.findItem(ThaumicCrops.ModID, itemName + "Shard"), OredictHelper.getFirstOreDictItemWithMeta(helpers.getOreDictNameItem(itemName)));
            recipes[q] = recipe;
            q++;
        }
        return recipes;
    }

}
