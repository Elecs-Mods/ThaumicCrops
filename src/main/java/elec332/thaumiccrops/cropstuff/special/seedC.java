package elec332.thaumiccrops.cropstuff.special;

import elec332.core.baseclasses.item.BaseSeed;
import net.minecraft.item.Item;

import java.util.ArrayList;

/**
 * Created by Elec332 on 6-1-2015.
 */
public class seedC extends BaseSeed {
    public seedC(String name, String modID, ArrayList<Item> crops){
        super(name, modID, null, new blockC(name, modID, crops));
    }
    public seedC(String name, String modID, Item crop){
        super(name, modID, null, new blockC(name, modID, crop));
    }
    public seedC(String name, String modID){
        super(name, modID, null, new MonsterSeed(name, modID));
    }
}