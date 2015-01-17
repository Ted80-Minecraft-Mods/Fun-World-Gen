package fwg.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeDefaultSnow extends BiomeGenBase
{
    public BiomeDefaultSnow(int par1)
    {
        super(par1);
        spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 2, 6));
    }

    
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    { 
		return ColorizerGrass.getGrassColor(0.6F, 0.6F);
    } 
    
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {  
		return ColorizerFoliage.getFoliageColor(0.6F, 0.6F);
    } 

    @SideOnly(Side.CLIENT)
    public float getFTemp(int p_150564_1_, int p_150564_2_, int p_150564_3_)
    {
        if (p_150564_2_ > 64)
        {
            float var4 = (float)temperatureNoise.func_151601_a((double)p_150564_1_ * 1.0D / 8.0D, (double)p_150564_3_ * 1.0D / 8.0D) * 4.0F;
            return this.temperature - (var4 + (float)p_150564_2_ - 64.0F) * 0.05F / 30.0F;
        }
        else
        {
            return this.temperature;
        }
    }
}
