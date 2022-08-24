package org.ancit.json.ui.editors.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import Json.JsonFactory;
import Json.Node;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Position;

public class NodeChangeConstraintCommand extends Command{
private EditPart host;
private Object model;
private Node node;
private Node1 node1;
private Node2 node2;
private Node3 node3;
private Node4 node4;
private Rectangle constraint;
private Position position;

@Override
public void execute() {
	
	if (model instanceof Node) {
		node=(Node)model;
		node.setPlacement(position);
	    
	    
	}
	/*else if (model instanceof Node1) {
		node1=(Node1)model;
		node1.setPlacement(position);
	    
	}
	else if (model instanceof Node2) {
		node2=(Node2)model;
		node2.setPlacement(position);
	   
	}
	else if (model instanceof Node3) {
		node3=(Node3)model;
		node3.setPlacement(position);
	    
	}
	else if (model instanceof Node4) {
		node4=(Node4)model;
		
	    node4.setPlacement(position);
	}*/
	 
}

public void setChild(EditPart child) {
	this.host = child;
	this.model =  host.getModel();
	// TODO Auto-generated method stub
	
}

public void setPlacement(Rectangle constraint) {
	this.constraint = constraint;
	position = JsonFactory.eINSTANCE.createPosition();
	position.setH(constraint.height);
	position.setW(constraint.width);
	position.setX(constraint.x);
	position.setY(constraint.y);
	
}
}
