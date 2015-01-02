package elec332.thaumiccrops.thaumcraft.research;

import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.ResearchHelper;
import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
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
        ResearchHelper research;
        CrucibleRecipe crucible;

       pages = new ResearchPage[]{new ResearchPage("thaumiccrops.research.primseed")};
        new ResearchHelper(lib.PRIMALSEEDS, new AspectList().add(Aspect.aspects.get("praecantatio"), 50), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/aignis.seed.png"), 0, 0, 2, pages);
//GameRegistry.findItemStack(crops.ModID, "aaerseed", 1)

        crucible = ThaumcraftApi.addCrucibleRecipe(lib.AGENT, new ItemStack(Items.apple), new ItemStack(Items.wheat_seeds), (new AspectList()).merge(Aspect.AIR, 3));
        //research.setPages(new ResearchPage(crucible));
        pages = new ResearchPage[]{new ResearchPage("thaumiccrops.research.agent"), new ResearchPage(crucible)};
        research = new ResearchHelper(lib.AGENT, new AspectList().add(Aspect.aspects.get("praecantatio"), 50).add(Aspect.getAspect("ordo"), 68), new ResourceLocation(crops.ModID.toLowerCase(), "textures/items/aordo.crop.png"), 2, 3, 2, pages);

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