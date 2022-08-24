package org.ancit.json.ui.editors.policy;

import org.ancit.json.ui.editors.command.ClusterCreateCommand;

import org.ancit.json.ui.editors.command.NodeChangeConstraintCommand;
import org.ancit.json.ui.editors.command.NodeCreateCommand;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import Json.Cluster;
import Json.Node;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;

public class NodeXYLayoutPolicy extends XYLayoutEditPolicy {

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
/*		if (request.getNewObject() instanceof Node1) {
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

		}*/

		return null;

	}
	
	@Override
	protected Command createChangeConstraintCommand(
			ChangeBoundsRequest request, EditPart child, Object constraint) {
		NodeChangeConstraintCommand retVal = new NodeChangeConstraintCommand();
		retVal.setChild(child);
		retVal.setPlacement((Rectangle) constraint);

		return retVal;
	}

}
