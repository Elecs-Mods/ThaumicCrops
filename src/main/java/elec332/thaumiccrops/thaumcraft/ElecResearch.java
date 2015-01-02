package elec332.thaumiccrops.thaumcraft;

import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

/**
 * Created by Elec332 on 1-1-2015.
 */
public class ElecResearch extends ResearchItem {
    public ElecResearch(String name, AspectList aspectlist, ResourceLocation icon, int col, int row, int complex){
        super(name, lib.TCTAB, aspectlist, col, row, complex, icon);
        this.setPages(new ResearchPage("thaumiccrops.research." + name.toLowerCase()));


        this.registerResearchItem();
    }

public ResearchItem addPage(ResearchPage researchPage){
    ResearchPage[] standardpages = this.getPages();
    ResearchPage[] Pages = new ResearchPage[standardpages.length + 1];
    for (int i = 0; i < standardpages.length; i++) {
        Pages[i] = standardpages[i];
    }
    Pages[standardpages.length] = researchPage;
    this.setPages(Pages);
    return this;
}




}
