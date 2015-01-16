package elec332.thaumiccrops.thaumcraft;

import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
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

    @SuppressWarnings("ManualArrayCopy")
    public ResearchItem addPage(ResearchPage researchPage){
        ResearchPage[] standardPages = this.getPages();
        ResearchPage[] Pages = new ResearchPage[standardPages.length + 1];
        for (int i = 0; i < standardPages.length; i++) {
            Pages[i] = standardPages[i];
        }
        Pages[standardPages.length] = researchPage;
        this.setPages(Pages);
        return this;
    }
}
