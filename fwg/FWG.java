package fwg;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fwg.biomes.BiomeList;
import fwg.config.ConfigFWG;
import fwg.data.Planets;
import fwg.support.Support;
import fwg.world.WorldTypeFWG;

@Mod(modid="FWG", name="FunWorldGen", version="1.0.2")
public class FWG
{	
	@Instance("FWG")
	public static FWG instance;
	
	public static final WorldTypeFWG worldtype = (new WorldTypeFWG("FWG"));  
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		instance = this;
		
		ConfigFWG.init(event);
		BiomeList.init();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		Support.init();
		Planets.init();
	}
}