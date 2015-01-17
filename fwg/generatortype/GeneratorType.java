package fwg.generatortype;

import fwg.biomes.BiomeList;
import fwg.gui.GuiGeneratorSettings;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;

public class GeneratorType 
{
	public static GeneratorType currentGenerator;
	public static String biomestring;
	public static int[] currentSettings;
	
	public static long seed;
	public static String genString;
	
	public static final GeneratorType[] generatortypes = new GeneratorType[7];

	public static final GeneratorType SKYDIM = new GeneratorTypeSkyDim(0, 0, "SKYDIM", true);
	public static final GeneratorType ISLAND = new GeneratorTypeIsland(1, 0, "ISLAND", true);
	public static final GeneratorType SKYLAND = new GeneratorTypeSkyland(2, 0, "SKYLAND", true);
	public static final GeneratorType PLANET = new GeneratorTypePlanet(3, 0, "PLANET", true);
	
	//public static final GeneratorType CAVE = new GeneratorTypeCaves(4, 0, "CAVE", false);
	//public static final GeneratorType SKYBLOCK = new GeneratorTypeSkyblock(5, 0, "SKYBLOCK", false);
	//public static final GeneratorType CAVEDIM = new GeneratorTypeCaveDim(6, 0, "CAVEDIM", false);
	
	private final int GeneratorTypeId;
	private final String GeneratorName;
	private final boolean Creatable;
	private final int category;
	
	public GeneratorType(int id, int cat, String name, boolean c, boolean fog, boolean angle)
	{
		generatortypes[id] = this;
		GeneratorTypeId = id;
		GeneratorName = name;
		Creatable = c;
		category = cat;
	}
	
	public GeneratorType(int id, int cat, String name, boolean c)
	{
		this(id, cat, name, c, false, false);
	}
	
	public int GetID()
	{
		return GeneratorTypeId;
	}
	
	public int GetCategory()
	{
		return category;
	}
	
	public String GetName()
	{
		return GeneratorName;
	}
	
	public boolean CanBeCreated()
	{
		return Creatable;
	}

	public boolean getSettings(GuiGeneratorSettings gui)
	{
		return false;
	}

	public WorldChunkManager getServerWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.default_1, 0.5F);
    }
	
	public WorldChunkManager getClientWorldChunkManager(World world)
    {
		return new WorldChunkManagerHell(BiomeList.default_1, 0.5F);
    }
	
    public IChunkProvider getChunkGenerator(World world)
    {	
    	return null;
    }
    
    public float getCloudHeight()
    {
    	return 128F;
    }
    
    public double getHorizon()
    {
    	return 63D;
    }

	public static int trySetting(int pos, int max)
	{
		if(currentSettings != null) 
		{
			if(currentSettings.length > pos) 
			{
				if(currentSettings[pos] <= max) 
				{
					return currentSettings[pos];
				}
			}
		}
		return 0;
	}
}
