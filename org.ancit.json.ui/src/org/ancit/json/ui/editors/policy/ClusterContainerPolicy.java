package org.ancit.json.ui.editors.policy;

import org.ancit.json.ui.editors.command.NodeCreateCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import Json.Node;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;

public class ClusterContainerPolicy extends ContainerEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Command retVal = null;
		if (request.getNewObject() instanceof Node) {
			NodeCreateCommand command = new NodeCreateCommand();
			command.setLocation(request.getLocation());

			command.setParent(getHost());

			command.setThing( request.getNewObject());
			retVal = command;
			return retVal;


		}
		if (request.getNewObject() instanceof Node1) {
			NodeCreateCommand command = new NodeCreateCommand();
			command.setLocation(request.getLocation());

			command.setParent(getHost());

			command.setThing(request.getNewObject());
			retVal = command;
			return retVal;


		}
		if (request.getNewObject() instanceof Node2) {
			NodeCreateCommand command = new NodeCreateCommand();
			command.setLocation(request.getLocation());

			command.setParent(getHost());

			command.setThing((request.getNewObject()));
			retVal = command;
			return retVal;

		}
		if (request.getNewObject() instanceof Node3) {
			NodeCreateCommand command = new NodeCreateCommand();
			command.setLocation(request.getLocation());

			command.setParent(getHost());

			command.setThing( request.getNewObject());
			retVal = command;
			return retVal;


		}
		if (request.getNewObject() instanceof Node4) {
			NodeCreateCommand command = new NodeCreateCommand();
			command.setLocation(request.getLocation());

			command.setParent(getHost());

			command.setThing((request.getNewObject()));
			retVal = command;
			return retVal;

		}

		return null;
	}

}
