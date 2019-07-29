package fishg.frist.init;

import fishg.frist.Frist;
import fishg.frist.ItemsItemGroup;
import fishg.frist.entities.Tundran;
import lists.ItemList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;

public class FristEntities 
{
	public static EntityType<?> TUNDRAN = EntityType.Builder.create(Tundran::new, EntityClassification.CREATURE).build(Frist.MODID + ":tundran").setRegistryName(Frist.RegistryEvents.location("tundran"));
	
	public static void registerEntitySpawnEgg(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			ItemList.tundran_entity_egg = registerEntitySpawnEgg(TUNDRAN, 0xb51d1d, 0xe3b510, "tundran_entity_egg")
		);
	}
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(TUNDRAN, EntityClassification.CREATURE, Biomes.PLAINS);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemsItemGroup.MISC));
		item.setRegistryName(Frist.RegistryEvents.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification, Biome...biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(classification).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
}