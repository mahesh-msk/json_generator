package org.ancit.json.ui.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import Json.JsonFactory;
import Json.Link;


public class NodeLinkFactory implements CreationFactory{

	public Object getNewObject() {
		// TODO Auto-generated method stub
		return JsonFactory.eINSTANCE.createLink();
	}

	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Link.class;
	}

}
