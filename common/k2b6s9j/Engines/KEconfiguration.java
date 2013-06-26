package k2b6s9j.Engines;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class KEconfiguration extends Configuration {

	public KEconfiguration(File file) {
		super(file);
	}

	@Override
	public void save() {
		Property versionProp = get(CATEGORY_GENERAL, "version", Reference.VERSION);
		versionProp.set(Reference.VERSION);
		super.save();
	}

}
