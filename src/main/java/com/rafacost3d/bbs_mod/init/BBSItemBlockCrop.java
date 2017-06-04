package com.rafacost3d.bbs_mod.init;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class BBSItemBlockCrop extends ItemBlock {

    public BBSItemBlockCrop(Block block) {
        super(block);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return (I18n.format("bbs_mod." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }
}