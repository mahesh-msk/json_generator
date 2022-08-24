package org.ancit.json.ui.editors.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import Json.Cluster;
import Json.JsonFactory;
import Json.Node;
import Json.Position;

public class ClusterChangeConstraintCommand extends Command {

	private EditPart host;
	private Cluster model;
	private Rectangle constraint;

	@Override
	public void execute() {
		Position placement = JsonFactory.eINSTANCE.createPosition();
		placement.setX(constraint.x);
		placement.setY(constraint.y);
		placement.setW(constraint.width);
		placement.setH(constraint.height);
		
		model.setPlacement(placement);
	}

	public void setChild(EditPart child) {
		this.host = child;
		this.model = (Cluster) host.getModel();

	}

	public void setPlacement(Rectangle constraint) {
		this.constraint = constraint;

	}

}
