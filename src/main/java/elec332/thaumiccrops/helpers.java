package elec332.thaumiccrops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

/**
 * Created by Elec332 on 5-1-2015.
 */
public class helpers {

    public static String isTCShard(String string, String True, String False){
        if(isTCShard(string))
            return True;
        return False;
    }

    public static Boolean isTCShard(String string){
        return(string.equalsIgnoreCase("air") || string.equalsIgnoreCase("fire") || string.equalsIgnoreCase("water") || string.equalsIgnoreCase("earth") || string.equalsIgnoreCase("order") || string.equalsIgnoreCase("entropy"));
    }

    public static void addAspectsSeed(Item item, AspectList aspectList){
        ThaumcraftApi.registerObjectTag(new ItemStack(item), (new AspectList()).add(Aspect.PLANT, 1).add(aspectList));
    }

    public static String uppercaseFirstLetter(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String getOreDictNameItem(String item){
        if (item.equalsIgnoreCase("coal"))
            return item;
        return typeOre(item) + helpers.uppercaseFirstLetter(item);
    }

    public static String getOreDictNameBlock(String item){
        if (item.equalsIgnoreCase("glowstone"))
            return item;
        return "block" + helpers.uppercaseFirstLetter(item);
    }

    public static String typeOre(String string){
        if (string.equalsIgnoreCase("iron") || string.equalsIgnoreCase("gold"))
            return "ingot";
        if (string.equalsIgnoreCase("redstone") || string.equalsIgnoreCase("glowstone"))
            return "dust";
        if (string.equalsIgnoreCase("coal"))
            return "";
        if (isTCShard(string))
            return "shard";
        return "gem";
    }
}
