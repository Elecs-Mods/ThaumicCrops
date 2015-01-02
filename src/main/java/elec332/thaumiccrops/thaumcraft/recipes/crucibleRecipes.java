package elec332.thaumiccrops.thaumcraft.recipes;

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
    public static HashMap<String, CrucibleRecipe> PrimSeedRecipes = new HashMap();

    public static void init(){
        for (int i = 0; i < crops.primAspects.size(); i++) {
            String aspect = crops.primAspects.get(i).toString();
            ItemStack thisItem = new ItemStack(GameRegistry.findItem(crops.ModID, aspect+"seed"));
            PrimSeedRecipes.put(aspect, ThaumcraftApi.addCrucibleRecipe(lib.AGENT, thisItem, new ItemStack(Items.wheat_seeds), (new AspectList()).merge(Aspect.MAGIC, 10).merge(Aspect.getAspect(aspect), 10)));
        }
    }
}
