package elec332.thaumiccrops.init.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
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
            String cropname = crops.cropList.get(i).toString();
            ItemStack thisItem = new ItemStack(GameRegistry.findItem(crops.ModID, cropname+"seed"));
            recipes.put(cropname, ThaumcraftApi.addCrucibleRecipe(lib.AGENT, thisItem, new ItemStack(Items.wheat_seeds), (new AspectList()).merge(Aspect.MAGIC, 10)));
        }
    }
}
