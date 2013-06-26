/** 
 * Copyright (c) SpaceToad, 2011
 * http://www.mod-buildcraft.com
 * 
 * BuildCraft is distributed under the terms of the Minecraft Mod Public 
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package k2b6s9j.Engines.item;

import net.minecraft.item.ItemStack;

public class ItemEngineUnbreakable extends ItemBlockKeplersEngines {

	public ItemEngineUnbreakable(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		if (itemstack.getItemDamage() == 0)
			return "tile.engineBedrock";
		else
			return "tile.engineUnknownUnbreakable";
	}
}
