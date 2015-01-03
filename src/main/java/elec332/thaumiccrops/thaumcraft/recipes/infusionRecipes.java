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

import java.util.HashMap;

/**
 * Created by Elec332 on 3-1-2015.
 */
public class infusionRecipes {

    @SuppressWarnings("unchecked")
    public static HashMap<String, InfusionRecipe> InfusionRecipes = new HashMap();

    static ItemStack seed = new ItemStack(Items.wheat_seeds);

    public static void init(){
        for (int i = 0; i < crops.T1Aspects.size(); i++) {
            String aspect = crops.T1Aspects.get(i);
            Aspect Aspect = thaumcraft.api.aspects.Aspect.getAspect(aspect);
            ItemStack thisItem = new ItemStack(GameRegistry.findItem(crops.ModID, aspect + "seed"));
            InfusionRecipes.put(aspect, ThaumcraftApi.addInfusionCraftingRecipe(lib.T1SEED, thisItem, 3, (new AspectList()).add(Aspect.PLANT, 15).add(Aspect.CROP, 15).add(Aspect.ORDER, 20).add(Aspect.MAGIC, 20), seed, new ItemStack[]{GameRegistry.findItemStack(crops.ModID, Aspect.getComponents()[0].getTag()+"seed", 3), GameRegistry.findItemStack(crops.ModID, Aspect.getComponents()[1].getTag() + "seed", 3)}));
        }
    }
}
