package com.rafacost3d.bbs_mod.blocks;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.compat.top.TOPInfoProvider;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DataBlock extends Block implements ITileEntityProvider, TOPInfoProvider {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public DataBlock() {
        super(Material.ROCK);
        setUnlocalizedName(BBSMod.MODID + ".datablock");
        setRegistryName("datablock");
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
        GameRegistry.registerTileEntity(DataTileEntity.class, BBSMod.MODID + "_datablock");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new DataTileEntity();
    }

    private DataTileEntity getTE(World world, BlockPos pos) {
        return (DataTileEntity) world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote) {
            // We only count on the server side.

            if (side == state.getValue(FACING)) {
                int counter;
                if (hitY < .5f) {
                    counter = getTE(world, pos).decrement();
                } else {
                    counter = getTE(world, pos).increment();
                }
                player.sendMessage(new TextComponentString(TextFormatting.GREEN + "Counter: " + counter));
            }
        }
        return true;
    }


    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        // Since we only allow horizontal rotation we need only 2 bits for facing. North, South, West, East start at index 2 so we have to add 2 here.
        return getDefaultState().withProperty(FACING, EnumFacing.getFront((meta & 3) + 2));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        // Since we only allow horizontal rotation we need only 2 bits for facing. North, South, West, East start at index 2 so we have to subtract 2 here.
        return state.getValue(FACING).getIndex()-2;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }


    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data){
        TileEntity te = world.getTileEntity(data.getPos());
        if (te instanceof DataTileEntity) {
            // If we are sure that the entity there is correct we can proceed:
            DataTileEntity dataTileEntity = (DataTileEntity) te;
            // First add a horizontal line showing the clock item followed by current contents of the counter in the tile entity
            probeInfo.horizontal()
                    .item(new ItemStack(Items.CLOCK))
                    .text(TextFormatting.GREEN + "Counter: " + dataTileEntity.getCounter());
            // Then add another line with a border. Inside the border there will be a horse and the counter shown as a progress bar
            probeInfo.horizontal(probeInfo.defaultLayoutStyle().borderColor(0xffff0000))
                    .progress(dataTileEntity.getCounter() % 100, 100, probeInfo.defaultProgressStyle().suffix("%"));
        }
    }
}