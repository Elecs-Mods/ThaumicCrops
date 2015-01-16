package elec332.thaumiccrops.thaumcraft.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.oredictHelper;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.main.crops;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
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
    public static HashMap<String, InfusionRecipe> InfusionRecipes = new HashMap<String, InfusionRecipe>();

    public static void init(){
        makeRecipesForSeeds(crops.T1Aspects, 1);
        makeRecipesForSeeds(crops.T2Aspects, 2);
        makeRecipesForSeeds(crops.T3Aspects, 3);
        makeRecipesForSeeds(crops.T4Aspects, 4);
        makeRecipesForSeeds(crops.T5Aspects, 5);
        makeRecipesForSeeds(crops.T6Aspects, 6);
        makeRecipesForSeeds(crops.T7Aspects, 7);
        recourceSeedRecipes(crops.RecourceSeeds);
    }

    static void makeRecipesForSeeds(ArrayList<String> aspectList, int Tier){
        for (int i = 0; i < aspectList.size(); i++) {
            String aspect = aspectList.get(i);
            int Instability = 1+2*Tier;
            int aspectNumber1 = 10+5*Tier;
            int aspectNumber2 = aspectNumber1 + 5;
            Aspect Aspect = thaumcraft.api.aspects.Aspect.getAspect(aspect);
            ItemStack compoundSeed1 = new ItemStack(GameRegistry.findItem(crops.ModID, Aspect.getComponents()[0].getTag()+"crop"));
            ItemStack compoundSeed2 = new ItemStack(GameRegistry.findItem(crops.ModID, Aspect.getComponents()[1].getTag()+"crop"));
            ItemStack thisItem = new ItemStack(GameRegistry.findItem(crops.ModID, aspect + "seed"));
            ItemStack agent = new ItemStack(GameRegistry.findItem(crops.ModID, "agent"+Tier));
            InfusionRecipes.put(aspect, ThaumcraftApi.addInfusionCraftingRecipe("T"+Tier+"SEED", thisItem, Instability, (new AspectList()).add(Aspect.PLANT, aspectNumber1).add(Aspect.CROP, aspectNumber1).add(Aspect.ORDER, aspectNumber2).add(Aspect.MAGIC, aspectNumber2), new ItemStack(Items.wheat_seeds), new ItemStack[]{compoundSeed1, compoundSeed1, compoundSeed1, compoundSeed2, compoundSeed2, compoundSeed2, agent, agent}));
        }
    }

    static void recourceSeedRecipes(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String itemName = arrayList.get(i);
            if (itemName.equalsIgnoreCase("shard") || itemName.equalsIgnoreCase("lapis")){
                //do nothing yet
            } else {
                Aspect[] aspectList = ThaumcraftApiHelper.getObjectAspects(new ItemStack(oredictHelper.getFirstOredictEntry("gem" + helpers.uppercaseFirstLetter(itemName)))).getAspects();
                String aspectName1 = aspectList[0].getTag();
                String aspectName2 = aspectList[1].getTag();
                String fullName = itemName + "seed";
                Item seed1 = crops.getItemFromName(aspectName1 + "seed");
                Item seed2 = crops.getItemFromName(aspectName2 + "seed");
                InfusionRecipes.put(itemName, ThaumcraftApi.addInfusionCraftingRecipe("CROPRESOURCES", new ItemStack(crops.getItemFromName(fullName)), 12, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 50).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50), new ItemStack(crops.getItemFromName("fabricoseed")), new ItemStack[]{new ItemStack(seed1), new ItemStack(seed2)}));
            }
        }
    }

    static String getModFromItem(String item){
        if (item.equalsIgnoreCase("diamond") || item.equalsIgnoreCase("lapis"))
            return "minecraft";
        if (item.equalsIgnoreCase("amber") || item.equalsIgnoreCase("shard"))
            return "Thaumcraft";
       return null;
    }
}
