package fwg.generatortype;

import fwg.biomes.BiomeList;
import fwg.generator.ChunkGeneratorSkyland;
import fwg.gui.GuiGeneratorSettings;
import fwg.gui.GuiSettingsButton;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class GeneratorTypeSkyland extends GeneratorType
{
	public GeneratorTypeSkyland(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}
	
	@Override
	public boolean getSettings(GuiGeneratorSettings gui)
	{
		gui.settings.add(new GuiSettingsButton(new String[]{StatCollector.translateToLocal("fwg.setting.theme") + ": " + StatCollector.translateToLocal("fwg.theme.default"), StatCollector.translateToLocal("fwg.setting.theme") + ": " + StatCollector.translateToLocal("fwg.theme.snow"), StatCollector.translateToLocal("fwg.setting.theme") + ": " + StatCollector.translateToLocal("fwg.theme.jungle")}, new int[]{0, 1, 2}, 20, 50, gui.width)); 
		return true;
	}
	
	@Override
	public WorldChunkManager getServerWorldChunkManager(World world)
    {
		int themeID = trySetting(0, 2) + 1; 
		switch (themeID) 
		{
			case 2: return new WorldChunkManagerHell(BiomeList.default_snow, 0.5F);
			default: return new WorldChunkManagerHell(BiomeList.default_2, 0.5F);
		}
    }

	@Override
	public WorldChunkManager getClientWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.default_2, 0.5F);
    }

	@Override
    public IChunkProvider getChunkGenerator(World world)
    {	
		int themeID = trySetting(0, 2) + 1; 
        return new ChunkGeneratorSkyland(world, world.getSeed(), themeID);
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