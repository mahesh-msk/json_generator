package org.ancit.json.ui.outlineview;

import java.util.ArrayList;

import org.ancit.json.ui.Activator;
import org.ancit.json.ui.editor.JsonGraphicalEditor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import Json.Cluster;
import Json.JsonModel;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Node5;

public class JsonOutlinePage extends ContentOutlinePage {

	private static class TreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof JsonModel) {
				JsonModel jsonModel = (JsonModel) inputElement;
				return jsonModel.getCluster().toArray();
			}
			return getChildren(inputElement);
		}

		public Object[] getChildren(Object parentElement) {

//			if (parentElement instanceof JsonModel) {
//				JsonModel jsonModel = (JsonModel) parentElement;
//				return jsonModel.getCluster().toArray();
//			}

			if (parentElement instanceof Cluster) {
				Cluster cluster = (Cluster) parentElement;
				ArrayList<Object> nodes = new ArrayList<Object>();
				if (cluster.getNode1() != null) {
					nodes.add(cluster.getNode1());
				}
				if (cluster.getNode2() != null) {
					nodes.add(cluster.getNode2());
				}
				if (cluster.getNode3() != null) {
					nodes.add(cluster.getNode3());
				}
				if (cluster.getNode4() != null) {
					nodes.add(cluster.getNode4());
				}
				if (cluster.getNode5() != null) {
					nodes.add(cluster.getNode5());
				}
				return nodes.toArray();

			}
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof JsonModel | element instanceof Cluster) {
				return true;
			}
			return false;
		}
	}

	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			
			if (element instanceof Cluster) {
				Image originalImage = Activator.getDefault().getImage(
						"compancode");
				return resize(originalImage, 20, 20);
			}
			if (element instanceof Node1) {
				Image originalImage = Activator.getDefault().getImage(
						"discha");
				return resize(originalImage, 20, 20);

			}
			if (element instanceof Node2) {
			
				Image originalImage = Activator.getDefault().getImage(
						"discha");
				return resize(originalImage, 20, 20);
			}
			if (element instanceof Node3) {
				
				Image originalImage = Activator.getDefault().getImage(
						"discha");
				return resize(originalImage, 20, 20);
			}
			if (element instanceof Node4) {
				Image originalImage = Activator.getDefault().getImage(
						"discha");
				return resize(originalImage, 20, 20);

			}
			if (element instanceof Node5) {
				
				Image originalImage = Activator.getDefault().getImage(
						"discha");
				return resize(originalImage, 20, 20);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			Image originalImage = Activator.getDefault().getImage(
					"salesdiv");
			return resize(originalImage, 20, 20);}

		public String getText(Object element) {
			if (element instanceof Cluster) {
				Cluster cluster = (Cluster) element;
				return cluster.getName();
			}
			if (element instanceof Node1) {
				Node1 node1 = (Node1) element;
				return node1.getName();

			}
			if (element instanceof Node2) {
				Node2 node2 = (Node2) element;
				return node2.getName();

			}
			if (element instanceof Node3) {
				Node3 node3 = (Node3) element;
				return node3.getName();

			}
			if (element instanceof Node4) {
				Node4 node4 = (Node4) element;
				return node4.getName();

			}
			if (element instanceof Node5) {
				Node5 node5 = (Node5) element;
				return node5.getName();

			}
			return super.getText(element);
		}
		private Image resize(Image image, int width, int height) {
			Image scaled = new Image(Display.getDefault(), width, height);
			GC gc = new GC(scaled);
			gc.setAntialias(SWT.ON);
			gc.setInterpolation(SWT.HIGH);
			gc.drawImage(image, 0, 0, image.getBounds().width,
					image.getBounds().height, 0, 0, width, height);
			gc.dispose();
			//image.dispose(); // don't forget about me!
			return scaled;
		}
	}

	private JsonGraphicalEditor jsonGraphicalEditor;
	private TreeViewer viewer;

	public JsonOutlinePage(JsonGraphicalEditor jsonGraphicalEditor) {
		// TODO Auto-generated constructor stub
		this.jsonGraphicalEditor = jsonGraphicalEditor;

	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		super.createControl(parent);
		viewer = getTreeViewer();
		viewer.setLabelProvider(new ViewerLabelProvider());
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setInput(jsonGraphicalEditor.getJson());
		jsonGraphicalEditor.getJson().eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				viewer.refresh();
				super.notifyChanged(notification);
			}
		});

	}
	

}
