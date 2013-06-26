package k2b6s9j.Engines.proxy;

import java.io.File;
import java.util.List;
import java.util.Random;

import buildcraft.core.ItemBlockBuildCraft;
import buildcraft.core.network.BuildCraftPacket;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import k2b6s9j.Engines.tile.TileEngineUnbreakable;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;

public class Proxy {
	@SidedProxy(clientSide = "k2b6s9j.Engines.proxy.ProxyClient", serverSide = "k2b6s9j.Engines.proxy.Proxy")
	public static Proxy proxy;

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEngineUnbreakable.class, "net.minecraft.src.k2b6s9j.Engines.engines.EngineUnbreakable");
	}

	public void registerBlockRenderers() {
	}
	
	/* REGISTRATION */
	public void registerBlock(Block block) {
		registerBlock(block, ItemBlockBuildCraft.class);
	}
	
	public void registerBlock(Block block, Class<? extends ItemBlock> item) {
		GameRegistry.registerBlock(block, item, block.getUnlocalizedName().replace("tile.", ""));
	}

	public void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public void registerTileEntity(Class clas, String ident) {
		GameRegistry.registerTileEntity(clas, ident);
	}

	public void onCraftingPickup(World world, EntityPlayer player, ItemStack stack) {
		stack.onCrafting(world, player, stack.stackSize);
	}

	@SuppressWarnings("unchecked")
	public void addCraftingRecipe(ItemStack result, Object[] recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, recipe));
		//GameRegistry.addRecipe(result, recipe);
	}

	public void addShapelessRecipe(ItemStack result, Object[] recipe) {
		GameRegistry.addShapelessRecipe(result, recipe);
	}

	public void sendToPlayers(Packet packet, World world, int x, int y, int z, int maxDistance) {
		if (packet != null) {
			for (int j = 0; j < world.playerEntities.size(); j++) {
				EntityPlayerMP player = (EntityPlayerMP) world.playerEntities.get(j);

				if (Math.abs(player.posX - x) <= maxDistance && Math.abs(player.posY - y) <= maxDistance && Math.abs(player.posZ - z) <= maxDistance) {
					player.playerNetServerHandler.sendPacketToPlayer(packet);
				}
			}
		}
	}

	public void sendToPlayer(EntityPlayer entityplayer, BuildCraftPacket packet) {
		EntityPlayerMP player = (EntityPlayerMP) entityplayer;
		player.playerNetServerHandler.sendPacketToPlayer(packet.getPacket());
	}

	public void sendToServer(Packet packet) {
	}
	
	/* SIMULATION */
	public boolean isSimulating(World world) {
		return !world.isRemote;
	}

	public boolean isRenderWorld(World world) {
		return world.isRemote;
	}

	public String getCurrentLanguage() {
		return null;
	}
	
	/* FILE SYSTEM */
	public File getBuildCraftBase() {
		return new File("./");
	}

	public int addCustomTexture(String pathToTexture) {
		return 0;
	}

	public void TakenFromCrafting(EntityPlayer thePlayer, ItemStack itemstack, IInventory craftMatrix) {
		GameRegistry.onItemCrafted(thePlayer, itemstack, craftMatrix);
	}

	public Random createNewRandom(World world) {
		return new Random(world.getSeed());
	}
	
	/* GFX */
	public void initializeRendering() {
	}

	public void initializeEntityRendering() {
	}
	
	/* LOCALIZATION */
	public void addName(Object obj, String s) {
	}

	public void addLocalization(String s1, String string) {
	}

	public String getItemDisplayName(ItemStack newStack) {
		return "";
	}
	
	/* WRAPPER */
	@SuppressWarnings("rawtypes")
	public void feedSubBlocks(int id, CreativeTabs tab, List itemList) {
	}
	
	/* ENTITY HANDLING */
	public void removeEntity(Entity entity) {
		entity.worldObj.removeEntity(entity);
	}
}
