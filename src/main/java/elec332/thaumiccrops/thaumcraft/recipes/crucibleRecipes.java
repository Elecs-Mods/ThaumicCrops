package elec332.thaumiccrops.thaumcraft.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.thaumiccrops.init.Data;
import elec332.thaumiccrops.main.ThaumicCrops;
import elec332.thaumiccrops.thaumcraft.lib.Lib;
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
    public static HashMap<String, CrucibleRecipe> CrucibleRecipes = new HashMap();

    public static void init(){
        for (int i = 0; i < Data.primAspects.size(); i++) {
            String aspect = Data.primAspects.get(i);
            ItemStack thisItem = new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, aspect+"seed"));
            CrucibleRecipes.put(aspect, ThaumcraftApi.addCrucibleRecipe(Lib.PRIMALSEEDS, thisItem, new ItemStack(Items.wheat_seeds), (new AspectList()).merge(Aspect.MAGIC, 10).merge(Aspect.getAspect(aspect), 10)));
        }
        for (int i = 2; i < 8; i++) {
            CrucibleRecipes.put("agent"+i, ThaumcraftApi.addCrucibleRecipe(Lib.AGENT, new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, "agent"+i)), new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, "agent"+(i-1))), (new AspectList()).merge(Aspect.MAGIC, 10).merge(Aspect.ORDER, 10).merge(Aspect.SLIME, 10)) );
        }
    }
}
