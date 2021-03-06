package elec332.thaumiccrops.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import elec332.core.helper.FileHelper;
import elec332.core.helper.MCModInfo;
import elec332.core.helper.ModInfoHelper;
import elec332.core.modBaseUtils.ModBase;
import elec332.core.modBaseUtils.ModInfo;
import elec332.core.proxies.CommonProxy;
import elec332.thaumiccrops.init.Data;
import elec332.thaumiccrops.init.Seeds;
import elec332.thaumiccrops.thaumcraft.thaumcraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.io.File;

/**
 * Created by Elec332 on 29-12-2014.
 */
@Mod(modid = "ThaumicCrops", name = "Thaumic Crops", dependencies = ModInfo.DEPENDENCIES + ";required-after:Thaumcraft", acceptedMinecraftVersions = ModInfo.ACCEPTEDMCVERSIONS, useMetadata = true, canBeDeactivated = true)
public class ThaumicCrops extends ModBase{

    public static String ModID;
    public static File cfgFile;

    @SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance("ThaumicCrops")
    public static ThaumicCrops instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        cfgFile = FileHelper.getConfigFileElec(event);
        ModID = ModInfoHelper.getModID(event);
        Data.INSTANCE.createTCArrayLists();
        loadConfiguration();
        Seeds.init(event);



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
