package elec332.thaumiccrops.thaumcraft;

import elec332.core.helper.stringHelper;
import elec332.thaumiccrops.main.crops;
import elec332.thaumiccrops.thaumcraft.recipes.arcaneRecipes;
import elec332.thaumiccrops.thaumcraft.recipes.crucibleRecipes;
import elec332.thaumiccrops.thaumcraft.recipes.infusionRecipes;
import elec332.thaumiccrops.thaumcraft.research.pages;
import elec332.thaumiccrops.thaumcraft.research.tab;
import thaumcraft.api.aspects.Aspect;

import java.util.ArrayList;

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
