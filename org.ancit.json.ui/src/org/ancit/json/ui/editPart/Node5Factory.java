package org.ancit.json.ui.editPart;

import org.eclipse.gef.requests.CreationFactory;

import Json.JsonFactory;
import Json.Node;
import Json.Node5;


public class Node5Factory implements CreationFactory{

	public Object getNewObject() {
		Node5 node=JsonFactory.eINSTANCE.createNode5();
		
			return node;
	}

	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Node5.class;
	}

}
