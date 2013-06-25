package k2b6s9j.Engines.engines;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidStack;
import buildcraft.energy.Engine;
import buildcraft.energy.TileEngine;

public class EngineBedrock extends Engine {

	public EngineBedrock(TileEngine tile) {
		super(tile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextureFile() {
		// TODO Auto-generated method stub
		return null;
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
