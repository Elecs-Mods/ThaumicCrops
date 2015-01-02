package elec332.thaumiccrops.thaumcraft.research;

import elec332.thaumiccrops.thaumcraft.lib.lib;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.research.ResearchCategories;

/**
 * Created by Elec332 on 1-1-2015.
 */
public class tab {
    public static void createTCTab(){
        ResearchCategories.registerCategory(lib.TCTAB, new ResourceLocation("minecraft", "textures/items/seeds_wheat.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
    }
}
