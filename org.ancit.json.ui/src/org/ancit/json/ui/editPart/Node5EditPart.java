package org.ancit.json.ui.editPart;

import java.util.List;

import org.ancit.json.ui.Activator;
import org.ancit.json.ui.dialog.Node5Dialog;
import org.ancit.json.ui.editors.policy.NodeComponentEditPolicy;
import org.ancit.json.ui.editors.policy.NodeDirectEditPolicy;
import org.ancit.json.ui.editors.policy.NodeGraphicalNodeEditPolicy;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
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
import Json.Node;
import Json.Node5;

public class Node5EditPart extends AbstractGraphicalEditPart implements
		NodeEditPart {

	private Node node5;

	private Label lbl;

	protected IFigure createFigure() {
		// RectangleFigure figure = new RectangleFigure();

		node5 = (Node5) getModel();
		// figure.setBounds(new
		// Rectangle(node5.getPlacement().getX(),node5.getPlacement().getY(),
		// node5.getPlacement().getW(), node5.getPlacement().getH()));
		//
		// ToolbarLayout layout = new ToolbarLayout(false);
		// layout.setStretchMinorAxis(true);
		// layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		// figure.setLayoutManager(layout);
		// figure.setLayoutManager(layout);

		lbl = new Label();
		lbl.setText(node5.getName());
		lbl.setBorder(new LineBorder(1));
		lbl.setIconAlignment(PositionConstants.BOTTOM);
		lbl.setIconAlignment(PositionConstants.CENTER);
	       lbl.setTextPlacement(PositionConstants.NORTH);
		// lbl.setIconAlignment(PositionConstants.BOTTOM);
		// lbl.setIconAlignment(PositionConstants.CENTER);
		//
		// lbl.setTextPlacement(PositionConstants.NORTH);
		//
		// figure.add(lbl);
		node5.eAdapters().add(new AdapterImpl() {
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
		lbl.setText(node5.getName());
		lbl.setIcon(Activator.getDefault().getImage("plan"));
		lbl.setBounds(new Rectangle(node5.getPlacement().getX(), node5
				.getPlacement().getY(), node5.getPlacement().getW(), node5
				.getPlacement().getH()));

	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new NodeGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new NodeDirectEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new NodeComponentEditPolicy());
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());

	}

	@Override
	public void performRequest(Request req) {
		// TODO Auto-generated method stub
		super.performRequest(req);
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			NodeDirectEditManager manager = new NodeDirectEditManager(this,
					TextCellEditor.class, new NodeCellEditorLocator(lbl), lbl);
			manager.show();

		} else {
			Node5 node5 = (Node5) getModel();
			Node5Dialog dialog = new Node5Dialog(Display.getDefault()
					.getActiveShell(), node5);
			dialog.open();
		}
	}

	@Override
	public List<Link> getModelSourceConnections() {
		Node5 node5 = (Node5) getModel();
		if (node5.getSourceLink() != null) {
			return node5.getSourceLink();
		}
		return null;

	}

	@Override
	public List<Link> getModelTargetConnections() {
		Node5 node5 = (Node5) getModel();
		if (node5.getTargetLink() != null) {
			return node5.getTargetLink();
		}
		return null;
	}

	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		// TODO Auto-generated method stub
		return new ChopboxAnchor(getFigure());
	}

	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
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
