package org.ancit.json.ui.editPart;

import java.util.ArrayList;
import java.util.List;









import org.ancit.json.ui.editors.policy.ClusterContainerPolicy;
import org.ancit.json.ui.editors.policy.ClusterXYLayoutPolicy;
import org.ancit.json.ui.editors.policy.NodeFlowLayoutEditPolicy;
import org.ancit.json.ui.editors.policy.NodeXYLayoutPolicy;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;

import Json.Cluster;
import Json.JsonModel;
import Json.Node;

public class ClusterEditPart extends AbstractGraphicalEditPart {
	private Cluster cluster;
	private Label lbl;
	private RectangleFigure figure;
	private RectangleFigure containerFigure;

	protected IFigure createFigure() {
		figure = new RectangleFigure()
		 {
			@Override
			protected boolean useLocalCoordinates() {
				// TODO Auto-generated method stub
				return true;
			}
		};
		figure.setBorder(new LineBorder(1));

		cluster = (Cluster) getModel();
		figure.setBounds(new Rectangle(cluster.getPlacement().getX(), cluster
				.getPlacement().getY(), cluster.getPlacement().getW(), cluster
			.getPlacement().getH()));
		/*ToolbarLayout layout = new ToolbarLayout();
		 layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		    layout.setStretchMinorAxis(true);
		    layout.setSpacing(2);*/
				figure.setLayoutManager(new XYLayout());
				lbl = new Label();
			
				lbl.setIconAlignment(PositionConstants.BOTTOM);
				lbl.setIconAlignment(PositionConstants.CENTER);
		lbl.setText(cluster.getName());
				lbl.setTextPlacement(PositionConstants.NORTH);
				figure.add(lbl);
				cluster.eAdapters().add(new AdapterImpl() {
					@Override
					public void notifyChanged(Notification msg) {
						refreshChildren();
						refreshVisuals();
						
						super.notifyChanged(msg);
					}

				});

				
				return figure;

	
				
		
		
		
		/*containerFigure.setBorder(new LineBorder(1));
		containerFigure.setLayoutManager(new XYLayout());
		figure.add(containerFigure);*/

		
	}
	
	/*@Override
	public IFigure getContentPane() {
		// TODO Auto-generated method stub
		return containerFigure;
	}*/

	@Override
	protected void refreshVisuals() {
		lbl.setText(cluster.getName());
		figure.setBounds(new Rectangle(cluster.getPlacement().getX(), cluster
				.getPlacement().getY(), cluster.getPlacement().getW(), cluster
				.getPlacement().getH()));
	}

	protected void createEditPolicies() {
//		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ClusterContainerPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new NodeXYLayoutPolicy());
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
	}
	@Override
	public Object getAdapter(Class key) {
		// TODO Auto-generated method stub
		 if (key == SnapToHelper.class) {
		        List<SnapToHelper> helpers = new ArrayList<SnapToHelper>();
		        if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED))) {
		            helpers.add(new SnapToGeometry(this));
		        }
		        if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED))) {
		            helpers.add(new SnapToGrid(this));
		        }
		        if(helpers.size()==0) {
		            return null;
		        } else {
		            return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[0]));
		        }
		    }
		return super.getAdapter(key);
	}
	
	protected List<Object> getModelChildren() {
		List<Object> retVal = new ArrayList<Object>();
		Cluster cluster = (Cluster) getModel();
		if(cluster.getNode5() != null) {
		retVal.add(cluster.getNode5());
		}
		
		if(cluster.getNode1() != null) {
		retVal.add(cluster.getNode1());
		}
		
		if(cluster.getNode2() != null) {
		retVal.add(cluster.getNode2());
		}
		
		if(cluster.getNode3() != null) {
			retVal.add(cluster.getNode3());	
		}
		if(cluster.getNode4() != null) {
		retVal.add(cluster.getNode4());
		}
		return retVal;
	}
	
	@Override
	public void performRequest(Request req) {
		// TODO Auto-generated method stub
		super.performRequest(req);
		if (req.getType().equals(RequestConstants.REQ_OPEN)) {
			InputDialog input = new InputDialog(Display.getDefault().getActiveShell(), "EnterName", "Enter the name", null, null);
			input.open();
			((Cluster)getModel()).setName(input.getValue());
		}
	}

}
