package elec332.thaumiccrops.init;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.core.util.blocks.baseCrop;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Elec332 on 29-12-2014.
 */
public class cropBlock extends baseCrop {
    public cropBlock(String blockname, String modid){
        super(blockname, modid);
        this.Type = 1;
    }

    int Type;

    @SideOnly(Side.CLIENT)
    private IIcon[] icon;

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister IIconRegister)
    {
        this.icon = new IIcon[8];

        for (int i = 0; i < this.icon.length - 1; ++i)
        {
            this.icon[i] = IIconRegister.registerIcon("AspectCrop" + "_stage_" + i);
        }
        this.icon[7] = IIconRegister.registerIcon(this.getTextureName() + "_stage_" + 7);
    }
}
