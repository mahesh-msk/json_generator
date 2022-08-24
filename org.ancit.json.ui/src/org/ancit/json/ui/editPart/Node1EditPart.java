package org.ancit.json.ui.editPart;

import java.util.List;

import org.ancit.json.ui.Activator;
import org.ancit.json.ui.dialog.Node1Dialog;
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
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Display;

import com.ancit.json.ui.jet.JsonGenerator;

import Json.Link;
import Json.Node1;

public class Node1EditPart extends AbstractGraphicalEditPart implements NodeEditPart{

	private Label lbl;
	private Node1 node1;
	private RectangleFigure containerFigure;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	protected IFigure createFigure() {
//		figure = new RectangleFigure();
	node1 = (Node1)getModel();
	

//		figure.setBounds(new Rectangle(node1.getPlacement().getX(),node1.getPlacement().getY(),
//				node1.getPlacement().getW(), node1.getPlacement().getH()));
//		ToolbarLayout layout = new ToolbarLayout(false);
//		layout.setStretchMinorAxis(true);
//		layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
//		figure.setLayoutManager(layout);
		
		
		lbl = new Label();
		lbl.setText(node1.getName());
		lbl.setBorder(new LineBorder(1));
	lbl.setIconAlignment(PositionConstants.BOTTOM);
	lbl.setIconAlignment(PositionConstants.CENTER);
       lbl.setTextPlacement(PositionConstants.NORTH);
//        lbl.setText("Node");
        
//        figure.setBorder(new LineBorder(1));
//		figure.add(lbl);
		
		node1.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				refreshVisuals();
				refreshSourceConnections();
				refreshTargetConnections();
				super.notifyChanged(msg);
				
			}
		});
	lbl.setBorder(new LineBorder(1));
		
		
		return lbl;
	}
	
	
	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		lbl.setText(node1.getName());
		lbl.setIcon(Activator.getDefault().getImage("businessarea"));

		lbl.setBounds(new Rectangle(node1.getPlacement().getX(),node1.getPlacement().getY(),
				node1.getPlacement().getW(), node1.getPlacement().getH()));
//		
		

	}
	@Override
	public List<Link> getModelSourceConnections() {
		Node1 node1 = (Node1) getModel();
		if (node1.getSourceLink()!=null) {
			return node1.getSourceLink();
		}
		return null;
	}
	@Override
	public List<Link> getModelTargetConnections() {
		Node1 node1 = (Node1) getModel();
		if (node1.getTargetLink()!=null) {
			return node1.getTargetLink();
		}
		return null;
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
		else if (req.getType().equals(RequestConstants.REQ_OPEN)) {
		
			Node1 node1=(Node1)getModel();
	
			Node1Dialog dialog=new Node1Dialog(Display.getDefault().getActiveShell(),node1);
			dialog.open();
		
			
		}
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
