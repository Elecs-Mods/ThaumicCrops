package elec332.thaumiccrops.thaumcraft;

import elec332.thaumiccrops.init.recipes.crucibleRecipes;
import elec332.thaumiccrops.thaumcraft.research.pages;
import elec332.thaumiccrops.thaumcraft.research.tab;

/**
 * Created by Elec332 on 1-1-2015.
 */
public class thaumcraft {
    public static void init(){
        crucibleRecipes.init();

        tab.createTCTab();
        pages.init();
    }
}
