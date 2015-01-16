package elec332.thaumiccrops.main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Elec332 on 6-1-2015.
 */
public class CTab {
    public static CreativeTabs ElecTab = new CreativeTabs(crops.ModID) {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return crops.getItemFromName("aerseed");
        }
    };
}
