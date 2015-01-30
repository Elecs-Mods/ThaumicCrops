package elec332.thaumiccrops.cropstuff.special;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.core.util.blocks.baseCrop;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Elec332 on 6-1-2015.
 */
public class blockC extends baseCrop {
    public blockC(String blockname, String modid) {
        super(blockname, modid);
    }

    public blockC crop(ArrayList<Item> crop) {
        this.crops = crop;
        return this;
    }

    public blockC crop(Item crop) {
        this.crops = new ArrayList<Item>();
        crops.add(crop);
        return this;
    }

    public blockC setMonsterSeed(){
        this.monster = true;
        return this;
    }

    ArrayList<Item> crops;
    boolean monster;

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
        Random random = world.rand;
        if (metadata != 7) ret.add(new ItemStack(func_149866_i()));

        if (metadata >= 7) {
            for (int i = 0; i < 1 + fortune; ++i) {
                if (random.nextInt(9) <= metadata) {
                    ret.add(new ItemStack(this.func_149866_i(), 1));
                }
                if (random.nextInt(18) <= metadata) {
                    ret.add(new ItemStack(this.func_149866_i(), 1));
                }
                if(crops.size() == 1) {
                    ret.add(new ItemStack(crops.get(0)));
                }else if(monster){
                    if (random.nextInt(10) == 1)
                        ret.add(new ItemStack(elec332.thaumiccrops.main.crops.getItemFromName("witherShard")));
                    if (random.nextInt(10) == 1)
                        ret.add(new ItemStack(Items.experience_bottle));
                    if (random.nextInt(4) == 1)
                        ret.add(new ItemStack(Items.blaze_rod));
                    if (random.nextInt(4) == 1)
                        ret.add(new ItemStack(Items.ghast_tear));
                    if (random.nextInt(4) == 1)
                        ret.add(new ItemStack(Items.slime_ball));
                    if (random.nextInt(4) == 1)
                        ret.add(new ItemStack(Items.arrow));
                    if (random.nextInt(4) == 1)
                        ret.add(new ItemStack(Items.ender_pearl));
                    if (random.nextInt(2) == 1)
                        ret.add(new ItemStack(Items.bone));
                    if (random.nextInt(2) == 1)
                        ret.add(new ItemStack(Items.spider_eye));
                    if (random.nextInt(2) == 1)
                        ret.add(new ItemStack(Items.string));
                    if (random.nextInt(2) == 1)
                        ret.add(new ItemStack(Items.gunpowder));
                    if (random.nextInt(10) <= 7)
                        ret.add(new ItemStack(Items.rotten_flesh));
                } else {
                    int boolnr = random.nextInt((crops.size()+crops.size()/2));
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
        return false;
    }
}