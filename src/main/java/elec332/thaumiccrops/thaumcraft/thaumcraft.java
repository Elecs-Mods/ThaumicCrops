package elec332.thaumiccrops.thaumcraft;

import elec332.thaumiccrops.thaumcraft.recipes.*;
import elec332.thaumiccrops.thaumcraft.research.*;

/**
 * Created by Elec332 on 1-1-2015.
 */
public class thaumcraft {

    public static void init(){
        crucibleRecipes.init();
        arcaneRecipes.init();
        infusionRecipes.init();
        tab.createTCTab();
        pages.init();
    }
}
