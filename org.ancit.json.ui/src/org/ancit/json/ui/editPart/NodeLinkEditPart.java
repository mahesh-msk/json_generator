package org.ancit.json.ui.editPart;

import org.ancit.json.ui.editors.policy.NodeConnectionEditPolicy;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

public class NodeLinkEditPart extends AbstractConnectionEditPart{

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		 installEditPolicy(EditPolicy.CONNECTION_ROLE, new NodeConnectionEditPolicy());
		
	}
	@Override
	protected IFigure createFigure() {
		 PolylineConnection conn = new PolylineConnection();
		 conn.setTargetDecoration(new PolylineDecoration());
		
		    return conn; 
	}

}
