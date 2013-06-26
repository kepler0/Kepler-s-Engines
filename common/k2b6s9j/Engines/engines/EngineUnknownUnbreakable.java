package k2b6s9j.Engines.engines;

import k2b6s9j.Engines.Reference;
import k2b6s9j.Engines.tile.TileEngineUnbreakable;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidStack;

// THIS SHOULD ONLY BE USED IF SOMETHING REALLY WEIRD HAS HAPPENED!

public class EngineUnknownUnbreakable extends EngineUnbreakable {

	public EngineUnknownUnbreakable(TileEngineUnbreakable tile) {
		super(tile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextureFile() {
		return Reference.TEXTURE_PATH_BLOCKS + "/base_unknown.png";
	}

	@Override
	public int explosionRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxEnergyReceived() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPistonSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBurning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getScaledBurnTime(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void burn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		// TODO Auto-generated method stub
		return null;
	}

}
