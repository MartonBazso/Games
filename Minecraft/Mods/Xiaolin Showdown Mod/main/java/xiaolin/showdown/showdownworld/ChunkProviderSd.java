package xiaolin.showdown.showdownworld;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityBreakingFX.SnowballFactory;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderSd implements IChunkProvider {

	private World world;
	public static final Random random = new Random();
	int random1;

	public ChunkProviderSd(World worldIn)

	{
		this.world = worldIn;
		/* Megadja, hogy melyik random shailin leszámolás színtér következik */
		random1 = random.nextInt(4);
	}

	@Override
	public boolean chunkExists(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Chunk provideChunk(int x, int z) {

		/* Generálja az összes chunkot a dimenzióban */
		ChunkPrimer chunkprimer = new ChunkPrimer();
		if (random1 == 0) {
			// chunkprimer.setBlockState(1,1,1, Blocks.portal.getDefaultState());
			Random height = new Random();

			for (int k = 3; k < 100; k++) {

				for (int l = 1; l < 15; l++) {
					for (int m = 1; m < 15; m++) {
						if (height.nextInt(2) == 0) {
							chunkprimer.setBlockState(l, k + height.nextInt(4), m, Blocks.stone.getDefaultState());
						}
						if (height.nextInt(2) == 1) {
							chunkprimer.setBlockState(l, k + height.nextInt(4), m, Blocks.grass.getDefaultState());
						}
					}
				}
			}
		}

		if (random1 == 1) {
			// chunkprimer.setBlockState(1,1,1, Blocks.portal.getDefaultState());
			Random height = new Random();

			for (int l = 0; l < 16; ++l) {
				for (int m = 0; m < 16; ++m) {
					chunkprimer.setBlockState(l, 1, m, Blocks.slime_block.getDefaultState());
				}

			}

		}

		if (random1 == 2) {
			// chunkprimer.setBlockState(1,1,1, Blocks.portal.getDefaultState());
			Random earth = new Random();
			int q = earth.nextInt(2);
			for (int l = 0; l < 16; ++l) {
				for (int m = 0; m < 16; ++m) {
					if (q == 0) {
						chunkprimer.setBlockState(l, 1, m, Blocks.grass.getDefaultState());
					}
					if (q == 1) {
						chunkprimer.setBlockState(l, 1, m, Blocks.farmland.getDefaultState());
					}
				}

			}

			chunkprimer.setBlockState(5, 2, 3, Blocks.pumpkin.getDefaultState());
			chunkprimer.setBlockState(0, 2, 0, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(0, 3, 0, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(1, 2, 0, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(1, 3, 0, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(0, 2, 15, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(0, 3, 15, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(1, 2, 15, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(1, 3, 15, Blocks.hay_block.getDefaultState());
			chunkprimer.setBlockState(6, 2, 10, Blocks.melon_block.getDefaultState());

		}

		if (random1 == 3) {
			// chunkprimer.setBlockState(1,1,1, Blocks.portal.getDefaultState());
			Random height = new Random();

			for (int l = 0; l < 16; ++l) {

				chunkprimer.setBlockState(height.nextInt(2), 2 + height.nextInt(4), height.nextInt(3),
						Blocks.coal_ore.getDefaultState());

				for (int m = 0; m < 16; ++m) {

					chunkprimer.setBlockState(m, 0, l, Blocks.stone.getDefaultState());
				}

				chunkprimer.setBlockState(height.nextInt(8), 1 + height.nextInt(3), height.nextInt(3),
						Blocks.redstone_ore.getDefaultState());
				chunkprimer.setBlockState(height.nextInt(3), 2 + height.nextInt(3), height.nextInt(5),
						Blocks.diamond_ore.getDefaultState());

			}

		}

		Chunk chunk = new Chunk(this.world, chunkprimer, x, z);

		return chunk;
	}

	@Override
	public Chunk provideChunk(BlockPos blockPosIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {

	}

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {

		return false;
	}

	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {

		return false;
	}

	@Override
	public boolean unloadQueuedChunks() {

		return true;
	}

	@Override
	public boolean canSave() {

		return false;
	}

	@Override
	public String makeString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String p_180513_2_, BlockPos p_180513_3_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recreateStructures(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveExtraData() {
		// TODO Auto-generated method stub

	}

}
