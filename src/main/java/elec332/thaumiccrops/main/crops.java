package elec332.thaumiccrops.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.*;
import elec332.core.modBaseUtils.ModBase;
import elec332.core.modBaseUtils.modInfo;
import elec332.core.proxies.CommonProxy;
import elec332.core.util.items.baseItem;
import elec332.thaumiccrops.cropstuff.seedItem;
import elec332.thaumiccrops.cropstuff.special.seedC;
import elec332.thaumiccrops.helpers;
import elec332.thaumiccrops.thaumcraft.TChelper;
import elec332.thaumiccrops.thaumcraft.thaumcraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.aspects.Aspect;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Elec332 on 29-12-2014.
 */
@Mod(modid = "Thaumiccrops", name = "Thaumic Crops", dependencies = modInfo.DEPENDENCIES + ";required-after:Thaumcraft", acceptedMinecraftVersions = modInfo.ACCEPTEDMCVERSIONS, useMetadata = true, canBeDeactivated = true)
public class crops extends ModBase{

    public static String ModID;
    public static File cfgFile;

    protected static String[] miscItemShardsString = {"air", "fire", "water", "earth", "order", "entropy", "diamond", "lapis", "amber", "iron", "gold", "coal", "redstone", "glowstone"};
    public static ArrayList<String> RecourceSeeds = new ArrayList<String>();
    public static ArrayList<String> T1Aspects = new ArrayList<String>();
    public static ArrayList<String> T2Aspects = new ArrayList<String>();
    public static ArrayList<String> T3Aspects = new ArrayList<String>();
    public static ArrayList<String> T4Aspects = new ArrayList<String>();
    public static ArrayList<String> T5Aspects = new ArrayList<String>();
    public static ArrayList<String> T6Aspects = new ArrayList<String>();
    public static ArrayList<String> T7Aspects = new ArrayList<String>();

    @SuppressWarnings("unchecked")
    public static ArrayList<String> primAspects = TChelper.getAspectTag(Aspect.getPrimalAspects());

    @SuppressWarnings("unchecked")
    public static ArrayList<String> compoundAspects = TChelper.getAspectTag(Aspect.getCompoundAspects());

    @SuppressWarnings("unchecked")
    public static ArrayList<String> cropList = arrayHelper.mergeArrays(primAspects, compoundAspects);

    @SidedProxy(clientSide = modInfo.CLIENTPROXY, serverSide = modInfo.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance("Thaumiccrops")
    public static crops instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.cfgFile = FileHelper.getConfigFileElec(event);
        this.ModID = modInfoHelper.getModID(event);
        createTCArrayLists();
        for (String cropName : cropList) {
            new seedItem(cropName, ModID, new baseItem(cropName + "crop", CTab.ElecTab, ModID).setTextureName(ModID + ":" + cropName + ".crop")).setCreativeTab(CTab.ElecTab);
        }
        for (int i = 1; i < 8; i++) {
            new baseItem("agent" + i, CTab.ElecTab, event);
        }
        ArrayList<Item> shards= new ArrayList<Item>();
        for (String cropName : miscItemShardsString) {
            if(helpers.isTCShard(cropName)) {
                String fullname = cropName + "Shard";
                new baseItem(fullname, CTab.ElecTab, event);
                shards.add(getItemFromName(fullname));
            }
            if(!helpers.isTCShard(cropName)) {
                ArrayList<Item> item = new ArrayList<Item>();
                item.add(new baseItem(cropName + "Shard", CTab.ElecTab, event));
                new seedC(cropName, ModID, item).setCreativeTab(CTab.ElecTab);
                RecourceSeeds.add(cropName);
            }
        }
        new seedC("shard", ModID, shards).setCreativeTab(CTab.ElecTab);
        RecourceSeeds.add("shard");
        new seedC("treasure", ModID, new baseItem("treasureCore", CTab.ElecTab, event)).setCreativeTab(CTab.ElecTab);
        new baseItem("teleportCore", CTab.ElecTab, event);
        for (int i = 1; i < 4; i++) {
            new baseItem("interdimtreasure"+i, CTab.ElecTab, event);
        }
        new baseItem("soulCore", CTab.ElecTab, event);
        new seedC("monster", ModID).setCreativeTab(CTab.ElecTab);
        new baseItem("witherShard", CTab.ElecTab, event);
        loadConfiguration();


        MCModInfo.CreateMCModInfoElec(event, "Crops!",
                "-", "assets/elec332/logo.png", new String[]{"Elec332"});
        notifyEvent(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        loadConfiguration();
        notifyEvent(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        OreDictionary.registerOre("blockAmber", GameRegistry.findBlock("Thaumcraft", "blockCosmeticOpaque"));
        OreDictionary.registerOre("blockShard", new ItemStack(GameRegistry.findBlock("Thaumcraft", "blockCrystal"), 1, 6));
        OreDictionary.registerOre("coal", net.minecraft.init.Items.coal);
        thaumcraft.init();
        notifyEvent(event);
    }

    void createTCArrayLists() {
        for (int i = 0; i < 10; i++) {
            this.T1Aspects.add(compoundAspects.get(i));
        }
        this.T2Aspects = stringHelper.convertStringArrayToArraylist(new String[]{"bestia", "fames", "herba", "iter", "limus", "metallum", "mortuus", "praecantatio", "sano", "tenebrae", "vinculum", "volatus"});
        this.T3Aspects = stringHelper.convertStringArrayToArraylist(new String[]{"alienis", "arbor", "auram", "corpus", "exanimis", "spiritus", "vitium"});
        this.T4Aspects = stringHelper.convertStringArrayToArraylist(new String[]{"cognitio", "sensus"});
        this.T5Aspects.add("humanus");
        this.T6Aspects = stringHelper.convertStringArrayToArraylist(new String[]{"instrumentum", "lucrum", "messis", "perfodio"});
        this.T7Aspects = stringHelper.convertStringArrayToArraylist(new String[]{"fabrico", "machina", "meto", "pannus", "telum", "tutamen"});
    }

    public static Item getItemFromName(String name){
        return GameRegistry.findItem(ModID, name);
    }

    @Override
    public File configFile() {
        return cfgFile;
    }

    @Override
    public String modID(){
        return ModID;
    }
}
