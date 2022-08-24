package org.ancit.json.ui.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import Json.Cluster;
import Json.JsonFactory;

public class ClusterFactory implements CreationFactory{

	public Object getNewObject() {
		Cluster cluster=JsonFactory.eINSTANCE.createCluster();
		cluster.setName("cluster");
			return cluster;
	}

	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Cluster.class;
	}

}
