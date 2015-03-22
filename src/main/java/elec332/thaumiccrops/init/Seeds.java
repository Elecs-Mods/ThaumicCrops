package elec332.thaumiccrops.init;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import elec332.core.util.items.baseItem;
import elec332.thaumiccrops.cropstuff.seedItem;
import elec332.thaumiccrops.cropstuff.special.seedC;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.main.CTab;
import elec332.thaumiccrops.main.ThaumicCrops;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import thaumcraft.common.config.ConfigItems;

import java.util.ArrayList;

/**
 * Created by Elec332 on 14-2-2015.
 */
public class Seeds extends Data{

    public static void init(FMLPreInitializationEvent event){
        for (String cropName : cropList) {
            new seedItem(cropName, ThaumicCrops.ModID, new baseItem(cropName + "crop", CTab.ElecTab, ThaumicCrops.ModID).setTextureName(ThaumicCrops.ModID + ":" + cropName + ".crop")).setCreativeTab(CTab.ElecTab);
        }
        for (int i = 1; i < 8; i++) {
            new baseItem("agent" + i, CTab.ElecTab, event);
        }
        ArrayList<Item> shards= new ArrayList<Item>();
        for (String cropName : miscItemShardsString) {
            if(helpers.isTCShard(cropName)) {
                String fullname = cropName + "Shard";
                new baseItem(fullname, CTab.ElecTab, event);
                shards.add(ThaumicCrops.getItemFromName(fullname));
            }
            if(!helpers.isTCShard(cropName)) {
                ArrayList<Item> item = new ArrayList<Item>();
                if (cropName.equalsIgnoreCase("iron"))
                    item.add(ConfigItems.itemNugget);
                else if (cropName.equalsIgnoreCase("gold"))
                    item.add(Items.gold_nugget);
                else
                    item.add(new baseItem(cropName + "Shard", CTab.ElecTab, event));
                //Item item = new baseItem(cropName + "Shard", CTab.ElecTab, event);
                new seedC(cropName, ThaumicCrops.ModID, item).setCreativeTab(CTab.ElecTab);
                RecourceSeeds.add(cropName);
            }
        }
        new seedC("shard", ThaumicCrops.ModID, shards).setCreativeTab(CTab.ElecTab);
        RecourceSeeds.add("shard");
        new seedC("treasure", ThaumicCrops.ModID, new baseItem("treasureCore", CTab.ElecTab, event)).setCreativeTab(CTab.ElecTab);
        new baseItem("teleportCore", CTab.ElecTab, event);
        for (int i = 1; i < 4; i++) {
            new baseItem("interdimtreasure"+i, CTab.ElecTab, event);
        }
        new baseItem("soulCore", CTab.ElecTab, event);
        new seedC("monster", ThaumicCrops.ModID).setCreativeTab(CTab.ElecTab);
        new baseItem("witherShard", CTab.ElecTab, event);
    }
}
