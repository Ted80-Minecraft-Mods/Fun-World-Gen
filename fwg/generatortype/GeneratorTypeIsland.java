package fwg.generatortype;

import fwg.biomes.BiomeList;
import fwg.generator.ChunkGeneratorIsland;
import fwg.gui.GuiGeneratorSettings;
import fwg.gui.GuiSettingsButton;
import fwg.gui.GuiSettingsSlider;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class GeneratorTypeIsland extends GeneratorType
{
	public GeneratorTypeIsland(int id, int cat, String name, boolean c) 
	{
		super(id, cat, name, c);
	}
	
	@Override
	public boolean getSettings(GuiGeneratorSettings gui)
	{
		gui.settings.add(new GuiSettingsButton(new String[]{StatCollector.translateToLocal("fwg.setting.theme") + ": " + StatCollector.translateToLocal("fwg.theme.default"), StatCollector.translateToLocal("fwg.setting.theme") + ": " + StatCollector.translateToLocal("fwg.theme.tropical"), StatCollector.translateToLocal("fwg.setting.theme") + ": " + StatCollector.translateToLocal("fwg.theme.paradise")}, new int[]{0, 1, 4}, 20, 50, gui.width)); //"Theme: Hell", "Theme: Iceberg",   2, 3,
		gui.settings.add(new GuiSettingsSlider(new String[]{StatCollector.translateToLocal("fwg.setting.size") + ": " + StatCollector.translateToLocal("fwg.setting.small"), StatCollector.translateToLocal("fwg.setting.size") + ": " + StatCollector.translateToLocal("fwg.setting.default"), StatCollector.translateToLocal("fwg.setting.size") + ": " + StatCollector.translateToLocal("fwg.setting.large")}, new int[]{0, 1, 2}, 1, 21, 70, gui.width, 20, new int[]{0, 1})); //, 2, 3
		return true;
	}
	
	@Override
	public WorldChunkManager getServerWorldChunkManager(World world)
    {
		int themeID = trySetting(0, 4) + 1; 
		switch (themeID) 
		{
			case 5: return new WorldChunkManagerHell(BiomeList.default_2, 0.5F);
			default: return new WorldChunkManagerHell(BiomeList.default_1, 0.5F);
		}
    }

	@Override
	public WorldChunkManager getClientWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.default_1, 0.5F);
    }

	@Override
    public IChunkProvider getChunkGenerator(World world)
    {	
		int themeID = trySetting(0, 4) + 1; 
		int size = trySetting(1, 2) + 1; 
        return new ChunkGeneratorIsland(world, world.getSeed(), themeID, size);
    }
}