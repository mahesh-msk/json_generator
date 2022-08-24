package org.ancit.json.ui.editPart;

import java.util.ArrayList;
import java.util.List;

import org.ancit.json.ui.editors.policy.ClusterXYLayoutPolicy;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;

import Json.Cluster;
import Json.JsonModel;


public class ParentEditPart extends AbstractGraphicalEditPart {

	protected IFigure createFigure() {
		FreeformLayer layer = new FreeformLayer();
		layer.setLayoutManager(new FreeformLayout());
		layer.setBorder(new LineBorder(1));
		JsonModel jsonModel=(JsonModel)getModel();
		(jsonModel).eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				refreshChildren();
				refreshVisuals();
				super.notifyChanged(msg);
			}
			
		});
		
		
		
		return layer;
		
	}

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ClusterXYLayoutPolicy());
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());

	}
	protected List<Cluster> getModelChildren() {
		JsonModel jsonModel = (JsonModel) getModel();
		return jsonModel.getCluster();
	}
	@Override
	public Object getAdapter(Class key) {
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

}
