package org.ancit.json.ui.editors.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

import Json.Cluster;
import Json.JsonModel;
import Json.Link;
import Json.Node;

public class NodeLinkDeleteCommand extends Command {

	private Link link;
	private Cluster cluster;
	private EObject eContainer;
	private JsonModel json;

	public void setLink(Link link) {
		// TODO Auto-generated method stub
		this.link=link;
		eContainer = link.eContainer();
		if (eContainer instanceof Cluster) {
			this.cluster=(Cluster)eContainer;
		}
		else if (eContainer instanceof JsonModel) {
			this.json = (JsonModel)eContainer;
		}
			
		
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
		if (cluster !=null) {
			cluster.getNodeLink().remove(link);
		}
		
		Node sourceNode = link.getSourceNode();
		Node targetNode=link.getTargetNode();
				targetNode.getTargetLink().remove(link);
		sourceNode.getSourceLink().remove(link);

	if (json !=null) {
		json.getLinks().remove(link);
	}
	
		
		
		
	}


}
