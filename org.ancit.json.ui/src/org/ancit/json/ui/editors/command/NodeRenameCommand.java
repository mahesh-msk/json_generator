package org.ancit.json.ui.editors.command;

import org.eclipse.gef.commands.Command;

import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Node5;

public class NodeRenameCommand extends Command {
	 private String oldName, newName;
	private Node1 node1;
	private Node2 node2;
	private Node3 node3;
	private Node4 node4;
	private Node5 node5;

	public void setNewName(String value) {
		this.newName=value;
		
	}

	public void setModel(Object model) {
		// TODO Auto-generated method stub
		
		if (model instanceof Node1) {
			this.node1 = (Node1)model;
			oldName=node1.getName();
		}
		else if (model instanceof Node2) {
			this.node2=(Node2)model;
			oldName=node2.getName();
		}
else if (model instanceof Node3) {
			this.node3=(Node3)model;
			oldName=node3.getName();
		}
else if (model instanceof Node4) {
	this.node4=(Node4)model;
	oldName=node4.getName();
}
else if (model instanceof Node5) {
	this.node5=(Node5)model;
	oldName=node5.getName();
}
		 
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
		if (node1!=null) {
			node1.setName(newName);
		}
		else if (node2!=null) {
			node2.setName(newName);
		}
else if (node3!=null) {
	node3.setName(newName);	
		}
else if (node4!=null) {
	node4.setName(newName);
}
else if (node5!=null) {
	node5.setName(newName);
}
	}



	

}
