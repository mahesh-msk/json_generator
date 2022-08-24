package org.ancit.json.ui.editor;

import java.io.IOException;
import java.util.EventObject;
import java.util.List;

import org.ancit.json.ui.dialog.FileExportDialog;
import org.ancit.json.ui.editPartFactory.JsonEditPartFactory;
import org.ancit.json.ui.outlineview.JsonOutlinePage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.ancit.json.ui.jet.JsonGenerator;

import Json.Cluster;
import Json.JsonModel;
import Json.JsonPackage;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Node5;

public class JsonGraphicalEditor extends GraphicalEditorWithFlyoutPalette{

	private Resource jsonResource;
	private JsonModel json;
	private Action action2;
	private org.eclipse.jface.action.Action action;
	private Action deleteAction;
	private ResourceSet resourceSet;
	private JsonOutlinePage jsonOutlinePage;
	private Node5 node5;
	private Node4 node4;
	private Node3 node3;
	private Node2 node2;
	private Node1 node1;
	private Cluster cluster;
	private PropertySheetPage propertyPage;

	public JsonGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}

	protected PaletteRoot getPaletteRoot() {
		// TODO Auto-generated method stub
		return new JsonGraphicalEditorPalette();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			System.out.println("Save called");
			json.eResource().save(null);
			dirty=false;
			firePropertyChange(PROP_DIRTY);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	boolean dirty;
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return dirty;
	}
