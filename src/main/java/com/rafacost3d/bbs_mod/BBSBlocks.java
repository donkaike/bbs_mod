package com.rafacost3d.bbs_mod;


import com.rafacost3d.bbs_mod.blocks.BasicBlock;
import com.rafacost3d.bbs_mod.blocks.HopCropBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    private static BasicBlock basicBlock;
    public static HopCropBlock hopcropBlock;

    public static void init(){

        basicBlock = new BasicBlock();
        hopcropBlock = new HopCropBlock();

    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        basicBlock.initModel();
        hopcropBlock.initModel();
    }
}