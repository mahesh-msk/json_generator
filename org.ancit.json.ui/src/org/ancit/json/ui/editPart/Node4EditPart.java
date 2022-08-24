package org.ancit.json.ui.editPart;

import java.util.List;

import org.ancit.json.ui.Activator;
import org.ancit.json.ui.dialog.Node1Dialog;
import org.ancit.json.ui.dialog.Node4Dialog;
import org.ancit.json.ui.editors.policy.NodeComponentEditPolicy;
import org.ancit.json.ui.editors.policy.NodeDirectEditPolicy;
import org.ancit.json.ui.editors.policy.NodeGraphicalNodeEditPolicy;
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
import Json.Node4;

public class Node4EditPart extends AbstractGraphicalEditPart implements NodeEditPart{

	private Label lbl;
private Node4 node4;
	@Override
	protected IFigure createFigure() {
	node4 = (Node4) getModel();
//	figure=new RectangleFigure();
//		figure.setBounds(new Rectangle(node4.getPlacement().getX(),node4.getPlacement().getY(),
//				node4.getPlacement().getW(), node4.getPlacement().getH()));
//		ToolbarLayout layout = new ToolbarLayout(false);
//		layout.setStretchMinorAxis(true);
//		layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
//		figure.setLayoutManager(layout);
		lbl = new Label();
		lbl.setText(node4.getName());
		lbl.setBorder(new LineBorder(1));
		lbl.setIconAlignment(PositionConstants.BOTTOM);
		lbl.setIconAlignment(PositionConstants.CENTER);
	       lbl.setTextPlacement(PositionConstants.NORTH);
//		lbl.setIconAlignment(PositionConstants.BOTTOM);
//		lbl.setIconAlignment(PositionConstants.CENTER);
//
//		lbl.setTextPlacement(PositionConstants.NORTH);
//		figure.add(lbl);
		node4.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				// TODO Auto-generated method stub
				super.notifyChanged(msg);
				refreshVisuals();
				refreshSourceConnections();
				refreshTargetConnections();
			}
		});
		return lbl;

	}
	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		lbl.setText(node4.getName());
		lbl.setIcon(Activator.getDefault().getImage("businessarea"));

		lbl.setBounds(new Rectangle(node4.getPlacement().getX(),node4.getPlacement().getY(),
				node4.getPlacement().getW(), node4.getPlacement().getH()));
		
		
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
			Node4 node4=(Node4)getModel();
			Node4Dialog dialog=new Node4Dialog(Display.getDefault().getActiveShell(),node4);
			dialog.open();
		}
	}

	@Override
	public List<Link> getModelSourceConnections() {
		Node4 node4 = (Node4) getModel();
		if (node4.getSourceLink()!=null) {
			return node4.getSourceLink();
		}
		return null;
	}
	@Override
	public List<Link> getModelTargetConnections() {
		Node4 node4 = (Node4) getModel();
		if (node4.getTargetLink()!=null) {
			return node4.getTargetLink();
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
