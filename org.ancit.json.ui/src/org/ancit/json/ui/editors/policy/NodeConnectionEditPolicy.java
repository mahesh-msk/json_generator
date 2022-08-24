package org.ancit.json.ui.editors.policy;

import org.ancit.json.ui.editors.command.NodeLinkDeleteCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import Json.Cluster;
import Json.Link;

public class NodeConnectionEditPolicy extends ConnectionEditPolicy{

	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		// TODO Auto-generated method stub
		 NodeLinkDeleteCommand command = new  NodeLinkDeleteCommand();

		  EditPart parent = getHost().getParent();
		 
		  
		 
		  Link link = (Link)getHost().getModel();
		  command.setLink(link);
		    
		    return command;
	}

}
