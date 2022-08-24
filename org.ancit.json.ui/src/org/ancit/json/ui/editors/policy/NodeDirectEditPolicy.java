package org.ancit.json.ui.editors.policy;

import org.ancit.json.ui.editors.command.NodeRenameCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

public class NodeDirectEditPolicy extends DirectEditPolicy {

	private Object model;

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		// TODO Auto-generated method stub
		 model = getHost().getModel();
		NodeRenameCommand command = new NodeRenameCommand();
		command.setModel(model);
		 command.setNewName((String) request.getCellEditor().getValue());
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		 String value = (String) request.getCellEditor().getValue();

	}

}
