package elec332.thaumiccrops.cropstuff.special;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.core.baseclasses.block.BaseCrop;
import elec332.thaumiccrops.main.ThaumicCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Elec332 on 6-1-2015.
 */
public class blockC extends BaseCrop {
    public blockC(String blockname, String modid) {
        super(blockname, modid);
    }

    public blockC(String blockname, String modid, ArrayList<Item> crop) {
        super(blockname, modid);
        this.crops = crop;
    }

    public blockC(String blockname, String modid, Item crop) {
        super(blockname, modid);
        this.crops = new ArrayList<Item>();
        crops.add(crop);
    }

    ArrayList<Item> crops;

    @SideOnly(Side.CLIENT)
    private IIcon[] icon;

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 7) {
            meta = 7;
        }

        return this.icon[meta];
    }

    public int getRenderType()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister IIconRegister) {
        this.icon = new IIcon[8];

        for (int i = 0; i < this.icon.length - 1; ++i) {
            this.icon[i] = IIconRegister.registerIcon("thaumiccrops:ResourceCrop" + "_stage_" + i);
        }
        this.icon[7] = IIconRegister.registerIcon(this.getTextureName() + "_stage_" + 7);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        if (metadata != 7) ret.add(new ItemStack(func_149866_i()));

        if (metadata >= 7) {
            for (int i = 0; i < 1 + fortune; ++i) {
                if (world.rand.nextInt(9) <= metadata) {
                    ret.add(new ItemStack(this.func_149866_i(), 1));
                }
                if (world.rand.nextInt(18) <= metadata) {
                    ret.add(new ItemStack(this.func_149866_i(), 1));
                }
                if(crops.size() == 1) {
                    ret.add(new ItemStack(crops.get(0)));
                }else{
                    int boolnr = world.rand.nextInt((crops.size()+crops.size()/2));
                    if(boolnr <= (crops.size()-1))
                        ret.add(new ItemStack(crops.get(boolnr)));
                }
            }
        }
        return ret;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int p_149650_3_) {
        return null;
    }

    @Override
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
        return ThaumicCrops.developmentEnvironment && super.func_149851_a(p_149851_1_, p_149851_2_, p_149851_3_, p_149851_4_, p_149851_5_);
    }
}