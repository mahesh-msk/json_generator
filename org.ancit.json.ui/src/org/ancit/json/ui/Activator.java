package org.ancit.json.ui;

import java.io.File;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.ancit.json.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		String path = Activator.getDefault().getPreferenceStore().getString("Path");
		if (path!=null) {
			
			File dir = new File(path);
			File[] listFiles = dir.listFiles();
			
			for (File file : listFiles) {
				if(!file.getName().equals("Thumbs.db")){
				String substring = file.getName().substring(0, file.getName().lastIndexOf("."));
				Image image = new Image(Display.getDefault(),file.getAbsolutePath());
				JFaceResources.getImageRegistry().put(substring, image);
				}
			}
		}
		else {
			MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Please set the Image", "Please set Image to proceed");
		}
	

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public Image getImage(String string) {
		Image image = JFaceResources.getImage(string);
		return image;
	}

}
