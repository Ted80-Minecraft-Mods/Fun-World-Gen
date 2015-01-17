package fwg.generatortype;

import fwg.biomes.BiomeList;
import fwg.generator.ChunkGeneratorSkyDimension;
import fwg.gui.GuiGeneratorSettings;
import fwg.gui.GuiSettingsButton;
import fwg.world.ManagerFWG;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class GeneratorTypeSkyDim extends GeneratorType
{
	public GeneratorTypeSkyDim(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}
	
	@Override
	public boolean getSettings(GuiGeneratorSettings gui)
	{
		gui.settings.add(new GuiSettingsButton(new String[]{StatCollector.translateToLocal("fwg.biomes.biomes") + ": " + StatCollector.translateToLocal("fwg.biomes.all"), StatCollector.translateToLocal("fwg.biomes.biomes") + ": " + StatCollector.translateToLocal("fwg.biomes.vanilla")}, new int[]{1, 0}, 20, 50, gui.width));
		return true;
	}
	
	@Override
	public WorldChunkManager getServerWorldChunkManager(World world)
    {
		int biomes = trySetting(0, 1);
		return new ManagerFWG(world, true, biomes);
    }

	@Override
	public WorldChunkManager getClientWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.default_1, 0.5F);
    }

	@Override
    public IChunkProvider getChunkGenerator(World world)
    {	
		return new ChunkGeneratorSkyDimension(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), trySetting(0, 1), 0);
    }

	@Override
    public float getCloudHeight()
    {
    	return 0F;
    }

	@Override
    public double getHorizon()
    {
    	return 2D;
    }
}