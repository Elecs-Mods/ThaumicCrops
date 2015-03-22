package elec332.thaumiccrops.thaumcraft.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.OredictHelper;
import elec332.core.main.ElecCore;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.init.Data;
import elec332.thaumiccrops.main.ThaumicCrops;
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
        makeRecipesForSeeds(Data.T1Aspects, 1);
        makeRecipesForSeeds(Data.T2Aspects, 2);
        makeRecipesForSeeds(Data.T3Aspects, 3);
        makeRecipesForSeeds(Data.T4Aspects, 4);
        makeRecipesForSeeds(Data.T5Aspects, 5);
        makeRecipesForSeeds(Data.T6Aspects, 6);
        makeRecipesForSeeds(Data.T7Aspects, 7);
        recourceSeedRecipes(Data.RecourceSeeds);
        InfusionRecipes.put("treasure", ThaumcraftApi.addInfusionCraftingRecipe("TREASURESEED", new ItemStack(ThaumicCrops.getItemFromName("treasureseed")), 12, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.CROP, 45).add(Aspect.CRAFT, 50).add(Aspect.TRAVEL, 100).add(Aspect.GREED, 100), new ItemStack(ThaumicCrops.getItemFromName("fabricoseed")), new ItemStack[]{new ItemStack(ThaumicCrops.getItemFromName("itercrop")), new ItemStack(ThaumicCrops.getItemFromName("ordocrop")), new ItemStack(ThaumicCrops.getItemFromName("itercrop")), new ItemStack(ThaumicCrops.getItemFromName("lucrumcrop")), new ItemStack(ThaumicCrops.getItemFromName("itercrop")), new ItemStack(ThaumicCrops.getItemFromName("ordocrop")), new ItemStack(ThaumicCrops.getItemFromName("teleportCore")), new ItemStack(Blocks.gold_block), new ItemStack(Blocks.diamond_block), new ItemStack(ThaumicCrops.getItemFromName("agent7")), new ItemStack(ThaumicCrops.getItemFromName("agent7"))}));
        InfusionRecipes.put("teleCore", ThaumcraftApi.addInfusionCraftingRecipe("TREASURESEED", new ItemStack(ThaumicCrops.getItemFromName("teleportCore")), 11, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 50).add(Aspect.CRAFT, 50).add(Aspect.TRAVEL, 100), new ItemStack(Items.nether_star), new ItemStack[]{new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl), new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl), new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl), new ItemStack(Items.gold_nugget), new ItemStack(Items.ender_pearl)}));
        InfusionRecipes.put("monsterSeed", ThaumcraftApi.addInfusionCraftingRecipe("MONSTERSEED", new ItemStack(ThaumicCrops.getItemFromName("monsterseed")), 18, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 45).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50).add(Aspect.DEATH, 100), new ItemStack(ThaumicCrops.getItemFromName("fabricoseed")), new ItemStack[]{new ItemStack(ThaumicCrops.getItemFromName("exanimiscrop")), new ItemStack(ThaumicCrops.getItemFromName("exanimiscrop")), new ItemStack(ThaumicCrops.getItemFromName("exanimiscrop")), new ItemStack(ThaumicCrops.getItemFromName("exanimiscrop")), new ItemStack(ThaumicCrops.getItemFromName("exanimiscrop")), new ItemStack(ThaumicCrops.getItemFromName("exanimiscrop")), new ItemStack(ThaumicCrops.getItemFromName("soulCore")), new ItemStack(ThaumicCrops.getItemFromName("agent7")), new ItemStack(ThaumicCrops.getItemFromName("agent7"))}));
        InfusionRecipes.put("soulCore", ThaumcraftApi.addInfusionCraftingRecipe("MONSTERSEED", new ItemStack(ThaumicCrops.getItemFromName("soulCore")), 11, (new AspectList()).add(Aspect.WEAPON, 45).add(Aspect.UNDEAD, 45).add(Aspect.DARKNESS, 45).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50).add(Aspect.DEATH, 100), new ItemStack(Items.nether_star), new ItemStack[]{ new ItemStack(Items.skull), new ItemStack(Items.blaze_rod), new ItemStack(Items.ghast_tear), new ItemStack(Items.ender_pearl), new ItemStack(Items.bone), new ItemStack(Items.rotten_flesh), new ItemStack(Items.spider_eye), new ItemStack(Items.string), new ItemStack(Items.arrow), new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemZombieBrain)}));
        InfusionRecipes.put("treasure1", ThaumcraftApi.addInfusionCraftingRecipe("TREASURESEED", new ItemStack(ThaumicCrops.getItemFromName("interdimtreasure1")), 3, (new AspectList()).add(Aspect.GREED, 5), new ItemStack(Items.gold_ingot), new ItemStack[]{ new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore"))}));
        InfusionRecipes.put("treasure2", ThaumcraftApi.addInfusionCraftingRecipe("TREASURESEED", new ItemStack(ThaumicCrops.getItemFromName("interdimtreasure2")), 5, (new AspectList()).add(Aspect.GREED, 15), new ItemStack(Items.gold_ingot), new ItemStack[]{ new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore"))}));
        InfusionRecipes.put("treasure3", ThaumcraftApi.addInfusionCraftingRecipe("TREASURESEED", new ItemStack(ThaumicCrops.getItemFromName("interdimtreasure3")), 7, (new AspectList()).add(Aspect.GREED, 25), new ItemStack(Items.gold_ingot), new ItemStack[]{ new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore")), new ItemStack(ThaumicCrops.getItemFromName("treasureCore"))}));

    }

    static void makeRecipesForSeeds(ArrayList<String> aspectList, int Tier){
        for (String aspectString : aspectList) {
            int Instability = 1+2*Tier;
            int aspectNumber1 = 10+5*Tier;
            int aspectNumber2 = aspectNumber1 + 5;
            Aspect aspect = thaumcraft.api.aspects.Aspect.getAspect(aspectString);
            ItemStack compoundSeed1 = new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, aspect.getComponents()[0].getTag()+"crop"));
            ItemStack compoundSeed2 = new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, aspect.getComponents()[1].getTag()+"crop"));
            ItemStack thisItem = new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, aspectString + "seed"));
            ItemStack agent = new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, "agent"+Tier));
            InfusionRecipes.put(aspectString, ThaumcraftApi.addInfusionCraftingRecipe("T" + Tier + "SEED", thisItem, Instability, (new AspectList()).add(Aspect.PLANT, aspectNumber1).add(Aspect.CROP, aspectNumber1).add(Aspect.ORDER, aspectNumber2).add(Aspect.MAGIC, aspectNumber2), new ItemStack(Items.wheat_seeds), new ItemStack[]{compoundSeed1, compoundSeed1, compoundSeed1, compoundSeed2, compoundSeed2, compoundSeed2, agent, agent}));
        }
    }

    private static void recourceSeedRecipes(ArrayList<String> arrayList) {
        for (String itemName : arrayList) {
            String fullName = itemName + "seed";
            ItemStack agent = new ItemStack(ThaumicCrops.getItemFromName("agent7"));
            ItemStack block = OredictHelper.getFirstOreDictItemWithMeta(helpers.getOreDictNameBlock(itemName));
            if (itemName.equalsIgnoreCase("shard")){
                InfusionRecipes.put(itemName, ThaumcraftApi.addInfusionCraftingRecipe("CROPRESOURCES", new ItemStack(ThaumicCrops.getItemFromName(fullName)), 12, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 50).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50), new ItemStack(ThaumicCrops.getItemFromName("fabricoseed")), new ItemStack[]{primCrop(1), primCrop(2), primCrop(3),primCrop(4), primCrop(5), primCrop(6), block, block, agent, agent}));
            } else {
                if (ElecCore.Debug)
                    ThaumicCrops.instance.info("Attempting to find OreDict entry for: " + itemName);
                Aspect[] aspectList = ThaumcraftApiHelper.getObjectAspects(OredictHelper.getFirstOreDictItemWithMeta(helpers.getOreDictNameItem(itemName))).getAspects();
                String aspectName1 = aspectList[0].getTag();
                String aspectName2 = ResTest(aspectList, 1, aspectName1);
                ItemStack seed1 = new ItemStack(ThaumicCrops.getItemFromName(aspectName1 + "crop"));
                ItemStack seed2 = new ItemStack(ThaumicCrops.getItemFromName(aspectName2 + "crop"));
                InfusionRecipes.put(itemName, ThaumcraftApi.addInfusionCraftingRecipe("CROPRESOURCES", new ItemStack(ThaumicCrops.getItemFromName(fullName)), 12, (new AspectList()).add(Aspect.PLANT, 45).add(Aspect.HARVEST, 50).add(Aspect.CRAFT, 50).add(Aspect.MAGIC, 50), new ItemStack(ThaumicCrops.getItemFromName("fabricoseed")), new ItemStack[]{seed1, seed1, seed1, seed2, seed2, seed2, block, block, agent, agent}));
            }
        }
    }



    private static String ResTest(Aspect[] aspects, int i, String ifNull){
        try {
            return aspects[i].getTag();
        }catch (Exception e){
            return ifNull;
        }
    }

    private static ItemStack primCrop(int i){
        if(i >= 0 && i <= Data.primAspects.size() || i == Data.primAspects.size())
            return new ItemStack(ThaumicCrops.getItemFromName(Data.primAspects.get((i - 1)) + "crop"));
        return null;
    }
}
