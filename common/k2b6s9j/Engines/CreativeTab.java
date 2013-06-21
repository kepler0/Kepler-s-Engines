package k2b6s9j.Engines;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
	
	public static final CreativeTabs tabKeplersEngines = new CreativeTab(Reference.MOD_NAME);

	public CreativeTab(String label) {
		super(label);
	}
	
	@Override
    public ItemStack getIconItemStack() {
		return null;
	}
	
	@Override
    public String getTranslatedTabLabel() {
		return Reference.MOD_NAME;
	}

}
