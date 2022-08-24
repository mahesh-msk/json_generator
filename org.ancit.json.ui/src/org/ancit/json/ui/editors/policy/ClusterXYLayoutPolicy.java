package org.ancit.json.ui.editors.policy;

import org.ancit.json.ui.editors.command.ClusterChangeConstraintCommand;
import org.ancit.json.ui.editors.command.ClusterCreateCommand;
import org.ancit.json.ui.editors.command.NodeChangeConstraintCommand;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import Json.Cluster;

public class ClusterXYLayoutPolicy extends XYLayoutEditPolicy{

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		 Command retVal = null;
		    if(request.getNewObject() instanceof Cluster) {
		    	ClusterCreateCommand command = new ClusterCreateCommand();
		      command.setLocation(request.getLocation());
		      command.setParent(getHost());
		      
		      command.setThing((Cluster)(request.getNewObject()));
		      retVal = command;
		    }
		    return retVal;
	}
	@Override
	protected Command createChangeConstraintCommand(
			ChangeBoundsRequest request, EditPart child, Object constraint) {
		
			ClusterChangeConstraintCommand retVal = new ClusterChangeConstraintCommand();
			retVal.setChild(child);
			retVal.setPlacement((Rectangle)constraint);
			
			return retVal;
	}
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		// TODO Auto-generated method stub
		return getChangeConstraintCommand((ChangeBoundsRequest) request);
	}
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		// TODO Auto-generated method stub
		return getChangeConstraintCommand((ChangeBoundsRequest) request);
	}

}
