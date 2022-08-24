package org.ancit.json.ui.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import Json.JsonFactory;
import Json.Node;
import Json.Node1;


public class Node1Factory implements CreationFactory{

	public Object getNewObject() {
		Node1 node=JsonFactory.eINSTANCE.createNode1();
	node.setName("node 01");
			return node;
	}

	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Node1.class;
	}

}
