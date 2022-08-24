package org.ancit.json.ui.editPartFactory;

import org.ancit.json.ui.editPart.ClusterEditPart;
import org.ancit.json.ui.editPart.Node1EditPart;
import org.ancit.json.ui.editPart.Node2EditPart;
import org.ancit.json.ui.editPart.Node3EditPart;
import org.ancit.json.ui.editPart.Node4EditPart;
import org.ancit.json.ui.editPart.Node5EditPart;
import org.ancit.json.ui.editPart.NodeLinkEditPart;
import org.ancit.json.ui.editPart.ParentEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import Json.Cluster;
import Json.JsonModel;
import Json.Link;
import Json.Node;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Node5;

public class JsonEditPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;

		if (model instanceof JsonModel) {
			part = new ParentEditPart();
		} else if (model instanceof Cluster) {
			part = new ClusterEditPart();
		} else if (model instanceof Node5) {
			part = new Node5EditPart();
		} else if (model instanceof Node1) {
			part = new Node1EditPart();
		} else if (model instanceof Node2) {
			part = new Node2EditPart();
		} else if (model instanceof Node3) {
			part = new Node3EditPart();
		} else if (model instanceof Node4) {
			part = new Node4EditPart();
		}
		else if (model instanceof Link) {
			part=new NodeLinkEditPart();
		}

		if (part != null) {
			part.setModel(model);
		}

		return part;
	}

}
