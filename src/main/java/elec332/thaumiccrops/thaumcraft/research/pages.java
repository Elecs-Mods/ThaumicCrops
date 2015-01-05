package elec332.thaumiccrops.thaumcraft.research;

import elec332.thaumiccrops.init.recipes;
import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.ElecResearch;
import elec332.thaumiccrops.thaumcraft.lib.lib;
import elec332.thaumiccrops.thaumcraft.recipes.arcaneRecipes;
import elec332.thaumiccrops.thaumcraft.recipes.crucibleRecipes;
import elec332.thaumiccrops.thaumcraft.recipes.infusionRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

/**
 * Created by Elec332 on 1-1-2015.
 */
public class pages {

    public static void init(){
        ElecResearch research;

        research = new ElecResearch(lib.PRIMALSEEDS, StringToAspectList("messis 50, ignis 50, aqua 50, aer 50, terra 50, ordo 50, perditio 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/aignis.seed.png"), 0, 0, 2);
        for (int i = 0; i < crops.primAspects.size(); i++) {
            research.addPage(new ResearchPage(crucibleRecipes.CrucibleRecipes.get(crops.primAspects.get(i))));
        }

        research = new ElecResearch(lib.AGENT, new AspectList().add(Aspect.aspects.get("praecantatio"), 50).add(Aspect.getAspect("ordo"), 68), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/aordo.crop.png"), 2, 3, 2);
        research.addPage(new ResearchPage(arcaneRecipes.ArcaneRecipes.get("agent1")));
        for (int i = 2; i < 8; i++) {
            research.addPage(new ResearchPage(crucibleRecipes.CrucibleRecipes.get("agent"+i)));
        }

        research = new ElecResearch("T1SEED", StringToAspectList("messis 50, gelum 50, motus 50, potentia 50, vacuos 50, victus 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/aordo.crop.png"), 5, 4, 1);
        for (int i = 0; i < crops.T1Aspects.size(); i++) {
            research.addPage(new ResearchPage(infusionRecipes.InfusionRecipes.get(crops.T1Aspects.get(i))));
        }

        research = new ElecResearch("T2SEED", StringToAspectList("messis 50, bestia 50, herba 50, limus 50, mortuus 50, sano 50, vinculum 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/messis.crop.png"), 5, 5, 1);
        for (int i = 0; i < crops.T2Aspects.size(); i++) {
            research.addPage(new ResearchPage(infusionRecipes.InfusionRecipes.get(crops.T2Aspects.get(i))));
        }

        research = new ElecResearch("T3SEED", StringToAspectList("messis 50, alienis 50, arbor 50, auram 50, corpus 50, exanimis 50, spiritus 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/messis.crop.png"), 5, 6, 2);
        for (int i = 0; i < crops.T3Aspects.size(); i++) {
            research.addPage(new ResearchPage(infusionRecipes.InfusionRecipes.get(crops.T3Aspects.get(i))));
        }

        research = new ElecResearch("T4SEED", StringToAspectList("messis 50, cognitio 50, sensus 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/messis.crop.png"), 5, 7, 2);
        for (int i = 0; i < crops.T4Aspects.size(); i++) {
            research.addPage(new ResearchPage(infusionRecipes.InfusionRecipes.get(crops.T4Aspects.get(i))));
        }

        research = new ElecResearch("T5SEED", StringToAspectList("messis 50, humanus 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/messis.crop.png"), 5, 8, 3);
        for (int i = 0; i < crops.T5Aspects.size(); i++) {
            research.addPage(new ResearchPage(infusionRecipes.InfusionRecipes.get(crops.T5Aspects.get(i))));
        }

        research = new ElecResearch("T6SEED", StringToAspectList("messis 50, instrumentum 50, lucrum 50, messis 50, perfodio 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/messis.crop.png"), 5, 9, 3);
        for (int i = 0; i < crops.T6Aspects.size(); i++) {
            research.addPage(new ResearchPage(infusionRecipes.InfusionRecipes.get(crops.T6Aspects.get(i))));
        }

        research = new ElecResearch("T7SEED", StringToAspectList("messis 50, fabrico 50, machina 50, meto 50, pannus 50, telum 50, tutamen 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/messis.crop.png"), 5, 10, 3);
        for (int i = 0; i < crops.T7Aspects.size(); i++) {
            research.addPage(new ResearchPage(infusionRecipes.InfusionRecipes.get(crops.T7Aspects.get(i))));
        }

        research = new ElecResearch("CROPRESOURCES", StringToAspectList("messis 50, fabrico 50, machina 50, meto 50, pannus 50, telum 50, tutamen 50"), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/messis.crop.png"), 4, -1, 3);
        research.addPage(new ResearchPage(recipes.PageRecipes()));
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