package org.ancit.json.ui.editors.policy;

import org.ancit.json.ui.editors.command.NodeDeleteCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public class NodeComponentEditPolicy extends ComponentEditPolicy {
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		// TODO Auto-generated method stub
		
		/*OrganizationDeleteCommand thingDeleteCommand = new OrganizationDeleteCommand();
		   
		
		
		  EditPart parent = getHost().getParent();
		    thingDeleteCommand.setThing((Organization) getHost().getModel(),parent);
		    return thingDeleteCommand;*/
		EditPart parent=getHost().getParent();
		NodeDeleteCommand nodeDeleteCommand=new NodeDeleteCommand();
		nodeDeleteCommand.setThing(getHost().getModel(),parent);
		
		return nodeDeleteCommand;
	}

}
