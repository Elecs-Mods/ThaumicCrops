package elec332.thaumiccrops.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import elec332.core.helper.FileHelper;
import elec332.core.helper.MCModInfo;
import elec332.core.helper.modInfoHelper;
import elec332.core.helper.stringHelper;
import elec332.core.main.ElecCTab;
import elec332.core.modBaseUtils.ModBase;
import elec332.core.modBaseUtils.modInfo;
import elec332.core.proxies.CommonProxy;
import elec332.core.util.items.baseItem;
import elec332.core.util.items.baseSeed;
import elec332.thaumiccrops.cropstuff.seedItem;
import elec332.thaumiccrops.thaumcraft.TChelper;
import elec332.thaumiccrops.thaumcraft.thaumcraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.util.ArrayList;

/**
 * Created by Elec332 on 29-12-2014.
 */
@Mod(modid = "Thaumiccrops", name = "Thaumic Crops", dependencies = modInfo.DEPENDENCIES, acceptedMinecraftVersions = modInfo.ACCEPTEDMCVERSIONS, useMetadata = true, canBeDeactivated = true)
public class crops extends ModBase{

    public static Configuration config;
    public static String ModID;

    //static String[] crops = Aspect.a  //{"aaer", "aaqua", "aignis", "aordo"};
    public static ArrayList primAspects = TChelper.getAspectTag(Aspect.getPrimalAspects());
    public static ArrayList cropList = primAspects;

    @SidedProxy(clientSide = modInfo.CLIENTPROXY, serverSide = modInfo.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance("Thaumiccrops")
    public static crops instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.ModID = modInfoHelper.getModID(event);
        this.config = new Configuration(FileHelper.getConfigFileElec(event));

        for (int i = 0; i < cropList.size(); i++) {
            String cropName = (String) cropList.get(i);
            String modName = ModID;

            //blocks block = new blocks();
            //Item Item = new baseSeed("aaer", modName, block);
           // block.seed(Item);
            //new baseItem()
            Item item = new seedItem(cropName, modName, new baseItem(cropName + "crop", ElecCTab.ElecTab, modName).setTextureName(modName + ":" + cropName + ".crop"));

            //registerHelper.registerItem(Item, "aaer");
            //registerHelper.registerBlock(block, "aaerCrop");
            //GameRegistry.addRecipe(new ItemStack(items.aaerSeed, 9), new Object[]{
            //        "GGG", "GGG", "GGG", 'G', Blocks.dirt
            //});



        }

        //t = new baseCrop("aaer", ropItem, ETestMod.cropItem, "crops");
        //Item q = new test("aaer", "crops");

        MCModInfo.CreateMCModInfoElec(event, "Crops!",
                "-", "assets/elec332/logo.png", new String[]{"Elec332"});
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        loadConfiguration(config);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        thaumcraft.init();
        localize();
    }

    //mods.thaumcraft.Infusion.addRecipe("T1SEEDS", <minecraft:wheat_seeds>, [ignisCrop, ignisCrop, ignisCrop, ignisCrop, perditioCrop, perditioCrop, perditioCrop, perditioCrop, agent1, agent1], "herba 15, messis 15, ordo 20, praecantatio 20", gelumSeed, 3);
    public static void localize(){
        I18n.format("en_US", "tc.research_category.THAUMCROPS", "Thaumic Crops");
    }

}
