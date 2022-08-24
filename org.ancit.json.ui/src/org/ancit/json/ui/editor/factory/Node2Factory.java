package org.ancit.json.ui.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import Json.JsonFactory;
import Json.Node;
import Json.Node1;
import Json.Node2;


public class Node2Factory implements CreationFactory{

	public Object getNewObject() {
		Node2 node=JsonFactory.eINSTANCE.createNode2();
		node.setName("node1");
			return node;
	}

	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Node2.class;
	}

}
