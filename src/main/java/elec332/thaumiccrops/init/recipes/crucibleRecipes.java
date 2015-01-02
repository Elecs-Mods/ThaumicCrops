package elec332.thaumiccrops.init.recipes;

import elec332.thaumiccrops.main.crops;
import thaumcraft.api.crafting.CrucibleRecipe;

import java.util.HashMap;

/**
 * Created by Elec332 on 2-1-2015.
 */
public class crucibleRecipes {
    @SuppressWarnings("unchecked")
    public static HashMap<String, CrucibleRecipe> recipes = new HashMap();

    public static void init(){
        for (int i = 0; i < crops.cropList.size(); i++) {
            //recipes.put(crops.cropList.get(i).toString(), );
        }
    }
}
