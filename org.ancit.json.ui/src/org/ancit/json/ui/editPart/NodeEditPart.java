package org.ancit.json.ui.editPart;


import java.util.ArrayList;
import java.util.List;

import org.ancit.json.ui.Activator;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import Json.Cluster;
import Json.JsonModel;
import Json.Link;
import Json.Node;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;


public class NodeEditPart extends AbstractGraphicalEditPart {

	private Node node;
	private Node1 node1;
	private Node2 node2;
	private Node3 node3;
	private Node4 node4;
	private Label lbl;

	protected IFigure createFigure() {
		RectangleFigure figure = new RectangleFigure();

	
		
			node = (Node) getModel();
			figure.setBounds(new Rectangle(node.getPlacement().getX(),node.getPlacement().getY(),
					node.getPlacement().getW(), node.getPlacement().getH()));
			XYLayout layout = new XYLayout();
			
			figure.setLayoutManager(layout);
			lbl = new Label();
			lbl.setIconAlignment(PositionConstants.BOTTOM);
			lbl.setIconAlignment(PositionConstants.CENTER);

			lbl.setTextPlacement(PositionConstants.NORTH);
			lbl.setIcon(Activator.getDefault().getImage("businessarea"));
			figure.add(lbl);
			node.eAdapters().add(new AdapterImpl(){@Override
			public void notifyChanged(Notification msg) {
				// TODO Auto-generated method stub
				super.notifyChanged(msg);
				refreshChildren();
				refreshVisuals();
				

			}});
			return figure;
			
		


		
		
		
	
		

		

	}
	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		
		figure.setBounds(new Rectangle(node.getPlacement().getX(),node.getPlacement().getY(),
				node.getPlacement().getW(), node.getPlacement().getH()));
	
	
	
	}
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}
	
	
	


}
