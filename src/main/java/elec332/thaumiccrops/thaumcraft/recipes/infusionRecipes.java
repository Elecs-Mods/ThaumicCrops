package elec332.thaumiccrops.thaumcraft.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.OredictHelper;
import elec332.core.main.ElecCore;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.main.crops;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.common.config.ConfigItems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Elec332 on 3-1-2015.
 */
public class infusionRecipes {

    @SuppressWarnings("unchecked")
    public static HashMap<String, InfusionRecipe> InfusionRecipes = new HashMap();

    public static void init(){
        makeRecipesForSeeds(crops.T1Aspects, 1);
        makeRecipesForSeeds(crops.T2Aspects, 2);
        makeRecipesForSeeds(crops.T3Aspects, 3);
        makeRecipesForSeeds(crops.T4Aspects, 4);
        makeRecipesForSeeds(crops.T5Aspects, 5);
        makeRecipesForSeeds(crops.T6Aspects, 6);
        makeRecipesForSeeds(crops.T7Aspects, 7);
        recourceSeedRecipes(crops.RecourceSeeds);
        InfusionRecipes.put("treasure", ThaumcraftApi.addInfusionCraftingRecipe("TREASURESEED", new ItemStack(crops.getItemFromName("treasureseed")), 12, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.CROP, 45).add(Aspect.CRAFT, 50).add(Aspect.TRAVEL, 100).add(Aspect.GREED, 100), new ItemStack(crops.getItemFromName("fabricoseed")), new ItemStack[]{new ItemStack(crops.getItemFromName("itercrop")), new ItemStack(crops.getItemFromName("ordocrop")), new ItemStack(crops.getItemFromName("itercrop")), new ItemStack(crops.getItemFromName("lucrumcrop")), new ItemStack(crops.getItemFromName("itercrop")), new ItemStack(crops.getItemFromName("ordocrop")), new ItemStack(crops.getItemFromName("teleportCore")), new ItemStack(Blocks.gold_block), new ItemStack(Blocks.diamond_block), new ItemStack(crops.getItemFromName("agent7")), new ItemStack(crops.getItemFromName("agent7"))}));
        InfusionRecipes.put("teleCore", ThaumcraftApi.addInfusionCraftingRecipe("TREASURESEED", new ItemStack(crops.getItemFromName("teleportCore")), 11, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 50).add(Aspect.CRAFT, 50).add(Aspect.TRAVEL, 100), new ItemStack(Items.nether_star), new ItemStack[]{new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl), new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl), new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl), new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl)}));
        InfusionRecipes.put("monsterSeed", ThaumcraftApi.addInfusionCraftingRecipe("MONSTERSEED", new ItemStack(crops.getItemFromName("monsterseed")), 18, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 45).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50).add(Aspect.DEATH, 100), new ItemStack(crops.getItemFromName("fabricoseed")), new ItemStack[]{new ItemStack(crops.getItemFromName("exanimiscrop")), new ItemStack(crops.getItemFromName("exanimiscrop")), new ItemStack(crops.getItemFromName("exanimiscrop")), new ItemStack(crops.getItemFromName("exanimiscrop")), new ItemStack(crops.getItemFromName("exanimiscrop")), new ItemStack(crops.getItemFromName("exanimiscrop")), new ItemStack(crops.getItemFromName("soulCore")), new ItemStack(crops.getItemFromName("agent7")), new ItemStack(crops.getItemFromName("agent7"))}));
        InfusionRecipes.put("soulCore", ThaumcraftApi.addInfusionCraftingRecipe("MONSTERSEED", new ItemStack(crops.getItemFromName("soulCore")), 11, (new AspectList()).add(Aspect.WEAPON, 45).add(Aspect.UNDEAD, 45).add(Aspect.DARKNESS, 45).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50).add(Aspect.DEATH, 100), new ItemStack(Items.nether_star), new ItemStack[]{ new ItemStack(Items.skull), new ItemStack(Items.blaze_rod), new ItemStack(Items.ghast_tear), new ItemStack(Items.ender_pearl), new ItemStack(Items.bone), new ItemStack(Items.rotten_flesh), new ItemStack(Items.spider_eye), new ItemStack(Items.string), new ItemStack(Items.arrow), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemZombieBrain)}));
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
            String fullName = itemName + "seed";
            ItemStack agent = new ItemStack(crops.getItemFromName("agent7"));
            ItemStack block = OredictHelper.getFirstOreDictItemWithMeta(helpers.getOreDictNameBlock(itemName));
            if (itemName.equalsIgnoreCase("shard")){
                InfusionRecipes.put(itemName, ThaumcraftApi.addInfusionCraftingRecipe("CROPRESOURCES", new ItemStack(crops.getItemFromName(fullName)), 12, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 50).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50), new ItemStack(crops.getItemFromName("fabricoseed")), new ItemStack[]{primCrop(1), primCrop(2), primCrop(3),primCrop(4), primCrop(5), primCrop(6), block, block, agent, agent}));
            } else {
                if (ElecCore.Debug)
                    crops.instance.info("Attempting to find OreDict entry for: " + itemName);
                Aspect[] aspectList = ThaumcraftApiHelper.getObjectAspects(OredictHelper.getFirstOreDictItemWithMeta(helpers.getOreDictNameItem(itemName))).getAspects();
                String aspectName1 = aspectList[0].getTag();
                String aspectName2 = ResTest(aspectList, 1, aspectName1);
                ItemStack seed1 = new ItemStack(crops.getItemFromName(aspectName1 + "crop"));
                ItemStack seed2 = new ItemStack(crops.getItemFromName(aspectName2 + "crop"));
                InfusionRecipes.put(itemName, ThaumcraftApi.addInfusionCraftingRecipe("CROPRESOURCES", new ItemStack(crops.getItemFromName(fullName)), 12, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 50).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50), new ItemStack(crops.getItemFromName("fabricoseed")), new ItemStack[]{seed1, seed1, seed1, seed2, seed2, seed2, block, block, agent, agent}));
            }
        }
    }



    static String ResTest(Aspect[] aspects, int i, String ifNull){
        try {
            return aspects[i].getTag();
        }catch (Exception e){
            return ifNull;
        }
    }

    static ItemStack primCrop(int i){
        if(i >= 0 && i <= crops.primAspects.size() || i == crops.primAspects.size())
            return new ItemStack(crops.getItemFromName(crops.primAspects.get((i - 1))+"crop"));
        return null;
    }
}
