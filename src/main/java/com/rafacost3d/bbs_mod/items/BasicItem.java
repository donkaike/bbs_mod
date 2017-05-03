package com.rafacost3d.bbs_mod.items;

import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BasicItem extends Item {

    public BasicItem() {
        super();

        setRegistryName("basicitem");
        setUnlocalizedName(BBSMod.MODID + ".basicitem");
        setCreativeTab(CreativeTabs.MATERIALS);
        GameRegistry.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
