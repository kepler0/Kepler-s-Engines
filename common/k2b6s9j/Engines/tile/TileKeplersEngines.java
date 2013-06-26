package k2b6s9j.Engines.tile;

import java.util.HashMap;
import java.util.Map;

import k2b6s9j.Engines.Reference;
import k2b6s9j.Engines.proxy.Proxy;

import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.core.network.ISynchronizedTile;
import buildcraft.core.network.PacketPayload;
import buildcraft.core.network.PacketTileUpdate;
import buildcraft.core.network.PacketUpdate;
import buildcraft.core.network.TilePacketWrapper;
import buildcraft.core.utils.Utils;

public abstract class TileKeplersEngines extends TileEntity implements ISynchronizedTile {

	@SuppressWarnings("rawtypes")
	private static Map<Class, TilePacketWrapper> updateWrappers = new HashMap<Class, TilePacketWrapper>();
	@SuppressWarnings("rawtypes")
	private static Map<Class, TilePacketWrapper> descriptionWrappers = new HashMap<Class, TilePacketWrapper>();

	private final TilePacketWrapper descriptionPacket;
	private final TilePacketWrapper updatePacket;

	private boolean init = false;

	public TileKeplersEngines() {
		if (!updateWrappers.containsKey(this.getClass())) {
			updateWrappers.put(this.getClass(), new TilePacketWrapper(this.getClass()));
		}

		if (!descriptionWrappers.containsKey(this.getClass())) {
			descriptionWrappers.put(this.getClass(), new TilePacketWrapper(this.getClass()));
		}

		updatePacket = updateWrappers.get(this.getClass());
		descriptionPacket = descriptionWrappers.get(this.getClass());

	}

	@Override
	public void updateEntity() {
		if (!init && !isInvalid()) {
			initialize();
			init = true;
		}

		if (this instanceof IPowerReceptor) {
			IPowerReceptor receptor = ((IPowerReceptor) this);

			receptor.getPowerProvider().update(receptor);
		}
	}

	@Override
	public void invalidate() {
		init = false;
		super.invalidate();
	}

	public void initialize() {
		Utils.handleBufferedDescription(this);
	}

	public void destroy() {

	}

	public void sendNetworkUpdate() {
		if (Proxy.proxy.isSimulating(worldObj)) {
			Proxy.proxy.sendToPlayers(getUpdatePacket(), worldObj, xCoord, yCoord, zCoord, Reference.NETWORK_UPDATE_RANGE);
		}
	}

	@Override
	public Packet getDescriptionPacket() {
		return new PacketTileUpdate(this).getPacket();
	}

	@Override
	public PacketPayload getPacketPayload() {
		return updatePacket.toPayload(this);
	}

	@Override
	public Packet getUpdatePacket() {
		return new PacketTileUpdate(this).getPacket();
	}

	@Override
	public void handleDescriptionPacket(PacketUpdate packet) {
		descriptionPacket.fromPayload(this, packet.payload);
	}

	@Override
	public void handleUpdatePacket(PacketUpdate packet) {
		updatePacket.fromPayload(this, packet.payload);
	}

	@Override
	public void postPacketHandling(PacketUpdate packet) {

	}

    public boolean isInvNameLocalized()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
