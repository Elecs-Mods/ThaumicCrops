package elec332.thaumiccrops.cropstuff;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.core.util.blocks.baseCrop;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Elec332 on 29-12-2014.
 */
public class cropBlock extends baseCrop {
    public cropBlock(String blockname, String modid){
        super(blockname, modid);
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] icon;

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 0 || meta > 7)
        {
            meta = 7;
        }

        return this.icon[meta];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister IIconRegister)
    {
        this.icon = new IIcon[8];

        for (int i = 0; i < this.icon.length - 1; ++i)
        {
            this.icon[i] = IIconRegister.registerIcon("thaumiccrops:AspectCrop" + "_stage_" + i);
        }
        this.icon[7] = IIconRegister.registerIcon(this.getTextureName() + "_stage_" + 7);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        if(metadata != 7) ret.add(new ItemStack(func_149866_i()));

        if (metadata >= 7)
        {
            for (int i = 0; i < 1 + fortune; ++i)
            {
                if (world.rand.nextInt(9) <= metadata)
                {
                    ret.add(new ItemStack(this.func_149866_i(), 1));
                }
                if (world.rand.nextInt(18) <= metadata)
                {
                    ret.add(new ItemStack(this.func_149866_i(), 1));
                }
                if (world.rand.nextInt(9) <= metadata)
                {
                    ret.add(new ItemStack(func_149865_P()));
                }
            }
        }

        return ret;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int p_149650_3_)
    {
        //if (metadata != 7){
        //    return func_149866_i();
        //}
        return null;
    }

    @Override
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return elec332.thaumiccrops.main.crops.developmentEnvironment && super.func_149851_a(p_149851_1_, p_149851_2_, p_149851_3_, p_149851_4_, p_149851_5_);
    }
}
