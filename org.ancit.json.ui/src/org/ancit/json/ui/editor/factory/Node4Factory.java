package org.ancit.json.ui.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import Json.JsonFactory;
import Json.Node;
import Json.Node4;


public class Node4Factory implements CreationFactory{

	public Object getNewObject() {
		Node4 node=JsonFactory.eINSTANCE.createNode4();
		node.setName("node1");
			return node;
	}

	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Node4.class;
	}

}
