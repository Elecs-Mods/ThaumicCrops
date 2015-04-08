package elec332.thaumiccrops.cropstuff;

import elec332.core.baseclasses.item.BaseSeed;
import net.minecraft.item.Item;

/**
 * Created by Elec332 on 2-1-2015.
 */
public class seedItem extends BaseSeed {
    public seedItem(String name, String modID, Item cropItem){
        super(name, modID, cropItem, new cropBlock(name, modID));
    }
}
