package elec332.thaumiccrops.thaumcraft.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Elec332 on 3-1-2015.
 */
public class infusionRecipes {

    @SuppressWarnings("unchecked")
    public static HashMap<String, InfusionRecipe> InfusionRecipes = new HashMap();

    static ItemStack seed = new ItemStack(Items.wheat_seeds);

    public static void init(){
        makeRecipesForSeeds(crops.T1Aspects, 3, 0);
    }

    static void makeRecipesForSeeds(ArrayList<String> aspectList, int Instability, int aspectNumber){
        for (int i = 0; i < aspectList.size(); i++) {
            String aspect = aspectList.get(i);
            Aspect Aspect = thaumcraft.api.aspects.Aspect.getAspect(aspect);
            ItemStack compoundSeed1 = new ItemStack(GameRegistry.findItem(crops.ModID, Aspect.getComponents()[0].getTag()+"crop"));
            ItemStack compoundSeed2 = new ItemStack(GameRegistry.findItem(crops.ModID, Aspect.getComponents()[1].getTag()+"crop"));
            ItemStack thisItem = new ItemStack(GameRegistry.findItem(crops.ModID, aspect + "seed"));
            InfusionRecipes.put(aspect, ThaumcraftApi.addInfusionCraftingRecipe(lib.T1SEED, thisItem, Instability, (new AspectList()).add(Aspect.PLANT, 15+aspectNumber).add(Aspect.CROP, 15+aspectNumber).add(Aspect.ORDER, 20+aspectNumber).add(Aspect.MAGIC, 20+aspectNumber), seed, new ItemStack[]{compoundSeed1, compoundSeed1, compoundSeed1, compoundSeed2, compoundSeed2, compoundSeed2}));
        }
    }
}
