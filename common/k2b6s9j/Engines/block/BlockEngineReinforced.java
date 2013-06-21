package k2b6s9j.Engines.block;

import k2b6s9j.Engines.CreativeTab;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEngineReinforced extends BlockContainer {

	public BlockEngineReinforced(int id) {
		super(id, Material.piston);
		setResistance(50.0F);
		setHardness(200.0F);
		setCreativeTab(CreativeTab.tabKeplersEngines);
		setUnlocalizedName("engineBlockUnbreakable");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
