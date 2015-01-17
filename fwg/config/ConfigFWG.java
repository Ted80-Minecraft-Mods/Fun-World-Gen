package fwg.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigFWG
{
	public static Configuration config;
	public static int[] biomeIDs = new int[3];
	
	public static void init(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		
		for(int c = 0; c < biomeIDs.length; c++)
		{
			biomeIDs[c] = 185 + c;
		}
		
		try 
		{
			config.load();

			biomeIDs[0] = config.get("Biome IDs", "Default 1", 185).getInt();
			biomeIDs[1] = config.get("Biome IDs", "Default 2", 186).getInt();
			biomeIDs[2] = config.get("Biome IDs", "Default Snow", 187).getInt();
		}
		catch (Exception e) 
		{
			for(int c = 0; c < biomeIDs.length; c++)
			{
				biomeIDs[c] = 185 + c;
			}
		}
		finally 
		{
			if (config.hasChanged()) 
			{
				config.save();
			}
		}
	}
}