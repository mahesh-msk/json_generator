package org.ancit.json.ui.editor;

import org.ancit.json.ui.editor.factory.ClusterFactory;
import org.ancit.json.ui.editor.factory.Node1Factory;
import org.ancit.json.ui.editor.factory.Node2Factory;
import org.ancit.json.ui.editor.factory.Node3Factory;
import org.ancit.json.ui.editor.factory.Node4Factory;
import org.ancit.json.ui.editor.factory.Node5Factory;

import org.ancit.json.ui.editor.factory.NodeLinkFactory;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.resource.ImageDescriptor;
import org.ancit.json.ui.Activator;

public class JsonGraphicalEditorPalette extends PaletteRoot {

	private PaletteGroup group;
	private PaletteDrawer paletteDrawer;
	private PaletteDrawer paletteDrawer1;
	private PaletteDrawer paletteDrawer2;
	private PaletteDrawer paletteDrawer3;

	public JsonGraphicalEditorPalette() {
		addGroup();
		addCluster();
		addNode();
		addNode1();
		addNode2();
		addNode3();
		addNode4();
		addNodeLink();
	}

	private void addNodeLink() {
		ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry(
				"Link", "Creates a new link", new NodeLinkFactory(), null, null);
		paletteDrawer3.add(entry);

	}

	private void addNode2() {
		ImageDescriptor descriptor = new ImageDescriptor() {

			@Override
			public ImageData getImageData() {
				// TODO Auto-generated method stub
				Image originalImage = Activator.getDefault().getImage(
						"salesdiv");
				return resize(originalImage, 20, 20).getImageData();

			}
		};
		CreationToolEntry entry = new CreationToolEntry("Node2",
				"Create a new Object", new Node2Factory(), null, null);
		paletteDrawer1.add(entry); // TODO Auto-generated method stub

	}

	private void addNode4() {
		ImageDescriptor descriptor = new ImageDescriptor() {

			@Override
			public ImageData getImageData() {
				// TODO Auto-generated method stub
				Image originalImage = Activator.getDefault().getImage(
						"salesdiv");
				return resize(originalImage, 20, 20).getImageData();

			}
		};
		CreationToolEntry entry = new CreationToolEntry("Node4",
				"Create a new Object", new Node4Factory(), descriptor, null);
		paletteDrawer1.add(entry);
	}

	private void addNode3() {
		ImageDescriptor descriptor = new ImageDescriptor() {

			@Override
			public ImageData getImageData() {
				// TODO Auto-generated method stub
				Image originalImage = Activator.getDefault().getImage(
						"salesdiv");
				return resize(originalImage, 20, 20).getImageData();

			}
		};
		CreationToolEntry entry = new CreationToolEntry("Node3",
				"Create a new Object", new Node3Factory(), descriptor, null);
		paletteDrawer1.add(entry);

	}

	private void addNode1() {
		ImageDescriptor descriptor = new ImageDescriptor() {

			@Override
			public ImageData getImageData() {
				// TODO Auto-generated method stub
				Image originalImage = Activator.getDefault().getImage(
						"salesdiv");
				return resize(originalImage, 20, 20).getImageData();

			}
		};
		CreationToolEntry entry = new CreationToolEntry("Node1",
				"Create a new Object", new Node1Factory(), descriptor, null);
		paletteDrawer1.add(entry);
	}

	private void addNode() {
		ImageDescriptor descriptor = new ImageDescriptor() {

			@Override
			public ImageData getImageData() {
				// TODO Auto-generated method stub
				Image originalImage = Activator.getDefault().getImage(
						"salesdiv");
				return resize(originalImage, 20, 20).getImageData();

			}
		};
		CreationToolEntry entry = new CreationToolEntry("Node5",
				"Create a new Object", new Node5Factory(), descriptor, null);
		paletteDrawer1.add(entry);

	}

	private void addCluster() {
		ImageDescriptor descriptor = new ImageDescriptor() {

			@Override
			public ImageData getImageData() {
				// TODO Auto-generated method stub
				Image originalImage = Activator.getDefault().getImage(
						"salesdiv");
				return resize(originalImage, 20, 20).getImageData();

			}
		};
		CreationToolEntry entry = new CreationToolEntry("Cluster",
				"Create a new Object", new ClusterFactory(), descriptor, null);
		paletteDrawer.add(entry);

	}

	private void addGroup() {
		group = new PaletteGroup("OPM Controls");
		add(group);
		paletteDrawer = new PaletteDrawer("Cluster");

		paletteDrawer1 = new PaletteDrawer("Nodes");
		paletteDrawer2 = new PaletteDrawer("Select");
		paletteDrawer3 = new PaletteDrawer("Select");
		group.add(paletteDrawer2);
		group.add(paletteDrawer);
		group.add(paletteDrawer1);
		group.add(paletteDrawer3);

	}

	private Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width,
				image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		// image.dispose(); // don't forget about me!
		return scaled;
	}

}
