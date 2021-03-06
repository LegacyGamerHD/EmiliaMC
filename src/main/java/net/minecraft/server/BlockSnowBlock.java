package net.minecraft.server;

import java.util.Random;

public class BlockSnowBlock extends Block {

    protected BlockSnowBlock(Block.Info block_info) {
        super(block_info);
    }

    public IMaterial getDropType(IBlockData iblockdata, World world, BlockPosition blockposition, int i) {
        return Items.SNOWBALL;
    }

    public int a(IBlockData iblockdata, Random random) {
        return 4;
    }

    // Paper start - snow blocks don't need to tick
    /*
    public void a(IBlockData iblockdata, World world, BlockPosition blockposition, Random random) {
        if (world.getBrightness(EnumSkyBlock.BLOCK, blockposition) > 11) {
            // CraftBukkit start
            if (org.bukkit.craftbukkit.event.CraftEventFactory.callBlockFadeEvent(world, blockposition, Blocks.AIR.getBlockData()).isCancelled()) {
                return;
            }
            // CraftBukkit end
            iblockdata.a(world, blockposition, 0);
            world.setAir(blockposition);
        }

    }
    */
    //Paper end
}
