package xiaolin.showdown.showdownworld;

import java.util.List;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenEnd;
import net.minecraft.world.biome.BiomeGenMushroomIsland;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.BiomeGenSavanna;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderDebug;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldShowdownProvider extends WorldProvider{
	
	
	
	
	
    public String getDimensionName()
    {
        return "ShowdownWorld";
    }

    public String getInternalNameSuffix()
    {
        return "_xiaolin";
    }
    
    public void setDimension(int dim)
    {
        this.dimensionId = dim;
    }
    

    
    public IChunkProvider createChunkGenerator() 
    {
    	
    	return new ChunkProviderSd(this.worldObj);
    }
    
    public boolean canRespawnHere()
    {
        return false;
    }
    
    public boolean isSurfaceWorld()
    {
        return false;
    }
    
    

    public int getAverageGroundLevel()
    {
        return 150;
    }

    
    
    
    
    public void registerWorldChunkManager()
    {
    	
        this.worldChunkMgr = new WorldChunkManagerHell(new BiomeGenShowdown(9), 1f);
        this.hasNoSky = false;
        this.dimensionId = 2;
      
    }
    


	
}