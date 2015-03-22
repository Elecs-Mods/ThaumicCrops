package elec332.thaumiccrops.thaumcraft.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.thaumiccrops.main.ThaumicCrops;
import elec332.thaumiccrops.thaumcraft.lib.Lib;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.common.config.ConfigItems;

import java.util.HashMap;

/**
 * Created by Elec332 on 3-1-2015.
 */
public class arcaneRecipes {

    public static HashMap<String, IArcaneRecipe> ArcaneRecipes = new HashMap<String, IArcaneRecipe>();

    public static void init(){
        ArcaneRecipes.put("agent1", ThaumcraftApi.addArcaneCraftingRecipe(Lib.AGENT, new ItemStack(GameRegistry.findItem(ThaumicCrops.ModID, "agent1")), (new AspectList()).merge(Aspect.getAspect("aqua"), 15).merge(Aspect.getAspect("ordo"), 20),
                "ABA", "CDC", " E ", 'A', new ItemStack(ConfigItems.itemResource, 1, 14), 'B', new ItemStack(Items.dye, 1, 15), 'C', new ItemStack(ConfigItems.itemNugget, 1, 5), 'D', Items.slime_ball, 'E', ConfigItems.itemBucketPure
        ));
        for (int i = 1; i < 4; i++) {
            ArcaneRecipes.put("treasure"+i, ThaumcraftApi.addArcaneCraftingRecipe("TREASURESEED", new ItemStack(ConfigItems.itemLootbag, 1, (i-1)), (new AspectList()).merge(Aspect.getAspect("aer"), 20).merge(Aspect.getAspect("ordo"), 20),
                    "A A", "CDC", " C ", 'A', new ItemStack(Items.string), 'C', new ItemStack(ConfigItems.itemResource, 1, 7), 'D', ThaumicCrops.getItemFromName("interdimtreasure" + i)
            ));
        }
    }
}
