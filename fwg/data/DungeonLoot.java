package fwg.data;

import java.util.Random;

import fwg.generatortype.GeneratorType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;

public class DungeonLoot 
{
	public static Item getRandomRecord(Random rand)
	{
		switch(rand.nextInt(12))
		{
			case 0: return Items.record_11;
			case 1: return Items.record_13;
			case 2: return Items.record_blocks;
			case 3: return Items.record_cat;
			case 4: return Items.record_chirp;
			case 5: return Items.record_far;
			case 6: return Items.record_mall;
			case 7: return Items.record_mellohi;
			case 8: return Items.record_stal;
			case 9: return Items.record_strad;
			case 10: return Items.record_wait;
			case 11: return Items.record_ward;
		}
		
		return Items.record_11;
	}
	
    public static ItemStack pickCheckLootItem(Random par1Random, int listitem, int chestID)
    {
    	if(GeneratorType.currentGenerator == GeneratorType.ISLAND)
    	{ 
    		if(chestID == 1)
    		{
    			if(listitem == 0) { return new ItemStack(Items.melon_seeds, par1Random.nextInt(2) + 1); }
    			if(listitem == 1) { return new ItemStack(Items.pumpkin_seeds, par1Random.nextInt(2) + 1); }
    			if(listitem == 2) { return new ItemStack(Blocks.cactus, par1Random.nextInt(4) + 1); }
    			if(listitem == 3) { return new ItemStack(Items.reeds, par1Random.nextInt(4) + 1); }
    			if(listitem == 4) { return new ItemStack(Items.wheat_seeds, 12); }
    			if(listitem == 5) { return new ItemStack(Blocks.vine, par1Random.nextInt(4) + 1); }
    			if(listitem == 6) { return new ItemStack(Items.spawn_egg, 2, 93); }
    			if(listitem == 7) { return new ItemStack(Items.spawn_egg, 2, 91); }
    			else { return null; }		
    		} 
    		else if(chestID == 2)
    		{
    			if(listitem == 0) { return new ItemStack(Items.potato, par1Random.nextInt(2) + 1); }
    			if(listitem == 1) { return new ItemStack(Items.carrot, par1Random.nextInt(2) + 1); }
    			if(listitem == 2) { return new ItemStack(Blocks.snow, par1Random.nextInt(12) + 1); }
    			if(listitem == 3) { return new ItemStack(Blocks.mycelium); }
    			if(listitem == 4) { return new ItemStack(Items.spawn_egg, 2, 92); }
    			if(listitem == 5) { return new ItemStack(Items.spawn_egg, 2, 90); }
    			if(listitem == 6) { return new ItemStack(Items.spawn_egg, 2, 120); }
    			else { return null; }		
    		} 
    		else
    		{
    			int i = par1Random.nextInt(18);
    			if (i == 0 && par1Random.nextInt(3) == 0) { return new ItemStack(Items.spawn_egg, 1, 95); }
    			if (i == 1 && par1Random.nextInt(3) == 0) { return new ItemStack(Items.spawn_egg, 1, 98); }
    			else { return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random); }		
    		}
    	}
    	else if(GeneratorType.currentGenerator == GeneratorType.SKYLAND)
    	{
    		if(chestID == 2)
    		{
    			int i = par1Random.nextInt(30);
    			if (i == 1) { return new ItemStack(Items.brick, par1Random.nextInt(63) + 1); }
    			if (i == 2) { return new ItemStack(Blocks.snow, par1Random.nextInt(12) + 1); }
    			if (i == 3) { return new ItemStack(Blocks.waterlily, par1Random.nextInt(4) + 1); }
    			if (i == 5 && par1Random.nextInt(3) == 0) { return new ItemStack(Blocks.mycelium); }
    			if (i == 6 && par1Random.nextInt(3) == 0) { return new ItemStack(getRandomRecord(par1Random)); }
    			if (i == 7) { return new ItemStack(Blocks.vine, par1Random.nextInt(4) + 1); }
    			if (i == 8) { return new ItemStack(Items.potato, par1Random.nextInt(4) + 1); }
    			if (i == 9) { return new ItemStack(Items.carrot, par1Random.nextInt(4) + 1); }
    			if (i == 10) { return new ItemStack(Items.emerald, par1Random.nextInt(4) + 1); }
    			if (i == 11) { return new ItemStack(Items.gunpowder, par1Random.nextInt(4) + 1); }
    			if (i == 12 && par1Random.nextInt(3) == 0) { return new ItemStack(Items.golden_carrot); }
    			if (i == 13 && par1Random.nextInt(3) == 0) { return new ItemStack(Items.golden_apple); }
    			if (i > 13 || i < 13 + 6) { return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random); }
    			else { return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random); }			
    		} 
    		else
    		{
				int i = par1Random.nextInt(15);
				if (i == 0) { return new ItemStack(Blocks.cactus, par1Random.nextInt(4) + 1); }
				if (i == 1) { return new ItemStack(Items.reeds, par1Random.nextInt(4) + 1); }
				if (i == 2) { return new ItemStack(Blocks.sapling, 1, par1Random.nextInt(3) + 1); }
				if (i == 3) { return new ItemStack(Items.melon_seeds, par1Random.nextInt(4) + 1); }
				if (i == 4) { return new ItemStack(Items.pumpkin_seeds, par1Random.nextInt(4) + 1); }
				if (i == 5 || i == 6) { return new ItemStack(Items.lava_bucket, par1Random.nextInt(4) + 1); }
				else { return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random); }	
    		}
    	}
    	/*else if(GeneratorType.currentGenerator == GeneratorType.CAVE)
    	{
    		if(chestID == 0)
    		{
	    		int i = par1Random.nextInt(15);
	    		if (i == 0) { return new ItemStack(Blocks.clay, par1Random.nextInt(12) + 4); }
	    		if (i == 1) { return new ItemStack(Items.reeds, 1); }
	    		if (i == 2) { return new ItemStack(Items.carrot, par1Random.nextInt(3) + 1); }
	    		if (i == 3) { return new ItemStack(Items.potato, par1Random.nextInt() + 1); }
	    		if (i == 4) { return new ItemStack(Items.pumpkin_seeds, par1Random.nextInt(3) + 1); }
	    		if (i == 5) { return new ItemStack(Items.melon_seeds, par1Random.nextInt(3) + 1); }
	    		if (i == 6) { return new ItemStack(Blocks.snow, par1Random.nextInt(8) + 1); }
	    		else { return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random); }
    		}
    		else
    		{
    			return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random);
    		}
    	}*/
    	else if(GeneratorType.currentGenerator == GeneratorType.SKYDIM)
    	{
        	if(chestID == 1)
    		{
    			int i = par1Random.nextInt(21);
    			if (i == 0) { return new ItemStack(Items.potato, par1Random.nextInt(4) + 1); }
    			if (i == 1) { return new ItemStack(Items.carrot, par1Random.nextInt(4) + 1); }
    			if (i == 2) { return new ItemStack(Items.emerald, par1Random.nextInt(4) + 1); }
    			if (i == 3) { return new ItemStack(Items.melon_seeds, par1Random.nextInt(4) + 1); }
    			if (i == 4) { return new ItemStack(Items.pumpkin_seeds, par1Random.nextInt(4) + 1); }
    			if (i == 5) { return new ItemStack(Blocks.vine, par1Random.nextInt(4) + 1); }
    			if (i == 6 && par1Random.nextInt(3) == 0) { return new ItemStack(Blocks.mycelium); }
    			if (i == 7) { return new ItemStack(Blocks.sapling, 1, 3); }
    			if (i == 8) { return new ItemStack(Blocks.waterlily, par1Random.nextInt(4) + 1); }
    			if (i == 9 || i == 10 || i == 11) { return new ItemStack(Items.water_bucket, par1Random.nextInt(2) + 1); }
    			if (i == 12 || i == 13 || i == 14) { return new ItemStack(Items.lava_bucket, par1Random.nextInt(2) + 1); }
    			else { return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random); }	
    		} 
    		else
    		{
    			int i = par1Random.nextInt(20);
    			if (i == 0) { return new ItemStack(Items.potato, par1Random.nextInt(4) + 1); }
    			if (i == 1) { return new ItemStack(Items.carrot, par1Random.nextInt(4) + 1); }
    			if (i == 2 && par1Random.nextInt(3) == 0) { return new ItemStack(Blocks.mycelium); }
    			if (i == 3) { return new ItemStack(Blocks.waterlily, par1Random.nextInt(4) + 1); }
    			if (i == 4 || i == 5 || i == 6) { return new ItemStack(Items.water_bucket, par1Random.nextInt(2) + 1); }
    			if (i == 7 || i == 8 || i == 9) { return new ItemStack(Items.lava_bucket, par1Random.nextInt(2) + 1); }
    			else { return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random); }	
    		} 
    	}
    	
    	return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random);
    }
}