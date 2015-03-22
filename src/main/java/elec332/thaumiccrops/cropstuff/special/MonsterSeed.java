package elec332.thaumiccrops.cropstuff.special;

import elec332.thaumiccrops.main.ThaumicCrops;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Elec332 on 2-2-2015.
 */
public class MonsterSeed extends blockC{

    public MonsterSeed(String blockname, String modid) {
        super(blockname, modid);
    }

    boolean monster = true;

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
                if(monster){
                    if (random.nextInt(10) == 1)
                        ret.add(new ItemStack(ThaumicCrops.getItemFromName("witherShard")));
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
                }
            }
        }
        return ret;
    }
}
