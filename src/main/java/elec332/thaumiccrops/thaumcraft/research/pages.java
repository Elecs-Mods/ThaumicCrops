package elec332.thaumiccrops.thaumcraft.research;

import elec332.thaumiccrops.thaumcraft.recipes.crucibleRecipes;
import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.ElecResearch;
import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchPage;

/**
 * Created by Elec332 on 1-1-2015.
 */
public class pages {

    public static void init(){
        ResearchPage[] pages;
        ElecResearch research;
        CrucibleRecipe crucible;


        research = new ElecResearch(lib.PRIMALSEEDS, StringToAspectList("messis 50, ignis 50, aqua 50, aer 50, terra 50, ordo 50, perditio 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/aignis.seed.png"), 0, 0, 2);
        for (int i = 0; i < crops.primAspects.size(); i++) {
            research.addPage(new ResearchPage(crucibleRecipes.PrimSeedRecipes.get(crops.primAspects.get(i).toString())));
        }

        //GameRegistry.findItemStack(crops.ModID, "aaerseed", 1)
        //(new AspectList()).merge(Aspect.AIR, 3)
        //crucible = ThaumcraftApi.addCrucibleRecipe(lib.AGENT, new ItemStack(GameRegistry.findItem(crops.ModID, "aaerseed")), new ItemStack(Items.wheat_seeds), StringToAspectList("ordo 4, praecantatio 18"));

        research = new ElecResearch(lib.AGENT, new AspectList().add(Aspect.aspects.get("praecantatio"), 50).add(Aspect.getAspect("ordo"), 68), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/aordo.crop.png"), 2, 3, 2);




    }



    public static AspectList StringToAspectList(String aspectString) {
        AspectList AspectList = new AspectList();
        String[] aspects = aspectString.split(",");
        //ArrayList ASPECTS = stringHelper.convertStringArrayToArraylist(aspects);
        for (int i = 0; i < aspects.length; i++) {
            String aspectandnumberstring = aspects[i];
            if (aspectandnumberstring.startsWith(" ")) aspectandnumberstring = aspectandnumberstring.replaceFirst(" ", "");
            String[] aspectandnumber = aspectandnumberstring.split(" ");
            AspectList.add(Aspect.aspects.get(aspectandnumber[0]), Integer.parseInt(aspectandnumber[1]));
        }

        return AspectList;
    }
}