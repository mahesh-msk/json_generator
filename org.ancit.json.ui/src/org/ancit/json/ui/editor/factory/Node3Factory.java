package org.ancit.json.ui.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import Json.JsonFactory;
import Json.Node;
import Json.Node3;


public class Node3Factory implements CreationFactory{

	public Object getNewObject() {
		Node3 node=JsonFactory.eINSTANCE.createNode3();
		node.setName("node1");
		
			return node;
	}

	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Node3.class;
	}

}
