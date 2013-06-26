package k2b6s9j.Engines.proxy;

import k2b6s9j.Engines.KeplersEnginesMod;
import k2b6s9j.Engines.Reference;
import k2b6s9j.Engines.tile.TileEngineUnbreakable;
import buildcraft.core.render.RenderingEntityBlocks;
import buildcraft.core.render.RenderingEntityBlocks.EntityRenderIndex;
import buildcraft.energy.render.RenderEngine;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ProxyClient extends Proxy {
	@Override
	public void registerTileEntities() {
		super.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEngineUnbreakable.class, new RenderEngine());
	}

	@Override
	public void registerBlockRenderers() {
		RenderingEntityBlocks.blockByEntityRenders.put(new EntityRenderIndex(KeplersEnginesMod.unbreakableEngine, 0), new RenderEngine(
				Reference.TEXTURE_PATH_BLOCKS + "/base_bedrock.png"));
		RenderingEntityBlocks.blockByEntityRenders.put(new EntityRenderIndex(KeplersEnginesMod.unbreakableEngine, 1), new RenderEngine(
				Reference.TEXTURE_PATH_BLOCKS + "/base_unknown.png"));
	}
}
