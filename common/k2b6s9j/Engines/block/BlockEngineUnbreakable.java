package k2b6s9j.Engines.block;

import java.util.List;
import java.util.Random;

import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.api.tools.IToolWrench;
import buildcraft.core.GuiIds;
import buildcraft.core.IItemPipe;
import buildcraft.core.liquids.LiquidUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import k2b6s9j.Engines.CreativeTab;
import k2b6s9j.Engines.tile.TileEngineUnbreakable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.LiquidContainerRegistry;

public class BlockEngineUnbreakable extends BlockContainer {

	public BlockEngineUnbreakable(int id) {
		super(id, Material.piston);
		setBlockUnbreakable();
		setResistance(6000000.0F);
		setCreativeTab(CreativeTab.tabKeplersEngines);
		setUnlocalizedName("engineBlockUnbreakable");
	}
	
	private static Icon bedrockTexture;
	private static Icon unknownTexture;
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		bedrockTexture = par1IconRegister.registerIcon("keplersengines:engineBedrockBottom");
		unknownTexture = par1IconRegister.registerIcon("keplersengines:engineUnknownBottom");
	}

	@Override
	public int getRenderType() {
		return BuildCraftCore.blockByEntityModel;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEngineUnbreakable();
	}

	@Override
	public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (tile instanceof TileEngineUnbreakable) {
			return ForgeDirection.getOrientation(((TileEngineUnbreakable) tile).orientation).getOpposite() == side;
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		TileEngineUnbreakable engine = ((TileEngineUnbreakable) world.getBlockTileEntity(x, y, z));

		if (engine != null) {
			engine.delete();
		}
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int side, float par7, float par8, float par9) {

		TileEngineUnbreakable tile = (TileEngineUnbreakable) world.getBlockTileEntity(i, j, k);

		// Drop through if the player is sneaking
		if (player.isSneaking())
			return false;

		// Switch orientation if whacked with a wrench.
		Item equipped = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem().getItem() : null;
		if (equipped instanceof IToolWrench && ((IToolWrench) equipped).canWrench(player, i, j, k)) {

			tile.switchOrientation();
			((IToolWrench) equipped).wrenchUsed(player, i, j, k);
			return true;

		} else {

			// Do not open guis when having a pipe in hand
			if (player.getCurrentEquippedItem() != null) {
				if (player.getCurrentEquippedItem().getItem() instanceof IItemPipe) {
					return false;
				}
				
			}

		}

		return false;
	}

	@Override
	public void onPostBlockPlaced(World world, int x, int y, int z, int par5) {
		TileEngineUnbreakable tile = (TileEngineUnbreakable) world.getBlockTileEntity(x, y, z);
		tile.orientation = ForgeDirection.UP.ordinal();
		tile.switchOrientation();
	}

	@Override
	public int damageDropped(int i) {
		return i;
	}

	@SuppressWarnings({"all"})
	@Override
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		TileEngineUnbreakable tile = (TileEngineUnbreakable) world.getBlockTileEntity(i, j, k);

		if (!tile.isBurning())
			return;

		float f = (float) i + 0.5F;
		float f1 = (float) j + 0.0F + (random.nextFloat() * 6F) / 16F;
		float f2 = (float) k + 0.5F;
		float f3 = 0.52F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;

		world.spawnParticle("reddust", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("reddust", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("reddust", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("reddust", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void getSubBlocks(int blockid, CreativeTabs par2CreativeTabs, List itemList) {
		itemList.add(new ItemStack(this, 1, 0));
		itemList.add(new ItemStack(this, 1, 1));
		itemList.add(new ItemStack(this, 1, 2));
	}

	@Override
	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		TileEngineUnbreakable tile = (TileEngineUnbreakable) world.getBlockTileEntity(i, j, k);

		if (tile != null) {
			tile.checkRedstonePower();
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		switch (meta) {
			case 0:
				return bedrockTexture;
			default:
				return unknownTexture;
		}
	}
}

