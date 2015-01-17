package elec332.thaumiccrops.thaumcraft.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.lib.lib;
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

    @SuppressWarnings("unchecked")
    public static HashMap<String, IArcaneRecipe> ArcaneRecipes = new HashMap();

    public static void init(){
        ArcaneRecipes.put("agent1", ThaumcraftApi.addArcaneCraftingRecipe(lib.AGENT, new ItemStack(GameRegistry.findItem(crops.ModID, "agent1")), (new AspectList()).merge(Aspect.getAspect("aqua"), 15).merge(Aspect.getAspect("ordo"), 20),  new Object[]{
                "ABA", "CDC", " E ", 'A', new ItemStack(ConfigItems.itemResource, 1, 14), 'B', new ItemStack(Items.dye, 1, 15), 'C', new ItemStack(ConfigItems.itemNugget, 1, 5), 'D', Items.slime_ball, 'E', ConfigItems.itemBucketPure
        }));
        for (int i = 1; i < 4; i++) {
            ArcaneRecipes.put("treasure"+i, ThaumcraftApi.addArcaneCraftingRecipe("TREASURESEED", new ItemStack(ConfigItems.itemLootbag, 1, (i-1)), (new AspectList()).merge(Aspect.getAspect("aer"), 20).merge(Aspect.getAspect("ordo"), 20),  new Object[]{
                    "A A", "CDC", " C ", 'A', new ItemStack(Items.string), 'C', new ItemStack(ConfigItems.itemResource, 1, 7), 'D', crops.getItemFromName("interdimtreasure"+i)
            }));
        }
    }
}
