package fwg.generatortype;

import fwg.biomes.BiomeList;
import fwg.generator.ChunkGeneratorCaveSurv;
import fwg.gui.GuiGeneratorSettings;
import fwg.gui.GuiSettingsButton;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class GeneratorTypeCaves extends GeneratorType
{
	public GeneratorTypeCaves(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}

	@Override
	public WorldChunkManager getServerWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.default_1, 0.5F);
    }

	@Override
	public WorldChunkManager getClientWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.default_1, 0.5F);
    }

	@Override
    public IChunkProvider getChunkGenerator(World world)
    {	
    	return new ChunkGeneratorCaveSurv(world, world.getSeed());
    }   

	@Override
	public double getHorizon()
    {
    	return 129D;
    }
}