package org.ancit.json.ui.editors.command;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import Json.Cluster;
import Json.JsonFactory;
import Json.JsonModel;

import Json.Position;

public class ClusterCreateCommand extends Command{
private Dimension defaultDimension = new Dimension(500, 500);;
private Rectangle constraints;
private EditPart editPart;
private JsonModel jsonModel;
private Cluster newCluster;

@Override
public void execute() {
	Position placement = JsonFactory.eINSTANCE
			.createPosition();
	placement.setX(constraints.x);
	placement.setY(constraints.y);
	placement.setW(defaultDimension.width);
	placement.setH(defaultDimension.height);
	newCluster.setPlacement(placement);
	jsonModel.getCluster().add(newCluster);

}
public void setLocation(Point location) {
	constraints = new Rectangle(location, defaultDimension);
}

public void setParent(EditPart editPart) {
	this.editPart = editPart;
	this.jsonModel = (JsonModel) editPart.getModel();
}

public void setThing(Cluster cluster) {
	this.newCluster = cluster;
}
}
