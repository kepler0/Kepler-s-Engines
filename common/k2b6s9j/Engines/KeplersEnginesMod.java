package k2b6s9j.Engines;

import java.io.File;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;

import org.modstats.ModstatInfo;

import buildcraft.BuildCraftCore;
import buildcraft.api.power.PowerFramework;
import buildcraft.core.BlockSpring;
import buildcraft.core.BuildCraftConfiguration;
import buildcraft.core.DefaultProps;
import buildcraft.core.ItemBuildCraft;
import buildcraft.core.ItemSpring;
import buildcraft.core.ItemWrench;
import buildcraft.core.RedstonePowerFramework;
import buildcraft.core.Version;
import buildcraft.core.network.PacketHandler;

import k2b6s9j.Engines.block.BlockEngineReinforced;
import k2b6s9j.Engines.block.BlockEngineUnbreakable;
import k2b6s9j.Engines.item.ItemEngineUnbreakable;
import k2b6s9j.Engines.proxy.Proxy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = {Reference.NET_CHANNEL_NAME}, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = true)
@ModstatInfo(prefix="kengines")
public class KeplersEnginesMod {
	
	public static KEconfiguration mainConfiguration;
	public static BlockEngineUnbreakable unbreakableEngine;
	public static BlockEngineReinforced reinforcedEngine;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	Property unbreakableEngineID = mainConfiguration.getBlock("engine.unbreakable.id", Reference.UNBREAKABLE_ENGINE_ID);
    	mainConfiguration.save();
    	
    	unbreakableEngine = new BlockEngineUnbreakable(unbreakableEngineID.getInt(Reference.UNBREAKABLE_ENGINE_ID));
    	Proxy.proxy.registerBlock(unbreakableEngine, ItemEngineUnbreakable.class);
    	
    	LanguageRegistry.addName(new ItemStack(unbreakableEngine, 1, 0), "Bedrock Engine");
    }
    
    @PreInit
	public void loadConfiguration(FMLPreInitializationEvent evt) {

		Version.check();

		mainConfiguration = new KEconfiguration(new File(evt.getModConfigurationDirectory(), "k2b6s9j/Engines.conf"));
		try {
			mainConfiguration.load();;

			MinecraftForge.EVENT_BUS.register(this);

		} finally {
			if (mainConfiguration.hasChanged()) {
				mainConfiguration.save();
			}
		}
	}
    
    @Init
    public void init(FMLInitializationEvent event) {
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}