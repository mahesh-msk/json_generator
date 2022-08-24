package org.ancit.json.ui.editors.command;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;

import Json.Cluster;
import Json.JsonFactory;
import Json.JsonModel;
import Json.Node;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Node5;
import Json.Position;

public class NodeCreateCommand extends Command {
	private Rectangle constraints;
	private EditPart editPart;
	private Cluster cluster;
	private Node5 newNode5;
	private Node1 newNode1;
	private Node2 newNode2;
	private Node3 newNode3;
	private Node4 newNode4;
	private JsonModel jsonModel;
	private Object object;

	@Override
	public void execute() {

		Position placement = JsonFactory.eINSTANCE.createPosition();
		placement.setX(constraints.x);
		placement.setY(constraints.y);
		placement.setW(constraints.width);
		placement.setH(constraints.height);
		if (object instanceof Node5) {
			newNode5 = (Node5) object;
			newNode5.setPlacement(placement);
			cluster.setNode5(newNode5);
		} else if (object instanceof Node1) {
			newNode1 = (Node1) object;
			newNode1.setPlacement(placement);
			cluster.setNode1(newNode1);
		} else if (object instanceof Node2) {
			newNode2 = (Node2) object;
			newNode2.setPlacement(placement);
			cluster.setNode2(newNode2);
		} else if (object instanceof Node3) {
			newNode3 = (Node3) object;
			newNode3.setPlacement(placement);
			cluster.setNode3(newNode3);
		} else if (object instanceof Node4) {
			newNode4 = (Node4) object;
			newNode4.setPlacement(placement);
			cluster.setNode4(newNode4);
		}
		

		// editPart.refresh();
	}

	public void setLocation(Point location) {
		Dimension dimension = new Dimension(100,100);
		this.constraints = new Rectangle(location, dimension);
	}

	public void setParent(EditPart editPart) {
		this.editPart = editPart;
		this.cluster = (Cluster) editPart.getModel();

	}

	public void setThing(Object object2) {
		this.object = object2;

	}
}
