package elec332.thaumiccrops.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.*;
import elec332.core.main.ElecCTab;
import elec332.core.modBaseUtils.ModBase;
import elec332.core.modBaseUtils.modInfo;
import elec332.core.proxies.CommonProxy;
import elec332.core.util.items.baseItem;
import elec332.thaumiccrops.cropstuff.seedItem;
import elec332.thaumiccrops.init.recipes;
import elec332.thaumiccrops.thaumcraft.TChelper;
import elec332.thaumiccrops.thaumcraft.thaumcraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.config.ConfigItems;

import java.util.ArrayList;

/**
 * Created by Elec332 on 29-12-2014.
 */
@Mod(modid = "Thaumiccrops", name = "Thaumic Crops", dependencies = modInfo.DEPENDENCIES + ";required-after:Thaumcraft", acceptedMinecraftVersions = modInfo.ACCEPTEDMCVERSIONS, useMetadata = true, canBeDeactivated = true)
public class crops extends ModBase{


    public static Configuration config;
    public static String ModID;
    static String[] miscItemShardsString = {"diamond", "lapis", "amber"};
    public static ArrayList<String> miscItemShards = stringHelper.convertStringArrayToArraylist(miscItemShardsString);
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
    public static ArrayList<String> cropList = stringHelper.mergeArrays(primAspects, compoundAspects);

    @SuppressWarnings("unchecked")
    static ArrayList<String> miscItemShardsAll = stringHelper.mergeArrays(miscItemShards, primAspects);
    public static int miscItemShardNumber = miscItemShardsAll.size();


    @SidedProxy(clientSide = modInfo.CLIENTPROXY, serverSide = modInfo.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance("Thaumiccrops")
    public static crops instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.ModID = modInfoHelper.getModID(event);
        this.config = new Configuration(FileHelper.getConfigFileElec(event));
        createTCArrayLists();
        for (int i = 0; i < cropList.size(); i++) {
            String cropName = cropList.get(i);
            String modName = ModID;
            new seedItem(cropName, modName, new baseItem(cropName + "crop", ElecCTab.ElecTab, modName).setTextureName(modName + ":" + cropName + ".crop"));
        }
        for (int i = 1; i < 8; i++) {
            new baseItem("agent" + i, null, event);
        }
        for (int i = 0; i < miscItemShardsAll.size(); i++) {
            new baseItem(miscItemShardsAll.get(i) + "Shard", null, event);
        }

        MCModInfo.CreateMCModInfoElec(event, "Crops!",
                "-", "assets/elec332/logo.png", new String[]{"Elec332"});
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(event.getModState());
        loadConfiguration(config);
        //recipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println(event.getModState());
        //recipes.init();
        thaumcraft.init();
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
}
