package elec332.thaumiccrops.cropstuff.special;

import elec332.core.util.items.baseSeed;
import net.minecraft.item.Item;

import java.util.ArrayList;

/**
 * Created by Elec332 on 6-1-2015.
 */
public class seedC extends baseSeed {
    public seedC(String name, String modID, ArrayList<Item> crops){
        super(name, modID, null, new blockC(name, modID).crop(crops));
    }
}