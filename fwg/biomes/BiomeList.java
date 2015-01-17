package fwg.biomes;

import fwg.config.ConfigFWG;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class BiomeList 
{
	public static BiomeGenBase default_1;
	public static BiomeGenBase default_2;
	public static BiomeGenBase default_snow;
	
	public static void init()
	{
		default_1 = new BiomeDefault(ConfigFWG.biomeIDs[0], 0).setBiomeName("fwg_default1");
		default_2 = new BiomeDefault(ConfigFWG.biomeIDs[1], 1).setBiomeName("fwg_default2");
		default_snow = new BiomeDefaultSnow(ConfigFWG.biomeIDs[2]).setBiomeName("fwg_default_snow").setTemperatureRainfall(0.0F, 0.5F);

		BiomeDictionary.registerBiomeType(default_1, Type.HOT, Type.COLD, Type.DENSE, Type.RIVER, Type.OCEAN, Type.FOREST, Type.PLAINS, Type.HILLS);
		BiomeDictionary.registerBiomeType(default_2, Type.HOT, Type.COLD, Type.DENSE, Type.RIVER, Type.OCEAN, Type.FOREST, Type.PLAINS, Type.HILLS);
		BiomeDictionary.registerBiomeType(default_snow, Type.COLD, Type.DENSE, Type.RIVER, Type.OCEAN, Type.FOREST, Type.PLAINS, Type.HILLS, Type.SNOWY, Type.FROZEN);
	}
}
