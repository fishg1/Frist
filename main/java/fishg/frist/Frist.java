package fishg.frist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fishg.frist.init.FristEntities;
import lists.BlockList;
import lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("frist")
public class Frist 
{
	public static Frist instance;
	public static final String MODID = "frist";
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	
	//Item Groups
	public static final ItemGroup frist_blocks = new BlocksItemGroup();
	public static final ItemGroup frist_items = new ItemsItemGroup();
	
	public Frist() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		LOGGER.info("Client Registries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.frospal = new Item(new Item.Properties().group(frist_items)).setRegistryName(location("frospal")),
				ItemList.amphure = new Item(new Item.Properties().group(frist_items)).setRegistryName(location("amphure")),
				ItemList.gasteel = new Item(new Item.Properties().group(frist_items)).setRegistryName(location("gasteel")),
				ItemList.frist_portal = new Item(new Item.Properties().group(frist_items)).setRegistryName(location("frist_portal")),
				
				//BLOCK ITEMS
				ItemList.fristum_block = new BlockItem(BlockList.fristum, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.fristum.getRegistryName()),
				ItemList.dark_fristum_block = new BlockItem(BlockList.dark_fristum, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.dark_fristum.getRegistryName()),
				ItemList.white_fristum_block = new BlockItem(BlockList.white_fristum, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.white_fristum.getRegistryName()),
				
				ItemList.fristum_brick_block = new BlockItem(BlockList.fristum_brick, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.fristum_brick.getRegistryName()),
				ItemList.dark_fristum_brick_block = new BlockItem(BlockList.dark_fristum_brick, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.dark_fristum_brick.getRegistryName()),
				ItemList.white_fristum_brick_block = new BlockItem(BlockList.white_fristum_brick, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.white_fristum_brick.getRegistryName()),
				ItemList.dark_fristum_pillar_block = new BlockItem(BlockList.dark_fristum_pillar, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.dark_fristum_pillar.getRegistryName()),
				ItemList.tundran_bookshelf_block = new BlockItem(BlockList.tundran_bookshelf, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.tundran_bookshelf.getRegistryName()),
			
				ItemList.amphure_ore_block = new BlockItem(BlockList.amphure_ore, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.amphure_ore.getRegistryName()),
				ItemList.frospal_ore_block = new BlockItem(BlockList.frospal_ore, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.frospal_ore.getRegistryName()),
				ItemList.sleet_block = new BlockItem(BlockList.sleet, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.sleet.getRegistryName()),
				ItemList.packed_sleet_block = new BlockItem(BlockList.packed_sleet, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.packed_sleet.getRegistryName()),
				ItemList.packed_blue_ice_block = new BlockItem(BlockList.packed_blue_ice, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.packed_blue_ice.getRegistryName()),
				
				ItemList.gasteel_brick_block = new BlockItem(BlockList.gasteel_brick, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.gasteel_brick.getRegistryName()),
				ItemList.gasteel_pillar_block = new BlockItem(BlockList.gasteel_pillar, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.gasteel_pillar.getRegistryName()),
				
				ItemList.gasteel_lamp_block = new BlockItem(BlockList.gasteel_lamp, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.gasteel_lamp.getRegistryName()),
				ItemList.fristum_lamp_block = new BlockItem(BlockList.fristum_lamp, new Item.Properties().group(frist_blocks)).setRegistryName(BlockList.fristum_lamp.getRegistryName())
				
				

			);		
			
			FristEntities.registerEntitySpawnEgg(event);
			
			LOGGER.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.fristum = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.SNOW)).setRegistryName(location("fristum")),
				BlockList.dark_fristum = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.SNOW)).setRegistryName(location("dark_fristum")),
				BlockList.white_fristum = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.SNOW)).setRegistryName(location("white_fristum")),
				
				BlockList.fristum_brick = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("fristum_brick")),
				BlockList.dark_fristum_brick = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("dark_fristum_brick")),
				BlockList.white_fristum_brick = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("white_fristum_brick")),
				BlockList.dark_fristum_pillar = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("dark_fristum_pillar")),
				BlockList.tundran_bookshelf = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("tundran_bookshelf")),

				BlockList.amphure_ore = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("amphure_ore")),
				BlockList.frospal_ore = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("frospal_ore")),
				BlockList.sleet = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("sleet")),
				BlockList.packed_sleet = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("packed_sleet")),
				BlockList.packed_blue_ice = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("packed_blue_ice")),
				
				BlockList.gasteel_brick = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("gasteel_brick")),
				BlockList.gasteel_pillar = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE)).setRegistryName(location("gasteel_pillar")),
				
				BlockList.gasteel_lamp = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE).lightValue(14)).setRegistryName(location("gasteel_lamp")),
				BlockList.fristum_lamp = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2).sound(SoundType.STONE).lightValue(14)).setRegistryName(location("fristum_lamp"))
				
						
			);		
			LOGGER.info("Blocks registered.");
		}
		
		public static ResourceLocation location(String name)
		{
			return new ResourceLocation(MODID, name);
		}
	}
}
