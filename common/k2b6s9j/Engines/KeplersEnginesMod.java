package k2b6s9j.Engines;

import org.modstats.ModstatInfo;

import k2b6s9j.Engines.block.BlockEngineReinforced;
import k2b6s9j.Engines.block.BlockEngineUnbreakable;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@ModstatInfo(prefix="kengines")
public class KeplersEnginesMod {
	
	private static BlockEngineUnbreakable unbreakableEngine = new BlockEngineUnbreakable(Reference.UNBREAKABLE_ENGINE_ID);
	private static BlockEngineReinforced reinforcedEngine = new BlockEngineReinforced(Reference.REINFORCED_ENGINE_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	GameRegistry.registerBlock(unbreakableEngine, "Unbreakable Engine");
    	GameRegistry.registerBlock(reinforcedEngine, "Reinforced Engine");
    }
    
    @Init
    public void init(FMLInitializationEvent event) {
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}