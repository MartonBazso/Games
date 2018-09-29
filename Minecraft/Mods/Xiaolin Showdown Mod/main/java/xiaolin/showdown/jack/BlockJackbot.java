package xiaolin.showdown.jack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import xiaolin.showdown.items.ModItems;

public class BlockJackbot extends Block{
	
	private BlockPattern golemBasePattern;
    private BlockPattern golemPattern;
    
	public BlockJackbot(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("jackbottop");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3f);
        this.setResistance(4f);
	}
	
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        this.trySpawnJackbot(worldIn, pos);
    }
	
	
	private void trySpawnJackbot(World worldIn, BlockPos pos)
    {
        BlockPattern.PatternHelper patternhelper;
        int i;
        int j;

        if ((patternhelper = this.getGolemPattern().match(worldIn, pos)) != null)
        {
            for (i = 0; i < this.getGolemPattern().getPalmLength(); ++i)
            {
                for (int k = 0; k < this.getGolemPattern().getThumbLength(); ++k)
                {
                    worldIn.setBlockState(patternhelper.translateOffset(i, k, 0).getPos(), Blocks.air.getDefaultState(), 2);
                }
            }

            BlockPos blockpos1 = patternhelper.translateOffset(1, 2, 0).getPos();
            EntityJackbot entityjackbot = new EntityJackbot(worldIn);
            
            entityjackbot.setLocationAndAngles((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.05D, (double)blockpos1.getZ() + 0.5D, 0.0F, 0.0F);
            worldIn.spawnEntityInWorld(entityjackbot);

            

            for (j = 0; j < this.getGolemPattern().getPalmLength(); ++j)
            {
                for (int l = 0; l < this.getGolemPattern().getThumbLength(); ++l)
                {
                    BlockWorldState blockworldstate2 = patternhelper.translateOffset(j, l, 0);
                    worldIn.notifyNeighborsRespectDebug(blockworldstate2.getPos(), Blocks.air);
                }
            }
        }
    }
	
	
	 protected BlockPattern getGolemPattern()
	    {
	        if (this.golemPattern == null)
	        {
	            this.golemPattern = FactoryBlockPattern.start().aisle(new String[] {"~^~", "###", "~#~"}).where('^', BlockWorldState.hasState(BlockStateHelper.forBlock(ModItems.jackbottop))).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.gold_block))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
	        }

	        return this.golemPattern;
	    }

	 public boolean isFullBlock() {
		return false;
		 
	 }
	 
}
