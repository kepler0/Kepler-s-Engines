package k2b6s9j.Engines.block;

import k2b6s9j.Engines.CreativeTab;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEngineUnbreakable extends BlockContainer {

	public BlockEngineUnbreakable(int id) {
		super(id, Material.piston);
		setBlockUnbreakable();
		setResistance(6000000.0F);
		setCreativeTab(CreativeTab.tabKeplersEngines);
		setUnlocalizedName("engineBlockUnbreakable");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
