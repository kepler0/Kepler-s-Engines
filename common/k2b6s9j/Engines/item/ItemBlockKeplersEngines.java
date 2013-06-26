package k2b6s9j.Engines.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import buildcraft.core.utils.StringUtils;

public class ItemBlockKeplersEngines extends ItemBlock {

	public ItemBlockKeplersEngines(int id) {
		super(id);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtils.localize(getUnlocalizedName(itemstack));
	}
}
