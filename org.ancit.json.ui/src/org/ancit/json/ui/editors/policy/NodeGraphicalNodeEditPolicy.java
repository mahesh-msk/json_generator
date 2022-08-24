package org.ancit.json.ui.editors.policy;

import org.ancit.json.ui.editors.command.NodeLinkCreatecommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import Json.Link;
import Json.Node;

public class NodeGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy{

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		NodeLinkCreatecommand command = (NodeLinkCreatecommand)request.getStartCommand();
command.setTarget(getHost());
		return command;
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		EditPart part = getHost();
	NodeLinkCreatecommand command = new NodeLinkCreatecommand();
		command.setSource(part);
		EditPart parent = getHost().getParent();
        command.setLink((Link) request.getNewObject(),parent);
		request.setStartCommand(command);
		return command;
	
		
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
