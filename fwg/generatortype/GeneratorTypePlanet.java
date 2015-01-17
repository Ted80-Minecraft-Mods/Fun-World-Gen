package fwg.generatortype;

import fwg.biomes.BiomeList;
import fwg.generator.ChunkGeneratorPlanetoids;
import fwg.gui.GuiGeneratorSettings;
import fwg.gui.GuiSettingsButton;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class GeneratorTypePlanet extends GeneratorType
{
	public GeneratorTypePlanet(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}
	
	public boolean getSettings(GuiGeneratorSettings gui)
	{
		gui.settings.add(new GuiSettingsButton(new String[]{StatCollector.translateToLocal("fwg.setting.water") + ": " + StatCollector.translateToLocal("fwg.setting.off"), StatCollector.translateToLocal("fwg.setting.water") + ": " + StatCollector.translateToLocal("fwg.setting.on")}, new int[]{0, 1}, 20, 50, gui.width));
		return true;
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
		int water = trySetting(0, 2); 
		return new ChunkGeneratorPlanetoids(world, world.getSeed(), water == 1 ? true : false, 0);
    }

	@Override
    public double getHorizon()
    {
    	return 1D;
    }
}