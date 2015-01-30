package elec332.thaumiccrops.init;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.oredictHelper;
import elec332.core.helper.recipeHelper;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.main.crops;
import net.minecraft.item.crafting.IRecipe;

/**
 * Created by Elec332 on 4-1-2015.
 */
public class recipes extends crops{

    public static IRecipe[] PageRecipes(){
        IRecipe[] recipes = new IRecipe[miscItemShardsString.length];
        int q = 0;
        for (String itemName : miscItemShardsString) {
            IRecipe recipe = recipeHelper.addStorageRecipe(GameRegistry.findItem(crops.ModID, itemName + "Shard"), oredictHelper.getFirstOreDictItemWithMeta(helpers.getOreDictNameItem(itemName)));
            recipes[q] = recipe;
            q++;
        }
        return recipes;
    }

}
