package k2b6s9j.Engines.engines;

import k2b6s9j.Engines.Reference;
import k2b6s9j.Engines.tile.TileEngineUnbreakable;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidStack;
import buildcraft.energy.Engine;
import buildcraft.energy.TileEngine;

public class EngineBedrock extends EngineUnbreakable {

	public EngineBedrock(TileEngineUnbreakable tile) {
		super(tile);
		maxEnergy = 60000000;
		maxEnergyExtracted = 500;
	}

	@Override
	public String getTextureFile() {
		return Reference.TEXTURE_PATH_BLOCKS + "/base_bedrock.png";
	}

	@Override
	public int explosionRange() {
		return 1;
	}

	@Override
	public int minEnergyReceived() {
		return 1;
	}

	@Override
	public int maxEnergyReceived() {
		return 2000;
	}

	@Override
	protected void computeEnergyStage() {
		double level = energy / (double) maxEnergy * 100.0;
		if (level <= 1) {
			energyStage = EnergyStage.Blue;
		} else if (level <= 1000) {
			energyStage = EnergyStage.Green;
		} else if (level <= 48000000) {
			energyStage = EnergyStage.Yellow;
		} else {
			energyStage = EnergyStage.Red;
		}
	}

	@Override
	public float getPistonSpeed() {
		switch (getEnergyStage()) {
		case Blue:
			return 0.02F;
		case Green:
			return 0.04F;
		case Yellow:
			return 0.08F;
		case Red:
			return 0.16F;
		default:
			return 0;
		}
	}

	@Override
	public void update() {
		super.update();

		if (tile.isRedstonePowered) {
			addEnergy(1000);
		}
	}

	@Override
	public boolean isBurning() {
		return tile.isRedstonePowered;
	}

	@Override
	public int getScaledBurnTime(int i) {
		return 0;
	}

	@Override
	public void delete() {
	}

	@Override
	public void burn() {
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		return null;
	}
}
