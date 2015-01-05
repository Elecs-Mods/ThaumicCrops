package elec332.thaumiccrops.init;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.oredictHelper;
import elec332.core.helper.recipeHelper;
import elec332.thaumiccrops.main.crops;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

import java.util.ArrayList;

/**
 * Created by Elec332 on 4-1-2015.
 */
public class recipes {

    public static IRecipe[] PageRecipes(){
        IRecipe[] recipes = new IRecipe[crops.miscItemShardNumber];
        int q = 0;
        for (int i = 0; i < crops.miscItemShards.size(); i++) {
            String itemName = crops.miscItemShards.get(i);
            String itemNameUppercase = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
            IRecipe recipe = recipeHelper.addStorageRecipe(GameRegistry.findItem(crops.ModID, itemName+"Shard"), oredictHelper.getFirstOredictEntry("gem" + itemNameUppercase));
            recipes[q] = recipe;
            q++;
        }
        for (int i = 0; i < crops.primAspects.size(); i++) {
            String itemName = crops.primAspects.get(i);
            String itemNameUppercase = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
            IRecipe recipe = recipeHelper.addStorageRecipe(GameRegistry.findItem(crops.ModID, itemName+"Shard"), oredictHelper.getFirstOredictEntry("shard" + itemNameUppercase));
            recipes[q] = recipe;
            q++;
        }

        return recipes;
    }


}
