package elec332.thaumiccrops.init;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.oredictHelper;
import elec332.core.helper.recipeHelper;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.recipes.infusionRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

/**
 * Created by Elec332 on 4-1-2015.
 */
public class recipes extends crops{

    public static IRecipe[] PageRecipes(){
        IRecipe[] recipes = new IRecipe[miscItemShardsString.length];
        int q = 0;
        for (String itemName : miscItemShardsString) {
            //String ident = helpers.isTCShard(itemName, "shard", "gem");
            String itemNameUppercase = helpers.uppercaseFirstLetter(itemName);
            if (helpers.isTCShard(itemName)){
                String ident = "shard";
                IRecipe recipe = recipeHelper.addStorageRecipe(GameRegistry.findItem(crops.ModID, itemName + "Shard"), new ItemStack(oredictHelper.getFirstOredictEntry(ident + itemNameUppercase),1, oredictHelper.getFirstOredictItemDamage(ident+itemNameUppercase)));
                recipes[q] = recipe;
                q++;
            } else {
                IRecipe recipe = recipeHelper.addStorageRecipe(GameRegistry.findItem(crops.ModID, itemName + "Shard"), oredictHelper.getFirstOreDictItemWithMeta(infusionRecipes.typeOre(itemName) + (itemName.equalsIgnoreCase("coal") ? itemName : itemNameUppercase)));
                recipes[q] = recipe;
                q++;
            }
        }
        return recipes;
    }

}
