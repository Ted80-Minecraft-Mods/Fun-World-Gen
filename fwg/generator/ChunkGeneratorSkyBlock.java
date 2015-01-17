package fwg.generator;

import java.util.List;
import java.util.Random;

import fwg.deco.DecoSurvival;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkGeneratorSkyBlock implements IChunkProvider
{
    private Random rand;
    private World world;
    private double[] densities;
    private BiomeGenBase[] biomesForGeneration;
    int[][] field_73203_h = new int[32][32];
	int getSize = 1;
	private boolean isNether = false;
	private int size = 1;
	
    public ChunkGeneratorSkyBlock(World par1World, long par2, boolean nether, int s)
    {
        world = par1World;
        rand = new Random(par2);
        isNether = nether;
        size = s;
    }

    public Chunk loadChunk(int par1, int par2)
    {
        return this.provideChunk(par1, par2);
    }

    public Chunk provideChunk(int par1, int par2)
    {
    	rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);

        Block[] var3 = new Block[32768];
        Chunk var4 = new Chunk(world, var3, par1, par2);
		
        if(world.getWorldInfo().getSpawnX() != 0 || world.getWorldInfo().getSpawnY() != 64 || world.getWorldInfo().getSpawnZ() != 0)
		{
			world.getWorldInfo().setSpawnPosition(0, 256, 0);
		}
        
        byte[] var5 = var4.getBiomeArray();
		this.biomesForGeneration = world.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        for (int var6 = 0; var6 < var5.length; ++var6)
        {
            var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
        }
		
        var4.generateSkylightMap();
        return var4;
    }

    public boolean chunkExists(int par1, int par2)
    {
        return true;
    }

    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
    {
        int var4 = par2 * 16;
        int var5 = par3 * 16;
        BiomeGenBase var6 = world.getBiomeGenForCoords(var4 + 16, var5 + 16);
        //var6.decorate(this.endWorld, this.endWorld.rand, var4, var5);
        
        if(par2 == 0 && par3 == 0)
        {
			if(isNether)
			{
				(new DecoSurvival(8)).generate(world, rand, 10, 80, 0);
			}
			else
			{
				(new DecoSurvival(6)).generate(world, rand, size, 70, 0);
				(new DecoSurvival(7)).generate(world, rand, 0, 80, 60);
			}
        }
    }

    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
    {
        return true;
    }
	
    public boolean unloadQueuedChunks()
    {
        return false;
    }

    public boolean unload100OldestChunks()
    {
        return false;
    }

    public boolean canSave()
    {
        return true;
    }

    public String makeString()
    {
        return "RandomLevelSource";
    }

    public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
    {
        BiomeGenBase var5 = world.getBiomeGenForCoords(par2, par4);
        return var5 == null ? null : var5.getSpawnableList(par1EnumCreatureType);
    }

    public ChunkPosition func_147416_a(World par1World, String par2Str, int par3, int par4, int par5)
    {
        return null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void saveExtraData() {}

    public void recreateStructures(int par1, int par2) {}
}