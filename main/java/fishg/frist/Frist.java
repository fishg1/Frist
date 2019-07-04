package fishg.frist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lists.ItemList;
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
	public static final String modid = "frist";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public Frist() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("Client Registries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.frospal = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("frospal")),
				ItemList.amphure = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("amphure")),
				ItemList.gasteel = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("gasteel")),
				ItemList.frigidTablet = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("frigidTablet"))
			);		
			logger.info("Items registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
