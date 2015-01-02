package elec332.thaumiccrops.thaumcraft;

import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

/**
 * Created by Elec332 on 1-1-2015.
 */
public class ResearchHelper extends ResearchItem {
    public ResearchHelper(String name, AspectList aspectlist, ResourceLocation icon, int col, int row, int complex, ResearchPage[] pages){
        super(name, lib.TCTAB, aspectlist, col, row, complex, icon);
        this.setPages(pages);


        this.registerResearchItem();
    }
}