@Override
public void doSaveAs() {

	super.doSaveAs();
}
	protected void initializeGraphicalViewer() {
		// TODO Auto-generated method stub
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(json);
		getSite().setSelectionProvider(getGraphicalViewer());
	}

	protected void configureGraphicalViewer() {
		// TODO Auto-generated method stub
		super.configureGraphicalViewer();
		createOtherActions();
		createSQLGenerationActions();
		getGraphicalViewer().setEditPartFactory(new JsonEditPartFactory());
		// getActionRegistry().registerAction(new
		// ToggleGridAction(getGraphicalViewer()));
		// getActionRegistry().registerAction(new
		// ToggleSnapToGeometryAction(getGraphicalViewer()));
		getGraphicalViewer().addSelectionChangedListener(
				new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {

						MenuManager menuMgr = new MenuManager("Query");
						menuMgr.addMenuListener(new IMenuListener() {

							@Override
							public void menuAboutToShow(IMenuManager manager) {
								manager.add(action);
								IStructuredSelection iStructuredSelection = (IStructuredSelection) getGraphicalViewer()
										.getSelection();
								EditPart editPart = (EditPart) iStructuredSelection
										.getFirstElement();
								Object object = editPart.getModel();
								if (object instanceof Cluster) {

									manager.add(action2);
									cluster = (Cluster) object;
								} else if (object instanceof Node1) {
									manager.add(action2);
									node1 = (Node1) object;
								} else if (object instanceof Node2) {
									manager.add(action2);
									node2 = (Node2) object;
								} else if (object instanceof Node3) {
									manager.add(action2);
									node3 = (Node3) object;
								} else if (object instanceof Node4) {
									manager.add(action2);
									node4 = (Node4) object;
								} else if (object instanceof Node5) {
									manager.add(action2);
									node5 = (Node5) object;
								}

							};
						});

						Menu menu = menuMgr
								.createContextMenu(getGraphicalViewer()
										.getControl());
						menuMgr.setRemoveAllWhenShown(true);
						getGraphicalViewer().getControl().setMenu(menu);
						getSite().registerContextMenu(menuMgr,
								getGraphicalViewer());
					}
				});
		   getActionRegistry().registerAction(new ToggleGridAction(getGraphicalViewer())); 
		    getActionRegistry().registerAction(new ToggleSnapToGeometryAction(getGraphicalViewer())); 

	}
	@Override
	public void commandStackChanged(EventObject event) {
		// TODO Auto-generated method stub
		dirty=true;
		firePropertyChange(PROP_DIRTY);
		super.commandStackChanged(event);
	}

	private void createOtherActions() {
		// TODO Auto-generated method stub
		IToolBarManager toolBarManager = getEditorSite().getActionBars()
				.getToolBarManager();
		// toolBarManager.add(getActionRegistry().getAction(ActionFactory.UNDO.getId()));
		// toolBarManager.add(getActionRegistry().getAction(ActionFactory.REDO.getId()));
		getEditorSite().getActionBars().setGlobalActionHandler(
				ActionFactory.DELETE.getId(),
				getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		toolBarManager.add(getActionRegistry().getAction(
				ActionFactory.DELETE.getId()));

		deleteAction = new Action() {
			@Override
			public void run() {
				List selectedEditParts = getGraphicalViewer()
						.getSelectedEditParts();
				// create delete request
				GroupRequest deleteReq = new GroupRequest(
						RequestConstants.REQ_DELETE);
				// pass the selected machine to the request
				deleteReq.setEditParts(selectedEditParts);

				CompoundCommand compoundCmd = new CompoundCommand(
						GEFMessages.DeleteAction_ActionDeleteCommandName);
				// Get del command for all selected blocks and add in compound
				// command
				for (int i = 0; i < selectedEditParts.size(); i++) {
					EditPart object = (EditPart) selectedEditParts.get(i);
					Command cmd = object.getCommand(deleteReq);
					if (cmd != null)
						compoundCmd.add(cmd);
				}
				if (MessageDialog.openQuestion(Display.getDefault()
						.getActiveShell(), "Delete Node",
						"Do you want to delete selected Node"
								+ " from the Project")) {
					// Perform the delete command on all selected machine
					getGraphicalViewer().getEditDomain().getCommandStack()
							.execute(compoundCmd);
				}

			}

		};
		deleteAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		getGraphicalViewer().getControl().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					if (getGraphicalViewer().getSelectedEditParts().size() > 0) {

						deleteAction.run();

					}
				}
			}
		});
	}

	private void createSQLGenerationActions() {
		action = new org.eclipse.jface.action.Action("Save") {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					json.eResource().save(null);
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		action2 = new Action("Generate") {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				JsonGenerator generator = new JsonGenerator();
				if (node1 != null) {
					String generate = generator.generate(node1);
					FileExportDialog.export(generate);
				}

				else if (node2 != null) {
					String generate = generator.generate(node2);
					FileExportDialog.export(generate);
				} else if (node3 != null) {
					String generate = generator.generate(node3);
					FileExportDialog.export(generate);
				} else if (node4 != null) {
					String generate = generator.generate(node4);
					FileExportDialog.export(generate);
				} else if (node5 != null) {
					String generate = generator.generate(node5);
					FileExportDialog.export(generate);
				} else if (cluster != null) {
					String generate = generator.generate(cluster);
					FileExportDialog.export(generate);
				}

			}
		};

	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site, input);

		JsonPackage.eINSTANCE.eClass(); // This initializes the OPMPackage
										// singleton implementation.
		resourceSet = new ResourceSetImpl();
		if (input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			IFile file = fileInput.getFile();
			jsonResource = resourceSet.createResource(URI.createURI(file
					.getLocationURI().toString()));
			try {
				jsonResource.load(null);
				json = (JsonModel) jsonResource.getContents().get(0);
			} catch (IOException e) {
				// TODO do something smarter.
				e.printStackTrace();
				jsonResource = null;
			}
			json.eAdapters().add(new AdapterImpl(){@Override
			public void notifyChanged(Notification msg) {
				// TODO Auto-generated method stub
				super.notifyChanged(msg);
				firePropertyChange(PROP_DIRTY);
			}});
		}

	}

	public JsonModel getJson() {
		return json;
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (IContentOutlinePage.class.equals(adapter)) {
			if (jsonOutlinePage == null) {
				jsonOutlinePage = new JsonOutlinePage(this);
			}

			return jsonOutlinePage;
		}
		else
		{
		
		
		return super.getAdapter(adapter);
		
		}
	}
}
