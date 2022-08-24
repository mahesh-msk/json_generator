package org.ancit.json.preferences;

import org.ancit.json.ui.Activator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

public class PreferenceInitializer1 extends AbstractPreferenceInitializer {

	public PreferenceInitializer1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		String string = Activator.getDefault().getPreferenceStore().getString("Path");
		if (string=="") {
			System.out.println(string);
			String path = Platform.getInstallLocation().getURL().getPath()+"orgimages";
			

			Activator.getDefault().getPreferenceStore().setValue("Path",path);
		}
		
	

	}

}
