package org.ancit.json.ui.editPart;

import java.util.List;

import org.ancit.json.ui.Activator;
import org.ancit.json.ui.dialog.Node1Dialog;
import org.ancit.json.ui.dialog.Node3Dialog;
import org.ancit.json.ui.editors.policy.NodeComponentEditPolicy;
import org.ancit.json.ui.editors.policy.NodeDirectEditPolicy;
import org.ancit.json.ui.editors.policy.NodeGraphicalNodeEditPolicy;
import org.ancit.json.ui.editors.policy.NodeXYLayoutPolicy;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
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
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Display;

import Json.Link;
import Json.Node1;
import Json.Node2;
import Json.Node3;

public class Node3EditPart extends AbstractGraphicalEditPart implements NodeEditPart{

	private Label lbl;
	private Node3 node3;

	@Override
	protected IFigure createFigure() {
		node3 = (Node3) getModel();
//		figure=new RectangleFigure();
//		figure.setBounds(new Rectangle(node3.getPlacement().getX(),node3.getPlacement().getY(),
//				node3.getPlacement().getW(), node3.getPlacement().getH()));
//		ToolbarLayout layout = new ToolbarLayout(false);
//		layout.setStretchMinorAxis(true);
//		layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
//		figure.setLayoutManager(layout);
		lbl = new Label();
		lbl.setText(node3.getName());
		lbl.setBorder(new LineBorder(1));
		lbl.setIconAlignment(PositionConstants.BOTTOM);
		lbl.setIconAlignment(PositionConstants.CENTER);
	       lbl.setTextPlacement(PositionConstants.NORTH);
//		lbl.setIconAlignment(PositionConstants.BOTTOM);
//		lbl.setIconAlignment(PositionConstants.CENTER);
//
//		lbl.setTextPlacement(PositionConstants.NORTH);
//		figure.add(lbl);
		node3.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				// TODO Auto-generated method stub
				super.notifyChanged(msg);
				refreshChildren();
				refreshVisuals();
				refreshSourceConnections();
				refreshTargetConnections();
			}
		});
		return figure;
	}
@Override
protected void refreshVisuals() {
	// TODO Auto-generated method stub
	lbl.setText(node3.getName());
	lbl.setIcon(Activator.getDefault().getImage("businessarea"));

	lbl.setBounds(new Rectangle(node3.getPlacement().getX(),node3.getPlacement().getY(),
			node3.getPlacement().getW(), node3.getPlacement().getH()));
	
}
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new NodeGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NodeDirectEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());

	}
	@Override
	public void performRequest(Request req) {
		// TODO Auto-generated method stub
		super.performRequest(req);
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			NodeDirectEditManager manager = new NodeDirectEditManager(this, TextCellEditor.class,new NodeCellEditorLocator(lbl), lbl);
			manager.show();

		}
		else {
			Node3 node3=(Node3)getModel();
			Node3Dialog dialog=new Node3Dialog(Display.getDefault().getActiveShell(),node3);
			dialog.open();
		}
	}

	@Override
	public List<Link> getModelSourceConnections() {
		Node3 node3 = (Node3) getModel();
		if (node3.getSourceLink()!=null) {
			return node3.getSourceLink();
		}
		return null;
	}
	@Override
	public List<Link> getModelTargetConnections() {
		Node3 node3 = (Node3) getModel();
		if (node3.getTargetLink()!=null) {
			return node3.getTargetLink();
		}
		return null;
	}
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}


}
