package fwg.generatortype;

import fwg.biomes.BiomeList;
import fwg.generator.ChunkGeneratorSkyBlock;
import fwg.gui.GuiGeneratorSettings;
import fwg.gui.GuiSettingsButton;
import fwg.gui.GuiSettingsSlider;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class GeneratorTypeSkyblock extends GeneratorType
{
	public GeneratorTypeSkyblock(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}
	
	@Override
	public boolean getSettings(GuiGeneratorSettings gui)
	{
		gui.settings.add(new GuiSettingsSlider(new String[]{StatCollector.translateToLocal("fwg.setting.size") + ": " + StatCollector.translateToLocal("fwg.setting.small"), StatCollector.translateToLocal("fwg.setting.size") + ": " + StatCollector.translateToLocal("fwg.setting.default"), StatCollector.translateToLocal("fwg.setting.size") + ": " + StatCollector.translateToLocal("fwg.setting.large")}, new int[]{0, 1, 2}, 1, 20, 50, gui.width));
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
		int size = trySetting(0, 2) + 1; 
		return new ChunkGeneratorSkyBlock(world, world.getSeed(), false, size);
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